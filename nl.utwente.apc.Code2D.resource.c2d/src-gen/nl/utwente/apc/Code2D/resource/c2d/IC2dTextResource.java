/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2d;

/**
 * An extended resource that can hold information about the exact positions of
 * each element of its content in a text file. This can be used to give more
 * detailed error feedback.
 */
public interface IC2dTextResource extends org.eclipse.emf.ecore.resource.Resource, nl.utwente.apc.Code2D.resource.c2d.IC2dTextResourcePluginPart {
	
	/**
	 * Returns the raw contents of this resource. This method must be used by
	 * generated classes only. It is not intended to be used by clients.
	 */
	public org.eclipse.emf.common.util.EList<org.eclipse.emf.ecore.EObject> getContentsInternal();
	
	/**
	 * Try to load the content of this resource from the given stream. If loading
	 * fails, the state of this resource is kept. If loading is successful, the
	 * content of this resource is replaced with the new content.
	 * This method can be used to try loading erroneous files, as e.g., needed during
	 * background parsing in the editor.
	 * 
	 * @param stream the stream to read from
	 * @param options the load options to use
	 * 
	 * @throws java.io.IOException thrown if the stream can not be read
	 */
	public void reload(java.io.InputStream stream, java.util.Map<?,?> options) throws java.io.IOException;
	
	/**
	 * Returns a map containing information about the location of model elements in
	 * the text.
	 * 
	 * @return the model element to text location mapping
	 */
	public nl.utwente.apc.Code2D.resource.c2d.IC2dLocationMap getLocationMap();
	
	/**
	 * Adds an error that should be displayed at the position of the given element.
	 */
	public void addProblem(nl.utwente.apc.Code2D.resource.c2d.IC2dProblem problem, org.eclipse.emf.ecore.EObject element);
	
	/**
	 * Adds an error to be displayed at the indicated position.
	 */
	public void addProblem(nl.utwente.apc.Code2D.resource.c2d.IC2dProblem problem, int column, int line, int charStart, int charEnd);
	
	/**
	 * Internal method used by the parser to register a context dependent proxy object
	 * for later resolution.
	 * 
	 * @param container
	 * @param reference
	 * @param position
	 * @param id
	 * @param proxyElement
	 */
	public <ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> void registerContextDependentProxy(nl.utwente.apc.Code2D.resource.c2d.IC2dContextDependentURIFragmentFactory<ContainerType, ReferenceType> factory, ContainerType container, org.eclipse.emf.ecore.EReference reference, String id, org.eclipse.emf.ecore.EObject proxyElement, int position);
	
	@Deprecated	
	public void addWarning(String message, org.eclipse.emf.ecore.EObject cause);
	
	/**
	 * Attaches a warning with the given message to object 'cause'.
	 */
	public void addWarning(String message, nl.utwente.apc.Code2D.resource.c2d.C2dEProblemType type, org.eclipse.emf.ecore.EObject cause);
	
	@Deprecated	
	public void addError(String message, org.eclipse.emf.ecore.EObject cause);
	
	/**
	 * Attaches an error with the given message to object 'cause'.
	 */
	public void addError(String message, nl.utwente.apc.Code2D.resource.c2d.C2dEProblemType type, org.eclipse.emf.ecore.EObject cause);
	
	/**
	 * Returns the quick fix for the given context. This method is used by the
	 * MarkerResolutionGenerator to retrieve fixes for problem that are associated
	 * with this resource.
	 */
	public nl.utwente.apc.Code2D.resource.c2d.IC2dQuickFix getQuickFix(String quickFixContext);
	
}
