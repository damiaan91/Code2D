/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2.analysis;

public class C2TEXTTokenResolver implements nl.utwente.apc.Code2D.resource.c2.IC2TokenResolver {
	
	private nl.utwente.apc.Code2D.resource.c2.analysis.C2DefaultTokenResolver defaultTokenResolver = new nl.utwente.apc.Code2D.resource.c2.analysis.C2DefaultTokenResolver(true);
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		// By default token de-resolving is delegated to the DefaultTokenResolver.
		String result = defaultTokenResolver.deResolve(value, feature, container, null, null, null);
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, nl.utwente.apc.Code2D.resource.c2.IC2TokenResolveResult result) {
		// By default token resolving is delegated to the DefaultTokenResolver.
		defaultTokenResolver.resolve(lexem, feature, result, null, null, null);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
