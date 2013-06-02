/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2.mopp;

/**
 * A basic implementation of the
 * nl.utwente.apc.Code2D.resource.c2.IC2ReferenceResolveResult interface that
 * collects mappings in a list.
 * 
 * @param <ReferenceType> the type of the references that can be contained in this
 * result
 */
public class C2ReferenceResolveResult<ReferenceType> implements nl.utwente.apc.Code2D.resource.c2.IC2ReferenceResolveResult<ReferenceType> {
	
	private java.util.Collection<nl.utwente.apc.Code2D.resource.c2.IC2ReferenceMapping<ReferenceType>> mappings;
	private String errorMessage;
	private boolean resolveFuzzy;
	private java.util.Set<nl.utwente.apc.Code2D.resource.c2.IC2QuickFix> quickFixes;
	
	public C2ReferenceResolveResult(boolean resolveFuzzy) {
		super();
		this.resolveFuzzy = resolveFuzzy;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public java.util.Collection<nl.utwente.apc.Code2D.resource.c2.IC2QuickFix> getQuickFixes() {
		if (quickFixes == null) {
			quickFixes = new java.util.LinkedHashSet<nl.utwente.apc.Code2D.resource.c2.IC2QuickFix>();
		}
		return java.util.Collections.unmodifiableSet(quickFixes);
	}
	
	public void addQuickFix(nl.utwente.apc.Code2D.resource.c2.IC2QuickFix quickFix) {
		if (quickFixes == null) {
			quickFixes = new java.util.LinkedHashSet<nl.utwente.apc.Code2D.resource.c2.IC2QuickFix>();
		}
		quickFixes.add(quickFix);
	}
	
	public java.util.Collection<nl.utwente.apc.Code2D.resource.c2.IC2ReferenceMapping<ReferenceType>> getMappings() {
		return mappings;
	}
	
	public boolean wasResolved() {
		return mappings != null;
	}
	
	public boolean wasResolvedMultiple() {
		return mappings != null && mappings.size() > 1;
	}
	
	public boolean wasResolvedUniquely() {
		return mappings != null && mappings.size() == 1;
	}
	
	public void setErrorMessage(String message) {
		errorMessage = message;
	}
	
	public void addMapping(String identifier, ReferenceType target) {
		if (!resolveFuzzy && target == null) {
			throw new IllegalArgumentException("Mapping references to null is only allowed for fuzzy resolution.");
		}
		addMapping(identifier, target, null);
	}
	
	public void addMapping(String identifier, ReferenceType target, String warning) {
		if (mappings == null) {
			mappings = new java.util.ArrayList<nl.utwente.apc.Code2D.resource.c2.IC2ReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new nl.utwente.apc.Code2D.resource.c2.mopp.C2ElementMapping<ReferenceType>(identifier, target, warning));
		errorMessage = null;
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri) {
		addMapping(identifier, uri, null);
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri, String warning) {
		if (mappings == null) {
			mappings = new java.util.ArrayList<nl.utwente.apc.Code2D.resource.c2.IC2ReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new nl.utwente.apc.Code2D.resource.c2.mopp.C2URIMapping<ReferenceType>(identifier, uri, warning));
	}
}
