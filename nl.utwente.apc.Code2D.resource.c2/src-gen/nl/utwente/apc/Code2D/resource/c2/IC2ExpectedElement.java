/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2;

/**
 * An element that is expected at a given position in a resource stream.
 */
public interface IC2ExpectedElement {
	
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
	public nl.utwente.apc.Code2D.resource.c2.grammar.C2SyntaxElement getSymtaxElement();
	
	/**
	 * Adds an element that is a valid follower for this element.
	 */
	public void addFollower(nl.utwente.apc.Code2D.resource.c2.IC2ExpectedElement follower, nl.utwente.apc.Code2D.resource.c2.mopp.C2ContainedFeature[] path);
	
	/**
	 * Returns all valid followers for this element. Each follower is represented by a
	 * pair of an expected elements and the containment trace that leads from the
	 * current element to the follower.
	 */
	public java.util.Collection<nl.utwente.apc.Code2D.resource.c2.util.C2Pair<nl.utwente.apc.Code2D.resource.c2.IC2ExpectedElement, nl.utwente.apc.Code2D.resource.c2.mopp.C2ContainedFeature[]>> getFollowers();
	
}
