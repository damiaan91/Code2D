/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2d.mopp;

/**
 * A FuzzyResolveResult is an implementation of the IC2dReferenceResolveResult
 * interface that delegates all method calls to a given IC2dReferenceResolveResult
 * with ReferenceType EObject. It is used by reference resolver switches to
 * collect results from different reference resolvers in a type safe manner.
 * 
 * @param <ReferenceType> the type of the reference that is resolved
 */
public class C2dFuzzyResolveResult<ReferenceType extends org.eclipse.emf.ecore.EObject> implements nl.utwente.apc.Code2D.resource.c2d.IC2dReferenceResolveResult<ReferenceType> {
	
	private nl.utwente.apc.Code2D.resource.c2d.IC2dReferenceResolveResult<org.eclipse.emf.ecore.EObject> delegate;
	
	public C2dFuzzyResolveResult(nl.utwente.apc.Code2D.resource.c2d.IC2dReferenceResolveResult<org.eclipse.emf.ecore.EObject> delegate) {
		this.delegate = delegate;
	}
	
	public String getErrorMessage() {
		return delegate.getErrorMessage();
	}
	
	public java.util.Collection<nl.utwente.apc.Code2D.resource.c2d.IC2dReferenceMapping<ReferenceType>> getMappings() {
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
	
	public java.util.Collection<nl.utwente.apc.Code2D.resource.c2d.IC2dQuickFix> getQuickFixes() {
		return delegate.getQuickFixes();
	}
	
	public void addQuickFix(nl.utwente.apc.Code2D.resource.c2d.IC2dQuickFix quickFix) {
		delegate.addQuickFix(quickFix);
	}
	
}
