/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.Code2D.debug;

public class Code2DSourceLookupParticipant extends org.eclipse.debug.core.sourcelookup.AbstractSourceLookupParticipant {
	
	public String getSourceName(Object object) throws org.eclipse.core.runtime.CoreException {
		if (object instanceof nl.utwente.apc.Code2D.resource.Code2D.debug.Code2DStackFrame) {
			nl.utwente.apc.Code2D.resource.Code2D.debug.Code2DStackFrame frame = (nl.utwente.apc.Code2D.resource.Code2D.debug.Code2DStackFrame) object;
			return frame.getResourceURI();
		}
		return null;
	}
	
}
