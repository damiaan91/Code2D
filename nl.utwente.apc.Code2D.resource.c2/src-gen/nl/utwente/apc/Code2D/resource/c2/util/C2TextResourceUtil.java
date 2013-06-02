/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2.util;

/**
 * Class C2TextResourceUtil can be used to perform common tasks on text resources,
 * such as loading and saving resources, as well as, checking them for errors.
 * This class is deprecated and has been replaced by
 * nl.utwente.apc.Code2D.resource.c2.util.C2ResourceUtil.
 */
public class C2TextResourceUtil {
	
	/**
	 * Use nl.utwente.apc.Code2D.resource.c2.util.C2ResourceUtil.getResource() instead.
	 */
	@Deprecated	
	public static nl.utwente.apc.Code2D.resource.c2.mopp.C2Resource getResource(org.eclipse.core.resources.IFile file) {
		return new nl.utwente.apc.Code2D.resource.c2.util.C2EclipseProxy().getResource(file);
	}
	
	/**
	 * Use nl.utwente.apc.Code2D.resource.c2.util.C2ResourceUtil.getResource() instead.
	 */
	@Deprecated	
	public static nl.utwente.apc.Code2D.resource.c2.mopp.C2Resource getResource(java.io.File file, java.util.Map<?,?> options) {
		return nl.utwente.apc.Code2D.resource.c2.util.C2ResourceUtil.getResource(file, options);
	}
	
	/**
	 * Use nl.utwente.apc.Code2D.resource.c2.util.C2ResourceUtil.getResource() instead.
	 */
	@Deprecated	
	public static nl.utwente.apc.Code2D.resource.c2.mopp.C2Resource getResource(org.eclipse.emf.common.util.URI uri) {
		return nl.utwente.apc.Code2D.resource.c2.util.C2ResourceUtil.getResource(uri);
	}
	
	/**
	 * Use nl.utwente.apc.Code2D.resource.c2.util.C2ResourceUtil.getResource() instead.
	 */
	@Deprecated	
	public static nl.utwente.apc.Code2D.resource.c2.mopp.C2Resource getResource(org.eclipse.emf.common.util.URI uri, java.util.Map<?,?> options) {
		return nl.utwente.apc.Code2D.resource.c2.util.C2ResourceUtil.getResource(uri, options);
	}
	
}
