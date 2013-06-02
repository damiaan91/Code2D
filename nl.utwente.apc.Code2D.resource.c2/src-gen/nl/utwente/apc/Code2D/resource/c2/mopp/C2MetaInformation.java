/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2.mopp;

public class C2MetaInformation implements nl.utwente.apc.Code2D.resource.c2.IC2MetaInformation {
	
	public String getSyntaxName() {
		return "c2";
	}
	
	public String getURI() {
		return "http://www.utwente.nl/apc/Code2D";
	}
	
	public nl.utwente.apc.Code2D.resource.c2.IC2TextScanner createLexer() {
		return new nl.utwente.apc.Code2D.resource.c2.mopp.C2AntlrScanner(new nl.utwente.apc.Code2D.resource.c2.mopp.C2Lexer());
	}
	
	public nl.utwente.apc.Code2D.resource.c2.IC2TextParser createParser(java.io.InputStream inputStream, String encoding) {
		return new nl.utwente.apc.Code2D.resource.c2.mopp.C2Parser().createInstance(inputStream, encoding);
	}
	
	public nl.utwente.apc.Code2D.resource.c2.IC2TextPrinter createPrinter(java.io.OutputStream outputStream, nl.utwente.apc.Code2D.resource.c2.IC2TextResource resource) {
		return new nl.utwente.apc.Code2D.resource.c2.mopp.C2Printer2(outputStream, resource);
	}
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new nl.utwente.apc.Code2D.resource.c2.mopp.C2SyntaxCoverageInformationProvider().getClassesWithSyntax();
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new nl.utwente.apc.Code2D.resource.c2.mopp.C2SyntaxCoverageInformationProvider().getStartSymbols();
	}
	
	public nl.utwente.apc.Code2D.resource.c2.IC2ReferenceResolverSwitch getReferenceResolverSwitch() {
		return new nl.utwente.apc.Code2D.resource.c2.mopp.C2ReferenceResolverSwitch();
	}
	
	public nl.utwente.apc.Code2D.resource.c2.IC2TokenResolverFactory getTokenResolverFactory() {
		return new nl.utwente.apc.Code2D.resource.c2.mopp.C2TokenResolverFactory();
	}
	
	public String getPathToCSDefinition() {
		return "nl.utwente.apc.Code2D/metamodel/text.cs";
	}
	
	public String[] getTokenNames() {
		return nl.utwente.apc.Code2D.resource.c2.mopp.C2Parser.tokenNames;
	}
	
	public nl.utwente.apc.Code2D.resource.c2.IC2TokenStyle getDefaultTokenStyle(String tokenName) {
		return new nl.utwente.apc.Code2D.resource.c2.mopp.C2TokenStyleInformationProvider().getDefaultTokenStyle(tokenName);
	}
	
	public java.util.Collection<nl.utwente.apc.Code2D.resource.c2.IC2BracketPair> getBracketPairs() {
		return new nl.utwente.apc.Code2D.resource.c2.mopp.C2BracketInformationProvider().getBracketPairs();
	}
	
	public org.eclipse.emf.ecore.EClass[] getFoldableClasses() {
		return new nl.utwente.apc.Code2D.resource.c2.mopp.C2FoldingInformationProvider().getFoldableClasses();
	}
	
	public org.eclipse.emf.ecore.resource.Resource.Factory createResourceFactory() {
		return new nl.utwente.apc.Code2D.resource.c2.mopp.C2ResourceFactory();
	}
	
	public nl.utwente.apc.Code2D.resource.c2.mopp.C2NewFileContentProvider getNewFileContentProvider() {
		return new nl.utwente.apc.Code2D.resource.c2.mopp.C2NewFileContentProvider();
	}
	
	public void registerResourceFactory() {
		org.eclipse.emf.ecore.resource.Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(getSyntaxName(), new nl.utwente.apc.Code2D.resource.c2.mopp.C2ResourceFactory());
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
		return "nl.utwente.apc.Code2D.resource.c2.ui.launchConfigurationType";
	}
	
	public nl.utwente.apc.Code2D.resource.c2.IC2NameProvider createNameProvider() {
		return new nl.utwente.apc.Code2D.resource.c2.analysis.C2DefaultNameProvider();
	}
	
	public String[] getSyntaxHighlightableTokenNames() {
		nl.utwente.apc.Code2D.resource.c2.mopp.C2AntlrTokenHelper tokenHelper = new nl.utwente.apc.Code2D.resource.c2.mopp.C2AntlrTokenHelper();
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
		highlightableTokens.add(nl.utwente.apc.Code2D.resource.c2.mopp.C2TokenStyleInformationProvider.TASK_ITEM_TOKEN_NAME);
		return highlightableTokens.toArray(new String[highlightableTokens.size()]);
	}
	
}
