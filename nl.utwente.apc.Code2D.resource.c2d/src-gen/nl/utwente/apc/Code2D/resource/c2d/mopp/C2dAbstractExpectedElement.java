/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2d.mopp;

/**
 * Abstract super class for all expected elements. Provides methods to add
 * followers.
 */
public abstract class C2dAbstractExpectedElement implements nl.utwente.apc.Code2D.resource.c2d.IC2dExpectedElement {
	
	private org.eclipse.emf.ecore.EClass ruleMetaclass;
	
	private java.util.Set<nl.utwente.apc.Code2D.resource.c2d.util.C2dPair<nl.utwente.apc.Code2D.resource.c2d.IC2dExpectedElement, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dContainedFeature[]>> followers = new java.util.LinkedHashSet<nl.utwente.apc.Code2D.resource.c2d.util.C2dPair<nl.utwente.apc.Code2D.resource.c2d.IC2dExpectedElement, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dContainedFeature[]>>();
	
	public C2dAbstractExpectedElement(org.eclipse.emf.ecore.EClass ruleMetaclass) {
		super();
		this.ruleMetaclass = ruleMetaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getRuleMetaclass() {
		return ruleMetaclass;
	}
	
	public void addFollower(nl.utwente.apc.Code2D.resource.c2d.IC2dExpectedElement follower, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dContainedFeature[] path) {
		followers.add(new nl.utwente.apc.Code2D.resource.c2d.util.C2dPair<nl.utwente.apc.Code2D.resource.c2d.IC2dExpectedElement, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dContainedFeature[]>(follower, path));
	}
	
	public java.util.Collection<nl.utwente.apc.Code2D.resource.c2d.util.C2dPair<nl.utwente.apc.Code2D.resource.c2d.IC2dExpectedElement, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dContainedFeature[]>> getFollowers() {
		return followers;
	}
	
}
