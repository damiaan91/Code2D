/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.Code2D.mopp;

/**
 * A basic implementation of the
 * nl.utwente.apc.Code2D.resource.Code2D.ICode2DElementMapping interface.
 * 
 * @param <ReferenceType> the type of the reference that can be mapped to
 */
public class Code2DElementMapping<ReferenceType> implements nl.utwente.apc.Code2D.resource.Code2D.ICode2DElementMapping<ReferenceType> {
	
	private final ReferenceType target;
	private String identifier;
	private String warning;
	
	public Code2DElementMapping(String identifier, ReferenceType target, String warning) {
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
