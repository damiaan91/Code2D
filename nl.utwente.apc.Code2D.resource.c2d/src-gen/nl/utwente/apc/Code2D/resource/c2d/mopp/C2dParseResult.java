/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2d.mopp;

public class C2dParseResult implements nl.utwente.apc.Code2D.resource.c2d.IC2dParseResult {
	
	private org.eclipse.emf.ecore.EObject root;
	private java.util.Collection<nl.utwente.apc.Code2D.resource.c2d.IC2dCommand<nl.utwente.apc.Code2D.resource.c2d.IC2dTextResource>> commands = new java.util.ArrayList<nl.utwente.apc.Code2D.resource.c2d.IC2dCommand<nl.utwente.apc.Code2D.resource.c2d.IC2dTextResource>>();
	
	public C2dParseResult() {
		super();
	}
	
	public void setRoot(org.eclipse.emf.ecore.EObject root) {
		this.root = root;
	}
	
	public org.eclipse.emf.ecore.EObject getRoot() {
		return root;
	}
	
	public java.util.Collection<nl.utwente.apc.Code2D.resource.c2d.IC2dCommand<nl.utwente.apc.Code2D.resource.c2d.IC2dTextResource>> getPostParseCommands() {
		return commands;
	}
	
}
