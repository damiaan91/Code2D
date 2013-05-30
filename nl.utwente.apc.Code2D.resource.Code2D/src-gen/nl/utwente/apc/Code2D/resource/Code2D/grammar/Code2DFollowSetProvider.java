/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.Code2D.grammar;

/**
 * This class provides the follow sets for all terminals of the grammar. These
 * sets are used during code completion.
 */
public class Code2DFollowSetProvider {
	
	public final static nl.utwente.apc.Code2D.resource.Code2D.ICode2DExpectedElement TERMINALS[] = new nl.utwente.apc.Code2D.resource.Code2D.ICode2DExpectedElement[3];
	
	public final static org.eclipse.emf.ecore.EStructuralFeature[] FEATURES = new org.eclipse.emf.ecore.EStructuralFeature[0];
	
	public final static nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DContainedFeature[] LINKS = new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DContainedFeature[0];
	
	public final static nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DContainedFeature[] EMPTY_LINK_ARRAY = new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DContainedFeature[0];
	
	public static void initializeTerminals0() {
		TERMINALS[0] = new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectedCsString(nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_0_0_0_0);
		TERMINALS[1] = new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectedStructuralFeature(nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_0_0_0_1_0_0_0);
		TERMINALS[2] = new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectedCsString(nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_0_0_0_2);
	}
	
	public static void initializeTerminals() {
		initializeTerminals0();
	}
	
	public static void initializeFeatures() {
	}
	
	public static void initializeLinks() {
	}
	
	public static void wire0() {
		TERMINALS[0].addFollower(TERMINALS[1], EMPTY_LINK_ARRAY);
		TERMINALS[0].addFollower(TERMINALS[2], EMPTY_LINK_ARRAY);
		TERMINALS[1].addFollower(TERMINALS[1], EMPTY_LINK_ARRAY);
		TERMINALS[1].addFollower(TERMINALS[2], EMPTY_LINK_ARRAY);
	}
	
	public static void wire() {
		wire0();
	}
	
	static {
		// initialize the arrays
		initializeTerminals();
		initializeFeatures();
		initializeLinks();
		// wire the terminals
		wire();
	}
}
