/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.Code2D.mopp;

public class Code2DSyntaxElementDecorator {
	
	/**
	 * the syntax element to be decorated
	 */
	private nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DSyntaxElement decoratedElement;
	
	/**
	 * an array of child decorators (one decorator per child of the decorated syntax
	 * element
	 */
	private Code2DSyntaxElementDecorator[] childDecorators;
	
	/**
	 * a list of the indices that must be printed
	 */
	private java.util.List<Integer> indicesToPrint = new java.util.ArrayList<Integer>();
	
	public Code2DSyntaxElementDecorator(nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DSyntaxElement decoratedElement, Code2DSyntaxElementDecorator[] childDecorators) {
		super();
		this.decoratedElement = decoratedElement;
		this.childDecorators = childDecorators;
	}
	
	public void addIndexToPrint(Integer index) {
		indicesToPrint.add(index);
	}
	
	public nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DSyntaxElement getDecoratedElement() {
		return decoratedElement;
	}
	
	public Code2DSyntaxElementDecorator[] getChildDecorators() {
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
