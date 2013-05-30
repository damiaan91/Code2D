/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.Code2D.ui;

public class Code2DOutlinePageActionProvider {
	
	public java.util.List<org.eclipse.jface.action.IAction> getActions(nl.utwente.apc.Code2D.resource.Code2D.ui.Code2DOutlinePageTreeViewer treeViewer) {
		// To add custom actions to the outline view, set the
		// 'overrideOutlinePageActionProvider' option to <code>false</code> and modify
		// this method.
		java.util.List<org.eclipse.jface.action.IAction> defaultActions = new java.util.ArrayList<org.eclipse.jface.action.IAction>();
		defaultActions.add(new nl.utwente.apc.Code2D.resource.Code2D.ui.Code2DOutlinePageLinkWithEditorAction(treeViewer));
		defaultActions.add(new nl.utwente.apc.Code2D.resource.Code2D.ui.Code2DOutlinePageCollapseAllAction(treeViewer));
		defaultActions.add(new nl.utwente.apc.Code2D.resource.Code2D.ui.Code2DOutlinePageExpandAllAction(treeViewer));
		defaultActions.add(new nl.utwente.apc.Code2D.resource.Code2D.ui.Code2DOutlinePageAutoExpandAction(treeViewer));
		defaultActions.add(new nl.utwente.apc.Code2D.resource.Code2D.ui.Code2DOutlinePageLexicalSortingAction(treeViewer));
		defaultActions.add(new nl.utwente.apc.Code2D.resource.Code2D.ui.Code2DOutlinePageTypeSortingAction(treeViewer));
		return defaultActions;
	}
	
}
