/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2d.grammar;

/**
 * A C2dContainmentTrace represents a specific path to a structural feature by
 * navigating over a set of a structural feature from a start class.
 * C2dContainmentTraces are used during code completion to reconstruct containment
 * trees that are not created by the parser, for example, if the first character
 * of the contained object has not been typed yet.
 */
public class C2dContainmentTrace {
	
	/**
	 * The class where the trace starts.
	 */
	private org.eclipse.emf.ecore.EClass startClass;
	
	/**
	 * The path of contained features.
	 */
	private nl.utwente.apc.Code2D.resource.c2d.mopp.C2dContainedFeature[] path;
	
	public C2dContainmentTrace(org.eclipse.emf.ecore.EClass startClass, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dContainedFeature[] path) {
		super();
		// Verify arguments
		if (startClass != null) {
			if (path.length > 0) {
				org.eclipse.emf.ecore.EStructuralFeature feature = path[path.length - 1].getFeature();
				if (!startClass.getEAllStructuralFeatures().contains(feature)) {
					throw new RuntimeException("Metaclass " + startClass.getName() + " must contain feature " + feature.getName());
				}
			}
		}
		this.startClass = startClass;
		this.path = path;
	}
	
	public org.eclipse.emf.ecore.EClass getStartClass() {
		return startClass;
	}
	
	public nl.utwente.apc.Code2D.resource.c2d.mopp.C2dContainedFeature[] getPath() {
		return path;
	}
	
	public String toString() {
		return (startClass == null ? "null" : startClass.getName()) + "->" + nl.utwente.apc.Code2D.resource.c2d.util.C2dStringUtil.explode(path, "->");
	}
	
}
