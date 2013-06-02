/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2d.mopp;

/**
 * A representation for a range in a document where a keyword (i.e., a static
 * string) is expected.
 */
public class C2dExpectedCsString extends nl.utwente.apc.Code2D.resource.c2d.mopp.C2dAbstractExpectedElement {
	
	private nl.utwente.apc.Code2D.resource.c2d.grammar.C2dKeyword keyword;
	
	public C2dExpectedCsString(nl.utwente.apc.Code2D.resource.c2d.grammar.C2dKeyword keyword) {
		super(keyword.getMetaclass());
		this.keyword = keyword;
	}
	
	public String getValue() {
		return keyword.getValue();
	}
	
	/**
	 * Returns the expected keyword.
	 */
	public nl.utwente.apc.Code2D.resource.c2d.grammar.C2dSyntaxElement getSymtaxElement() {
		return keyword;
	}
	
	public java.util.Set<String> getTokenNames() {
		return java.util.Collections.singleton("'" + getValue() + "'");
	}
	
	public String toString() {
		return "CsString \"" + getValue() + "\"";
	}
	
	public boolean equals(Object o) {
		if (o instanceof C2dExpectedCsString) {
			return getValue().equals(((C2dExpectedCsString) o).getValue());
		}
		return false;
	}
	
	@Override	
	public int hashCode() {
		return getValue().hashCode();
	}
	
}
