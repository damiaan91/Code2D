/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2d.mopp;

/**
 * A factory for ContextDependentURIFragments. Given a feasible reference
 * resolver, this factory returns a matching fragment that used the resolver to
 * resolver proxy objects.
 * 
 * @param <ContainerType> the type of the class containing the reference to be
 * resolved
 * @param <ReferenceType> the type of the reference to be resolved
 */
public class C2dContextDependentURIFragmentFactory<ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject>  implements nl.utwente.apc.Code2D.resource.c2d.IC2dContextDependentURIFragmentFactory<ContainerType, ReferenceType> {
	
	private final nl.utwente.apc.Code2D.resource.c2d.IC2dReferenceResolver<ContainerType, ReferenceType> resolver;
	
	public C2dContextDependentURIFragmentFactory(nl.utwente.apc.Code2D.resource.c2d.IC2dReferenceResolver<ContainerType, ReferenceType> resolver) {
		this.resolver = resolver;
	}
	
	public nl.utwente.apc.Code2D.resource.c2d.IC2dContextDependentURIFragment<?> create(String identifier, ContainerType container, org.eclipse.emf.ecore.EReference reference, int positionInReference, org.eclipse.emf.ecore.EObject proxy) {
		
		return new nl.utwente.apc.Code2D.resource.c2d.mopp.C2dContextDependentURIFragment<ContainerType, ReferenceType>(identifier, container, reference, positionInReference, proxy) {
			public nl.utwente.apc.Code2D.resource.c2d.IC2dReferenceResolver<ContainerType, ReferenceType> getResolver() {
				return resolver;
			}
		};
	}
}
