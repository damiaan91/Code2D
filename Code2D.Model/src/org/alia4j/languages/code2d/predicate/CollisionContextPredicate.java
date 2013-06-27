package org.alia4j.languages.code2d.predicate;

import java.util.Arrays;
import java.util.List;

import nl.utwente.apc.Code2D.base.core.GameObject;

import org.alia4j.liam.AtomicPredicate;
import org.alia4j.liam.Context;
import org.alia4j.liam.signature.Signed;
import org.alia4j.util.Maybe;

public class CollisionContextPredicate extends AtomicPredicate {
	
	public CollisionContextPredicate(Context lclc, Context rclc) {
		super(Arrays.asList(lclc, rclc));
	}

	public boolean isSatisfied(Object one, Object two) {
		if (one instanceof List && two instanceof List){
			List<GameObject> leftCollisionList = (List<GameObject>) one;
			List<GameObject> rightCollisionList = (List<GameObject>) two;
			if(leftCollisionList.size() > 0 && rightCollisionList.size() > 0) 
				return existsColissionBetween(leftCollisionList, rightCollisionList);
		}
		return false;
	}
	
	private boolean existsColissionBetween(List<GameObject> one, List<GameObject> two) {
		for(GameObject go1 : one) {
			for(GameObject go2 : two) {
			if(go1!= go2 && go1.overlaps(go2))
				return true;
			}
		}
		return false;
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
