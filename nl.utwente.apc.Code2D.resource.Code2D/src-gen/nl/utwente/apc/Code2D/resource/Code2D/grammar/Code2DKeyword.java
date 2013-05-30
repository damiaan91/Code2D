/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.Code2D.grammar;

/**
 * A class to represent a keyword in the grammar.
 */
public class Code2DKeyword extends nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DSyntaxElement {
	
	private final String value;
	
	public Code2DKeyword(String value, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DCardinality cardinality) {
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
