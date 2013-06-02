/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2d.mopp;

public class C2dResourcePostProcessor implements nl.utwente.apc.Code2D.resource.c2d.IC2dResourcePostProcessor {
	
	public void process(nl.utwente.apc.Code2D.resource.c2d.mopp.C2dResource resource) {
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
