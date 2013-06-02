/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2.ui;

public class C2AnnotationModel extends org.eclipse.ui.texteditor.ResourceMarkerAnnotationModel {
	
	public C2AnnotationModel(org.eclipse.core.resources.IResource resource) {
		super(resource);
	}
	
	protected org.eclipse.ui.texteditor.MarkerAnnotation createMarkerAnnotation(org.eclipse.core.resources.IMarker marker) {
		return new nl.utwente.apc.Code2D.resource.c2.ui.C2MarkerAnnotation(marker);
	}
	
}
