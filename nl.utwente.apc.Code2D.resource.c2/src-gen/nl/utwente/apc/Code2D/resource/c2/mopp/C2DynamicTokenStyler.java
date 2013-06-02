/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2.mopp;

public class C2DynamicTokenStyler {
	
	/**
	 * This method is called to dynamically style tokens.
	 * 
	 * @param resource the TextResource that contains the token
	 * @param token the token to obtain a style for
	 * @param staticStyle the token style as set in the editor preferences (is
	 * <code>null</code> if syntax highlighting for the token is disabled)
	 */
	public nl.utwente.apc.Code2D.resource.c2.IC2TokenStyle getDynamicTokenStyle(nl.utwente.apc.Code2D.resource.c2.IC2TextResource resource, nl.utwente.apc.Code2D.resource.c2.IC2TextToken token, nl.utwente.apc.Code2D.resource.c2.IC2TokenStyle staticStyle) {
		// The default implementation returns the static style without any changes. To
		// implement dynamic token styling, set the overrideDynamicTokenStyler option to
		// <code>false</code> and customize this method.
		return staticStyle;
	}
	
}
