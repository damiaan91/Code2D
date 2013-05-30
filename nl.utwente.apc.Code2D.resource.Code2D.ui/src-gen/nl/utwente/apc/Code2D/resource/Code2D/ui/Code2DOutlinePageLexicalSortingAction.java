/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.Code2D.ui;

public class Code2DOutlinePageLexicalSortingAction extends nl.utwente.apc.Code2D.resource.Code2D.ui.AbstractCode2DOutlinePageAction {
	
	public Code2DOutlinePageLexicalSortingAction(nl.utwente.apc.Code2D.resource.Code2D.ui.Code2DOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Sort alphabetically", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/sort_lexically_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewerComparator().setSortLexically(on);
		getTreeViewer().refresh();
	}
	
}
