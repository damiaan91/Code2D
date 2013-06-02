/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2.grammar;

public class C2LineBreak extends nl.utwente.apc.Code2D.resource.c2.grammar.C2FormattingElement {
	
	private final int tabs;
	
	public C2LineBreak(nl.utwente.apc.Code2D.resource.c2.grammar.C2Cardinality cardinality, int tabs) {
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
