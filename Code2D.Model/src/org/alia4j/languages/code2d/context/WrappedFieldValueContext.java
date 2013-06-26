package org.alia4j.languages.code2d.context;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import org.alia4j.liam.Context;
import org.alia4j.liam.SimpleType;
import org.alia4j.liam.signature.Signed;
import org.alia4j.util.Maybe;

public class WrappedFieldValueContext extends Context {

	private String fieldName;

	protected WrappedFieldValueContext(List<? extends Context> contexts) {
		super(contexts);
	}

	public WrappedFieldValueContext(String fieldName, Context owner) {
		super(Arrays.asList(owner));
		this.fieldName = fieldName;
		
	}
	
	public Object getObjectValue(Object owner) {
		try {
			Class<?> currentClass = owner.getClass();
			while(currentClass != null) {
				try {
					Field field = currentClass.getDeclaredField(fieldName);
					field.setAccessible(true);
					return field.get(owner);
				} catch (NoSuchFieldException e) {
					currentClass = currentClass.getSuperclass();
				}
			}
			throw new RuntimeException("Could not find field '" + fieldName + "' in hierarchy of " + owner.getClass());
		} catch (IllegalArgumentException | IllegalAccessException
				| SecurityException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Maybe<? extends Object> computeValueStatically(
			List<? extends Signed<?>> callStack) {
		return new Maybe<Boolean>();
	}

	@Override
	public SimpleType getDeclaredResultType(Signed<?> genericFunction) {
		return SimpleType.REFERENCE;
	}

}
