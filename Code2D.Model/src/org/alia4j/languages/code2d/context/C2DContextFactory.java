package org.alia4j.languages.code2d.context;

import java.util.Map;
import java.util.HashMap;

import nl.utwente.apc.Code2D.base.core.GameObject;

import org.alia4j.liam.Context;

public class C2DContextFactory {
	
	private static C2DContextFactory singleton;
	private static HashMap<Object, Context> canonicalObjectConstantContexts = new HashMap<Object, Context>();
    
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
}
