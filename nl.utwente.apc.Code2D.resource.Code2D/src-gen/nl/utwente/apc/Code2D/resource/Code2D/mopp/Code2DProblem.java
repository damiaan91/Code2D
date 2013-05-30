/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.Code2D.mopp;

public class Code2DProblem implements nl.utwente.apc.Code2D.resource.Code2D.ICode2DProblem {
	
	private String message;
	private nl.utwente.apc.Code2D.resource.Code2D.Code2DEProblemType type;
	private nl.utwente.apc.Code2D.resource.Code2D.Code2DEProblemSeverity severity;
	private java.util.Collection<nl.utwente.apc.Code2D.resource.Code2D.ICode2DQuickFix> quickFixes;
	
	public Code2DProblem(String message, nl.utwente.apc.Code2D.resource.Code2D.Code2DEProblemType type, nl.utwente.apc.Code2D.resource.Code2D.Code2DEProblemSeverity severity) {
		this(message, type, severity, java.util.Collections.<nl.utwente.apc.Code2D.resource.Code2D.ICode2DQuickFix>emptySet());
	}
	
	public Code2DProblem(String message, nl.utwente.apc.Code2D.resource.Code2D.Code2DEProblemType type, nl.utwente.apc.Code2D.resource.Code2D.Code2DEProblemSeverity severity, nl.utwente.apc.Code2D.resource.Code2D.ICode2DQuickFix quickFix) {
		this(message, type, severity, java.util.Collections.singleton(quickFix));
	}
	
	public Code2DProblem(String message, nl.utwente.apc.Code2D.resource.Code2D.Code2DEProblemType type, nl.utwente.apc.Code2D.resource.Code2D.Code2DEProblemSeverity severity, java.util.Collection<nl.utwente.apc.Code2D.resource.Code2D.ICode2DQuickFix> quickFixes) {
		super();
		this.message = message;
		this.type = type;
		this.severity = severity;
		this.quickFixes = new java.util.LinkedHashSet<nl.utwente.apc.Code2D.resource.Code2D.ICode2DQuickFix>();
		this.quickFixes.addAll(quickFixes);
	}
	
	public nl.utwente.apc.Code2D.resource.Code2D.Code2DEProblemType getType() {
		return type;
	}
	
	public nl.utwente.apc.Code2D.resource.Code2D.Code2DEProblemSeverity getSeverity() {
		return severity;
	}
	
	public String getMessage() {
		return message;
	}
	
	public java.util.Collection<nl.utwente.apc.Code2D.resource.Code2D.ICode2DQuickFix> getQuickFixes() {
		return quickFixes;
	}
	
}
