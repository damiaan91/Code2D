/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.Code2D.mopp;

/**
 * A representation for a range in a document where a structural feature (e.g., a
 * reference) is expected.
 */
public class Code2DExpectedStructuralFeature extends nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DAbstractExpectedElement {
	
	private nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DPlaceholder placeholder;
	
	public Code2DExpectedStructuralFeature(nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DPlaceholder placeholder) {
		super(placeholder.getMetaclass());
		this.placeholder = placeholder;
	}
	
	public org.eclipse.emf.ecore.EStructuralFeature getFeature() {
		return placeholder.getFeature();
	}
	
	/**
	 * Returns the expected placeholder.
	 */
	public nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DSyntaxElement getSymtaxElement() {
		return placeholder;
	}
	
	public String getTokenName() {
		return placeholder.getTokenName();
	}
	
	public java.util.Set<String> getTokenNames() {
		return java.util.Collections.singleton(getTokenName());
	}
	
	public String toString() {
		return "EFeature " + getFeature().getEContainingClass().getName() + "." + getFeature().getName();
	}
	
	public boolean equals(Object o) {
		if (o instanceof Code2DExpectedStructuralFeature) {
			return getFeature().equals(((Code2DExpectedStructuralFeature) o).getFeature());
		}
		return false;
	}
	@Override	
	public int hashCode() {
		return getFeature().hashCode();
	}
	
}
