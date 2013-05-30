/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.Code2D.mopp;

/**
 * A FuzzyResolveResult is an implementation of the ICode2DReferenceResolveResult
 * interface that delegates all method calls to a given
 * ICode2DReferenceResolveResult with ReferenceType EObject. It is used by
 * reference resolver switches to collect results from different reference
 * resolvers in a type safe manner.
 * 
 * @param <ReferenceType> the type of the reference that is resolved
 */
public class Code2DFuzzyResolveResult<ReferenceType extends org.eclipse.emf.ecore.EObject> implements nl.utwente.apc.Code2D.resource.Code2D.ICode2DReferenceResolveResult<ReferenceType> {
	
	private nl.utwente.apc.Code2D.resource.Code2D.ICode2DReferenceResolveResult<org.eclipse.emf.ecore.EObject> delegate;
	
	public Code2DFuzzyResolveResult(nl.utwente.apc.Code2D.resource.Code2D.ICode2DReferenceResolveResult<org.eclipse.emf.ecore.EObject> delegate) {
		this.delegate = delegate;
	}
	
	public String getErrorMessage() {
		return delegate.getErrorMessage();
	}
	
	public java.util.Collection<nl.utwente.apc.Code2D.resource.Code2D.ICode2DReferenceMapping<ReferenceType>> getMappings() {
		return null;
	}
	
	public boolean wasResolved() {
		return delegate.wasResolved();
	}
	
	public boolean wasResolvedMultiple() {
		return delegate.wasResolvedMultiple();
	}
	
	public boolean wasResolvedUniquely() {
		return delegate.wasResolvedUniquely();
	}
	
	public void setErrorMessage(String message) {
		delegate.setErrorMessage(message);
	}
	
	public void addMapping(String identifier, ReferenceType target) {
		delegate.addMapping(identifier, (org.eclipse.emf.ecore.EObject) target);
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri) {
		delegate.addMapping(identifier, uri);
	}
	
	public void addMapping(String identifier, ReferenceType target, String warning) {
		delegate.addMapping(identifier, (org.eclipse.emf.ecore.EObject) target, warning);
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri, String warning) {
		delegate.addMapping(identifier, uri, warning);
	}
	
	public java.util.Collection<nl.utwente.apc.Code2D.resource.Code2D.ICode2DQuickFix> getQuickFixes() {
		return delegate.getQuickFixes();
	}
	
	public void addQuickFix(nl.utwente.apc.Code2D.resource.Code2D.ICode2DQuickFix quickFix) {
		delegate.addQuickFix(quickFix);
	}
	
}
