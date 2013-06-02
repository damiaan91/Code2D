/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2.grammar;

/**
 * The abstract super class for all elements of a grammar. This class provides
 * methods to traverse the grammar rules.
 */
public abstract class C2SyntaxElement {
	
	private C2SyntaxElement[] children;
	private C2SyntaxElement parent;
	private nl.utwente.apc.Code2D.resource.c2.grammar.C2Cardinality cardinality;
	
	public C2SyntaxElement(nl.utwente.apc.Code2D.resource.c2.grammar.C2Cardinality cardinality, C2SyntaxElement[] children) {
		this.cardinality = cardinality;
		this.children = children;
		if (this.children != null) {
			for (C2SyntaxElement child : this.children) {
				child.setParent(this);
			}
		}
	}
	
	/**
	 * Sets the parent of this syntax element. This method must be invoked at most
	 * once.
	 */
	public void setParent(C2SyntaxElement parent) {
		assert this.parent == null;
		this.parent = parent;
	}
	
	/**
	 * Returns the parent of this syntax element. This parent is determined by the
	 * containment hierarchy in the CS model.
	 */
	public C2SyntaxElement getParent() {
		return parent;
	}
	
	public C2SyntaxElement[] getChildren() {
		if (children == null) {
			return new C2SyntaxElement[0];
		}
		return children;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return parent.getMetaclass();
	}
	
	public nl.utwente.apc.Code2D.resource.c2.grammar.C2Cardinality getCardinality() {
		return cardinality;
	}
	
}
