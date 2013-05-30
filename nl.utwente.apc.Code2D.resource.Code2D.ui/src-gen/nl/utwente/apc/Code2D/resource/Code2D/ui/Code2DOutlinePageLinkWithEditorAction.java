/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.Code2D.ui;

public class Code2DOutlinePageLinkWithEditorAction extends nl.utwente.apc.Code2D.resource.Code2D.ui.AbstractCode2DOutlinePageAction {
	
	public Code2DOutlinePageLinkWithEditorAction(nl.utwente.apc.Code2D.resource.Code2D.ui.Code2DOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Link with Editor", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/link_with_editor_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setLinkWithEditor(on);
	}
	
}
