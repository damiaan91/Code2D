/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.Code2D.ui;

public class Code2DOutlinePageTypeSortingAction extends nl.utwente.apc.Code2D.resource.Code2D.ui.AbstractCode2DOutlinePageAction {
	
	public Code2DOutlinePageTypeSortingAction(nl.utwente.apc.Code2D.resource.Code2D.ui.Code2DOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Group types", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/group_types_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewerComparator().setGroupTypes(on);
		getTreeViewer().refresh();
	}
	
}
