/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.Code2D.grammar;

public class Code2DCompound extends nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DSyntaxElement {
	
	public Code2DCompound(nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DChoice choice, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DCardinality cardinality) {
		super(cardinality, new nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DSyntaxElement[] {choice});
	}
	
	public String toString() {
		return "(" + getChildren()[0] + ")";
	}
	
}
