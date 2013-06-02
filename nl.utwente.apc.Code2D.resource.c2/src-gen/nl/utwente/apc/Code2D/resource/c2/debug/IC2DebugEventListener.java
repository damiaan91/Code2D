/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2.debug;

public interface IC2DebugEventListener {
	
	/**
	 * Notification that the given event occurred in the while debugging.
	 */
	public void handleMessage(nl.utwente.apc.Code2D.resource.c2.debug.C2DebugMessage message);
}
