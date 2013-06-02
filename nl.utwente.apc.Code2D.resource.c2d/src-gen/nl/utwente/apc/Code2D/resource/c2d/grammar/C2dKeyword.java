/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2d.grammar;

/**
 * A class to represent a keyword in the grammar.
 */
public class C2dKeyword extends nl.utwente.apc.Code2D.resource.c2d.grammar.C2dSyntaxElement {
	
	private final String value;
	
	public C2dKeyword(String value, nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality cardinality) {
		super(cardinality, null);
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public String toString() {
		return value;
	}
	
}
