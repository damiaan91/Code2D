/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.Code2D.ui;

public class Code2DOutlinePageAutoExpandAction extends nl.utwente.apc.Code2D.resource.Code2D.ui.AbstractCode2DOutlinePageAction {
	
	public Code2DOutlinePageAutoExpandAction(nl.utwente.apc.Code2D.resource.Code2D.ui.Code2DOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Auto expand", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/auto_expand_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setAutoExpand(on);
		getTreeViewer().refresh();
	}
	
}
