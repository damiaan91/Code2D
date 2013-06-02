/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2d.grammar;

public class C2dWhiteSpace extends nl.utwente.apc.Code2D.resource.c2d.grammar.C2dFormattingElement {
	
	private final int amount;
	
	public C2dWhiteSpace(int amount, nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality cardinality) {
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
