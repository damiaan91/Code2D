/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2d.grammar;

public class C2dLineBreak extends nl.utwente.apc.Code2D.resource.c2d.grammar.C2dFormattingElement {
	
	private final int tabs;
	
	public C2dLineBreak(nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality cardinality, int tabs) {
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
