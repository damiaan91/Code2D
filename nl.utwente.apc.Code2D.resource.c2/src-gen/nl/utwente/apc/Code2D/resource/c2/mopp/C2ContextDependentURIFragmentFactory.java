/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2.mopp;

/**
 * A factory for ContextDependentURIFragments. Given a feasible reference
 * resolver, this factory returns a matching fragment that used the resolver to
 * resolver proxy objects.
 * 
 * @param <ContainerType> the type of the class containing the reference to be
 * resolved
 * @param <ReferenceType> the type of the reference to be resolved
 */
public class C2ContextDependentURIFragmentFactory<ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject>  implements nl.utwente.apc.Code2D.resource.c2.IC2ContextDependentURIFragmentFactory<ContainerType, ReferenceType> {
	
	private final nl.utwente.apc.Code2D.resource.c2.IC2ReferenceResolver<ContainerType, ReferenceType> resolver;
	
	public C2ContextDependentURIFragmentFactory(nl.utwente.apc.Code2D.resource.c2.IC2ReferenceResolver<ContainerType, ReferenceType> resolver) {
		this.resolver = resolver;
	}
	
	public nl.utwente.apc.Code2D.resource.c2.IC2ContextDependentURIFragment<?> create(String identifier, ContainerType container, org.eclipse.emf.ecore.EReference reference, int positionInReference, org.eclipse.emf.ecore.EObject proxy) {
		
		return new nl.utwente.apc.Code2D.resource.c2.mopp.C2ContextDependentURIFragment<ContainerType, ReferenceType>(identifier, container, reference, positionInReference, proxy) {
			public nl.utwente.apc.Code2D.resource.c2.IC2ReferenceResolver<ContainerType, ReferenceType> getResolver() {
				return resolver;
			}
		};
	}
}
