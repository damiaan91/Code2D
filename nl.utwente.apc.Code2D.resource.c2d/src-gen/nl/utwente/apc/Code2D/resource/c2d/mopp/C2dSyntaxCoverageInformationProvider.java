/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2d.mopp;

public class C2dSyntaxCoverageInformationProvider {
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.eclipse.emf.ecore.EClass[] {
			nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(),
			nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getWorld(),
			nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getPlayer(),
			nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getNPC(),
			nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getItem(),
		};
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new org.eclipse.emf.ecore.EClass[] {
			nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(),
			nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getPlayer(),
			nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getNPC(),
			nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getItem(),
		};
	}
	
}
