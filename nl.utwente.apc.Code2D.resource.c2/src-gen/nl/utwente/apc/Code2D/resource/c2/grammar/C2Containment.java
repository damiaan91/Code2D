/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2.grammar;

public class C2Containment extends nl.utwente.apc.Code2D.resource.c2.grammar.C2Terminal {
	
	private final org.eclipse.emf.ecore.EClass[] allowedTypes;
	
	public C2Containment(org.eclipse.emf.ecore.EStructuralFeature feature, nl.utwente.apc.Code2D.resource.c2.grammar.C2Cardinality cardinality, org.eclipse.emf.ecore.EClass[] allowedTypes, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.allowedTypes = allowedTypes;
	}
	
	public org.eclipse.emf.ecore.EClass[] getAllowedTypes() {
		return allowedTypes;
	}
	
	public String toString() {
		String typeRestrictions = null;
		if (allowedTypes != null && allowedTypes.length > 0) {
			typeRestrictions = nl.utwente.apc.Code2D.resource.c2.util.C2StringUtil.explode(allowedTypes, ", ", new nl.utwente.apc.Code2D.resource.c2.IC2Function1<String, org.eclipse.emf.ecore.EClass>() {
				public String execute(org.eclipse.emf.ecore.EClass eClass) {
					return eClass.getName();
				}
			});
		}
		return getFeature().getName() + (typeRestrictions == null ? "" : "[" + typeRestrictions + "]");
	}
	
}
