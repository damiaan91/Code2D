package org.alia4j.languages.code2d.context;

import org.alia4j.liam.Context;
import org.alia4j.util.PairHashMap;

public class C2DContextFactory {
	
	private static C2DContextFactory singleton;
	private static PairHashMap<String, Context, Context> canonicalFieldContexts = new PairHashMap<String, Context, Context>();
	
	private C2DContextFactory() {
    }
    
    public static C2DContextFactory getInstance() {
    	if (singleton == null)
    		singleton = new C2DContextFactory();
        return singleton;
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
