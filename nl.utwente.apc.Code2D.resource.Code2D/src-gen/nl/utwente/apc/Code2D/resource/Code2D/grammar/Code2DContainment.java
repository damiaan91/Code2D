/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.Code2D.grammar;

public class Code2DContainment extends nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DTerminal {
	
	private final org.eclipse.emf.ecore.EClass[] allowedTypes;
	
	public Code2DContainment(org.eclipse.emf.ecore.EStructuralFeature feature, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DCardinality cardinality, org.eclipse.emf.ecore.EClass[] allowedTypes, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.allowedTypes = allowedTypes;
	}
	
	public org.eclipse.emf.ecore.EClass[] getAllowedTypes() {
		return allowedTypes;
	}
	
	public String toString() {
		String typeRestrictions = null;
		if (allowedTypes != null && allowedTypes.length > 0) {
			typeRestrictions = nl.utwente.apc.Code2D.resource.Code2D.util.Code2DStringUtil.explode(allowedTypes, ", ", new nl.utwente.apc.Code2D.resource.Code2D.ICode2DFunction1<String, org.eclipse.emf.ecore.EClass>() {
				public String execute(org.eclipse.emf.ecore.EClass eClass) {
					return eClass.getName();
				}
			});
		}
		return getFeature().getName() + (typeRestrictions == null ? "" : "[" + typeRestrictions + "]");
	}
	
}
