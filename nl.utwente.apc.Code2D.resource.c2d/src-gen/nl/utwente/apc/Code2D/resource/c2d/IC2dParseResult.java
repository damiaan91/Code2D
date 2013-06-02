/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2d;

/**
 * An interface used to access the result of parsing a document.
 */
public interface IC2dParseResult {
	
	/**
	 * Returns the root object of the document.
	 */
	public org.eclipse.emf.ecore.EObject getRoot();
	
	/**
	 * Returns a list of commands that must be executed after parsing the document.
	 */
	public java.util.Collection<nl.utwente.apc.Code2D.resource.c2d.IC2dCommand<nl.utwente.apc.Code2D.resource.c2d.IC2dTextResource>> getPostParseCommands();
	
}
