package org.alia4j.languages.code2d.predicate;

import org.alia4j.liam.AtomicPredicate;
import org.alia4j.liam.Context;
import org.alia4j.util.PairHashMap;

public class C2DAtomicPredicateFactory {
    
	public C2DAtomicPredicateFactory() {
        if (C2DAtomicPredicateFactory.singleton != null)
            throw new IllegalStateException();
        C2DAtomicPredicateFactory.singleton = this;
    }
    
    private static C2DAtomicPredicateFactory getInstance() {
        return C2DAtomicPredicateFactory.singleton;
    }
    
    private static C2DAtomicPredicateFactory singleton;
    private static PairHashMap<Context, Context, AtomicPredicate> canonicalContextValuePredicates = new PairHashMap<Context, Context, AtomicPredicate>();

    public static final AtomicPredicate findOrCreateContextValuesPredicate(Context fst, Context snd) {
        if (!canonicalContextValuePredicates.containsKeys(fst, snd))
            canonicalContextValuePredicates.put(fst, snd, getInstance().createContextValuesPredicate(fst, snd));
        return canonicalContextValuePredicates.get(fst, snd);
    }
	
	protected AtomicPredicate createContextValuesPredicate(Context fst,	Context snd) {
		return new TriggerDispatching(fst, snd);
	}
}

