/**
 * <copyright>
 * </copyright>
 *
 * 
 */
/**
 * This class can be used to configure options that must be used when resources
 * are loaded. This is similar to using the extension point
 * 'nl.utwente.apc.Code2D.resource.c2d.default_load_options' with the difference
 * that the options defined in this class are used even if no Eclipse platform is
 * running.
 */
package nl.utwente.apc.Code2D.resource.c2d.mopp;

public class C2dOptionProvider implements nl.utwente.apc.Code2D.resource.c2d.IC2dOptionProvider {
	
	public java.util.Map<?,?> getOptions() {
		// create a map with static option providers here
		return java.util.Collections.emptyMap();
	}
	
}
