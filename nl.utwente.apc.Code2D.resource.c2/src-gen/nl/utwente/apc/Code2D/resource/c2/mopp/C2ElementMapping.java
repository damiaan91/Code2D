/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2.mopp;

/**
 * A basic implementation of the
 * nl.utwente.apc.Code2D.resource.c2.IC2ElementMapping interface.
 * 
 * @param <ReferenceType> the type of the reference that can be mapped to
 */
public class C2ElementMapping<ReferenceType> implements nl.utwente.apc.Code2D.resource.c2.IC2ElementMapping<ReferenceType> {
	
	private final ReferenceType target;
	private String identifier;
	private String warning;
	
	public C2ElementMapping(String identifier, ReferenceType target, String warning) {
		super();
		this.target = target;
		this.identifier = identifier;
		this.warning = warning;
	}
	
	public ReferenceType getTargetElement() {
		return target;
	}
	
	public String getIdentifier() {
		return identifier;
	}
	
	public String getWarning() {
		return warning;
	}
	
}
