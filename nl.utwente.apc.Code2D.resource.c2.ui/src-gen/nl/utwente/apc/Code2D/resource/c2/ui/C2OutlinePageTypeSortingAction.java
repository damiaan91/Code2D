/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2.ui;

public class C2OutlinePageTypeSortingAction extends nl.utwente.apc.Code2D.resource.c2.ui.AbstractC2OutlinePageAction {
	
	public C2OutlinePageTypeSortingAction(nl.utwente.apc.Code2D.resource.c2.ui.C2OutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Group types", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/group_types_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewerComparator().setGroupTypes(on);
		getTreeViewer().refresh();
	}
	
}
