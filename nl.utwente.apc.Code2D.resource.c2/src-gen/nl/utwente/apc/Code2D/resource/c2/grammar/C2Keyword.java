/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2.grammar;

/**
 * A class to represent a keyword in the grammar.
 */
public class C2Keyword extends nl.utwente.apc.Code2D.resource.c2.grammar.C2SyntaxElement {
	
	private final String value;
	
	public C2Keyword(String value, nl.utwente.apc.Code2D.resource.c2.grammar.C2Cardinality cardinality) {
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
