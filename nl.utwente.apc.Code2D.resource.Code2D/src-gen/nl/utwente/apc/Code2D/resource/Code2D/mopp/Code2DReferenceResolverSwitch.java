/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.Code2D.mopp;

public class Code2DReferenceResolverSwitch implements nl.utwente.apc.Code2D.resource.Code2D.ICode2DReferenceResolverSwitch {
	
	/**
	 * This map stores a copy of the options the were set for loading the resource.
	 */
	private java.util.Map<Object, Object> options;
	
	protected nl.utwente.apc.Code2D.resource.Code2D.analysis.NPCExtendsReferenceResolver nPCExtendsReferenceResolver = new nl.utwente.apc.Code2D.resource.Code2D.analysis.NPCExtendsReferenceResolver();
	
	public nl.utwente.apc.Code2D.resource.Code2D.ICode2DReferenceResolver<nl.utwente.apc.Code2D.NPC, nl.utwente.apc.Code2D.NPC> getNPCExtendsReferenceResolver() {
		return getResolverChain(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getNPC_Extends(), nPCExtendsReferenceResolver);
	}
	
	public void setOptions(java.util.Map<?, ?> options) {
		if (options != null) {
			this.options = new java.util.LinkedHashMap<Object, Object>();
			this.options.putAll(options);
		}
		nPCExtendsReferenceResolver.setOptions(options);
	}
	
	public void resolveFuzzy(String identifier, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, int position, nl.utwente.apc.Code2D.resource.Code2D.ICode2DReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
		if (container == null) {
			return;
		}
		if (nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getNPC().isInstance(container)) {
			Code2DFuzzyResolveResult<nl.utwente.apc.Code2D.NPC> frr = new Code2DFuzzyResolveResult<nl.utwente.apc.Code2D.NPC>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("Extends")) {
				nPCExtendsReferenceResolver.resolve(identifier, (nl.utwente.apc.Code2D.NPC) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
	}
	
	public nl.utwente.apc.Code2D.resource.Code2D.ICode2DReferenceResolver<? extends org.eclipse.emf.ecore.EObject, ? extends org.eclipse.emf.ecore.EObject> getResolver(org.eclipse.emf.ecore.EStructuralFeature reference) {
		if (reference == nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getNPC_Extends()) {
			return getResolverChain(reference, nPCExtendsReferenceResolver);
		}
		return null;
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})	
	public <ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> nl.utwente.apc.Code2D.resource.Code2D.ICode2DReferenceResolver<ContainerType, ReferenceType> getResolverChain(org.eclipse.emf.ecore.EStructuralFeature reference, nl.utwente.apc.Code2D.resource.Code2D.ICode2DReferenceResolver<ContainerType, ReferenceType> originalResolver) {
		if (options == null) {
			return originalResolver;
		}
		Object value = options.get(nl.utwente.apc.Code2D.resource.Code2D.ICode2DOptions.ADDITIONAL_REFERENCE_RESOLVERS);
		if (value == null) {
			return originalResolver;
		}
		if (!(value instanceof java.util.Map)) {
			// send this to the error log
			new nl.utwente.apc.Code2D.resource.Code2D.util.Code2DRuntimeUtil().logWarning("Found value with invalid type for option " + nl.utwente.apc.Code2D.resource.Code2D.ICode2DOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + java.util.Map.class.getName() + ", but was " + value.getClass().getName() + ")", null);
			return originalResolver;
		}
		java.util.Map<?,?> resolverMap = (java.util.Map<?,?>) value;
		Object resolverValue = resolverMap.get(reference);
		if (resolverValue == null) {
			return originalResolver;
		}
		if (resolverValue instanceof nl.utwente.apc.Code2D.resource.Code2D.ICode2DReferenceResolver) {
			nl.utwente.apc.Code2D.resource.Code2D.ICode2DReferenceResolver replacingResolver = (nl.utwente.apc.Code2D.resource.Code2D.ICode2DReferenceResolver) resolverValue;
			if (replacingResolver instanceof nl.utwente.apc.Code2D.resource.Code2D.ICode2DDelegatingReferenceResolver) {
				// pass original resolver to the replacing one
				((nl.utwente.apc.Code2D.resource.Code2D.ICode2DDelegatingReferenceResolver) replacingResolver).setDelegate(originalResolver);
			}
			return replacingResolver;
		} else if (resolverValue instanceof java.util.Collection) {
			java.util.Collection replacingResolvers = (java.util.Collection) resolverValue;
			nl.utwente.apc.Code2D.resource.Code2D.ICode2DReferenceResolver replacingResolver = originalResolver;
			for (Object next : replacingResolvers) {
				if (next instanceof nl.utwente.apc.Code2D.resource.Code2D.ICode2DReferenceCache) {
					nl.utwente.apc.Code2D.resource.Code2D.ICode2DReferenceResolver nextResolver = (nl.utwente.apc.Code2D.resource.Code2D.ICode2DReferenceResolver) next;
					if (nextResolver instanceof nl.utwente.apc.Code2D.resource.Code2D.ICode2DDelegatingReferenceResolver) {
						// pass original resolver to the replacing one
						((nl.utwente.apc.Code2D.resource.Code2D.ICode2DDelegatingReferenceResolver) nextResolver).setDelegate(replacingResolver);
					}
					replacingResolver = nextResolver;
				} else {
					// The collection contains a non-resolver. Send a warning to the error log.
					new nl.utwente.apc.Code2D.resource.Code2D.util.Code2DRuntimeUtil().logWarning("Found value with invalid type in value map for option " + nl.utwente.apc.Code2D.resource.Code2D.ICode2DOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + nl.utwente.apc.Code2D.resource.Code2D.ICode2DDelegatingReferenceResolver.class.getName() + ", but was " + next.getClass().getName() + ")", null);
				}
			}
			return replacingResolver;
		} else {
			// The value for the option ADDITIONAL_REFERENCE_RESOLVERS has an unknown type.
			new nl.utwente.apc.Code2D.resource.Code2D.util.Code2DRuntimeUtil().logWarning("Found value with invalid type in value map for option " + nl.utwente.apc.Code2D.resource.Code2D.ICode2DOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + nl.utwente.apc.Code2D.resource.Code2D.ICode2DDelegatingReferenceResolver.class.getName() + ", but was " + resolverValue.getClass().getName() + ")", null);
			return originalResolver;
		}
	}
	
}
