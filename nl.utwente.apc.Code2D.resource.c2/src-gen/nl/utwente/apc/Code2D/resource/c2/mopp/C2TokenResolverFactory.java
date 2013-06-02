/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2.mopp;

/**
 * The C2TokenResolverFactory class provides access to all generated token
 * resolvers. By giving the name of a defined token, the corresponding resolve can
 * be obtained. Despite the fact that this class is called TokenResolverFactory is
 * does NOT create new token resolvers whenever a client calls methods to obtain a
 * resolver. Rather, this class maintains a map of all resolvers and creates each
 * resolver at most once.
 */
public class C2TokenResolverFactory implements nl.utwente.apc.Code2D.resource.c2.IC2TokenResolverFactory {
	
	private java.util.Map<String, nl.utwente.apc.Code2D.resource.c2.IC2TokenResolver> tokenName2TokenResolver;
	private java.util.Map<String, nl.utwente.apc.Code2D.resource.c2.IC2TokenResolver> featureName2CollectInTokenResolver;
	private static nl.utwente.apc.Code2D.resource.c2.IC2TokenResolver defaultResolver = new nl.utwente.apc.Code2D.resource.c2.analysis.C2DefaultTokenResolver();
	
	public C2TokenResolverFactory() {
		tokenName2TokenResolver = new java.util.LinkedHashMap<String, nl.utwente.apc.Code2D.resource.c2.IC2TokenResolver>();
		featureName2CollectInTokenResolver = new java.util.LinkedHashMap<String, nl.utwente.apc.Code2D.resource.c2.IC2TokenResolver>();
		registerTokenResolver("TEXT", new nl.utwente.apc.Code2D.resource.c2.analysis.C2TEXTTokenResolver());
	}
	
	public nl.utwente.apc.Code2D.resource.c2.IC2TokenResolver createTokenResolver(String tokenName) {
		return internalCreateResolver(tokenName2TokenResolver, tokenName);
	}
	
	public nl.utwente.apc.Code2D.resource.c2.IC2TokenResolver createCollectInTokenResolver(String featureName) {
		return internalCreateResolver(featureName2CollectInTokenResolver, featureName);
	}
	
	protected boolean registerTokenResolver(String tokenName, nl.utwente.apc.Code2D.resource.c2.IC2TokenResolver resolver){
		return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);
	}
	
	protected boolean registerCollectInTokenResolver(String featureName, nl.utwente.apc.Code2D.resource.c2.IC2TokenResolver resolver){
		return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);
	}
	
	protected nl.utwente.apc.Code2D.resource.c2.IC2TokenResolver deRegisterTokenResolver(String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}
	
	private nl.utwente.apc.Code2D.resource.c2.IC2TokenResolver internalCreateResolver(java.util.Map<String, nl.utwente.apc.Code2D.resource.c2.IC2TokenResolver> resolverMap, String key) {
		if (resolverMap.containsKey(key)){
			return resolverMap.get(key);
		} else {
			return defaultResolver;
		}
	}
	
	private boolean internalRegisterTokenResolver(java.util.Map<String, nl.utwente.apc.Code2D.resource.c2.IC2TokenResolver> resolverMap, String key, nl.utwente.apc.Code2D.resource.c2.IC2TokenResolver resolver) {
		if (!resolverMap.containsKey(key)) {
			resolverMap.put(key,resolver);
			return true;
		}
		return false;
	}
	
}
