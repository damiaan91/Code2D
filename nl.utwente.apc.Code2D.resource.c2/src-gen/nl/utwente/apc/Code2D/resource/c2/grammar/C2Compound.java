/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2.grammar;

public class C2Compound extends nl.utwente.apc.Code2D.resource.c2.grammar.C2SyntaxElement {
	
	public C2Compound(nl.utwente.apc.Code2D.resource.c2.grammar.C2Choice choice, nl.utwente.apc.Code2D.resource.c2.grammar.C2Cardinality cardinality) {
		super(cardinality, new nl.utwente.apc.Code2D.resource.c2.grammar.C2SyntaxElement[] {choice});
	}
	
	public String toString() {
		return "(" + getChildren()[0] + ")";
	}
	
}
