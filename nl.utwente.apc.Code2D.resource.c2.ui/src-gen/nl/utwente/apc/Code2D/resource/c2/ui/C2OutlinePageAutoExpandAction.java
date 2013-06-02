/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2.ui;

public class C2OutlinePageAutoExpandAction extends nl.utwente.apc.Code2D.resource.c2.ui.AbstractC2OutlinePageAction {
	
	public C2OutlinePageAutoExpandAction(nl.utwente.apc.Code2D.resource.c2.ui.C2OutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Auto expand", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/auto_expand_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setAutoExpand(on);
		getTreeViewer().refresh();
	}
	
}
