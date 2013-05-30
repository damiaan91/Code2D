/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.Code2D;

/**
 * A delegating reference resolver is an extension of a normal reference resolver
 * that can be configured with another resolver that it may delegate method calls
 * to. This interface can be implemented by additional resolvers to customize
 * resolving using the load option ADDITIONAL_REFERENCE_RESOLVERS.
 * 
 * @see nl.utwente.apc.Code2D.resource.Code2D.ICode2DOptions
 */
public interface ICode2DDelegatingReferenceResolver<ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> extends nl.utwente.apc.Code2D.resource.Code2D.ICode2DReferenceResolver<ContainerType, ReferenceType> {
	
	/**
	 * Sets the delegate for this resolver.
	 */
	public void setDelegate(nl.utwente.apc.Code2D.resource.Code2D.ICode2DReferenceResolver<ContainerType, ReferenceType> delegate);
	
}
