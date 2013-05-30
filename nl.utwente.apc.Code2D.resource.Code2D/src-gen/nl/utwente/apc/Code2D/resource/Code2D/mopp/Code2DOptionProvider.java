/**
 * <copyright>
 * </copyright>
 *
 * 
 */
/**
 * This class can be used to configure options that must be used when resources
 * are loaded. This is similar to using the extension point
 * 'nl.utwente.apc.Code2D.resource.Code2D.default_load_options' with the
 * difference that the options defined in this class are used even if no Eclipse
 * platform is running.
 */
package nl.utwente.apc.Code2D.resource.Code2D.mopp;

public class Code2DOptionProvider implements nl.utwente.apc.Code2D.resource.Code2D.ICode2DOptionProvider {
	
	public java.util.Map<?,?> getOptions() {
		// create a map with static option providers here
		return java.util.Collections.emptyMap();
	}
	
}
