/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2d.grammar;

/**
 * A class to represent a rules in the grammar.
 */
public class C2dRule extends nl.utwente.apc.Code2D.resource.c2d.grammar.C2dSyntaxElement {
	
	private final org.eclipse.emf.ecore.EClass metaclass;
	
	public C2dRule(org.eclipse.emf.ecore.EClass metaclass, nl.utwente.apc.Code2D.resource.c2d.grammar.C2dChoice choice, nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality cardinality) {
		super(cardinality, new nl.utwente.apc.Code2D.resource.c2d.grammar.C2dSyntaxElement[] {choice});
		this.metaclass = metaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return metaclass;
	}
	
	public nl.utwente.apc.Code2D.resource.c2d.grammar.C2dChoice getDefinition() {
		return (nl.utwente.apc.Code2D.resource.c2d.grammar.C2dChoice) getChildren()[0];
	}
	
}

