/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2d;

/**
 * A simple interface for commands that can be executed and that return
 * information about the success of their execution.
 */
public interface IC2dCommand<ContextType> {
	
	public boolean execute(ContextType context);
}
