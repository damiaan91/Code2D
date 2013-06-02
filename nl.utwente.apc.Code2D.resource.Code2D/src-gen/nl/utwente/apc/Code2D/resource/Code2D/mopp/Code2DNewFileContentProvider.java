/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.Code2D.mopp;

public class Code2DNewFileContentProvider {
	
	public nl.utwente.apc.Code2D.resource.Code2D.ICode2DMetaInformation getMetaInformation() {
		return new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DMetaInformation();
	}
	
	public String getNewFileContent(String newFileName) {
		return getExampleContent(new org.eclipse.emf.ecore.EClass[] {
			nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(),
		}, getMetaInformation().getClassesWithSyntax(), newFileName);
	}
	
	protected String getExampleContent(org.eclipse.emf.ecore.EClass[] startClasses, org.eclipse.emf.ecore.EClass[] allClassesWithSyntax, String newFileName) {
		String content = "";
		for (org.eclipse.emf.ecore.EClass next : startClasses) {
			content = getExampleContent(next, allClassesWithSyntax, newFileName);
			if (content.trim().length() > 0) {
				break;
			}
		}
		return content;
	}
	
	protected String getExampleContent(org.eclipse.emf.ecore.EClass eClass, org.eclipse.emf.ecore.EClass[] allClassesWithSyntax, String newFileName) {
		// create a minimal model
		org.eclipse.emf.ecore.EObject root = new nl.utwente.apc.Code2D.resource.Code2D.util.Code2DMinimalModelHelper().getMinimalModel(eClass, allClassesWithSyntax, newFileName);
		if (root == null) {
			// could not create a minimal model. returning an empty document is the best we
			// can do.
			return "";
		}
		// use printer to get text for model
		java.io.ByteArrayOutputStream buffer = new java.io.ByteArrayOutputStream();
		nl.utwente.apc.Code2D.resource.Code2D.ICode2DTextPrinter printer = getPrinter(buffer);
		try {
			printer.print(root);
		} catch (java.io.IOException e) {
			new nl.utwente.apc.Code2D.resource.Code2D.util.Code2DRuntimeUtil().logError("Exception while generating example content.", e);
		}
		return buffer.toString();
	}
	
	public nl.utwente.apc.Code2D.resource.Code2D.ICode2DTextPrinter getPrinter(java.io.OutputStream outputStream) {
		return getMetaInformation().createPrinter(outputStream, new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DResource());
	}
	
}