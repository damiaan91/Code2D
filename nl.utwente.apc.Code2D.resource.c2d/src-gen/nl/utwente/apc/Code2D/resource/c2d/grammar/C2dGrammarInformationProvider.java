/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2d.grammar;

public class C2dGrammarInformationProvider {
	
	public final static org.eclipse.emf.ecore.EStructuralFeature ANONYMOUS_FEATURE = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEAttribute();
	static {
		ANONYMOUS_FEATURE.setName("_");
	}
	
	public final static C2dGrammarInformationProvider INSTANCE = new C2dGrammarInformationProvider();
	
	private java.util.Set<String> keywords;
	
	public final static nl.utwente.apc.Code2D.resource.c2d.grammar.C2dKeyword C2D_0_0_0_0 = new nl.utwente.apc.Code2D.resource.c2d.grammar.C2dKeyword("Game", nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality.ONE);
	public final static nl.utwente.apc.Code2D.resource.c2d.grammar.C2dKeyword C2D_0_0_0_1 = new nl.utwente.apc.Code2D.resource.c2d.grammar.C2dKeyword("{", nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality.ONE);
	public final static nl.utwente.apc.Code2D.resource.c2d.grammar.C2dPlaceholder C2D_0_0_0_2_0_0_0 = new nl.utwente.apc.Code2D.resource.c2d.grammar.C2dPlaceholder(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.GAME__NAME), "TEXT", nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality.ONE, 0);
	public final static nl.utwente.apc.Code2D.resource.c2d.grammar.C2dSequence C2D_0_0_0_2_0_0 = new nl.utwente.apc.Code2D.resource.c2d.grammar.C2dSequence(nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality.ONE, C2D_0_0_0_2_0_0_0);
	public final static nl.utwente.apc.Code2D.resource.c2d.grammar.C2dKeyword C2D_0_0_0_2_0_1_0 = new nl.utwente.apc.Code2D.resource.c2d.grammar.C2dKeyword("GameWorld", nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality.ONE);
	public final static nl.utwente.apc.Code2D.resource.c2d.grammar.C2dKeyword C2D_0_0_0_2_0_1_1 = new nl.utwente.apc.Code2D.resource.c2d.grammar.C2dKeyword(":", nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality.ONE);
	public final static nl.utwente.apc.Code2D.resource.c2d.grammar.C2dContainment C2D_0_0_0_2_0_1_2 = new nl.utwente.apc.Code2D.resource.c2d.grammar.C2dContainment(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.GAME__GAME_WORLD), nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getWorld(), }, 0);
	public final static nl.utwente.apc.Code2D.resource.c2d.grammar.C2dSequence C2D_0_0_0_2_0_1 = new nl.utwente.apc.Code2D.resource.c2d.grammar.C2dSequence(nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality.ONE, C2D_0_0_0_2_0_1_0, C2D_0_0_0_2_0_1_1, C2D_0_0_0_2_0_1_2);
	public final static nl.utwente.apc.Code2D.resource.c2d.grammar.C2dChoice C2D_0_0_0_2_0 = new nl.utwente.apc.Code2D.resource.c2d.grammar.C2dChoice(nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality.ONE, C2D_0_0_0_2_0_0, C2D_0_0_0_2_0_1);
	public final static nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCompound C2D_0_0_0_2 = new nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCompound(C2D_0_0_0_2_0, nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality.STAR);
	public final static nl.utwente.apc.Code2D.resource.c2d.grammar.C2dKeyword C2D_0_0_0_3 = new nl.utwente.apc.Code2D.resource.c2d.grammar.C2dKeyword("}", nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality.ONE);
	public final static nl.utwente.apc.Code2D.resource.c2d.grammar.C2dSequence C2D_0_0_0 = new nl.utwente.apc.Code2D.resource.c2d.grammar.C2dSequence(nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality.ONE, C2D_0_0_0_0, C2D_0_0_0_1, C2D_0_0_0_2, C2D_0_0_0_3);
	public final static nl.utwente.apc.Code2D.resource.c2d.grammar.C2dChoice C2D_0_0 = new nl.utwente.apc.Code2D.resource.c2d.grammar.C2dChoice(nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality.ONE, C2D_0_0_0);
	public final static nl.utwente.apc.Code2D.resource.c2d.grammar.C2dRule C2D_0 = new nl.utwente.apc.Code2D.resource.c2d.grammar.C2dRule(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), C2D_0_0, nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality.ONE);
	public final static nl.utwente.apc.Code2D.resource.c2d.grammar.C2dKeyword C2D_1_0_0_0 = new nl.utwente.apc.Code2D.resource.c2d.grammar.C2dKeyword("World", nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality.ONE);
	public final static nl.utwente.apc.Code2D.resource.c2d.grammar.C2dKeyword C2D_1_0_0_1 = new nl.utwente.apc.Code2D.resource.c2d.grammar.C2dKeyword(";", nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality.ONE);
	public final static nl.utwente.apc.Code2D.resource.c2d.grammar.C2dSequence C2D_1_0_0 = new nl.utwente.apc.Code2D.resource.c2d.grammar.C2dSequence(nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality.ONE, C2D_1_0_0_0, C2D_1_0_0_1);
	public final static nl.utwente.apc.Code2D.resource.c2d.grammar.C2dChoice C2D_1_0 = new nl.utwente.apc.Code2D.resource.c2d.grammar.C2dChoice(nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality.ONE, C2D_1_0_0);
	public final static nl.utwente.apc.Code2D.resource.c2d.grammar.C2dRule C2D_1 = new nl.utwente.apc.Code2D.resource.c2d.grammar.C2dRule(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getWorld(), C2D_1_0, nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality.ONE);
	public final static nl.utwente.apc.Code2D.resource.c2d.grammar.C2dKeyword C2D_2_0_0_0 = new nl.utwente.apc.Code2D.resource.c2d.grammar.C2dKeyword("Player", nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality.ONE);
	public final static nl.utwente.apc.Code2D.resource.c2d.grammar.C2dPlaceholder C2D_2_0_0_1_0_0_0 = new nl.utwente.apc.Code2D.resource.c2d.grammar.C2dPlaceholder(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getPlayer().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.PLAYER__NAME), "QUOTED_34_34", nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality.ONE, 0);
	public final static nl.utwente.apc.Code2D.resource.c2d.grammar.C2dSequence C2D_2_0_0_1_0_0 = new nl.utwente.apc.Code2D.resource.c2d.grammar.C2dSequence(nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality.ONE, C2D_2_0_0_1_0_0_0);
	public final static nl.utwente.apc.Code2D.resource.c2d.grammar.C2dPlaceholder C2D_2_0_0_1_0_1_0 = new nl.utwente.apc.Code2D.resource.c2d.grammar.C2dPlaceholder(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getPlayer().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.PLAYER__TEXTURE), "QUOTED_34_34", nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality.ONE, 0);
	public final static nl.utwente.apc.Code2D.resource.c2d.grammar.C2dSequence C2D_2_0_0_1_0_1 = new nl.utwente.apc.Code2D.resource.c2d.grammar.C2dSequence(nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality.ONE, C2D_2_0_0_1_0_1_0);
	public final static nl.utwente.apc.Code2D.resource.c2d.grammar.C2dChoice C2D_2_0_0_1_0 = new nl.utwente.apc.Code2D.resource.c2d.grammar.C2dChoice(nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality.ONE, C2D_2_0_0_1_0_0, C2D_2_0_0_1_0_1);
	public final static nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCompound C2D_2_0_0_1 = new nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCompound(C2D_2_0_0_1_0, nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality.STAR);
	public final static nl.utwente.apc.Code2D.resource.c2d.grammar.C2dKeyword C2D_2_0_0_2 = new nl.utwente.apc.Code2D.resource.c2d.grammar.C2dKeyword(";", nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality.ONE);
	public final static nl.utwente.apc.Code2D.resource.c2d.grammar.C2dSequence C2D_2_0_0 = new nl.utwente.apc.Code2D.resource.c2d.grammar.C2dSequence(nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality.ONE, C2D_2_0_0_0, C2D_2_0_0_1, C2D_2_0_0_2);
	public final static nl.utwente.apc.Code2D.resource.c2d.grammar.C2dChoice C2D_2_0 = new nl.utwente.apc.Code2D.resource.c2d.grammar.C2dChoice(nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality.ONE, C2D_2_0_0);
	public final static nl.utwente.apc.Code2D.resource.c2d.grammar.C2dRule C2D_2 = new nl.utwente.apc.Code2D.resource.c2d.grammar.C2dRule(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getPlayer(), C2D_2_0, nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality.ONE);
	public final static nl.utwente.apc.Code2D.resource.c2d.grammar.C2dKeyword C2D_3_0_0_0 = new nl.utwente.apc.Code2D.resource.c2d.grammar.C2dKeyword("NPC", nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality.ONE);
	public final static nl.utwente.apc.Code2D.resource.c2d.grammar.C2dPlaceholder C2D_3_0_0_1_0_0_0 = new nl.utwente.apc.Code2D.resource.c2d.grammar.C2dPlaceholder(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getNPC().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.NPC__NAME), "QUOTED_34_34", nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality.ONE, 0);
	public final static nl.utwente.apc.Code2D.resource.c2d.grammar.C2dSequence C2D_3_0_0_1_0_0 = new nl.utwente.apc.Code2D.resource.c2d.grammar.C2dSequence(nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality.ONE, C2D_3_0_0_1_0_0_0);
	public final static nl.utwente.apc.Code2D.resource.c2d.grammar.C2dPlaceholder C2D_3_0_0_1_0_1_0 = new nl.utwente.apc.Code2D.resource.c2d.grammar.C2dPlaceholder(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getNPC().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.NPC__TEXTURE), "QUOTED_34_34", nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality.ONE, 0);
	public final static nl.utwente.apc.Code2D.resource.c2d.grammar.C2dSequence C2D_3_0_0_1_0_1 = new nl.utwente.apc.Code2D.resource.c2d.grammar.C2dSequence(nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality.ONE, C2D_3_0_0_1_0_1_0);
	public final static nl.utwente.apc.Code2D.resource.c2d.grammar.C2dEnumerationTerminal C2D_3_0_0_1_0_2_0 = new nl.utwente.apc.Code2D.resource.c2d.grammar.C2dEnumerationTerminal(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getNPC().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.NPC__BEHAVIOUR), new String[] {"Friendly", "Friendly", "Neutral", "Neutral", "Hostile", "Hostile", }, nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality.ONE, 0);
	public final static nl.utwente.apc.Code2D.resource.c2d.grammar.C2dSequence C2D_3_0_0_1_0_2 = new nl.utwente.apc.Code2D.resource.c2d.grammar.C2dSequence(nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality.ONE, C2D_3_0_0_1_0_2_0);
	public final static nl.utwente.apc.Code2D.resource.c2d.grammar.C2dChoice C2D_3_0_0_1_0 = new nl.utwente.apc.Code2D.resource.c2d.grammar.C2dChoice(nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality.ONE, C2D_3_0_0_1_0_0, C2D_3_0_0_1_0_1, C2D_3_0_0_1_0_2);
	public final static nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCompound C2D_3_0_0_1 = new nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCompound(C2D_3_0_0_1_0, nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality.STAR);
	public final static nl.utwente.apc.Code2D.resource.c2d.grammar.C2dKeyword C2D_3_0_0_2 = new nl.utwente.apc.Code2D.resource.c2d.grammar.C2dKeyword(";", nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality.ONE);
	public final static nl.utwente.apc.Code2D.resource.c2d.grammar.C2dSequence C2D_3_0_0 = new nl.utwente.apc.Code2D.resource.c2d.grammar.C2dSequence(nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality.ONE, C2D_3_0_0_0, C2D_3_0_0_1, C2D_3_0_0_2);
	public final static nl.utwente.apc.Code2D.resource.c2d.grammar.C2dChoice C2D_3_0 = new nl.utwente.apc.Code2D.resource.c2d.grammar.C2dChoice(nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality.ONE, C2D_3_0_0);
	public final static nl.utwente.apc.Code2D.resource.c2d.grammar.C2dRule C2D_3 = new nl.utwente.apc.Code2D.resource.c2d.grammar.C2dRule(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getNPC(), C2D_3_0, nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality.ONE);
	public final static nl.utwente.apc.Code2D.resource.c2d.grammar.C2dKeyword C2D_4_0_0_0 = new nl.utwente.apc.Code2D.resource.c2d.grammar.C2dKeyword("Item", nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality.ONE);
	public final static nl.utwente.apc.Code2D.resource.c2d.grammar.C2dPlaceholder C2D_4_0_0_1_0_0_0 = new nl.utwente.apc.Code2D.resource.c2d.grammar.C2dPlaceholder(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getItem().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.ITEM__NAME), "QUOTED_34_34", nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality.ONE, 0);
	public final static nl.utwente.apc.Code2D.resource.c2d.grammar.C2dSequence C2D_4_0_0_1_0_0 = new nl.utwente.apc.Code2D.resource.c2d.grammar.C2dSequence(nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality.ONE, C2D_4_0_0_1_0_0_0);
	public final static nl.utwente.apc.Code2D.resource.c2d.grammar.C2dPlaceholder C2D_4_0_0_1_0_1_0 = new nl.utwente.apc.Code2D.resource.c2d.grammar.C2dPlaceholder(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getItem().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.ITEM__TEXTURE), "QUOTED_34_34", nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality.ONE, 0);
	public final static nl.utwente.apc.Code2D.resource.c2d.grammar.C2dSequence C2D_4_0_0_1_0_1 = new nl.utwente.apc.Code2D.resource.c2d.grammar.C2dSequence(nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality.ONE, C2D_4_0_0_1_0_1_0);
	public final static nl.utwente.apc.Code2D.resource.c2d.grammar.C2dChoice C2D_4_0_0_1_0 = new nl.utwente.apc.Code2D.resource.c2d.grammar.C2dChoice(nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality.ONE, C2D_4_0_0_1_0_0, C2D_4_0_0_1_0_1);
	public final static nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCompound C2D_4_0_0_1 = new nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCompound(C2D_4_0_0_1_0, nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality.STAR);
	public final static nl.utwente.apc.Code2D.resource.c2d.grammar.C2dKeyword C2D_4_0_0_2 = new nl.utwente.apc.Code2D.resource.c2d.grammar.C2dKeyword(";", nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality.ONE);
	public final static nl.utwente.apc.Code2D.resource.c2d.grammar.C2dSequence C2D_4_0_0 = new nl.utwente.apc.Code2D.resource.c2d.grammar.C2dSequence(nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality.ONE, C2D_4_0_0_0, C2D_4_0_0_1, C2D_4_0_0_2);
	public final static nl.utwente.apc.Code2D.resource.c2d.grammar.C2dChoice C2D_4_0 = new nl.utwente.apc.Code2D.resource.c2d.grammar.C2dChoice(nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality.ONE, C2D_4_0_0);
	public final static nl.utwente.apc.Code2D.resource.c2d.grammar.C2dRule C2D_4 = new nl.utwente.apc.Code2D.resource.c2d.grammar.C2dRule(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getItem(), C2D_4_0, nl.utwente.apc.Code2D.resource.c2d.grammar.C2dCardinality.ONE);
	
	public static String getSyntaxElementID(nl.utwente.apc.Code2D.resource.c2d.grammar.C2dSyntaxElement syntaxElement) {
		if (syntaxElement == null) {
			// null indicates EOF
			return "<EOF>";
		}
		for (java.lang.reflect.Field field : nl.utwente.apc.Code2D.resource.c2d.grammar.C2dGrammarInformationProvider.class.getFields()) {
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
	
	public static nl.utwente.apc.Code2D.resource.c2d.grammar.C2dSyntaxElement getSyntaxElementByID(String syntaxElementID) {
		try {
			return (nl.utwente.apc.Code2D.resource.c2d.grammar.C2dSyntaxElement) nl.utwente.apc.Code2D.resource.c2d.grammar.C2dGrammarInformationProvider.class.getField(syntaxElementID).get(null);
		} catch (Exception e) {
			return null;
		}
	}
	
	public final static nl.utwente.apc.Code2D.resource.c2d.grammar.C2dRule[] RULES = new nl.utwente.apc.Code2D.resource.c2d.grammar.C2dRule[] {
		C2D_0,
		C2D_1,
		C2D_2,
		C2D_3,
		C2D_4,
	};
	
	/**
	 * Returns all keywords of the grammar. This includes all literals for boolean and
	 * enumeration terminals.
	 */
	public java.util.Set<String> getKeywords() {
		if (this.keywords == null) {
			this.keywords = new java.util.LinkedHashSet<String>();
			for (nl.utwente.apc.Code2D.resource.c2d.grammar.C2dRule rule : RULES) {
				findKeywords(rule, this.keywords);
			}
		}
		return keywords;
	}
	
	/**
	 * Finds all keywords in the given element and its children and adds them to the
	 * set. This includes all literals for boolean and enumeration terminals.
	 */
	private void findKeywords(nl.utwente.apc.Code2D.resource.c2d.grammar.C2dSyntaxElement element, java.util.Set<String> keywords) {
		if (element instanceof nl.utwente.apc.Code2D.resource.c2d.grammar.C2dKeyword) {
			keywords.add(((nl.utwente.apc.Code2D.resource.c2d.grammar.C2dKeyword) element).getValue());
		} else if (element instanceof nl.utwente.apc.Code2D.resource.c2d.grammar.C2dBooleanTerminal) {
			keywords.add(((nl.utwente.apc.Code2D.resource.c2d.grammar.C2dBooleanTerminal) element).getTrueLiteral());
			keywords.add(((nl.utwente.apc.Code2D.resource.c2d.grammar.C2dBooleanTerminal) element).getFalseLiteral());
		} else if (element instanceof nl.utwente.apc.Code2D.resource.c2d.grammar.C2dEnumerationTerminal) {
			nl.utwente.apc.Code2D.resource.c2d.grammar.C2dEnumerationTerminal terminal = (nl.utwente.apc.Code2D.resource.c2d.grammar.C2dEnumerationTerminal) element;
			for (String key : terminal.getLiteralMapping().keySet()) {
				keywords.add(key);
			}
		}
		for (nl.utwente.apc.Code2D.resource.c2d.grammar.C2dSyntaxElement child : element.getChildren()) {
			findKeywords(child, this.keywords);
		}
	}
	
}
