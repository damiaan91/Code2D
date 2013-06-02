/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2d.grammar;

public class C2dCompound extends nl.utwente.apc.Code2D.resource.c2d.grammar.C2dSyntaxElement {
	
	public C2dCompound(nl.utwente.apc.Code2D.resource.c2d.grammar.C2dChoice choice, nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality cardinality) {
		super(cardinality, new nl.utwente.apc.Code2D.resource.c2d.grammar.C2dSyntaxElement[] {choice});
	}
	
	public String toString() {
		return "(" + getChildren()[0] + ")";
	}
	
}
