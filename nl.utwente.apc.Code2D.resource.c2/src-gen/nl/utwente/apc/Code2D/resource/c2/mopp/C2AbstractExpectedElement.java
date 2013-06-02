/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2.mopp;

/**
 * Abstract super class for all expected elements. Provides methods to add
 * followers.
 */
public abstract class C2AbstractExpectedElement implements nl.utwente.apc.Code2D.resource.c2.IC2ExpectedElement {
	
	private org.eclipse.emf.ecore.EClass ruleMetaclass;
	
	private java.util.Set<nl.utwente.apc.Code2D.resource.c2.util.C2Pair<nl.utwente.apc.Code2D.resource.c2.IC2ExpectedElement, nl.utwente.apc.Code2D.resource.c2.mopp.C2ContainedFeature[]>> followers = new java.util.LinkedHashSet<nl.utwente.apc.Code2D.resource.c2.util.C2Pair<nl.utwente.apc.Code2D.resource.c2.IC2ExpectedElement, nl.utwente.apc.Code2D.resource.c2.mopp.C2ContainedFeature[]>>();
	
	public C2AbstractExpectedElement(org.eclipse.emf.ecore.EClass ruleMetaclass) {
		super();
		this.ruleMetaclass = ruleMetaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getRuleMetaclass() {
		return ruleMetaclass;
	}
	
	public void addFollower(nl.utwente.apc.Code2D.resource.c2.IC2ExpectedElement follower, nl.utwente.apc.Code2D.resource.c2.mopp.C2ContainedFeature[] path) {
		followers.add(new nl.utwente.apc.Code2D.resource.c2.util.C2Pair<nl.utwente.apc.Code2D.resource.c2.IC2ExpectedElement, nl.utwente.apc.Code2D.resource.c2.mopp.C2ContainedFeature[]>(follower, path));
	}
	
	public java.util.Collection<nl.utwente.apc.Code2D.resource.c2.util.C2Pair<nl.utwente.apc.Code2D.resource.c2.IC2ExpectedElement, nl.utwente.apc.Code2D.resource.c2.mopp.C2ContainedFeature[]>> getFollowers() {
		return followers;
	}
	
}
