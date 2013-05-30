/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.Code2D.grammar;

/**
 * The abstract super class for all elements of a grammar. This class provides
 * methods to traverse the grammar rules.
 */
public abstract class Code2DSyntaxElement {
	
	private Code2DSyntaxElement[] children;
	private Code2DSyntaxElement parent;
	private nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DCardinality cardinality;
	
	public Code2DSyntaxElement(nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DCardinality cardinality, Code2DSyntaxElement[] children) {
		this.cardinality = cardinality;
		this.children = children;
		if (this.children != null) {
			for (Code2DSyntaxElement child : this.children) {
				child.setParent(this);
			}
		}
	}
	
	/**
	 * Sets the parent of this syntax element. This method must be invoked at most
	 * once.
	 */
	public void setParent(Code2DSyntaxElement parent) {
		assert this.parent == null;
		this.parent = parent;
	}
	
	/**
	 * Returns the parent of this syntax element. This parent is determined by the
	 * containment hierarchy in the CS model.
	 */
	public Code2DSyntaxElement getParent() {
		return parent;
	}
	
	public Code2DSyntaxElement[] getChildren() {
		if (children == null) {
			return new Code2DSyntaxElement[0];
		}
		return children;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return parent.getMetaclass();
	}
	
	public nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DCardinality getCardinality() {
		return cardinality;
	}
	
}
