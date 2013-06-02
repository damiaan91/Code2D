/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2d;

/**
 * Implementors of this interface can provide a post-processor for text resources.
 */
public interface IC2dResourcePostProcessorProvider {
	
	/**
	 * Returns the processor that shall be called after text resource are successfully
	 * parsed.
	 */
	public nl.utwente.apc.Code2D.resource.c2d.IC2dResourcePostProcessor getResourcePostProcessor();
	
}
