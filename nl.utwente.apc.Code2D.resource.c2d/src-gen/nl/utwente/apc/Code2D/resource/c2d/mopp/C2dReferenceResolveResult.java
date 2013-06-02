/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2d.mopp;

/**
 * A basic implementation of the
 * nl.utwente.apc.Code2D.resource.c2d.IC2dReferenceResolveResult interface that
 * collects mappings in a list.
 * 
 * @param <ReferenceType> the type of the references that can be contained in this
 * result
 */
public class C2dReferenceResolveResult<ReferenceType> implements nl.utwente.apc.Code2D.resource.c2d.IC2dReferenceResolveResult<ReferenceType> {
	
	private java.util.Collection<nl.utwente.apc.Code2D.resource.c2d.IC2dReferenceMapping<ReferenceType>> mappings;
	private String errorMessage;
	private boolean resolveFuzzy;
	private java.util.Set<nl.utwente.apc.Code2D.resource.c2d.IC2dQuickFix> quickFixes;
	
	public C2dReferenceResolveResult(boolean resolveFuzzy) {
		super();
		this.resolveFuzzy = resolveFuzzy;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public java.util.Collection<nl.utwente.apc.Code2D.resource.c2d.IC2dQuickFix> getQuickFixes() {
		if (quickFixes == null) {
			quickFixes = new java.util.LinkedHashSet<nl.utwente.apc.Code2D.resource.c2d.IC2dQuickFix>();
		}
		return java.util.Collections.unmodifiableSet(quickFixes);
	}
	
	public void addQuickFix(nl.utwente.apc.Code2D.resource.c2d.IC2dQuickFix quickFix) {
		if (quickFixes == null) {
			quickFixes = new java.util.LinkedHashSet<nl.utwente.apc.Code2D.resource.c2d.IC2dQuickFix>();
		}
		quickFixes.add(quickFix);
	}
	
	public java.util.Collection<nl.utwente.apc.Code2D.resource.c2d.IC2dReferenceMapping<ReferenceType>> getMappings() {
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
			mappings = new java.util.ArrayList<nl.utwente.apc.Code2D.resource.c2d.IC2dReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new nl.utwente.apc.Code2D.resource.c2d.mopp.C2dElementMapping<ReferenceType>(identifier, target, warning));
		errorMessage = null;
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri) {
		addMapping(identifier, uri, null);
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri, String warning) {
		if (mappings == null) {
			mappings = new java.util.ArrayList<nl.utwente.apc.Code2D.resource.c2d.IC2dReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new nl.utwente.apc.Code2D.resource.c2d.mopp.C2dURIMapping<ReferenceType>(identifier, uri, warning));
	}
}
