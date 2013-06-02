/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2d.mopp;

public class C2dReferenceResolverSwitch implements nl.utwente.apc.Code2D.resource.c2d.IC2dReferenceResolverSwitch {
	
	/**
	 * This map stores a copy of the options the were set for loading the resource.
	 */
	private java.util.Map<Object, Object> options;
	
	
	public void setOptions(java.util.Map<?, ?> options) {
		if (options != null) {
			this.options = new java.util.LinkedHashMap<Object, Object>();
			this.options.putAll(options);
		}
	}
	
	public void resolveFuzzy(String identifier, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, int position, nl.utwente.apc.Code2D.resource.c2d.IC2dReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
		if (container == null) {
			return;
		}
	}
	
	public nl.utwente.apc.Code2D.resource.c2d.IC2dReferenceResolver<? extends org.eclipse.emf.ecore.EObject, ? extends org.eclipse.emf.ecore.EObject> getResolver(org.eclipse.emf.ecore.EStructuralFeature reference) {
		return null;
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})	
	public <ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> nl.utwente.apc.Code2D.resource.c2d.IC2dReferenceResolver<ContainerType, ReferenceType> getResolverChain(org.eclipse.emf.ecore.EStructuralFeature reference, nl.utwente.apc.Code2D.resource.c2d.IC2dReferenceResolver<ContainerType, ReferenceType> originalResolver) {
		if (options == null) {
			return originalResolver;
		}
		Object value = options.get(nl.utwente.apc.Code2D.resource.c2d.IC2dOptions.ADDITIONAL_REFERENCE_RESOLVERS);
		if (value == null) {
			return originalResolver;
		}
		if (!(value instanceof java.util.Map)) {
			// send this to the error log
			new nl.utwente.apc.Code2D.resource.c2d.util.C2dRuntimeUtil().logWarning("Found value with invalid type for option " + nl.utwente.apc.Code2D.resource.c2d.IC2dOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + java.util.Map.class.getName() + ", but was " + value.getClass().getName() + ")", null);
			return originalResolver;
		}
		java.util.Map<?,?> resolverMap = (java.util.Map<?,?>) value;
		Object resolverValue = resolverMap.get(reference);
		if (resolverValue == null) {
			return originalResolver;
		}
		if (resolverValue instanceof nl.utwente.apc.Code2D.resource.c2d.IC2dReferenceResolver) {
			nl.utwente.apc.Code2D.resource.c2d.IC2dReferenceResolver replacingResolver = (nl.utwente.apc.Code2D.resource.c2d.IC2dReferenceResolver) resolverValue;
			if (replacingResolver instanceof nl.utwente.apc.Code2D.resource.c2d.IC2dDelegatingReferenceResolver) {
				// pass original resolver to the replacing one
				((nl.utwente.apc.Code2D.resource.c2d.IC2dDelegatingReferenceResolver) replacingResolver).setDelegate(originalResolver);
			}
			return replacingResolver;
		} else if (resolverValue instanceof java.util.Collection) {
			java.util.Collection replacingResolvers = (java.util.Collection) resolverValue;
			nl.utwente.apc.Code2D.resource.c2d.IC2dReferenceResolver replacingResolver = originalResolver;
			for (Object next : replacingResolvers) {
				if (next instanceof nl.utwente.apc.Code2D.resource.c2d.IC2dReferenceCache) {
					nl.utwente.apc.Code2D.resource.c2d.IC2dReferenceResolver nextResolver = (nl.utwente.apc.Code2D.resource.c2d.IC2dReferenceResolver) next;
					if (nextResolver instanceof nl.utwente.apc.Code2D.resource.c2d.IC2dDelegatingReferenceResolver) {
						// pass original resolver to the replacing one
						((nl.utwente.apc.Code2D.resource.c2d.IC2dDelegatingReferenceResolver) nextResolver).setDelegate(replacingResolver);
					}
					replacingResolver = nextResolver;
				} else {
					// The collection contains a non-resolver. Send a warning to the error log.
					new nl.utwente.apc.Code2D.resource.c2d.util.C2dRuntimeUtil().logWarning("Found value with invalid type in value map for option " + nl.utwente.apc.Code2D.resource.c2d.IC2dOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + nl.utwente.apc.Code2D.resource.c2d.IC2dDelegatingReferenceResolver.class.getName() + ", but was " + next.getClass().getName() + ")", null);
				}
			}
			return replacingResolver;
		} else {
			// The value for the option ADDITIONAL_REFERENCE_RESOLVERS has an unknown type.
			new nl.utwente.apc.Code2D.resource.c2d.util.C2dRuntimeUtil().logWarning("Found value with invalid type in value map for option " + nl.utwente.apc.Code2D.resource.c2d.IC2dOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + nl.utwente.apc.Code2D.resource.c2d.IC2dDelegatingReferenceResolver.class.getName() + ", but was " + resolverValue.getClass().getName() + ")", null);
			return originalResolver;
		}
	}
	
}
