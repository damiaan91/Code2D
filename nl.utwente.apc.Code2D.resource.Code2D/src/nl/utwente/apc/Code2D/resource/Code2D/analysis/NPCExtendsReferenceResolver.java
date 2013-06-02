/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.Code2D.analysis;

public class NPCExtendsReferenceResolver implements nl.utwente.apc.Code2D.resource.Code2D.ICode2DReferenceResolver<nl.utwente.apc.Code2D.NPC, nl.utwente.apc.Code2D.NPC> {
	
	private nl.utwente.apc.Code2D.resource.Code2D.analysis.Code2DDefaultResolverDelegate<nl.utwente.apc.Code2D.NPC, nl.utwente.apc.Code2D.NPC> delegate = new nl.utwente.apc.Code2D.resource.Code2D.analysis.Code2DDefaultResolverDelegate<nl.utwente.apc.Code2D.NPC, nl.utwente.apc.Code2D.NPC>();
	
	public void resolve(String identifier, nl.utwente.apc.Code2D.NPC container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final nl.utwente.apc.Code2D.resource.Code2D.ICode2DReferenceResolveResult<nl.utwente.apc.Code2D.NPC> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(nl.utwente.apc.Code2D.NPC element, nl.utwente.apc.Code2D.NPC container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
