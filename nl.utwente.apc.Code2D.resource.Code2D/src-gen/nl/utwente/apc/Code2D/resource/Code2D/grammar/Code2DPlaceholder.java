/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.Code2D.grammar;

/**
 * A class to represent placeholders in a grammar.
 */
public class Code2DPlaceholder extends nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DTerminal {
	
	private final String tokenName;
	
	public Code2DPlaceholder(org.eclipse.emf.ecore.EStructuralFeature feature, String tokenName, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DCardinality cardinality, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.tokenName = tokenName;
	}
	
	public String getTokenName() {
		return tokenName;
	}
	
}
