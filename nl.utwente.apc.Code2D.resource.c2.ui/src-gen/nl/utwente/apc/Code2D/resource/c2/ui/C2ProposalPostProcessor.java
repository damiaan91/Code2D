/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2.ui;

/**
 * A class which can be overridden to customize code completion proposals.
 */
public class C2ProposalPostProcessor {
	
	public java.util.List<nl.utwente.apc.Code2D.resource.c2.ui.C2CompletionProposal> process(java.util.List<nl.utwente.apc.Code2D.resource.c2.ui.C2CompletionProposal> proposals) {
		// the default implementation does returns the proposals as they are
		return proposals;
	}
	
}
