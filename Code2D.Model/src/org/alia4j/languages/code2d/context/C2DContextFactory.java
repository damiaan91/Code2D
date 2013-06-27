package org.alia4j.languages.code2d.context;

import java.util.HashMap;

import nl.utwente.apc.Code2D.base.core.GameObject;

import org.alia4j.liam.Context;
import org.alia4j.util.PairHashMap;

public class C2DContextFactory {
	
	private static PairHashMap<String, Context, Context> canonicalFieldContexts = new PairHashMap<String, Context, Context>();
	private static HashMap<Context, PairHashMap<Class<? extends GameObject>, Integer, Context>> CollisionContexts = new HashMap<Context, PairHashMap<Class<? extends GameObject>, Integer, Context>>();
	
	
	private C2DContextFactory() {
    }

	public static Context findOrCreateWrappedFieldValueContext(String fieldName, Context owner) {
		if (!canonicalFieldContexts.containsKeys(fieldName, owner))
			canonicalFieldContexts.put(fieldName, owner, createWrappedFieldValueContext(fieldName, owner));
		return canonicalFieldContexts.get(fieldName, owner);
	}

	protected static Context createWrappedFieldValueContext(String fieldName, Context owner) {
		return new WrappedFieldValueContext(fieldName, owner);
	}

	public static Context findOrCreateCollisionListContext(Context wfvContext, Class<? extends GameObject> objClass, int id) {
		if(!CollisionContexts.containsKey(wfvContext)) {
			CollisionContexts.put(wfvContext, new PairHashMap<Class<? extends GameObject>, Integer, Context>());
			CollisionContexts.get(wfvContext).put(objClass, id, new CollisionListContext(wfvContext, objClass, id));
		} else {
			if(!CollisionContexts.get(wfvContext).containsKeys(objClass, id)) {
				CollisionContexts.get(wfvContext).put(objClass, id, new CollisionListContext(wfvContext, objClass, id));
			}
		}
		return CollisionContexts.get(wfvContext).get(objClass, id);
	}
}
