/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.Code2D;

public interface ICode2DProblem {
	public String getMessage();
	public nl.utwente.apc.Code2D.resource.Code2D.Code2DEProblemSeverity getSeverity();
	public nl.utwente.apc.Code2D.resource.Code2D.Code2DEProblemType getType();
	public java.util.Collection<nl.utwente.apc.Code2D.resource.Code2D.ICode2DQuickFix> getQuickFixes();
}
