/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2d.debug;

public class C2dSourceLookupParticipant extends org.eclipse.debug.core.sourcelookup.AbstractSourceLookupParticipant {
	
	public String getSourceName(Object object) throws org.eclipse.core.runtime.CoreException {
		if (object instanceof nl.utwente.apc.Code2D.resource.c2d.debug.C2dStackFrame) {
			nl.utwente.apc.Code2D.resource.c2d.debug.C2dStackFrame frame = (nl.utwente.apc.Code2D.resource.c2d.debug.C2dStackFrame) object;
			return frame.getResourceURI();
		}
		return null;
	}
	
}
