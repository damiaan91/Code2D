/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2d;

public interface IC2dProblem {
	public String getMessage();
	public nl.utwente.apc.Code2D.resource.c2d.C2dEProblemSeverity getSeverity();
	public nl.utwente.apc.Code2D.resource.c2d.C2dEProblemType getType();
	public java.util.Collection<nl.utwente.apc.Code2D.resource.c2d.IC2dQuickFix> getQuickFixes();
}
