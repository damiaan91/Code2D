package org.alia4j.languages.code2d.context;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import nl.utwente.apc.Code2D.base.core.GameObject;

import org.alia4j.liam.Context;
import org.alia4j.liam.SimpleType;
import org.alia4j.liam.signature.Signed;
import org.alia4j.util.Maybe;

public class CollisionListContext extends Context {

	private Class<? extends GameObject> filterClass;
	private int filerId;

	public CollisionListContext(Context wfvContext, Class<? extends GameObject> objClass, int id) {
		super(Arrays.asList(wfvContext));
		this.filterClass = objClass;
		this.filerId = id;
	}
	
	public Object getObjectValue(Object objList) {
		if(objList instanceof List) {
			List<GameObject> gameObjects = (List<GameObject>) objList;
			List<GameObject> filteredList = new ArrayList<GameObject>();
			for(GameObject gObj : gameObjects) {
				if(this.filterClass.isInstance(gObj)) {
					if(gObj.getId() == this.filerId) {
						filteredList.add(gObj);
					}
				}
			}
			return filteredList;
		}
		throw new RuntimeException("getObjectValue of context '" + CollisionListContext.class.getName() + "' expects a list of GameObjects");
	}

	@Override
	public Maybe<? extends Object> computeValueStatically(List<? extends Signed<?>> callStack) {
		return new Maybe<Boolean>();
	}

	@Override
	public SimpleType getDeclaredResultType(Signed<?> genericFunction) {
		return SimpleType.REFERENCE;
	}

}
