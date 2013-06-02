/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2.grammar;

/**
 * A class to represent placeholders in a grammar.
 */
public class C2Placeholder extends nl.utwente.apc.Code2D.resource.c2.grammar.C2Terminal {
	
	private final String tokenName;
	
	public C2Placeholder(org.eclipse.emf.ecore.EStructuralFeature feature, String tokenName, nl.utwente.apc.Code2D.resource.c2.grammar.C2Cardinality cardinality, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.tokenName = tokenName;
	}
	
	public String getTokenName() {
		return tokenName;
	}
	
}
