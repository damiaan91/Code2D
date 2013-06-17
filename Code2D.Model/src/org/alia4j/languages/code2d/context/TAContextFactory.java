package org.alia4j.languages.code2d.context;

import org.alia4j.liam.Context;

public class TAContextFactory {
    
	public TAContextFactory() {
        if (TAContextFactory.singleton != null)
            throw new IllegalStateException();
        TAContextFactory.singleton = this;
    }
    
    private static TAContextFactory getInstance() {
        return TAContextFactory.singleton;
    }
    
    private static TAContextFactory singleton;
	
}
