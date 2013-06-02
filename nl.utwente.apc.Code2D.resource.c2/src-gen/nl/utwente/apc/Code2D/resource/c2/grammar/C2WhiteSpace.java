/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2.grammar;

public class C2WhiteSpace extends nl.utwente.apc.Code2D.resource.c2.grammar.C2FormattingElement {
	
	private final int amount;
	
	public C2WhiteSpace(int amount, nl.utwente.apc.Code2D.resource.c2.grammar.C2Cardinality cardinality) {
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
