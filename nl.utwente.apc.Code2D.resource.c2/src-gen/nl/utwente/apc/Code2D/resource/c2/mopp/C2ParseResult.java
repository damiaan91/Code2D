/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2.mopp;

public class C2ParseResult implements nl.utwente.apc.Code2D.resource.c2.IC2ParseResult {
	
	private org.eclipse.emf.ecore.EObject root;
	private java.util.Collection<nl.utwente.apc.Code2D.resource.c2.IC2Command<nl.utwente.apc.Code2D.resource.c2.IC2TextResource>> commands = new java.util.ArrayList<nl.utwente.apc.Code2D.resource.c2.IC2Command<nl.utwente.apc.Code2D.resource.c2.IC2TextResource>>();
	
	public C2ParseResult() {
		super();
	}
	
	public void setRoot(org.eclipse.emf.ecore.EObject root) {
		this.root = root;
	}
	
	public org.eclipse.emf.ecore.EObject getRoot() {
		return root;
	}
	
	public java.util.Collection<nl.utwente.apc.Code2D.resource.c2.IC2Command<nl.utwente.apc.Code2D.resource.c2.IC2TextResource>> getPostParseCommands() {
		return commands;
	}
	
}
