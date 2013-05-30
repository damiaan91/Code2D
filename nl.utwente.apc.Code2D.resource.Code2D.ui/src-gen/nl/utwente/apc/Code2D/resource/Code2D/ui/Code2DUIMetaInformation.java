/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.Code2D.ui;

public class Code2DUIMetaInformation extends nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DMetaInformation {
	
	public nl.utwente.apc.Code2D.resource.Code2D.ICode2DHoverTextProvider getHoverTextProvider() {
		return new nl.utwente.apc.Code2D.resource.Code2D.ui.Code2DHoverTextProvider();
	}
	
	public nl.utwente.apc.Code2D.resource.Code2D.ui.Code2DImageProvider getImageProvider() {
		return nl.utwente.apc.Code2D.resource.Code2D.ui.Code2DImageProvider.INSTANCE;
	}
	
	public nl.utwente.apc.Code2D.resource.Code2D.ui.Code2DColorManager createColorManager() {
		return new nl.utwente.apc.Code2D.resource.Code2D.ui.Code2DColorManager();
	}
	
	/**
	 * @deprecated this method is only provided to preserve API compatibility. Use
	 * createTokenScanner(nl.utwente.apc.Code2D.resource.Code2D.ICode2DTextResource,
	 * nl.utwente.apc.Code2D.resource.Code2D.ui.Code2DColorManager) instead.
	 */
	public nl.utwente.apc.Code2D.resource.Code2D.ui.Code2DTokenScanner createTokenScanner(nl.utwente.apc.Code2D.resource.Code2D.ui.Code2DColorManager colorManager) {
		return createTokenScanner(null, colorManager);
	}
	
	public nl.utwente.apc.Code2D.resource.Code2D.ui.Code2DTokenScanner createTokenScanner(nl.utwente.apc.Code2D.resource.Code2D.ICode2DTextResource resource, nl.utwente.apc.Code2D.resource.Code2D.ui.Code2DColorManager colorManager) {
		return new nl.utwente.apc.Code2D.resource.Code2D.ui.Code2DTokenScanner(resource, colorManager);
	}
	
	public nl.utwente.apc.Code2D.resource.Code2D.ui.Code2DCodeCompletionHelper createCodeCompletionHelper() {
		return new nl.utwente.apc.Code2D.resource.Code2D.ui.Code2DCodeCompletionHelper();
	}
	
}
