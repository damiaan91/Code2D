/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.Code2D;

/**
 * A simple interface for commands that can be executed and that return
 * information about the success of their execution.
 */
public interface ICode2DCommand<ContextType> {
	
	public boolean execute(ContextType context);
}
