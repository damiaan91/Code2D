/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.Code2D.mopp;

/**
 * A factory for ContextDependentURIFragments. Given a feasible reference
 * resolver, this factory returns a matching fragment that used the resolver to
 * resolver proxy objects.
 * 
 * @param <ContainerType> the type of the class containing the reference to be
 * resolved
 * @param <ReferenceType> the type of the reference to be resolved
 */
public class Code2DContextDependentURIFragmentFactory<ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject>  implements nl.utwente.apc.Code2D.resource.Code2D.ICode2DContextDependentURIFragmentFactory<ContainerType, ReferenceType> {
	
	private final nl.utwente.apc.Code2D.resource.Code2D.ICode2DReferenceResolver<ContainerType, ReferenceType> resolver;
	
	public Code2DContextDependentURIFragmentFactory(nl.utwente.apc.Code2D.resource.Code2D.ICode2DReferenceResolver<ContainerType, ReferenceType> resolver) {
		this.resolver = resolver;
	}
	
	public nl.utwente.apc.Code2D.resource.Code2D.ICode2DContextDependentURIFragment<?> create(String identifier, ContainerType container, org.eclipse.emf.ecore.EReference reference, int positionInReference, org.eclipse.emf.ecore.EObject proxy) {
		
		return new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DContextDependentURIFragment<ContainerType, ReferenceType>(identifier, container, reference, positionInReference, proxy) {
			public nl.utwente.apc.Code2D.resource.Code2D.ICode2DReferenceResolver<ContainerType, ReferenceType> getResolver() {
				return resolver;
			}
		};
	}
}
