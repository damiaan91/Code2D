/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2.grammar;

/**
 * This class provides the follow sets for all terminals of the grammar. These
 * sets are used during code completion.
 */
public class C2FollowSetProvider {
	
	public final static nl.utwente.apc.Code2D.resource.c2.IC2ExpectedElement TERMINALS[] = new nl.utwente.apc.Code2D.resource.c2.IC2ExpectedElement[9];
	
	public final static org.eclipse.emf.ecore.EStructuralFeature[] FEATURES = new org.eclipse.emf.ecore.EStructuralFeature[1];
	
	public final static nl.utwente.apc.Code2D.resource.c2.mopp.C2ContainedFeature[] LINKS = new nl.utwente.apc.Code2D.resource.c2.mopp.C2ContainedFeature[1];
	
	public final static nl.utwente.apc.Code2D.resource.c2.mopp.C2ContainedFeature[] EMPTY_LINK_ARRAY = new nl.utwente.apc.Code2D.resource.c2.mopp.C2ContainedFeature[0];
	
	public static void initializeTerminals0() {
		TERMINALS[0] = new nl.utwente.apc.Code2D.resource.c2.mopp.C2ExpectedCsString(nl.utwente.apc.Code2D.resource.c2.grammar.C2GrammarInformationProvider.C2_0_0_0_0);
		TERMINALS[1] = new nl.utwente.apc.Code2D.resource.c2.mopp.C2ExpectedStructuralFeature(nl.utwente.apc.Code2D.resource.c2.grammar.C2GrammarInformationProvider.C2_0_0_0_1);
		TERMINALS[2] = new nl.utwente.apc.Code2D.resource.c2.mopp.C2ExpectedCsString(nl.utwente.apc.Code2D.resource.c2.grammar.C2GrammarInformationProvider.C2_0_0_0_2);
		TERMINALS[3] = new nl.utwente.apc.Code2D.resource.c2.mopp.C2ExpectedCsString(nl.utwente.apc.Code2D.resource.c2.grammar.C2GrammarInformationProvider.C2_1_0_0_0);
		TERMINALS[4] = new nl.utwente.apc.Code2D.resource.c2.mopp.C2ExpectedCsString(nl.utwente.apc.Code2D.resource.c2.grammar.C2GrammarInformationProvider.C2_0_0_0_4);
		TERMINALS[5] = new nl.utwente.apc.Code2D.resource.c2.mopp.C2ExpectedCsString(nl.utwente.apc.Code2D.resource.c2.grammar.C2GrammarInformationProvider.C2_1_0_0_1);
		TERMINALS[6] = new nl.utwente.apc.Code2D.resource.c2.mopp.C2ExpectedCsString(nl.utwente.apc.Code2D.resource.c2.grammar.C2GrammarInformationProvider.C2_1_0_0_2);
		TERMINALS[7] = new nl.utwente.apc.Code2D.resource.c2.mopp.C2ExpectedStructuralFeature(nl.utwente.apc.Code2D.resource.c2.grammar.C2GrammarInformationProvider.C2_1_0_0_3);
		TERMINALS[8] = new nl.utwente.apc.Code2D.resource.c2.mopp.C2ExpectedCsString(nl.utwente.apc.Code2D.resource.c2.grammar.C2GrammarInformationProvider.C2_1_0_0_4);
	}
	
	public static void initializeTerminals() {
		initializeTerminals0();
	}
	
	public static void initializeFeatures0() {
		FEATURES[0] = nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.GAME__GAME_WORLD);
	}
	
	public static void initializeFeatures() {
		initializeFeatures0();
	}
	
	public static void initializeLinks0() {
		LINKS[0] = new nl.utwente.apc.Code2D.resource.c2.mopp.C2ContainedFeature(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getWorld(), FEATURES[0]);
	}
	
	public static void initializeLinks() {
		initializeLinks0();
	}
	
	public static void wire0() {
		TERMINALS[0].addFollower(TERMINALS[1], EMPTY_LINK_ARRAY);
		TERMINALS[1].addFollower(TERMINALS[2], EMPTY_LINK_ARRAY);
		TERMINALS[2].addFollower(TERMINALS[3], new nl.utwente.apc.Code2D.resource.c2.mopp.C2ContainedFeature[] {new nl.utwente.apc.Code2D.resource.c2.mopp.C2ContainedFeature(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getWorld(), FEATURES[0]), });
		TERMINALS[3].addFollower(TERMINALS[5], EMPTY_LINK_ARRAY);
		TERMINALS[5].addFollower(TERMINALS[6], EMPTY_LINK_ARRAY);
		TERMINALS[6].addFollower(TERMINALS[7], EMPTY_LINK_ARRAY);
		TERMINALS[7].addFollower(TERMINALS[8], EMPTY_LINK_ARRAY);
		TERMINALS[8].addFollower(TERMINALS[4], EMPTY_LINK_ARRAY);
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
