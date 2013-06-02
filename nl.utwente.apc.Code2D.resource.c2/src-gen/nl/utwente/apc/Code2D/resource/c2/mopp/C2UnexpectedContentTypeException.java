/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2.mopp;

/**
 * An Excpetion to represent invalid content types for parser instances.
 * 
 * @see nl.utwente.apc.Code2D.resource.c2.IC2Options.RESOURCE_CONTENT_TYPE
 */
public class C2UnexpectedContentTypeException extends org.antlr.runtime3_4_0.RecognitionException {
	
	private static final long serialVersionUID = 4791359811519433999L;
	
	private Object contentType = null;
	
	public  C2UnexpectedContentTypeException(Object contentType) {
		this.contentType = contentType;
	}
	
	public Object getContentType() {
		return contentType;
	}
	
}
