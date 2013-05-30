/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.Code2D;

/**
 * Implementors of this interface can provide a post-processor for text resources.
 */
public interface ICode2DResourcePostProcessorProvider {
	
	/**
	 * Returns the processor that shall be called after text resource are successfully
	 * parsed.
	 */
	public nl.utwente.apc.Code2D.resource.Code2D.ICode2DResourcePostProcessor getResourcePostProcessor();
	
}
