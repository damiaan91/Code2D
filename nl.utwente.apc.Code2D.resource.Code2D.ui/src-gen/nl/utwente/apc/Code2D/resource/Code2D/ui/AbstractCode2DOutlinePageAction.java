/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.Code2D.ui;

public abstract class AbstractCode2DOutlinePageAction extends org.eclipse.jface.action.Action {
	
	private String preferenceKey = this.getClass().getSimpleName() + ".isChecked";
	
	private nl.utwente.apc.Code2D.resource.Code2D.ui.Code2DOutlinePageTreeViewer treeViewer;
	
	public AbstractCode2DOutlinePageAction(nl.utwente.apc.Code2D.resource.Code2D.ui.Code2DOutlinePageTreeViewer treeViewer, String text, int style) {
		super(text, style);
		this.treeViewer = treeViewer;
	}
	
	public void initialize(String imagePath) {
		org.eclipse.jface.resource.ImageDescriptor descriptor = nl.utwente.apc.Code2D.resource.Code2D.ui.Code2DImageProvider.INSTANCE.getImageDescriptor(imagePath);
		setDisabledImageDescriptor(descriptor);
		setImageDescriptor(descriptor);
		setHoverImageDescriptor(descriptor);
		boolean checked = nl.utwente.apc.Code2D.resource.Code2D.ui.Code2DUIPlugin.getDefault().getPreferenceStore().getBoolean(preferenceKey);
		valueChanged(checked, false);
	}
	
	@Override	
	public void run() {
		if (keepState()) {
			valueChanged(isChecked(), true);
		} else {
			runBusy(true);
		}
	}
	
	public void runBusy(final boolean on) {
		org.eclipse.swt.custom.BusyIndicator.showWhile(org.eclipse.swt.widgets.Display.getCurrent(), new Runnable() {
			public void run() {
				runInternal(on);
			}
		});
	}
	
	public abstract void runInternal(boolean on);
	
	private void valueChanged(boolean on, boolean store) {
		setChecked(on);
		runBusy(on);
		if (store) {
			nl.utwente.apc.Code2D.resource.Code2D.ui.Code2DUIPlugin.getDefault().getPreferenceStore().setValue(preferenceKey, on);
		}
	}
	
	public boolean keepState() {
		return true;
	}
	
	public nl.utwente.apc.Code2D.resource.Code2D.ui.Code2DOutlinePageTreeViewer getTreeViewer() {
		return treeViewer;
	}
	
	public nl.utwente.apc.Code2D.resource.Code2D.ui.Code2DOutlinePageTreeViewerComparator getTreeViewerComparator() {
		return (nl.utwente.apc.Code2D.resource.Code2D.ui.Code2DOutlinePageTreeViewerComparator) treeViewer.getComparator();
	}
	
}
