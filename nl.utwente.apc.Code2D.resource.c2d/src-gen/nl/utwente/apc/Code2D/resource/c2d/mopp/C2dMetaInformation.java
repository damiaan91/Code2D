/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2d.mopp;

public class C2dMetaInformation implements nl.utwente.apc.Code2D.resource.c2d.IC2dMetaInformation {
	
	public String getSyntaxName() {
		return "c2d";
	}
	
	public String getURI() {
		return "http://www.utwente.nl/apc/Code2D";
	}
	
	public nl.utwente.apc.Code2D.resource.c2d.IC2dTextScanner createLexer() {
		return new nl.utwente.apc.Code2D.resource.c2d.mopp.C2dAntlrScanner(new nl.utwente.apc.Code2D.resource.c2d.mopp.C2dLexer());
	}
	
	public nl.utwente.apc.Code2D.resource.c2d.IC2dTextParser createParser(java.io.InputStream inputStream, String encoding) {
		return new nl.utwente.apc.Code2D.resource.c2d.mopp.C2dParser().createInstance(inputStream, encoding);
	}
	
	public nl.utwente.apc.Code2D.resource.c2d.IC2dTextPrinter createPrinter(java.io.OutputStream outputStream, nl.utwente.apc.Code2D.resource.c2d.IC2dTextResource resource) {
		return new nl.utwente.apc.Code2D.resource.c2d.mopp.C2dPrinter2(outputStream, resource);
	}
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new nl.utwente.apc.Code2D.resource.c2d.mopp.C2dSyntaxCoverageInformationProvider().getClassesWithSyntax();
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new nl.utwente.apc.Code2D.resource.c2d.mopp.C2dSyntaxCoverageInformationProvider().getStartSymbols();
	}
	
	public nl.utwente.apc.Code2D.resource.c2d.IC2dReferenceResolverSwitch getReferenceResolverSwitch() {
		return new nl.utwente.apc.Code2D.resource.c2d.mopp.C2dReferenceResolverSwitch();
	}
	
	public nl.utwente.apc.Code2D.resource.c2d.IC2dTokenResolverFactory getTokenResolverFactory() {
		return new nl.utwente.apc.Code2D.resource.c2d.mopp.C2dTokenResolverFactory();
	}
	
	public String getPathToCSDefinition() {
		return "nl.utwente.apc.Code2D/metamodel/text.cs";
	}
	
	public String[] getTokenNames() {
		return nl.utwente.apc.Code2D.resource.c2d.mopp.C2dParser.tokenNames;
	}
	
	public nl.utwente.apc.Code2D.resource.c2d.IC2dTokenStyle getDefaultTokenStyle(String tokenName) {
		return new nl.utwente.apc.Code2D.resource.c2d.mopp.C2dTokenStyleInformationProvider().getDefaultTokenStyle(tokenName);
	}
	
	public java.util.Collection<nl.utwente.apc.Code2D.resource.c2d.IC2dBracketPair> getBracketPairs() {
		return new nl.utwente.apc.Code2D.resource.c2d.mopp.C2dBracketInformationProvider().getBracketPairs();
	}
	
	public org.eclipse.emf.ecore.EClass[] getFoldableClasses() {
		return new nl.utwente.apc.Code2D.resource.c2d.mopp.C2dFoldingInformationProvider().getFoldableClasses();
	}
	
	public org.eclipse.emf.ecore.resource.Resource.Factory createResourceFactory() {
		return new nl.utwente.apc.Code2D.resource.c2d.mopp.C2dResourceFactory();
	}
	
	public nl.utwente.apc.Code2D.resource.c2d.mopp.C2dNewFileContentProvider getNewFileContentProvider() {
		return new nl.utwente.apc.Code2D.resource.c2d.mopp.C2dNewFileContentProvider();
	}
	
	public void registerResourceFactory() {
		org.eclipse.emf.ecore.resource.Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(getSyntaxName(), new nl.utwente.apc.Code2D.resource.c2d.mopp.C2dResourceFactory());
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
		return "nl.utwente.apc.Code2D.resource.c2d.ui.launchConfigurationType";
	}
	
	public nl.utwente.apc.Code2D.resource.c2d.IC2dNameProvider createNameProvider() {
		return new nl.utwente.apc.Code2D.resource.c2d.analysis.C2dDefaultNameProvider();
	}
	
	public String[] getSyntaxHighlightableTokenNames() {
		nl.utwente.apc.Code2D.resource.c2d.mopp.C2dAntlrTokenHelper tokenHelper = new nl.utwente.apc.Code2D.resource.c2d.mopp.C2dAntlrTokenHelper();
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
		highlightableTokens.add(nl.utwente.apc.Code2D.resource.c2d.mopp.C2dTokenStyleInformationProvider.TASK_ITEM_TOKEN_NAME);
		return highlightableTokens.toArray(new String[highlightableTokens.size()]);
	}
	
}
