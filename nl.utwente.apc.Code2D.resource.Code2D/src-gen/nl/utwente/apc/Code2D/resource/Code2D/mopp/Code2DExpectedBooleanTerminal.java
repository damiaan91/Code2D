/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.Code2D.mopp;

/**
 * A representation for a range in a document where a boolean attribute is
 * expected.
 */
public class Code2DExpectedBooleanTerminal extends nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DAbstractExpectedElement {
	
	private nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DBooleanTerminal booleanTerminal;
	
	public Code2DExpectedBooleanTerminal(nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DBooleanTerminal booleanTerminal) {
		super(booleanTerminal.getMetaclass());
		this.booleanTerminal = booleanTerminal;
	}
	
	public nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DBooleanTerminal getBooleanTerminal() {
		return booleanTerminal;
	}
	
	/**
	 * Returns the expected boolean terminal.
	 */
	public nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DSyntaxElement getSymtaxElement() {
		return booleanTerminal;
	}
	
	private org.eclipse.emf.ecore.EStructuralFeature getFeature() {
		return booleanTerminal.getFeature();
	}
	
	public String toString() {
		return "EFeature " + getFeature().getEContainingClass().getName() + "." + getFeature().getName();
	}
	
	public boolean equals(Object o) {
		if (o instanceof Code2DExpectedBooleanTerminal) {
			return getFeature().equals(((Code2DExpectedBooleanTerminal) o).getFeature());
		}
		return false;
	}
	
	@Override	
	public int hashCode() {
		return getFeature().hashCode();
	}
	
	public java.util.Set<String> getTokenNames() {
		// BooleanTerminals are associated with two or one token(s)
		java.util.Set<String> tokenNames = new java.util.LinkedHashSet<String>(2);
		String trueLiteral = booleanTerminal.getTrueLiteral();
		if (!"".equals(trueLiteral)) {
			tokenNames.add("'" + trueLiteral + "'");
		}
		String falseLiteral = booleanTerminal.getFalseLiteral();
		if (!"".equals(falseLiteral)) {
			tokenNames.add("'" + falseLiteral + "'");
		}
		return tokenNames;
	}
	
}
