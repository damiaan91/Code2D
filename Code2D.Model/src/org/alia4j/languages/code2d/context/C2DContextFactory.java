package org.alia4j.languages.code2d.context;

import java.util.Map;
import java.util.HashMap;

import nl.utwente.apc.Code2D.base.core.GameObject;

import org.alia4j.liam.Context;
import org.alia4j.util.PairHashMap;

public class C2DContextFactory {
	
	private static C2DContextFactory singleton;
	private static HashMap<Object, Context> canonicalObjectConstantContexts = new HashMap<Object, Context>();
    private static PairHashMap<String, Context, Context> canonicalFieldContexts = new PairHashMap<String, Context, Context>();
	
	private C2DContextFactory() {
    }
    
    public static C2DContextFactory getInstance() {
    	if (singleton == null)
    		singleton = new C2DContextFactory();
        return singleton;
    }
    
    public Context findOrCreateObjectConstantContext(final Object go) {
        if (!canonicalObjectConstantContexts.containsKey(go))
        	canonicalObjectConstantContexts.put(go, createObjectConstantContext(go));
        return canonicalObjectConstantContexts.get(go);
    }
    
    protected Context createObjectConstantContext(final Object go) {
		return new GameObjectContext((GameObject) go);
	}

	public Context findOrCreateWrappedFieldValueContext(String fieldName,
			Context owner) {
		if (!canonicalFieldContexts.containsKeys(fieldName, owner))
			canonicalFieldContexts.put(fieldName, owner, createWrappedFieldValueContext(fieldName, owner));
		return canonicalFieldContexts.get(fieldName, owner);
	}

	private Context createWrappedFieldValueContext(String fieldName, Context owner) {
		return new WrappedFieldValueContext(fieldName, owner);
	}
}
