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
	
	private GameObject objectName;

	public GameObjectContext(GameObject objectName) {
		super(Collections.<Context> emptyList());
		this.objectName = objectName;
	}
	
	public GameObject getGO() {
		return objectName;
	}
	
	@Override
	public Maybe<? extends Object> computeValueStatically(List<? extends Signed<?>> callStack) {
		return new Maybe<Object>();
	}
	
	@Override
	public SimpleType getDeclaredResultType(Signed<?> genericFunction) {
		return SimpleType.REFERENCE;
	}
	
	/**
	 * may be useless.
	 * @return a GameObject.
	 */
	public GameObject getObjectValue() {
		final CallContext callContext = SystemImpl.getSingletonSystemImpl()
				.getCallStackTop();
		for (int i = 0; i < callContext.callerArgumentTypes.length; i++) {
			if (callContext.callerArgumentTypes[i].equals(objectName))
				return callContext.calleeArguments[i];
		}
		return null;
	}
}
