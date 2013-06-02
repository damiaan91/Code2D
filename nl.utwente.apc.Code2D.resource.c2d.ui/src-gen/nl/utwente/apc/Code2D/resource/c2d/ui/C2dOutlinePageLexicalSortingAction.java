/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2d.ui;

public class C2dOutlinePageLexicalSortingAction extends nl.utwente.apc.Code2D.resource.c2d.ui.AbstractC2dOutlinePageAction {
	
	public C2dOutlinePageLexicalSortingAction(nl.utwente.apc.Code2D.resource.c2d.ui.C2dOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Sort alphabetically", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/sort_lexically_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewerComparator().setSortLexically(on);
		getTreeViewer().refresh();
	}
	
}
