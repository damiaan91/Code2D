/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2d.ui;

/**
 * A class which can be overridden to customize code completion proposals.
 */
public class C2dProposalPostProcessor {
	
	public java.util.List<nl.utwente.apc.Code2D.resource.c2d.ui.C2dCompletionProposal> process(java.util.List<nl.utwente.apc.Code2D.resource.c2d.ui.C2dCompletionProposal> proposals) {
		// the default implementation does returns the proposals as they are
		return proposals;
	}
	
}
