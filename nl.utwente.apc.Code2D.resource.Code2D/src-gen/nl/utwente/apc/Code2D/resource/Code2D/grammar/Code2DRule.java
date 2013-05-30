/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.Code2D.grammar;

/**
 * A class to represent a rules in the grammar.
 */
public class Code2DRule extends nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DSyntaxElement {
	
	private final org.eclipse.emf.ecore.EClass metaclass;
	
	public Code2DRule(org.eclipse.emf.ecore.EClass metaclass, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DChoice choice, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DCardinality cardinality) {
		super(cardinality, new nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DSyntaxElement[] {choice});
		this.metaclass = metaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return metaclass;
	}
	
	public nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DChoice getDefinition() {
		return (nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DChoice) getChildren()[0];
	}
	
}

