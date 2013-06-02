/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2.ui;

public class C2UIMetaInformation extends nl.utwente.apc.Code2D.resource.c2.mopp.C2MetaInformation {
	
	public nl.utwente.apc.Code2D.resource.c2.IC2HoverTextProvider getHoverTextProvider() {
		return new nl.utwente.apc.Code2D.resource.c2.ui.C2HoverTextProvider();
	}
	
	public nl.utwente.apc.Code2D.resource.c2.ui.C2ImageProvider getImageProvider() {
		return nl.utwente.apc.Code2D.resource.c2.ui.C2ImageProvider.INSTANCE;
	}
	
	public nl.utwente.apc.Code2D.resource.c2.ui.C2ColorManager createColorManager() {
		return new nl.utwente.apc.Code2D.resource.c2.ui.C2ColorManager();
	}
	
	/**
	 * @deprecated this method is only provided to preserve API compatibility. Use
	 * createTokenScanner(nl.utwente.apc.Code2D.resource.c2.IC2TextResource,
	 * nl.utwente.apc.Code2D.resource.c2.ui.C2ColorManager) instead.
	 */
	public nl.utwente.apc.Code2D.resource.c2.ui.C2TokenScanner createTokenScanner(nl.utwente.apc.Code2D.resource.c2.ui.C2ColorManager colorManager) {
		return createTokenScanner(null, colorManager);
	}
	
	public nl.utwente.apc.Code2D.resource.c2.ui.C2TokenScanner createTokenScanner(nl.utwente.apc.Code2D.resource.c2.IC2TextResource resource, nl.utwente.apc.Code2D.resource.c2.ui.C2ColorManager colorManager) {
		return new nl.utwente.apc.Code2D.resource.c2.ui.C2TokenScanner(resource, colorManager);
	}
	
	public nl.utwente.apc.Code2D.resource.c2.ui.C2CodeCompletionHelper createCodeCompletionHelper() {
		return new nl.utwente.apc.Code2D.resource.c2.ui.C2CodeCompletionHelper();
	}
	
}
