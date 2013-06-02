/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2d.mopp;

public class C2dSyntaxElementDecorator {
	
	/**
	 * the syntax element to be decorated
	 */
	private nl.utwente.apc.Code2D.resource.c2d.grammar.C2dSyntaxElement decoratedElement;
	
	/**
	 * an array of child decorators (one decorator per child of the decorated syntax
	 * element
	 */
	private C2dSyntaxElementDecorator[] childDecorators;
	
	/**
	 * a list of the indices that must be printed
	 */
	private java.util.List<Integer> indicesToPrint = new java.util.ArrayList<Integer>();
	
	public C2dSyntaxElementDecorator(nl.utwente.apc.Code2D.resource.c2d.grammar.C2dSyntaxElement decoratedElement, C2dSyntaxElementDecorator[] childDecorators) {
		super();
		this.decoratedElement = decoratedElement;
		this.childDecorators = childDecorators;
	}
	
	public void addIndexToPrint(Integer index) {
		indicesToPrint.add(index);
	}
	
	public nl.utwente.apc.Code2D.resource.c2d.grammar.C2dSyntaxElement getDecoratedElement() {
		return decoratedElement;
	}
	
	public C2dSyntaxElementDecorator[] getChildDecorators() {
		return childDecorators;
	}
	
	public Integer getNextIndexToPrint() {
		if (indicesToPrint.size() == 0) {
			return null;
		}
		return indicesToPrint.remove(0);
	}
	
	public String toString() {
		return "" + getDecoratedElement();
	}
	
}
