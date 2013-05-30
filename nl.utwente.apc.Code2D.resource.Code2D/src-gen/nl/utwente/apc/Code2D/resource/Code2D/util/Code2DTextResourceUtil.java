/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.Code2D.util;

/**
 * Class Code2DTextResourceUtil can be used to perform common tasks on text
 * resources, such as loading and saving resources, as well as, checking them for
 * errors. This class is deprecated and has been replaced by
 * nl.utwente.apc.Code2D.resource.Code2D.util.Code2DResourceUtil.
 */
public class Code2DTextResourceUtil {
	
	/**
	 * Use nl.utwente.apc.Code2D.resource.Code2D.util.Code2DResourceUtil.getResource()
	 * instead.
	 */
	@Deprecated	
	public static nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DResource getResource(org.eclipse.core.resources.IFile file) {
		return new nl.utwente.apc.Code2D.resource.Code2D.util.Code2DEclipseProxy().getResource(file);
	}
	
	/**
	 * Use nl.utwente.apc.Code2D.resource.Code2D.util.Code2DResourceUtil.getResource()
	 * instead.
	 */
	@Deprecated	
	public static nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DResource getResource(java.io.File file, java.util.Map<?,?> options) {
		return nl.utwente.apc.Code2D.resource.Code2D.util.Code2DResourceUtil.getResource(file, options);
	}
	
	/**
	 * Use nl.utwente.apc.Code2D.resource.Code2D.util.Code2DResourceUtil.getResource()
	 * instead.
	 */
	@Deprecated	
	public static nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DResource getResource(org.eclipse.emf.common.util.URI uri) {
		return nl.utwente.apc.Code2D.resource.Code2D.util.Code2DResourceUtil.getResource(uri);
	}
	
	/**
	 * Use nl.utwente.apc.Code2D.resource.Code2D.util.Code2DResourceUtil.getResource()
	 * instead.
	 */
	@Deprecated	
	public static nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DResource getResource(org.eclipse.emf.common.util.URI uri, java.util.Map<?,?> options) {
		return nl.utwente.apc.Code2D.resource.Code2D.util.Code2DResourceUtil.getResource(uri, options);
	}
	
}
