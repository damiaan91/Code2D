/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2d.grammar;

/**
 * A class to represent placeholders in a grammar.
 */
public class C2dPlaceholder extends nl.utwente.apc.Code2D.resource.c2d.grammar.C2dTerminal {
	
	private final String tokenName;
	
	public C2dPlaceholder(org.eclipse.emf.ecore.EStructuralFeature feature, String tokenName, nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality cardinality, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.tokenName = tokenName;
	}
	
	public String getTokenName() {
		return tokenName;
	}
	
}
