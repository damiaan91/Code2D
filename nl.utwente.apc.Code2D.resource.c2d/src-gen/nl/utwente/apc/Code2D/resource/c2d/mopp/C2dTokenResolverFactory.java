/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2d.mopp;

/**
 * The C2dTokenResolverFactory class provides access to all generated token
 * resolvers. By giving the name of a defined token, the corresponding resolve can
 * be obtained. Despite the fact that this class is called TokenResolverFactory is
 * does NOT create new token resolvers whenever a client calls methods to obtain a
 * resolver. Rather, this class maintains a map of all resolvers and creates each
 * resolver at most once.
 */
public class C2dTokenResolverFactory implements nl.utwente.apc.Code2D.resource.c2d.IC2dTokenResolverFactory {
	
	private java.util.Map<String, nl.utwente.apc.Code2D.resource.c2d.IC2dTokenResolver> tokenName2TokenResolver;
	private java.util.Map<String, nl.utwente.apc.Code2D.resource.c2d.IC2dTokenResolver> featureName2CollectInTokenResolver;
	private static nl.utwente.apc.Code2D.resource.c2d.IC2dTokenResolver defaultResolver = new nl.utwente.apc.Code2D.resource.c2d.analysis.C2dDefaultTokenResolver();
	
	public C2dTokenResolverFactory() {
		tokenName2TokenResolver = new java.util.LinkedHashMap<String, nl.utwente.apc.Code2D.resource.c2d.IC2dTokenResolver>();
		featureName2CollectInTokenResolver = new java.util.LinkedHashMap<String, nl.utwente.apc.Code2D.resource.c2d.IC2dTokenResolver>();
		registerTokenResolver("TEXT", new nl.utwente.apc.Code2D.resource.c2d.analysis.C2dTEXTTokenResolver());
		registerTokenResolver("QUOTED_34_34", new nl.utwente.apc.Code2D.resource.c2d.analysis.C2dQUOTED_34_34TokenResolver());
	}
	
	public nl.utwente.apc.Code2D.resource.c2d.IC2dTokenResolver createTokenResolver(String tokenName) {
		return internalCreateResolver(tokenName2TokenResolver, tokenName);
	}
	
	public nl.utwente.apc.Code2D.resource.c2d.IC2dTokenResolver createCollectInTokenResolver(String featureName) {
		return internalCreateResolver(featureName2CollectInTokenResolver, featureName);
	}
	
	protected boolean registerTokenResolver(String tokenName, nl.utwente.apc.Code2D.resource.c2d.IC2dTokenResolver resolver){
		return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);
	}
	
	protected boolean registerCollectInTokenResolver(String featureName, nl.utwente.apc.Code2D.resource.c2d.IC2dTokenResolver resolver){
		return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);
	}
	
	protected nl.utwente.apc.Code2D.resource.c2d.IC2dTokenResolver deRegisterTokenResolver(String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}
	
	private nl.utwente.apc.Code2D.resource.c2d.IC2dTokenResolver internalCreateResolver(java.util.Map<String, nl.utwente.apc.Code2D.resource.c2d.IC2dTokenResolver> resolverMap, String key) {
		if (resolverMap.containsKey(key)){
			return resolverMap.get(key);
		} else {
			return defaultResolver;
		}
	}
	
	private boolean internalRegisterTokenResolver(java.util.Map<String, nl.utwente.apc.Code2D.resource.c2d.IC2dTokenResolver> resolverMap, String key, nl.utwente.apc.Code2D.resource.c2d.IC2dTokenResolver resolver) {
		if (!resolverMap.containsKey(key)) {
			resolverMap.put(key,resolver);
			return true;
		}
		return false;
	}
	
}
