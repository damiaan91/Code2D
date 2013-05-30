/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.Code2D.debug;

public class Code2DLineBreakpoint extends org.eclipse.debug.core.model.LineBreakpoint {
	
	private static final String LINE_BREAKPOINT_MARKER_ID = "nl.utwente.apc.Code2D.resource.Code2D.debug.lineBreakpoint.marker";
	
	public Code2DLineBreakpoint() {
		super();
	}
	
	public Code2DLineBreakpoint(final org.eclipse.core.resources.IResource resource, final int lineNumber) throws org.eclipse.debug.core.DebugException {
		org.eclipse.core.resources.IWorkspaceRunnable runnable = new org.eclipse.core.resources.IWorkspaceRunnable() {
			public void run(org.eclipse.core.runtime.IProgressMonitor monitor) throws org.eclipse.core.runtime.CoreException {
				org.eclipse.core.resources.IMarker marker = resource.createMarker(LINE_BREAKPOINT_MARKER_ID);
				setMarker(marker);
				marker.setAttribute(org.eclipse.debug.core.model.IBreakpoint.ENABLED, Boolean.TRUE);
				marker.setAttribute(org.eclipse.core.resources.IMarker.LINE_NUMBER, lineNumber);
				marker.setAttribute(org.eclipse.debug.core.model.IBreakpoint.ID, getModelIdentifier());
				marker.setAttribute(org.eclipse.core.resources.IMarker.MESSAGE, "Line Breakpoint: " + resource.getName() + " [line: " + lineNumber + "]");
				marker.setAttribute(org.eclipse.core.resources.IMarker.LOCATION, resource.getRawLocation().toPortableString());
			}
		};
		run(getMarkerRule(resource), runnable);
	}
	
	public String getModelIdentifier() {
		return nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DPlugin.DEBUG_MODEL_ID;
	}
	
	public void install(nl.utwente.apc.Code2D.resource.Code2D.debug.Code2DDebugTarget target) {
		try {
			String location = (String) getMarker().getAttribute(org.eclipse.core.resources.IMarker.LOCATION);
			target.getDebugProxy().addLineBreakpoint(location, getLineNumber());
		} catch (org.eclipse.core.runtime.CoreException e) {
			e.printStackTrace();
		}
	}
	
	public void remove(nl.utwente.apc.Code2D.resource.Code2D.debug.Code2DDebugTarget target) {
		try {
			String location = (String) getMarker().getAttribute(org.eclipse.core.resources.IMarker.LOCATION);
			target.getDebugProxy().removeLineBreakpoint(location, getLineNumber());
		} catch (org.eclipse.core.runtime.CoreException e) {
			e.printStackTrace();
		}
	}
	
}
