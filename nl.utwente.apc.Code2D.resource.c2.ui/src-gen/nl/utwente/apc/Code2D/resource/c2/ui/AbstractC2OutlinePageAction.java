/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2.ui;

public abstract class AbstractC2OutlinePageAction extends org.eclipse.jface.action.Action {
	
	private String preferenceKey = this.getClass().getSimpleName() + ".isChecked";
	
	private nl.utwente.apc.Code2D.resource.c2.ui.C2OutlinePageTreeViewer treeViewer;
	
	public AbstractC2OutlinePageAction(nl.utwente.apc.Code2D.resource.c2.ui.C2OutlinePageTreeViewer treeViewer, String text, int style) {
		super(text, style);
		this.treeViewer = treeViewer;
	}
	
	public void initialize(String imagePath) {
		org.eclipse.jface.resource.ImageDescriptor descriptor = nl.utwente.apc.Code2D.resource.c2.ui.C2ImageProvider.INSTANCE.getImageDescriptor(imagePath);
		setDisabledImageDescriptor(descriptor);
		setImageDescriptor(descriptor);
		setHoverImageDescriptor(descriptor);
		boolean checked = nl.utwente.apc.Code2D.resource.c2.ui.C2UIPlugin.getDefault().getPreferenceStore().getBoolean(preferenceKey);
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
			nl.utwente.apc.Code2D.resource.c2.ui.C2UIPlugin.getDefault().getPreferenceStore().setValue(preferenceKey, on);
		}
	}
	
	public boolean keepState() {
		return true;
	}
	
	public nl.utwente.apc.Code2D.resource.c2.ui.C2OutlinePageTreeViewer getTreeViewer() {
		return treeViewer;
	}
	
	public nl.utwente.apc.Code2D.resource.c2.ui.C2OutlinePageTreeViewerComparator getTreeViewerComparator() {
		return (nl.utwente.apc.Code2D.resource.c2.ui.C2OutlinePageTreeViewerComparator) treeViewer.getComparator();
	}
	
}
