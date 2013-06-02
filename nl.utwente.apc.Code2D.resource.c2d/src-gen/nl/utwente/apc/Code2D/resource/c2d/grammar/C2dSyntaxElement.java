/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2d.grammar;

/**
 * The abstract super class for all elements of a grammar. This class provides
 * methods to traverse the grammar rules.
 */
public abstract class C2dSyntaxElement {
	
	private C2dSyntaxElement[] children;
	private C2dSyntaxElement parent;
	private nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality cardinality;
	
	public C2dSyntaxElement(nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality cardinality, C2dSyntaxElement[] children) {
		this.cardinality = cardinality;
		this.children = children;
		if (this.children != null) {
			for (C2dSyntaxElement child : this.children) {
				child.setParent(this);
			}
		}
	}
	
	/**
	 * Sets the parent of this syntax element. This method must be invoked at most
	 * once.
	 */
	public void setParent(C2dSyntaxElement parent) {
		assert this.parent == null;
		this.parent = parent;
	}
	
	/**
	 * Returns the parent of this syntax element. This parent is determined by the
	 * containment hierarchy in the CS model.
	 */
	public C2dSyntaxElement getParent() {
		return parent;
	}
	
	public C2dSyntaxElement[] getChildren() {
		if (children == null) {
			return new C2dSyntaxElement[0];
		}
		return children;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return parent.getMetaclass();
	}
	
	public nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality getCardinality() {
		return cardinality;
	}
	
}
