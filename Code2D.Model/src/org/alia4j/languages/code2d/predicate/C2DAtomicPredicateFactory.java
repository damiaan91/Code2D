package org.alia4j.languages.code2d.predicate;

import org.alia4j.liam.AtomicPredicate;
import org.alia4j.liam.Context;
import org.alia4j.util.PairHashMap;

public class C2DAtomicPredicateFactory {
    
	private static PairHashMap<Context, Context, AtomicPredicate> collisionContextPredicates = new PairHashMap<Context, Context, AtomicPredicate>();

	private C2DAtomicPredicateFactory() {
    }

	public static AtomicPredicate findOrCreateCollisionContextPredicate(Context lclc, Context rclc) {
		if (!collisionContextPredicates.containsKeys(lclc, rclc)) {
			collisionContextPredicates.put(lclc, rclc,  new CollisionContextPredicate(lclc, rclc));
		}
		return collisionContextPredicates.get(lclc, rclc);
	}
}

