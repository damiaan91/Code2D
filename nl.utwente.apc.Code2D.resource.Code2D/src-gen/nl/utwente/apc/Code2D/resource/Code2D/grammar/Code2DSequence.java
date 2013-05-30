/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.Code2D.grammar;

public class Code2DSequence extends nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DSyntaxElement {
	
	public Code2DSequence(nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DCardinality cardinality, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DSyntaxElement... elements) {
		super(cardinality, elements);
	}
	
	public String toString() {
		return nl.utwente.apc.Code2D.resource.Code2D.util.Code2DStringUtil.explode(getChildren(), " ");
	}
	
}
