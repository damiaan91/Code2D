/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2d.mopp;

public class C2dProblem implements nl.utwente.apc.Code2D.resource.c2d.IC2dProblem {
	
	private String message;
	private nl.utwente.apc.Code2D.resource.c2d.C2dEProblemType type;
	private nl.utwente.apc.Code2D.resource.c2d.C2dEProblemSeverity severity;
	private java.util.Collection<nl.utwente.apc.Code2D.resource.c2d.IC2dQuickFix> quickFixes;
	
	public C2dProblem(String message, nl.utwente.apc.Code2D.resource.c2d.C2dEProblemType type, nl.utwente.apc.Code2D.resource.c2d.C2dEProblemSeverity severity) {
		this(message, type, severity, java.util.Collections.<nl.utwente.apc.Code2D.resource.c2d.IC2dQuickFix>emptySet());
	}
	
	public C2dProblem(String message, nl.utwente.apc.Code2D.resource.c2d.C2dEProblemType type, nl.utwente.apc.Code2D.resource.c2d.C2dEProblemSeverity severity, nl.utwente.apc.Code2D.resource.c2d.IC2dQuickFix quickFix) {
		this(message, type, severity, java.util.Collections.singleton(quickFix));
	}
	
	public C2dProblem(String message, nl.utwente.apc.Code2D.resource.c2d.C2dEProblemType type, nl.utwente.apc.Code2D.resource.c2d.C2dEProblemSeverity severity, java.util.Collection<nl.utwente.apc.Code2D.resource.c2d.IC2dQuickFix> quickFixes) {
		super();
		this.message = message;
		this.type = type;
		this.severity = severity;
		this.quickFixes = new java.util.LinkedHashSet<nl.utwente.apc.Code2D.resource.c2d.IC2dQuickFix>();
		this.quickFixes.addAll(quickFixes);
	}
	
	public nl.utwente.apc.Code2D.resource.c2d.C2dEProblemType getType() {
		return type;
	}
	
	public nl.utwente.apc.Code2D.resource.c2d.C2dEProblemSeverity getSeverity() {
		return severity;
	}
	
	public String getMessage() {
		return message;
	}
	
	public java.util.Collection<nl.utwente.apc.Code2D.resource.c2d.IC2dQuickFix> getQuickFixes() {
		return quickFixes;
	}
	
}
