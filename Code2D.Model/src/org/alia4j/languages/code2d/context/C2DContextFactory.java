package org.alia4j.languages.code2d.context;

import java.util.Map;
import java.util.HashMap;

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
    private static Map<TupleHash, Context> canonicalArgumentContexts = new HashMap<TupleHash, Context>();
	
    public static final Context findOrCreateArgumentContext(GameObject objName, int id) {
    	TupleHash th = C2DContextFactory.singleton.new TupleHash(objName, id);
        if (!canonicalArgumentContexts.containsKey(th))
           canonicalArgumentContexts.put(th, getInstance().createArgumentContext(th));
        return canonicalArgumentContexts.get(th);
    }
    
    protected Context createArgumentContext(TupleHash th) {
		return new GameObjectContext(th.fst, th.snd);
	}
    
    private class TupleHash {
    	
    	private GameObject fst;
    	private int snd;
    	
    	TupleHash(GameObject fst, int snd) {
    		this.fst = fst;
    		this.snd = snd;
    	}
    }
}
