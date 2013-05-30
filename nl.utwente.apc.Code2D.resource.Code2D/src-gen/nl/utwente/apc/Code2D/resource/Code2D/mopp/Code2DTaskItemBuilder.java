/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.Code2D.mopp;

/**
 * The Code2DTaskItemBuilder is used to find task items in text documents. The
 * current implementation uses the generated lexer and the TaskItemDetector to
 * detect task items. This class is called by the BuilderAdapter, which runs both
 * this builder and the default builder that is intended to be customized.
 */
public class Code2DTaskItemBuilder {
	
	public void build(org.eclipse.core.resources.IFile resource, org.eclipse.emf.ecore.resource.ResourceSet resourceSet, org.eclipse.core.runtime.IProgressMonitor monitor) {
		monitor.setTaskName("Searching for task items");
		new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DMarkerHelper().removeAllMarkers(resource, org.eclipse.core.resources.IMarker.TASK);
		if (isInBinFolder(resource)) {
			return;
		}
		java.util.List<nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DTaskItem> taskItems = new java.util.ArrayList<nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DTaskItem>();
		nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DTaskItemDetector taskItemDetector = new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DTaskItemDetector();
		try {
			java.io.InputStream inputStream = resource.getContents();
			String content = nl.utwente.apc.Code2D.resource.Code2D.util.Code2DStreamUtil.getContent(inputStream);
			nl.utwente.apc.Code2D.resource.Code2D.ICode2DTextScanner lexer = new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DMetaInformation().createLexer();
			lexer.setText(content);
			
			nl.utwente.apc.Code2D.resource.Code2D.ICode2DTextToken nextToken = lexer.getNextToken();
			while (nextToken != null) {
				String text = nextToken.getText();
				taskItems.addAll(taskItemDetector.findTaskItems(text, nextToken.getLine(), nextToken.getOffset()));
				nextToken = lexer.getNextToken();
			}
		} catch (java.io.IOException e) {
			nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DPlugin.logError("Exception while searching for task items", e);
		} catch (org.eclipse.core.runtime.CoreException e) {
			nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DPlugin.logError("Exception while searching for task items", e);
		}
		
		for (nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DTaskItem taskItem : taskItems) {
			java.util.Map<String, Object> markerAttributes = new java.util.LinkedHashMap<String, Object>();
			markerAttributes.put(org.eclipse.core.resources.IMarker.USER_EDITABLE, false);
			markerAttributes.put(org.eclipse.core.resources.IMarker.DONE, false);
			markerAttributes.put(org.eclipse.core.resources.IMarker.LINE_NUMBER, taskItem.getLine());
			markerAttributes.put(org.eclipse.core.resources.IMarker.CHAR_START, taskItem.getCharStart());
			markerAttributes.put(org.eclipse.core.resources.IMarker.CHAR_END, taskItem.getCharEnd());
			markerAttributes.put(org.eclipse.core.resources.IMarker.MESSAGE, taskItem.getMessage());
			new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DMarkerHelper().createMarker(resource, org.eclipse.core.resources.IMarker.TASK, markerAttributes);
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
