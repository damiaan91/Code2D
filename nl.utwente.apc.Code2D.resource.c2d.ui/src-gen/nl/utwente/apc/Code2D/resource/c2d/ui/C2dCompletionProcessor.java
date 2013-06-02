/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2d.ui;

public class C2dCompletionProcessor implements org.eclipse.jface.text.contentassist.IContentAssistProcessor {
	
	private nl.utwente.apc.Code2D.resource.c2d.IC2dResourceProvider resourceProvider;
	private nl.utwente.apc.Code2D.resource.c2d.ui.IC2dBracketHandlerProvider bracketHandlerProvider;
	
	public C2dCompletionProcessor(nl.utwente.apc.Code2D.resource.c2d.IC2dResourceProvider resourceProvider, nl.utwente.apc.Code2D.resource.c2d.ui.IC2dBracketHandlerProvider bracketHandlerProvider) {
		this.resourceProvider = resourceProvider;
		this.bracketHandlerProvider = bracketHandlerProvider;
	}
	
	public org.eclipse.jface.text.contentassist.ICompletionProposal[] computeCompletionProposals(org.eclipse.jface.text.ITextViewer viewer, int offset) {
		nl.utwente.apc.Code2D.resource.c2d.IC2dTextResource textResource = resourceProvider.getResource();
		if (textResource == null) {
			return new org.eclipse.jface.text.contentassist.ICompletionProposal[0];
		}
		String content = viewer.getDocument().get();
		nl.utwente.apc.Code2D.resource.c2d.ui.C2dCodeCompletionHelper helper = new nl.utwente.apc.Code2D.resource.c2d.ui.C2dCodeCompletionHelper();
		nl.utwente.apc.Code2D.resource.c2d.ui.C2dCompletionProposal[] computedProposals = helper.computeCompletionProposals(textResource, content, offset);
		
		// call completion proposal post processor to allow for customizing the proposals
		nl.utwente.apc.Code2D.resource.c2d.ui.C2dProposalPostProcessor proposalPostProcessor = new nl.utwente.apc.Code2D.resource.c2d.ui.C2dProposalPostProcessor();
		java.util.List<nl.utwente.apc.Code2D.resource.c2d.ui.C2dCompletionProposal> computedProposalList = java.util.Arrays.asList(computedProposals);
		java.util.List<nl.utwente.apc.Code2D.resource.c2d.ui.C2dCompletionProposal> extendedProposalList = proposalPostProcessor.process(computedProposalList);
		if (extendedProposalList == null) {
			extendedProposalList = java.util.Collections.emptyList();
		}
		java.util.List<nl.utwente.apc.Code2D.resource.c2d.ui.C2dCompletionProposal> finalProposalList = new java.util.ArrayList<nl.utwente.apc.Code2D.resource.c2d.ui.C2dCompletionProposal>();
		for (nl.utwente.apc.Code2D.resource.c2d.ui.C2dCompletionProposal proposal : extendedProposalList) {
			if (proposal.getMatchesPrefix()) {
				finalProposalList.add(proposal);
			}
		}
		org.eclipse.jface.text.contentassist.ICompletionProposal[] result = new org.eclipse.jface.text.contentassist.ICompletionProposal[finalProposalList.size()];
		int i = 0;
		for (nl.utwente.apc.Code2D.resource.c2d.ui.C2dCompletionProposal proposal : finalProposalList) {
			String proposalString = proposal.getInsertString();
			String displayString = proposal.getDisplayString();
			String prefix = proposal.getPrefix();
			org.eclipse.swt.graphics.Image image = proposal.getImage();
			org.eclipse.jface.text.contentassist.IContextInformation info;
			info = new org.eclipse.jface.text.contentassist.ContextInformation(image, proposalString, proposalString);
			int begin = offset - prefix.length();
			int replacementLength = prefix.length();
			// if a closing bracket was automatically inserted right before, we enlarge the
			// replacement length in order to overwrite the bracket.
			nl.utwente.apc.Code2D.resource.c2d.ui.IC2dBracketHandler bracketHandler = bracketHandlerProvider.getBracketHandler();
			String closingBracket = bracketHandler.getClosingBracket();
			if (bracketHandler.addedClosingBracket() && proposalString.endsWith(closingBracket)) {
				replacementLength += closingBracket.length();
			}
			result[i++] = new org.eclipse.jface.text.contentassist.CompletionProposal(proposalString, begin, replacementLength, proposalString.length(), image, displayString, info, proposalString);
		}
		return result;
	}
	
	public org.eclipse.jface.text.contentassist.IContextInformation[] computeContextInformation(org.eclipse.jface.text.ITextViewer viewer, int offset) {
		return null;
	}
	
	public char[] getCompletionProposalAutoActivationCharacters() {
		return null;
	}
	
	public char[] getContextInformationAutoActivationCharacters() {
		return null;
	}
	
	public org.eclipse.jface.text.contentassist.IContextInformationValidator getContextInformationValidator() {
		return null;
	}
	
	public String getErrorMessage() {
		return null;
	}
}
