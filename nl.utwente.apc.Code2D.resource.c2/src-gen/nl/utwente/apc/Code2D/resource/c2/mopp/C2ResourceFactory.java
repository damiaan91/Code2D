/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2.mopp;

public class C2ResourceFactory implements org.eclipse.emf.ecore.resource.Resource.Factory {
	
	public C2ResourceFactory() {
		super();
	}
	
	public org.eclipse.emf.ecore.resource.Resource createResource(org.eclipse.emf.common.util.URI uri) {
		return new nl.utwente.apc.Code2D.resource.c2.mopp.C2Resource(uri);
	}
	
}
