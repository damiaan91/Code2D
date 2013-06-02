/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2.ui;

public class C2OutlinePageCollapseAllAction extends nl.utwente.apc.Code2D.resource.c2.ui.AbstractC2OutlinePageAction {
	
	public C2OutlinePageCollapseAllAction(nl.utwente.apc.Code2D.resource.c2.ui.C2OutlinePageTreeViewer treeViewer) {
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
