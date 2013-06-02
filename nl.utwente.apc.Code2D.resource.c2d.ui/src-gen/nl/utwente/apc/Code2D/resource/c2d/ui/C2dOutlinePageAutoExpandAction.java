/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2d.ui;

public class C2dOutlinePageAutoExpandAction extends nl.utwente.apc.Code2D.resource.c2d.ui.AbstractC2dOutlinePageAction {
	
	public C2dOutlinePageAutoExpandAction(nl.utwente.apc.Code2D.resource.c2d.ui.C2dOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Auto expand", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/auto_expand_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setAutoExpand(on);
		getTreeViewer().refresh();
	}
	
}
