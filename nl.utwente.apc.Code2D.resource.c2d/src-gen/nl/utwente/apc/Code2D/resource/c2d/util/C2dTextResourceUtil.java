/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2d.util;

/**
 * Class C2dTextResourceUtil can be used to perform common tasks on text
 * resources, such as loading and saving resources, as well as, checking them for
 * errors. This class is deprecated and has been replaced by
 * nl.utwente.apc.Code2D.resource.c2d.util.C2dResourceUtil.
 */
public class C2dTextResourceUtil {
	
	/**
	 * Use nl.utwente.apc.Code2D.resource.c2d.util.C2dResourceUtil.getResource()
	 * instead.
	 */
	@Deprecated	
	public static nl.utwente.apc.Code2D.resource.c2d.mopp.C2dResource getResource(org.eclipse.core.resources.IFile file) {
		return new nl.utwente.apc.Code2D.resource.c2d.util.C2dEclipseProxy().getResource(file);
	}
	
	/**
	 * Use nl.utwente.apc.Code2D.resource.c2d.util.C2dResourceUtil.getResource()
	 * instead.
	 */
	@Deprecated	
	public static nl.utwente.apc.Code2D.resource.c2d.mopp.C2dResource getResource(java.io.File file, java.util.Map<?,?> options) {
		return nl.utwente.apc.Code2D.resource.c2d.util.C2dResourceUtil.getResource(file, options);
	}
	
	/**
	 * Use nl.utwente.apc.Code2D.resource.c2d.util.C2dResourceUtil.getResource()
	 * instead.
	 */
	@Deprecated	
	public static nl.utwente.apc.Code2D.resource.c2d.mopp.C2dResource getResource(org.eclipse.emf.common.util.URI uri) {
		return nl.utwente.apc.Code2D.resource.c2d.util.C2dResourceUtil.getResource(uri);
	}
	
	/**
	 * Use nl.utwente.apc.Code2D.resource.c2d.util.C2dResourceUtil.getResource()
	 * instead.
	 */
	@Deprecated	
	public static nl.utwente.apc.Code2D.resource.c2d.mopp.C2dResource getResource(org.eclipse.emf.common.util.URI uri, java.util.Map<?,?> options) {
		return nl.utwente.apc.Code2D.resource.c2d.util.C2dResourceUtil.getResource(uri, options);
	}
	
}
