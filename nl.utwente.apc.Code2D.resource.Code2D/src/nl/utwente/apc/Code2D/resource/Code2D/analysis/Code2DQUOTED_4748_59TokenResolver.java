/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.Code2D.analysis;

public class Code2DQUOTED_4748_59TokenResolver implements nl.utwente.apc.Code2D.resource.Code2D.ICode2DTokenResolver {
	
	private nl.utwente.apc.Code2D.resource.Code2D.analysis.Code2DDefaultTokenResolver defaultTokenResolver = new nl.utwente.apc.Code2D.resource.Code2D.analysis.Code2DDefaultTokenResolver(true);
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		// By default token de-resolving is delegated to the DefaultTokenResolver.
		String result = defaultTokenResolver.deResolve(value, feature, container, "/0", ";", null);
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, nl.utwente.apc.Code2D.resource.Code2D.ICode2DTokenResolveResult result) {
		// By default token resolving is delegated to the DefaultTokenResolver.
		defaultTokenResolver.resolve(lexem, feature, result, "/0", ";", null);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
