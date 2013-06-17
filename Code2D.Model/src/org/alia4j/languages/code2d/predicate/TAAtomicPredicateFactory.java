package org.alia4j.languages.code2d.predicate;

import org.alia4j.liam.AtomicPredicate;

public class TAAtomicPredicateFactory {
    
	public TAAtomicPredicateFactory() {
        if (TAAtomicPredicateFactory.singleton != null)
            throw new IllegalStateException();
        TAAtomicPredicateFactory.singleton = this;
    }
    
    private static TAAtomicPredicateFactory getInstance() {
        return TAAtomicPredicateFactory.singleton;
    }
    
    private static TAAtomicPredicateFactory singleton;


}

