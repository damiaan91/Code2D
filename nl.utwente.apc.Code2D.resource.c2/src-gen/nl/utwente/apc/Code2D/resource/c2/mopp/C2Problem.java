/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2.mopp;

public class C2Problem implements nl.utwente.apc.Code2D.resource.c2.IC2Problem {
	
	private String message;
	private nl.utwente.apc.Code2D.resource.c2.C2EProblemType type;
	private nl.utwente.apc.Code2D.resource.c2.C2EProblemSeverity severity;
	private java.util.Collection<nl.utwente.apc.Code2D.resource.c2.IC2QuickFix> quickFixes;
	
	public C2Problem(String message, nl.utwente.apc.Code2D.resource.c2.C2EProblemType type, nl.utwente.apc.Code2D.resource.c2.C2EProblemSeverity severity) {
		this(message, type, severity, java.util.Collections.<nl.utwente.apc.Code2D.resource.c2.IC2QuickFix>emptySet());
	}
	
	public C2Problem(String message, nl.utwente.apc.Code2D.resource.c2.C2EProblemType type, nl.utwente.apc.Code2D.resource.c2.C2EProblemSeverity severity, nl.utwente.apc.Code2D.resource.c2.IC2QuickFix quickFix) {
		this(message, type, severity, java.util.Collections.singleton(quickFix));
	}
	
	public C2Problem(String message, nl.utwente.apc.Code2D.resource.c2.C2EProblemType type, nl.utwente.apc.Code2D.resource.c2.C2EProblemSeverity severity, java.util.Collection<nl.utwente.apc.Code2D.resource.c2.IC2QuickFix> quickFixes) {
		super();
		this.message = message;
		this.type = type;
		this.severity = severity;
		this.quickFixes = new java.util.LinkedHashSet<nl.utwente.apc.Code2D.resource.c2.IC2QuickFix>();
		this.quickFixes.addAll(quickFixes);
	}
	
	public nl.utwente.apc.Code2D.resource.c2.C2EProblemType getType() {
		return type;
	}
	
	public nl.utwente.apc.Code2D.resource.c2.C2EProblemSeverity getSeverity() {
		return severity;
	}
	
	public String getMessage() {
		return message;
	}
	
	public java.util.Collection<nl.utwente.apc.Code2D.resource.c2.IC2QuickFix> getQuickFixes() {
		return quickFixes;
	}
	
}
