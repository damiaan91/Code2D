/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.Code2D.mopp;

public class Code2DResourceFactory implements org.eclipse.emf.ecore.resource.Resource.Factory {
	
	public Code2DResourceFactory() {
		super();
	}
	
	public org.eclipse.emf.ecore.resource.Resource createResource(org.eclipse.emf.common.util.URI uri) {
		return new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DResource(uri);
	}
	
}
