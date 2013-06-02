/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2d.ui;

public class C2dOutlinePageActionProvider {
	
	public java.util.List<org.eclipse.jface.action.IAction> getActions(nl.utwente.apc.Code2D.resource.c2d.ui.C2dOutlinePageTreeViewer treeViewer) {
		// To add custom actions to the outline view, set the
		// 'overrideOutlinePageActionProvider' option to <code>false</code> and modify
		// this method.
		java.util.List<org.eclipse.jface.action.IAction> defaultActions = new java.util.ArrayList<org.eclipse.jface.action.IAction>();
		defaultActions.add(new nl.utwente.apc.Code2D.resource.c2d.ui.C2dOutlinePageLinkWithEditorAction(treeViewer));
		defaultActions.add(new nl.utwente.apc.Code2D.resource.c2d.ui.C2dOutlinePageCollapseAllAction(treeViewer));
		defaultActions.add(new nl.utwente.apc.Code2D.resource.c2d.ui.C2dOutlinePageExpandAllAction(treeViewer));
		defaultActions.add(new nl.utwente.apc.Code2D.resource.c2d.ui.C2dOutlinePageAutoExpandAction(treeViewer));
		defaultActions.add(new nl.utwente.apc.Code2D.resource.c2d.ui.C2dOutlinePageLexicalSortingAction(treeViewer));
		defaultActions.add(new nl.utwente.apc.Code2D.resource.c2d.ui.C2dOutlinePageTypeSortingAction(treeViewer));
		return defaultActions;
	}
	
}
