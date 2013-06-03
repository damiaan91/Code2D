/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.Code2D.mopp;

public class Code2DSyntaxCoverageInformationProvider {
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.eclipse.emf.ecore.EClass[] {
			nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(),
			nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getPlayer(),
			nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getNPC(),
			nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getItem(),
			nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getWorld(),
			nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getTerrain(),
			nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getTrap(),
			nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getScenery(),
		};
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new org.eclipse.emf.ecore.EClass[] {
			nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(),
		};
	}
	
}
