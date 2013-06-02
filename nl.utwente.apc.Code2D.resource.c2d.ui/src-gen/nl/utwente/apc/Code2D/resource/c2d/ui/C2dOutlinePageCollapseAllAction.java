/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2d.ui;

public class C2dOutlinePageCollapseAllAction extends nl.utwente.apc.Code2D.resource.c2d.ui.AbstractC2dOutlinePageAction {
	
	public C2dOutlinePageCollapseAllAction(nl.utwente.apc.Code2D.resource.c2d.ui.C2dOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Collapse all", org.eclipse.jface.action.IAction.AS_PUSH_BUTTON);
		initialize("icons/collapse_all_icon.gif");
	}
	
	public void runInternal(boolean on) {
		if (on) {
			getTreeViewer().collapseAll();
		}
	}
	
	public boolean keepState() {
		return false;
	}
	
}
