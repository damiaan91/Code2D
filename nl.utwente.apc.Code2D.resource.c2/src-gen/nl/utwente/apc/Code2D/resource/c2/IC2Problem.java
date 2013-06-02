/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2;

public interface IC2Problem {
	public String getMessage();
	public nl.utwente.apc.Code2D.resource.c2.C2EProblemSeverity getSeverity();
	public nl.utwente.apc.Code2D.resource.c2.C2EProblemType getType();
	public java.util.Collection<nl.utwente.apc.Code2D.resource.c2.IC2QuickFix> getQuickFixes();
}
