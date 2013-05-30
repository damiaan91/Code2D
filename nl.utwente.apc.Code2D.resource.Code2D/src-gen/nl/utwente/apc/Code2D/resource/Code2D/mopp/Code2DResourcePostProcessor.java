/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.Code2D.mopp;

public class Code2DResourcePostProcessor implements nl.utwente.apc.Code2D.resource.Code2D.ICode2DResourcePostProcessor {
	
	public void process(nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DResource resource) {
		// Set the overrideResourcePostProcessor option to false to customize resource
		// post processing.
	}
	
	public void terminate() {
		// To signal termination to the process() method, setting a boolean field is
		// recommended. Depending on the value of this field process() can stop its
		// computation. However, this is only required for computation intensive
		// post-processors.
	}
	
}
