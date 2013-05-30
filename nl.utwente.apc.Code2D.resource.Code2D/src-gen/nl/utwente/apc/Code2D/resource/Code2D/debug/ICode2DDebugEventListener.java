/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.Code2D.debug;

public interface ICode2DDebugEventListener {
	
	/**
	 * Notification that the given event occurred in the while debugging.
	 */
	public void handleMessage(nl.utwente.apc.Code2D.resource.Code2D.debug.Code2DDebugMessage message);
}
