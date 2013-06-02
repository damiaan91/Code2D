/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2.ui;

public class C2OutlinePageLinkWithEditorAction extends nl.utwente.apc.Code2D.resource.c2.ui.AbstractC2OutlinePageAction {
	
	public C2OutlinePageLinkWithEditorAction(nl.utwente.apc.Code2D.resource.c2.ui.C2OutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Link with Editor", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/link_with_editor_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setLinkWithEditor(on);
	}
	
}
