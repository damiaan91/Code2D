/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2.grammar;

public class C2GrammarInformationProvider {
	
	public final static org.eclipse.emf.ecore.EStructuralFeature ANONYMOUS_FEATURE = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEAttribute();
	static {
		ANONYMOUS_FEATURE.setName("_");
	}
	
	public final static C2GrammarInformationProvider INSTANCE = new C2GrammarInformationProvider();
	
	private java.util.Set<String> keywords;
	
	public final static nl.utwente.apc.Code2D.resource.c2.grammar.C2Keyword C2_0_0_0_0 = new nl.utwente.apc.Code2D.resource.c2.grammar.C2Keyword("Game", nl.utwente.apc.Code2D.resource.c2.grammar.C2Cardinality.ONE);
	public final static nl.utwente.apc.Code2D.resource.c2.grammar.C2Placeholder C2_0_0_0_1 = new nl.utwente.apc.Code2D.resource.c2.grammar.C2Placeholder(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.GAME__NAME), "TEXT", nl.utwente.apc.Code2D.resource.c2.grammar.C2Cardinality.ONE, 0);
	public final static nl.utwente.apc.Code2D.resource.c2.grammar.C2Keyword C2_0_0_0_2 = new nl.utwente.apc.Code2D.resource.c2.grammar.C2Keyword("{", nl.utwente.apc.Code2D.resource.c2.grammar.C2Cardinality.ONE);
	public final static nl.utwente.apc.Code2D.resource.c2.grammar.C2Containment C2_0_0_0_3 = new nl.utwente.apc.Code2D.resource.c2.grammar.C2Containment(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.GAME__GAME_WORLD), nl.utwente.apc.Code2D.resource.c2.grammar.C2Cardinality.ONE, new org.eclipse.emf.ecore.EClass[] {nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getWorld(), }, 0);
	public final static nl.utwente.apc.Code2D.resource.c2.grammar.C2Keyword C2_0_0_0_4 = new nl.utwente.apc.Code2D.resource.c2.grammar.C2Keyword("}", nl.utwente.apc.Code2D.resource.c2.grammar.C2Cardinality.ONE);
	public final static nl.utwente.apc.Code2D.resource.c2.grammar.C2Sequence C2_0_0_0 = new nl.utwente.apc.Code2D.resource.c2.grammar.C2Sequence(nl.utwente.apc.Code2D.resource.c2.grammar.C2Cardinality.ONE, C2_0_0_0_0, C2_0_0_0_1, C2_0_0_0_2, C2_0_0_0_3, C2_0_0_0_4);
	public final static nl.utwente.apc.Code2D.resource.c2.grammar.C2Choice C2_0_0 = new nl.utwente.apc.Code2D.resource.c2.grammar.C2Choice(nl.utwente.apc.Code2D.resource.c2.grammar.C2Cardinality.ONE, C2_0_0_0);
	public final static nl.utwente.apc.Code2D.resource.c2.grammar.C2Rule C2_0 = new nl.utwente.apc.Code2D.resource.c2.grammar.C2Rule(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), C2_0_0, nl.utwente.apc.Code2D.resource.c2.grammar.C2Cardinality.ONE);
	public final static nl.utwente.apc.Code2D.resource.c2.grammar.C2Keyword C2_1_0_0_0 = new nl.utwente.apc.Code2D.resource.c2.grammar.C2Keyword("World", nl.utwente.apc.Code2D.resource.c2.grammar.C2Cardinality.ONE);
	public final static nl.utwente.apc.Code2D.resource.c2.grammar.C2Keyword C2_1_0_0_1 = new nl.utwente.apc.Code2D.resource.c2.grammar.C2Keyword("{", nl.utwente.apc.Code2D.resource.c2.grammar.C2Cardinality.ONE);
	public final static nl.utwente.apc.Code2D.resource.c2.grammar.C2Keyword C2_1_0_0_2 = new nl.utwente.apc.Code2D.resource.c2.grammar.C2Keyword("Name:", nl.utwente.apc.Code2D.resource.c2.grammar.C2Cardinality.ONE);
	public final static nl.utwente.apc.Code2D.resource.c2.grammar.C2Placeholder C2_1_0_0_3 = new nl.utwente.apc.Code2D.resource.c2.grammar.C2Placeholder(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getWorld().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.WORLD__NAME), "TEXT", nl.utwente.apc.Code2D.resource.c2.grammar.C2Cardinality.ONE, 0);
	public final static nl.utwente.apc.Code2D.resource.c2.grammar.C2Keyword C2_1_0_0_4 = new nl.utwente.apc.Code2D.resource.c2.grammar.C2Keyword("}", nl.utwente.apc.Code2D.resource.c2.grammar.C2Cardinality.ONE);
	public final static nl.utwente.apc.Code2D.resource.c2.grammar.C2Sequence C2_1_0_0 = new nl.utwente.apc.Code2D.resource.c2.grammar.C2Sequence(nl.utwente.apc.Code2D.resource.c2.grammar.C2Cardinality.ONE, C2_1_0_0_0, C2_1_0_0_1, C2_1_0_0_2, C2_1_0_0_3, C2_1_0_0_4);
	public final static nl.utwente.apc.Code2D.resource.c2.grammar.C2Choice C2_1_0 = new nl.utwente.apc.Code2D.resource.c2.grammar.C2Choice(nl.utwente.apc.Code2D.resource.c2.grammar.C2Cardinality.ONE, C2_1_0_0);
	public final static nl.utwente.apc.Code2D.resource.c2.grammar.C2Rule C2_1 = new nl.utwente.apc.Code2D.resource.c2.grammar.C2Rule(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getWorld(), C2_1_0, nl.utwente.apc.Code2D.resource.c2.grammar.C2Cardinality.ONE);
	
	public static String getSyntaxElementID(nl.utwente.apc.Code2D.resource.c2.grammar.C2SyntaxElement syntaxElement) {
		if (syntaxElement == null) {
			// null indicates EOF
			return "<EOF>";
		}
		for (java.lang.reflect.Field field : nl.utwente.apc.Code2D.resource.c2.grammar.C2GrammarInformationProvider.class.getFields()) {
			Object fieldValue;
			try {
				fieldValue = field.get(null);
				if (fieldValue == syntaxElement) {
					String id = field.getName();
					return id;
				}
			} catch (Exception e) { }
		}
		return null;
	}
	
	public static nl.utwente.apc.Code2D.resource.c2.grammar.C2SyntaxElement getSyntaxElementByID(String syntaxElementID) {
		try {
			return (nl.utwente.apc.Code2D.resource.c2.grammar.C2SyntaxElement) nl.utwente.apc.Code2D.resource.c2.grammar.C2GrammarInformationProvider.class.getField(syntaxElementID).get(null);
		} catch (Exception e) {
			return null;
		}
	}
	
	public final static nl.utwente.apc.Code2D.resource.c2.grammar.C2Rule[] RULES = new nl.utwente.apc.Code2D.resource.c2.grammar.C2Rule[] {
		C2_0,
		C2_1,
	};
	
	/**
	 * Returns all keywords of the grammar. This includes all literals for boolean and
	 * enumeration terminals.
	 */
	public java.util.Set<String> getKeywords() {
		if (this.keywords == null) {
			this.keywords = new java.util.LinkedHashSet<String>();
			for (nl.utwente.apc.Code2D.resource.c2.grammar.C2Rule rule : RULES) {
				findKeywords(rule, this.keywords);
			}
		}
		return keywords;
	}
	
	/**
	 * Finds all keywords in the given element and its children and adds them to the
	 * set. This includes all literals for boolean and enumeration terminals.
	 */
	private void findKeywords(nl.utwente.apc.Code2D.resource.c2.grammar.C2SyntaxElement element, java.util.Set<String> keywords) {
		if (element instanceof nl.utwente.apc.Code2D.resource.c2.grammar.C2Keyword) {
			keywords.add(((nl.utwente.apc.Code2D.resource.c2.grammar.C2Keyword) element).getValue());
		} else if (element instanceof nl.utwente.apc.Code2D.resource.c2.grammar.C2BooleanTerminal) {
			keywords.add(((nl.utwente.apc.Code2D.resource.c2.grammar.C2BooleanTerminal) element).getTrueLiteral());
			keywords.add(((nl.utwente.apc.Code2D.resource.c2.grammar.C2BooleanTerminal) element).getFalseLiteral());
		} else if (element instanceof nl.utwente.apc.Code2D.resource.c2.grammar.C2EnumerationTerminal) {
			nl.utwente.apc.Code2D.resource.c2.grammar.C2EnumerationTerminal terminal = (nl.utwente.apc.Code2D.resource.c2.grammar.C2EnumerationTerminal) element;
			for (String key : terminal.getLiteralMapping().keySet()) {
				keywords.add(key);
			}
		}
		for (nl.utwente.apc.Code2D.resource.c2.grammar.C2SyntaxElement child : element.getChildren()) {
			findKeywords(child, this.keywords);
		}
	}
	
}
