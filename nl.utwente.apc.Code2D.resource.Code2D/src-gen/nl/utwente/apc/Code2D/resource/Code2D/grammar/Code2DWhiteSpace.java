/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.Code2D.grammar;

public class Code2DWhiteSpace extends nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DFormattingElement {
	
	private final int amount;
	
	public Code2DWhiteSpace(int amount, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DCardinality cardinality) {
		super(cardinality);
		this.amount = amount;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public String toString() {
		return "#" + getAmount();
	}
	
}
