/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2d.debug;

public interface IC2dDebugEventListener {
	
	/**
	 * Notification that the given event occurred in the while debugging.
	 */
	public void handleMessage(nl.utwente.apc.Code2D.resource.c2d.debug.C2dDebugMessage message);
}
