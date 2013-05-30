/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.Code2D.mopp;

/**
 * Abstract super class for all expected elements. Provides methods to add
 * followers.
 */
public abstract class Code2DAbstractExpectedElement implements nl.utwente.apc.Code2D.resource.Code2D.ICode2DExpectedElement {
	
	private org.eclipse.emf.ecore.EClass ruleMetaclass;
	
	private java.util.Set<nl.utwente.apc.Code2D.resource.Code2D.util.Code2DPair<nl.utwente.apc.Code2D.resource.Code2D.ICode2DExpectedElement, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DContainedFeature[]>> followers = new java.util.LinkedHashSet<nl.utwente.apc.Code2D.resource.Code2D.util.Code2DPair<nl.utwente.apc.Code2D.resource.Code2D.ICode2DExpectedElement, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DContainedFeature[]>>();
	
	public Code2DAbstractExpectedElement(org.eclipse.emf.ecore.EClass ruleMetaclass) {
		super();
		this.ruleMetaclass = ruleMetaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getRuleMetaclass() {
		return ruleMetaclass;
	}
	
	public void addFollower(nl.utwente.apc.Code2D.resource.Code2D.ICode2DExpectedElement follower, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DContainedFeature[] path) {
		followers.add(new nl.utwente.apc.Code2D.resource.Code2D.util.Code2DPair<nl.utwente.apc.Code2D.resource.Code2D.ICode2DExpectedElement, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DContainedFeature[]>(follower, path));
	}
	
	public java.util.Collection<nl.utwente.apc.Code2D.resource.Code2D.util.Code2DPair<nl.utwente.apc.Code2D.resource.Code2D.ICode2DExpectedElement, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DContainedFeature[]>> getFollowers() {
		return followers;
	}
	
}
