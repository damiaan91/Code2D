/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.Code2D.mopp;

/**
 * An Excpetion to represent invalid content types for parser instances.
 * 
 * @see nl.utwente.apc.Code2D.resource.Code2D.ICode2DOptions.RESOURCE_CONTENT_TYPE
 */
public class Code2DUnexpectedContentTypeException extends org.antlr.runtime3_4_0.RecognitionException {
	
	private static final long serialVersionUID = 4791359811519433999L;
	
	private Object contentType = null;
	
	public  Code2DUnexpectedContentTypeException(Object contentType) {
		this.contentType = contentType;
	}
	
	public Object getContentType() {
		return contentType;
	}
	
}
