package org.alia4j.languages.code2d.context;

import java.util.Collections;
import java.util.List;

import org.alia4j.liam.Context;
import org.alia4j.liam.SimpleType;
import org.alia4j.liam.signature.Signed;
import org.alia4j.noirin.CallContext;
import org.alia4j.noirin.SystemImpl;
import org.alia4j.util.Maybe;

public class GameObjectContext extends Context{
	
	private String objectName;
	private int id;
	
	public GameObjectContext(String objectName, int id) {
		super(Collections.<Context> emptyList());
		this.objectName = objectName;
		this.id = id;
	}
	
	@Override
	public Maybe<? extends Object> computeValueStatically(List<? extends Signed<?>> callStack) {
		return new Maybe<Object>();
	}
	
	@Override
	public SimpleType getDeclaredResultType(Signed<?> genericFunction) {
		return SimpleType.REFERENCE;
	}
	
	public Object getObjectValue() {
		final CallContext callContext = SystemImpl.getSingletonSystemImpl()
				.getCallStackTop();
		for (int i = 0; i < callContext.callerLocalsNames.length; i++) {
			if (callContext.callerLocalsNames[i].equals(objectName))
				return callContext.callerLocals[i];
		}
		return "Object Not Found";
	}
}
