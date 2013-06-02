/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2.ui;

public class C2OutlinePageActionProvider {
	
	public java.util.List<org.eclipse.jface.action.IAction> getActions(nl.utwente.apc.Code2D.resource.c2.ui.C2OutlinePageTreeViewer treeViewer) {
		// To add custom actions to the outline view, set the
		// 'overrideOutlinePageActionProvider' option to <code>false</code> and modify
		// this method.
		java.util.List<org.eclipse.jface.action.IAction> defaultActions = new java.util.ArrayList<org.eclipse.jface.action.IAction>();
		defaultActions.add(new nl.utwente.apc.Code2D.resource.c2.ui.C2OutlinePageLinkWithEditorAction(treeViewer));
		defaultActions.add(new nl.utwente.apc.Code2D.resource.c2.ui.C2OutlinePageCollapseAllAction(treeViewer));
		defaultActions.add(new nl.utwente.apc.Code2D.resource.c2.ui.C2OutlinePageExpandAllAction(treeViewer));
		defaultActions.add(new nl.utwente.apc.Code2D.resource.c2.ui.C2OutlinePageAutoExpandAction(treeViewer));
		defaultActions.add(new nl.utwente.apc.Code2D.resource.c2.ui.C2OutlinePageLexicalSortingAction(treeViewer));
		defaultActions.add(new nl.utwente.apc.Code2D.resource.c2.ui.C2OutlinePageTypeSortingAction(treeViewer));
		return defaultActions;
	}
	
}
