/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2.grammar;

public class C2Choice extends nl.utwente.apc.Code2D.resource.c2.grammar.C2SyntaxElement {
	
	public C2Choice(nl.utwente.apc.Code2D.resource.c2.grammar.C2Cardinality cardinality, nl.utwente.apc.Code2D.resource.c2.grammar.C2SyntaxElement... choices) {
		super(cardinality, choices);
	}
	
	public String toString() {
		return nl.utwente.apc.Code2D.resource.c2.util.C2StringUtil.explode(getChildren(), "|");
	}
	
}
