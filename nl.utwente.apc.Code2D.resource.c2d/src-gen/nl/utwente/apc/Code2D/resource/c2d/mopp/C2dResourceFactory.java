/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2d.mopp;

public class C2dResourceFactory implements org.eclipse.emf.ecore.resource.Resource.Factory {
	
	public C2dResourceFactory() {
		super();
	}
	
	public org.eclipse.emf.ecore.resource.Resource createResource(org.eclipse.emf.common.util.URI uri) {
		return new nl.utwente.apc.Code2D.resource.c2d.mopp.C2dResource(uri);
	}
	
}
