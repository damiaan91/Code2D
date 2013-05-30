/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.Code2D.grammar;

public class Code2DChoice extends nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DSyntaxElement {
	
	public Code2DChoice(nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DCardinality cardinality, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DSyntaxElement... choices) {
		super(cardinality, choices);
	}
	
	public String toString() {
		return nl.utwente.apc.Code2D.resource.Code2D.util.Code2DStringUtil.explode(getChildren(), "|");
	}
	
}
