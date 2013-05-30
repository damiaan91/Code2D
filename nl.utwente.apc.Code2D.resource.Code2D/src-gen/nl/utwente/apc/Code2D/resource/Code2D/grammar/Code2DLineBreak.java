/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.Code2D.grammar;

public class Code2DLineBreak extends nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DFormattingElement {
	
	private final int tabs;
	
	public Code2DLineBreak(nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DCardinality cardinality, int tabs) {
		super(cardinality);
		this.tabs = tabs;
	}
	
	public int getTabs() {
		return tabs;
	}
	
	public String toString() {
		return "!" + getTabs();
	}
	
}
