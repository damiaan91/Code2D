/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.Code2D.mopp;

public class Code2DMetaInformation implements nl.utwente.apc.Code2D.resource.Code2D.ICode2DMetaInformation {
	
	public String getSyntaxName() {
		return "Code2D";
	}
	
	public String getURI() {
		return "http://www.utwente.nl/apc/Code2D";
	}
	
	public nl.utwente.apc.Code2D.resource.Code2D.ICode2DTextScanner createLexer() {
		return new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DAntlrScanner(new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DLexer());
	}
	
	public nl.utwente.apc.Code2D.resource.Code2D.ICode2DTextParser createParser(java.io.InputStream inputStream, String encoding) {
		return new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DParser().createInstance(inputStream, encoding);
	}
	
	public nl.utwente.apc.Code2D.resource.Code2D.ICode2DTextPrinter createPrinter(java.io.OutputStream outputStream, nl.utwente.apc.Code2D.resource.Code2D.ICode2DTextResource resource) {
		return new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DPrinter2(outputStream, resource);
	}
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DSyntaxCoverageInformationProvider().getClassesWithSyntax();
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DSyntaxCoverageInformationProvider().getStartSymbols();
	}
	
	public nl.utwente.apc.Code2D.resource.Code2D.ICode2DReferenceResolverSwitch getReferenceResolverSwitch() {
		return new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DReferenceResolverSwitch();
	}
	
	public nl.utwente.apc.Code2D.resource.Code2D.ICode2DTokenResolverFactory getTokenResolverFactory() {
		return new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DTokenResolverFactory();
	}
	
	public String getPathToCSDefinition() {
		return "nl.utwente.apc.Code2D/metamodel/text.cs";
	}
	
	public String[] getTokenNames() {
		return nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DParser.tokenNames;
	}
	
	public nl.utwente.apc.Code2D.resource.Code2D.ICode2DTokenStyle getDefaultTokenStyle(String tokenName) {
		return new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DTokenStyleInformationProvider().getDefaultTokenStyle(tokenName);
	}
	
	public java.util.Collection<nl.utwente.apc.Code2D.resource.Code2D.ICode2DBracketPair> getBracketPairs() {
		return new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DBracketInformationProvider().getBracketPairs();
	}
	
	public org.eclipse.emf.ecore.EClass[] getFoldableClasses() {
		return new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DFoldingInformationProvider().getFoldableClasses();
	}
	
	public org.eclipse.emf.ecore.resource.Resource.Factory createResourceFactory() {
		return new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DResourceFactory();
	}
	
	public nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DNewFileContentProvider getNewFileContentProvider() {
		return new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DNewFileContentProvider();
	}
	
	public void registerResourceFactory() {
		org.eclipse.emf.ecore.resource.Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(getSyntaxName(), new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DResourceFactory());
	}
	
	/**
	 * Returns the key of the option that can be used to register a preprocessor that
	 * is used as a pipe when loading resources. This key is language-specific. To
	 * register one preprocessor for multiple resource types, it must be registered
	 * individually using all keys.
	 */
	public String getInputStreamPreprocessorProviderOptionKey() {
		return getSyntaxName() + "_" + "INPUT_STREAM_PREPROCESSOR_PROVIDER";
	}
	
	/**
	 * Returns the key of the option that can be used to register a post-processors
	 * that are invoked after loading resources. This key is language-specific. To
	 * register one post-processor for multiple resource types, it must be registered
	 * individually using all keys.
	 */
	public String getResourcePostProcessorProviderOptionKey() {
		return getSyntaxName() + "_" + "RESOURCE_POSTPROCESSOR_PROVIDER";
	}
	
	public String getLaunchConfigurationType() {
		return "nl.utwente.apc.Code2D.resource.Code2D.ui.launchConfigurationType";
	}
	
	public nl.utwente.apc.Code2D.resource.Code2D.ICode2DNameProvider createNameProvider() {
		return new nl.utwente.apc.Code2D.resource.Code2D.analysis.Code2DDefaultNameProvider();
	}
	
	public String[] getSyntaxHighlightableTokenNames() {
		nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DAntlrTokenHelper tokenHelper = new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DAntlrTokenHelper();
		java.util.List<String> highlightableTokens = new java.util.ArrayList<String>();
		String[] parserTokenNames = getTokenNames();
		for (int i = 0; i < parserTokenNames.length; i++) {
			// If ANTLR is used we need to normalize the token names
			if (!tokenHelper.canBeUsedForSyntaxHighlighting(i)) {
				continue;
			}
			String tokenName = tokenHelper.getTokenName(parserTokenNames, i);
			if (tokenName == null) {
				continue;
			}
			highlightableTokens.add(tokenName);
		}
		highlightableTokens.add(nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DTokenStyleInformationProvider.TASK_ITEM_TOKEN_NAME);
		return highlightableTokens.toArray(new String[highlightableTokens.size()]);
	}
	
}
