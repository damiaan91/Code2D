/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2.grammar;

/**
 * A class to represent a rules in the grammar.
 */
public class C2Rule extends nl.utwente.apc.Code2D.resource.c2.grammar.C2SyntaxElement {
	
	private final org.eclipse.emf.ecore.EClass metaclass;
	
	public C2Rule(org.eclipse.emf.ecore.EClass metaclass, nl.utwente.apc.Code2D.resource.c2.grammar.C2Choice choice, nl.utwente.apc.Code2D.resource.c2.grammar.C2Cardinality cardinality) {
		super(cardinality, new nl.utwente.apc.Code2D.resource.c2.grammar.C2SyntaxElement[] {choice});
		this.metaclass = metaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return metaclass;
	}
	
	public nl.utwente.apc.Code2D.resource.c2.grammar.C2Choice getDefinition() {
		return (nl.utwente.apc.Code2D.resource.c2.grammar.C2Choice) getChildren()[0];
	}
	
}

