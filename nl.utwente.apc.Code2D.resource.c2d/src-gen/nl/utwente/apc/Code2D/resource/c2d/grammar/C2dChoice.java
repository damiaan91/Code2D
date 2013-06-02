/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2d.grammar;

public class C2dChoice extends nl.utwente.apc.Code2D.resource.c2d.grammar.C2dSyntaxElement {
	
	public C2dChoice(nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality cardinality, nl.utwente.apc.Code2D.resource.c2d.grammar.C2dSyntaxElement... choices) {
		super(cardinality, choices);
	}
	
	public String toString() {
		return nl.utwente.apc.Code2D.resource.c2d.util.C2dStringUtil.explode(getChildren(), "|");
	}
	
}
