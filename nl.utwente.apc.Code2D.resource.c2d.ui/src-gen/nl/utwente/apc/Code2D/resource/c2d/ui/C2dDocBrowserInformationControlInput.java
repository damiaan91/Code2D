/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2d.ui;

/**
 * Provides input for the <code>TextHover</code>. The most is copied from
 * <code>org.eclipse.jdt.internal.ui.text.java.hover.JavadocBrowserInformationContr
 * olInput</code>.
 */
public class C2dDocBrowserInformationControlInput {
	
	private final C2dDocBrowserInformationControlInput fPrevious;
	private C2dDocBrowserInformationControlInput fNext;
	private final org.eclipse.emf.ecore.EObject element;
	private final String htmlContent;
	private final String tokenText;
	private final org.eclipse.emf.ecore.resource.Resource resource;
	
	/**
	 * Creates a new browser information control input.
	 * 
	 * @param previous previous input, or <code>null</code> if none available
	 * @param element the element, or <code>null</code> if none available
	 * @param htmlContent HTML contents, must not be null
	 */
	public C2dDocBrowserInformationControlInput(C2dDocBrowserInformationControlInput previous, org.eclipse.emf.ecore.EObject element, org.eclipse.emf.ecore.resource.Resource resource, String htmlContent, String tokenText) {
		fPrevious= previous;
		if (previous != null) {
			previous.fNext= this;
		}
		assert htmlContent != null;
		this.element = element;
		this.htmlContent = htmlContent;
		this.tokenText = tokenText;
		this.resource = resource;
	}
	
	/**
	 * Returns the previous input or <code>null</code> if this is the first.
	 * 
	 * @return the previous input or <code>null</code>
	 */
	public C2dDocBrowserInformationControlInput getPrevious() {
		return fPrevious;
	}
	
	/**
	 * Returns the next input or <code>null</code> if this is the last.
	 * 
	 * @return the next input or <code>null</code>
	 */
	public C2dDocBrowserInformationControlInput getNext() {
		return fNext;
	}
	
	/**
	 * 
	 * @return the resource
	 */
	public org.eclipse.emf.ecore.resource.Resource getResource() {
		return resource;
	}
	
	public String getHtml() {
		return htmlContent;
	}
	
	public String toString() {
		return getHtml();
	}
	
	/**
	 * 
	 * @return the token text, it is needed for a hyperlink where the caret has to
	 * jump to
	 */
	public String getTokenText() {
		return tokenText;
	}
	
	public Object getInputElement() {
		return element == null ? (Object) htmlContent : element;
	}
	
	public String getInputName() {
		return element == null ? "" : element.toString();
	}
	
	public int getLeadingImageWidth() {
		return 0;
	}
}