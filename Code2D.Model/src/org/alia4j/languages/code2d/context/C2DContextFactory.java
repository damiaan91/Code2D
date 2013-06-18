package org.alia4j.languages.code2d.context;

import java.util.Map;
import java.util.HashMap;

import nl.utwente.apc.Code2D.base.core.GameObject;

import org.alia4j.liam.Context;

public class C2DContextFactory {
    
	public C2DContextFactory() {
        if (C2DContextFactory.singleton != null)
            throw new IllegalStateException();
        C2DContextFactory.singleton = this;
    }
    
    private static C2DContextFactory getInstance() {
        return C2DContextFactory.singleton;
    }
    
    private static C2DContextFactory singleton;
    private static Map<GameObject, Context> canonicalArgumentContexts = new HashMap<GameObject, Context>();
	
    public static final Context findOrCreateArgumentContext(GameObject go) {
        if (!canonicalArgumentContexts.containsKey(go))
           canonicalArgumentContexts.put(go, getInstance().createArgumentContext(go));
        return canonicalArgumentContexts.get(go);
    }
    
    protected Context createArgumentContext(GameObject go) {
		return new GameObjectContext(go);
	}
}
