/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.Code2D;

/**
 * An interface used to access the result of parsing a document.
 */
public interface ICode2DParseResult {
	
	/**
	 * Returns the root object of the document.
	 */
	public org.eclipse.emf.ecore.EObject getRoot();
	
	/**
	 * Returns a list of commands that must be executed after parsing the document.
	 */
	public java.util.Collection<nl.utwente.apc.Code2D.resource.Code2D.ICode2DCommand<nl.utwente.apc.Code2D.resource.Code2D.ICode2DTextResource>> getPostParseCommands();
	
}
