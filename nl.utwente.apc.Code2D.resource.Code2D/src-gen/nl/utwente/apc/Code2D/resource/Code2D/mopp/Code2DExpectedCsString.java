/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.Code2D.mopp;

/**
 * A representation for a range in a document where a keyword (i.e., a static
 * string) is expected.
 */
public class Code2DExpectedCsString extends nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DAbstractExpectedElement {
	
	private nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DKeyword keyword;
	
	public Code2DExpectedCsString(nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DKeyword keyword) {
		super(keyword.getMetaclass());
		this.keyword = keyword;
	}
	
	public String getValue() {
		return keyword.getValue();
	}
	
	/**
	 * Returns the expected keyword.
	 */
	public nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DSyntaxElement getSymtaxElement() {
		return keyword;
	}
	
	public java.util.Set<String> getTokenNames() {
		return java.util.Collections.singleton("'" + getValue() + "'");
	}
	
	public String toString() {
		return "CsString \"" + getValue() + "\"";
	}
	
	public boolean equals(Object o) {
		if (o instanceof Code2DExpectedCsString) {
			return getValue().equals(((Code2DExpectedCsString) o).getValue());
		}
		return false;
	}
	
	@Override	
	public int hashCode() {
		return getValue().hashCode();
	}
	
}
