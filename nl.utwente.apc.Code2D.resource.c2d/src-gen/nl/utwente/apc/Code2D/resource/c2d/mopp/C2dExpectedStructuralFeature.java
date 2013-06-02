/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2d.mopp;

/**
 * A representation for a range in a document where a structural feature (e.g., a
 * reference) is expected.
 */
public class C2dExpectedStructuralFeature extends nl.utwente.apc.Code2D.resource.c2d.mopp.C2dAbstractExpectedElement {
	
	private nl.utwente.apc.Code2D.resource.c2d.grammar.C2dPlaceholder placeholder;
	
	public C2dExpectedStructuralFeature(nl.utwente.apc.Code2D.resource.c2d.grammar.C2dPlaceholder placeholder) {
		super(placeholder.getMetaclass());
		this.placeholder = placeholder;
	}
	
	public org.eclipse.emf.ecore.EStructuralFeature getFeature() {
		return placeholder.getFeature();
	}
	
	/**
	 * Returns the expected placeholder.
	 */
	public nl.utwente.apc.Code2D.resource.c2d.grammar.C2dSyntaxElement getSymtaxElement() {
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
		if (o instanceof C2dExpectedStructuralFeature) {
			return getFeature().equals(((C2dExpectedStructuralFeature) o).getFeature());
		}
		return false;
	}
	@Override	
	public int hashCode() {
		return getFeature().hashCode();
	}
	
}
