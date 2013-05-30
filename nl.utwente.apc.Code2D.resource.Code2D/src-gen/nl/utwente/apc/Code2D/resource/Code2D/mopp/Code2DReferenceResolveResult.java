/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.Code2D.mopp;

/**
 * A basic implementation of the
 * nl.utwente.apc.Code2D.resource.Code2D.ICode2DReferenceResolveResult interface
 * that collects mappings in a list.
 * 
 * @param <ReferenceType> the type of the references that can be contained in this
 * result
 */
public class Code2DReferenceResolveResult<ReferenceType> implements nl.utwente.apc.Code2D.resource.Code2D.ICode2DReferenceResolveResult<ReferenceType> {
	
	private java.util.Collection<nl.utwente.apc.Code2D.resource.Code2D.ICode2DReferenceMapping<ReferenceType>> mappings;
	private String errorMessage;
	private boolean resolveFuzzy;
	private java.util.Set<nl.utwente.apc.Code2D.resource.Code2D.ICode2DQuickFix> quickFixes;
	
	public Code2DReferenceResolveResult(boolean resolveFuzzy) {
		super();
		this.resolveFuzzy = resolveFuzzy;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public java.util.Collection<nl.utwente.apc.Code2D.resource.Code2D.ICode2DQuickFix> getQuickFixes() {
		if (quickFixes == null) {
			quickFixes = new java.util.LinkedHashSet<nl.utwente.apc.Code2D.resource.Code2D.ICode2DQuickFix>();
		}
		return java.util.Collections.unmodifiableSet(quickFixes);
	}
	
	public void addQuickFix(nl.utwente.apc.Code2D.resource.Code2D.ICode2DQuickFix quickFix) {
		if (quickFixes == null) {
			quickFixes = new java.util.LinkedHashSet<nl.utwente.apc.Code2D.resource.Code2D.ICode2DQuickFix>();
		}
		quickFixes.add(quickFix);
	}
	
	public java.util.Collection<nl.utwente.apc.Code2D.resource.Code2D.ICode2DReferenceMapping<ReferenceType>> getMappings() {
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
			mappings = new java.util.ArrayList<nl.utwente.apc.Code2D.resource.Code2D.ICode2DReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DElementMapping<ReferenceType>(identifier, target, warning));
		errorMessage = null;
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri) {
		addMapping(identifier, uri, null);
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri, String warning) {
		if (mappings == null) {
			mappings = new java.util.ArrayList<nl.utwente.apc.Code2D.resource.Code2D.ICode2DReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DURIMapping<ReferenceType>(identifier, uri, warning));
	}
}
