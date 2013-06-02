/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2.debug;

public class C2SourceLookupParticipant extends org.eclipse.debug.core.sourcelookup.AbstractSourceLookupParticipant {
	
	public String getSourceName(Object object) throws org.eclipse.core.runtime.CoreException {
		if (object instanceof nl.utwente.apc.Code2D.resource.c2.debug.C2StackFrame) {
			nl.utwente.apc.Code2D.resource.c2.debug.C2StackFrame frame = (nl.utwente.apc.Code2D.resource.c2.debug.C2StackFrame) object;
			return frame.getResourceURI();
		}
		return null;
	}
	
}
