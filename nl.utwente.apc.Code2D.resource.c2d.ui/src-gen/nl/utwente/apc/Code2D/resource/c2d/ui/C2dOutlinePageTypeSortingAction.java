/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2d.ui;

public class C2dOutlinePageTypeSortingAction extends nl.utwente.apc.Code2D.resource.c2d.ui.AbstractC2dOutlinePageAction {
	
	public C2dOutlinePageTypeSortingAction(nl.utwente.apc.Code2D.resource.c2d.ui.C2dOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Group types", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/group_types_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewerComparator().setGroupTypes(on);
		getTreeViewer().refresh();
	}
	
}
