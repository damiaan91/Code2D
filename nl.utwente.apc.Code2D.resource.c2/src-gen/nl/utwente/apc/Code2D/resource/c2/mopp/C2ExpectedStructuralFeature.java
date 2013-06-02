/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2.mopp;

/**
 * A representation for a range in a document where a structural feature (e.g., a
 * reference) is expected.
 */
public class C2ExpectedStructuralFeature extends nl.utwente.apc.Code2D.resource.c2.mopp.C2AbstractExpectedElement {
	
	private nl.utwente.apc.Code2D.resource.c2.grammar.C2Placeholder placeholder;
	
	public C2ExpectedStructuralFeature(nl.utwente.apc.Code2D.resource.c2.grammar.C2Placeholder placeholder) {
		super(placeholder.getMetaclass());
		this.placeholder = placeholder;
	}
	
	public org.eclipse.emf.ecore.EStructuralFeature getFeature() {
		return placeholder.getFeature();
	}
	
	/**
	 * Returns the expected placeholder.
	 */
	public nl.utwente.apc.Code2D.resource.c2.grammar.C2SyntaxElement getSymtaxElement() {
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
		if (o instanceof C2ExpectedStructuralFeature) {
			return getFeature().equals(((C2ExpectedStructuralFeature) o).getFeature());
		}
		return false;
	}
	@Override	
	public int hashCode() {
		return getFeature().hashCode();
	}
	
}
