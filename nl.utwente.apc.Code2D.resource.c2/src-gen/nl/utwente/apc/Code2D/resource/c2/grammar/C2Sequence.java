/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2.grammar;

public class C2Sequence extends nl.utwente.apc.Code2D.resource.c2.grammar.C2SyntaxElement {
	
	public C2Sequence(nl.utwente.apc.Code2D.resource.c2.grammar.C2Cardinality cardinality, nl.utwente.apc.Code2D.resource.c2.grammar.C2SyntaxElement... elements) {
		super(cardinality, elements);
	}
	
	public String toString() {
		return nl.utwente.apc.Code2D.resource.c2.util.C2StringUtil.explode(getChildren(), " ");
	}
	
}
