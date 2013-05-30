/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.Code2D.ui;

/**
 * A class which can be overridden to customize code completion proposals.
 */
public class Code2DProposalPostProcessor {
	
	public java.util.List<nl.utwente.apc.Code2D.resource.Code2D.ui.Code2DCompletionProposal> process(java.util.List<nl.utwente.apc.Code2D.resource.Code2D.ui.Code2DCompletionProposal> proposals) {
		// the default implementation does returns the proposals as they are
		return proposals;
	}
	
}
