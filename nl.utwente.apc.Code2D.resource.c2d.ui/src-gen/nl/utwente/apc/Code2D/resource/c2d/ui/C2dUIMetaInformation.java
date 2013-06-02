/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2d.ui;

public class C2dUIMetaInformation extends nl.utwente.apc.Code2D.resource.c2d.mopp.C2dMetaInformation {
	
	public nl.utwente.apc.Code2D.resource.c2d.IC2dHoverTextProvider getHoverTextProvider() {
		return new nl.utwente.apc.Code2D.resource.c2d.ui.C2dHoverTextProvider();
	}
	
	public nl.utwente.apc.Code2D.resource.c2d.ui.C2dImageProvider getImageProvider() {
		return nl.utwente.apc.Code2D.resource.c2d.ui.C2dImageProvider.INSTANCE;
	}
	
	public nl.utwente.apc.Code2D.resource.c2d.ui.C2dColorManager createColorManager() {
		return new nl.utwente.apc.Code2D.resource.c2d.ui.C2dColorManager();
	}
	
	/**
	 * @deprecated this method is only provided to preserve API compatibility. Use
	 * createTokenScanner(nl.utwente.apc.Code2D.resource.c2d.IC2dTextResource,
	 * nl.utwente.apc.Code2D.resource.c2d.ui.C2dColorManager) instead.
	 */
	public nl.utwente.apc.Code2D.resource.c2d.ui.C2dTokenScanner createTokenScanner(nl.utwente.apc.Code2D.resource.c2d.ui.C2dColorManager colorManager) {
		return createTokenScanner(null, colorManager);
	}
	
	public nl.utwente.apc.Code2D.resource.c2d.ui.C2dTokenScanner createTokenScanner(nl.utwente.apc.Code2D.resource.c2d.IC2dTextResource resource, nl.utwente.apc.Code2D.resource.c2d.ui.C2dColorManager colorManager) {
		return new nl.utwente.apc.Code2D.resource.c2d.ui.C2dTokenScanner(resource, colorManager);
	}
	
	public nl.utwente.apc.Code2D.resource.c2d.ui.C2dCodeCompletionHelper createCodeCompletionHelper() {
		return new nl.utwente.apc.Code2D.resource.c2d.ui.C2dCodeCompletionHelper();
	}
	
}
