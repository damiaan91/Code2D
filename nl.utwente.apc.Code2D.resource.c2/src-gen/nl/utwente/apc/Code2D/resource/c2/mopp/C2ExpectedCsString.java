/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2.mopp;

/**
 * A representation for a range in a document where a keyword (i.e., a static
 * string) is expected.
 */
public class C2ExpectedCsString extends nl.utwente.apc.Code2D.resource.c2.mopp.C2AbstractExpectedElement {
	
	private nl.utwente.apc.Code2D.resource.c2.grammar.C2Keyword keyword;
	
	public C2ExpectedCsString(nl.utwente.apc.Code2D.resource.c2.grammar.C2Keyword keyword) {
		super(keyword.getMetaclass());
		this.keyword = keyword;
	}
	
	public String getValue() {
		return keyword.getValue();
	}
	
	/**
	 * Returns the expected keyword.
	 */
	public nl.utwente.apc.Code2D.resource.c2.grammar.C2SyntaxElement getSymtaxElement() {
		return keyword;
	}
	
	public java.util.Set<String> getTokenNames() {
		return java.util.Collections.singleton("'" + getValue() + "'");
	}
	
	public String toString() {
		return "CsString \"" + getValue() + "\"";
	}
	
	public boolean equals(Object o) {
		if (o instanceof C2ExpectedCsString) {
			return getValue().equals(((C2ExpectedCsString) o).getValue());
		}
		return false;
	}
	
	@Override	
	public int hashCode() {
		return getValue().hashCode();
	}
	
}
