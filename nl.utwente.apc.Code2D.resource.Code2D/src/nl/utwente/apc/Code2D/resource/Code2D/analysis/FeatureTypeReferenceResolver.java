/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.Code2D.analysis;

public class FeatureTypeReferenceResolver implements nl.utwente.apc.Code2D.resource.Code2D.ICode2DReferenceResolver<nl.utwente.apc.Code2D.Feature, nl.utwente.apc.Code2D.Type> {
	
	private nl.utwente.apc.Code2D.resource.Code2D.analysis.Code2DDefaultResolverDelegate<nl.utwente.apc.Code2D.Feature, nl.utwente.apc.Code2D.Type> delegate = new nl.utwente.apc.Code2D.resource.Code2D.analysis.Code2DDefaultResolverDelegate<nl.utwente.apc.Code2D.Feature, nl.utwente.apc.Code2D.Type>();
	
	public void resolve(String identifier, nl.utwente.apc.Code2D.Feature container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final nl.utwente.apc.Code2D.resource.Code2D.ICode2DReferenceResolveResult<nl.utwente.apc.Code2D.Type> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(nl.utwente.apc.Code2D.Type element, nl.utwente.apc.Code2D.Feature container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
