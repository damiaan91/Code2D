/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2.ui;

public class C2CompletionProcessor implements org.eclipse.jface.text.contentassist.IContentAssistProcessor {
	
	private nl.utwente.apc.Code2D.resource.c2.IC2ResourceProvider resourceProvider;
	private nl.utwente.apc.Code2D.resource.c2.ui.IC2BracketHandlerProvider bracketHandlerProvider;
	
	public C2CompletionProcessor(nl.utwente.apc.Code2D.resource.c2.IC2ResourceProvider resourceProvider, nl.utwente.apc.Code2D.resource.c2.ui.IC2BracketHandlerProvider bracketHandlerProvider) {
		this.resourceProvider = resourceProvider;
		this.bracketHandlerProvider = bracketHandlerProvider;
	}
	
	public org.eclipse.jface.text.contentassist.ICompletionProposal[] computeCompletionProposals(org.eclipse.jface.text.ITextViewer viewer, int offset) {
		nl.utwente.apc.Code2D.resource.c2.IC2TextResource textResource = resourceProvider.getResource();
		if (textResource == null) {
			return new org.eclipse.jface.text.contentassist.ICompletionProposal[0];
		}
		String content = viewer.getDocument().get();
		nl.utwente.apc.Code2D.resource.c2.ui.C2CodeCompletionHelper helper = new nl.utwente.apc.Code2D.resource.c2.ui.C2CodeCompletionHelper();
		nl.utwente.apc.Code2D.resource.c2.ui.C2CompletionProposal[] computedProposals = helper.computeCompletionProposals(textResource, content, offset);
		
		// call completion proposal post processor to allow for customizing the proposals
		nl.utwente.apc.Code2D.resource.c2.ui.C2ProposalPostProcessor proposalPostProcessor = new nl.utwente.apc.Code2D.resource.c2.ui.C2ProposalPostProcessor();
		java.util.List<nl.utwente.apc.Code2D.resource.c2.ui.C2CompletionProposal> computedProposalList = java.util.Arrays.asList(computedProposals);
		java.util.List<nl.utwente.apc.Code2D.resource.c2.ui.C2CompletionProposal> extendedProposalList = proposalPostProcessor.process(computedProposalList);
		if (extendedProposalList == null) {
			extendedProposalList = java.util.Collections.emptyList();
		}
		java.util.List<nl.utwente.apc.Code2D.resource.c2.ui.C2CompletionProposal> finalProposalList = new java.util.ArrayList<nl.utwente.apc.Code2D.resource.c2.ui.C2CompletionProposal>();
		for (nl.utwente.apc.Code2D.resource.c2.ui.C2CompletionProposal proposal : extendedProposalList) {
			if (proposal.getMatchesPrefix()) {
				finalProposalList.add(proposal);
			}
		}
		org.eclipse.jface.text.contentassist.ICompletionProposal[] result = new org.eclipse.jface.text.contentassist.ICompletionProposal[finalProposalList.size()];
		int i = 0;
		for (nl.utwente.apc.Code2D.resource.c2.ui.C2CompletionProposal proposal : finalProposalList) {
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
			nl.utwente.apc.Code2D.resource.c2.ui.IC2BracketHandler bracketHandler = bracketHandlerProvider.getBracketHandler();
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
