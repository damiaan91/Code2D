/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.Code2D.mopp;

/**
 * The Code2DTokenResolverFactory class provides access to all generated token
 * resolvers. By giving the name of a defined token, the corresponding resolve can
 * be obtained. Despite the fact that this class is called TokenResolverFactory is
 * does NOT create new token resolvers whenever a client calls methods to obtain a
 * resolver. Rather, this class maintains a map of all resolvers and creates each
 * resolver at most once.
 */
public class Code2DTokenResolverFactory implements nl.utwente.apc.Code2D.resource.Code2D.ICode2DTokenResolverFactory {
	
	private java.util.Map<String, nl.utwente.apc.Code2D.resource.Code2D.ICode2DTokenResolver> tokenName2TokenResolver;
	private java.util.Map<String, nl.utwente.apc.Code2D.resource.Code2D.ICode2DTokenResolver> featureName2CollectInTokenResolver;
	private static nl.utwente.apc.Code2D.resource.Code2D.ICode2DTokenResolver defaultResolver = new nl.utwente.apc.Code2D.resource.Code2D.analysis.Code2DDefaultTokenResolver();
	
	public Code2DTokenResolverFactory() {
		tokenName2TokenResolver = new java.util.LinkedHashMap<String, nl.utwente.apc.Code2D.resource.Code2D.ICode2DTokenResolver>();
		featureName2CollectInTokenResolver = new java.util.LinkedHashMap<String, nl.utwente.apc.Code2D.resource.Code2D.ICode2DTokenResolver>();
		registerTokenResolver("TEXT", new nl.utwente.apc.Code2D.resource.Code2D.analysis.Code2DTEXTTokenResolver());
		registerTokenResolver("QUOTED_34_34", new nl.utwente.apc.Code2D.resource.Code2D.analysis.Code2DQUOTED_34_34TokenResolver());
	}
	
	public nl.utwente.apc.Code2D.resource.Code2D.ICode2DTokenResolver createTokenResolver(String tokenName) {
		return internalCreateResolver(tokenName2TokenResolver, tokenName);
	}
	
	public nl.utwente.apc.Code2D.resource.Code2D.ICode2DTokenResolver createCollectInTokenResolver(String featureName) {
		return internalCreateResolver(featureName2CollectInTokenResolver, featureName);
	}
	
	protected boolean registerTokenResolver(String tokenName, nl.utwente.apc.Code2D.resource.Code2D.ICode2DTokenResolver resolver){
		return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);
	}
	
	protected boolean registerCollectInTokenResolver(String featureName, nl.utwente.apc.Code2D.resource.Code2D.ICode2DTokenResolver resolver){
		return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);
	}
	
	protected nl.utwente.apc.Code2D.resource.Code2D.ICode2DTokenResolver deRegisterTokenResolver(String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}
	
	private nl.utwente.apc.Code2D.resource.Code2D.ICode2DTokenResolver internalCreateResolver(java.util.Map<String, nl.utwente.apc.Code2D.resource.Code2D.ICode2DTokenResolver> resolverMap, String key) {
		if (resolverMap.containsKey(key)){
			return resolverMap.get(key);
		} else {
			return defaultResolver;
		}
	}
	
	private boolean internalRegisterTokenResolver(java.util.Map<String, nl.utwente.apc.Code2D.resource.Code2D.ICode2DTokenResolver> resolverMap, String key, nl.utwente.apc.Code2D.resource.Code2D.ICode2DTokenResolver resolver) {
		if (!resolverMap.containsKey(key)) {
			resolverMap.put(key,resolver);
			return true;
		}
		return false;
	}
	
}
