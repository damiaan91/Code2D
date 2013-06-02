/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2d.mopp;

/**
 * The C2dTaskItemBuilder is used to find task items in text documents. The
 * current implementation uses the generated lexer and the TaskItemDetector to
 * detect task items. This class is called by the BuilderAdapter, which runs both
 * this builder and the default builder that is intended to be customized.
 */
public class C2dTaskItemBuilder {
	
	public void build(org.eclipse.core.resources.IFile resource, org.eclipse.emf.ecore.resource.ResourceSet resourceSet, org.eclipse.core.runtime.IProgressMonitor monitor) {
		monitor.setTaskName("Searching for task items");
		new nl.utwente.apc.Code2D.resource.c2d.mopp.C2dMarkerHelper().removeAllMarkers(resource, org.eclipse.core.resources.IMarker.TASK);
		if (isInBinFolder(resource)) {
			return;
		}
		java.util.List<nl.utwente.apc.Code2D.resource.c2d.mopp.C2dTaskItem> taskItems = new java.util.ArrayList<nl.utwente.apc.Code2D.resource.c2d.mopp.C2dTaskItem>();
		nl.utwente.apc.Code2D.resource.c2d.mopp.C2dTaskItemDetector taskItemDetector = new nl.utwente.apc.Code2D.resource.c2d.mopp.C2dTaskItemDetector();
		try {
			java.io.InputStream inputStream = resource.getContents();
			String content = nl.utwente.apc.Code2D.resource.c2d.util.C2dStreamUtil.getContent(inputStream);
			nl.utwente.apc.Code2D.resource.c2d.IC2dTextScanner lexer = new nl.utwente.apc.Code2D.resource.c2d.mopp.C2dMetaInformation().createLexer();
			lexer.setText(content);
			
			nl.utwente.apc.Code2D.resource.c2d.IC2dTextToken nextToken = lexer.getNextToken();
			while (nextToken != null) {
				String text = nextToken.getText();
				taskItems.addAll(taskItemDetector.findTaskItems(text, nextToken.getLine(), nextToken.getOffset()));
				nextToken = lexer.getNextToken();
			}
		} catch (java.io.IOException e) {
			nl.utwente.apc.Code2D.resource.c2d.mopp.C2dPlugin.logError("Exception while searching for task items", e);
		} catch (org.eclipse.core.runtime.CoreException e) {
			nl.utwente.apc.Code2D.resource.c2d.mopp.C2dPlugin.logError("Exception while searching for task items", e);
		}
		
		for (nl.utwente.apc.Code2D.resource.c2d.mopp.C2dTaskItem taskItem : taskItems) {
			java.util.Map<String, Object> markerAttributes = new java.util.LinkedHashMap<String, Object>();
			markerAttributes.put(org.eclipse.core.resources.IMarker.USER_EDITABLE, false);
			markerAttributes.put(org.eclipse.core.resources.IMarker.DONE, false);
			markerAttributes.put(org.eclipse.core.resources.IMarker.LINE_NUMBER, taskItem.getLine());
			markerAttributes.put(org.eclipse.core.resources.IMarker.CHAR_START, taskItem.getCharStart());
			markerAttributes.put(org.eclipse.core.resources.IMarker.CHAR_END, taskItem.getCharEnd());
			markerAttributes.put(org.eclipse.core.resources.IMarker.MESSAGE, taskItem.getMessage());
			new nl.utwente.apc.Code2D.resource.c2d.mopp.C2dMarkerHelper().createMarker(resource, org.eclipse.core.resources.IMarker.TASK, markerAttributes);
		}
	}
	
	public String getBuilderMarkerId() {
		return org.eclipse.core.resources.IMarker.TASK;
	}
	
	public boolean isInBinFolder(org.eclipse.core.resources.IFile resource) {
		org.eclipse.core.resources.IContainer parent = resource.getParent();
		while (parent != null) {
			if ("bin".equals(parent.getName())) {
				return true;
			}
			parent = parent.getParent();
		}
		return false;
	}
	
}
