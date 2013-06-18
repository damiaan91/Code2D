package org.alia4j.languages.code2d.predicate;

import java.util.Arrays;
import java.util.List;

import org.alia4j.languages.code2d.context.GameObjectContext;
import org.alia4j.liam.AtomicPredicate;
import org.alia4j.liam.Context;
import org.alia4j.liam.signature.Signed;
import org.alia4j.util.Maybe;

public class TriggerDispatching extends AtomicPredicate {
	
	public TriggerDispatching(Context firstObjectContext, Context secondObjectContext) {
		super(Arrays.asList(firstObjectContext, secondObjectContext));
	}
	
	public boolean collision(GameObjectContext one, GameObjectContext two) {
		return one.getGO().x == two.getGO().x && one.getGO().y == two.getGO().y;
	}

	@Override
	public Maybe<Boolean> computeIsSatisfiedStatically(List<? extends Signed<?>> callStack) {
		return new Maybe<Boolean>();
	}

	@Override
	public int estimateRuntimeCost() {
		return 1;
	}
	
}
