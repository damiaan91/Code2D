/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2d;

/**
 * An element that is expected at a given position in a resource stream.
 */
public interface IC2dExpectedElement {
	
	/**
	 * Returns the names of all tokens that are expected at the given position.
	 */
	public java.util.Set<String> getTokenNames();
	
	/**
	 * Returns the metaclass of the rule that contains the expected element.
	 */
	public org.eclipse.emf.ecore.EClass getRuleMetaclass();
	
	/**
	 * Returns the syntax element that is expected.
	 */
	public nl.utwente.apc.Code2D.resource.c2d.grammar.C2dSyntaxElement getSymtaxElement();
	
	/**
	 * Adds an element that is a valid follower for this element.
	 */
	public void addFollower(nl.utwente.apc.Code2D.resource.c2d.IC2dExpectedElement follower, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dContainedFeature[] path);
	
	/**
	 * Returns all valid followers for this element. Each follower is represented by a
	 * pair of an expected elements and the containment trace that leads from the
	 * current element to the follower.
	 */
	public java.util.Collection<nl.utwente.apc.Code2D.resource.c2d.util.C2dPair<nl.utwente.apc.Code2D.resource.c2d.IC2dExpectedElement, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dContainedFeature[]>> getFollowers();
	
}
