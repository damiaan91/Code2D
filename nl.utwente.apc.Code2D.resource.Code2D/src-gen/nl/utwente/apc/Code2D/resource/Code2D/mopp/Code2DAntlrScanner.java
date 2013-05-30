/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.Code2D.mopp;

public class Code2DAntlrScanner implements nl.utwente.apc.Code2D.resource.Code2D.ICode2DTextScanner {
	
	private org.antlr.runtime3_4_0.Lexer antlrLexer;
	
	public Code2DAntlrScanner(org.antlr.runtime3_4_0.Lexer antlrLexer) {
		this.antlrLexer = antlrLexer;
	}
	
	public nl.utwente.apc.Code2D.resource.Code2D.ICode2DTextToken getNextToken() {
		if (antlrLexer.getCharStream() == null) {
			return null;
		}
		final org.antlr.runtime3_4_0.Token current = antlrLexer.nextToken();
		if (current == null || current.getType() < 0) {
			return null;
		}
		nl.utwente.apc.Code2D.resource.Code2D.ICode2DTextToken result = new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DANTLRTextToken(current);
		return result;
	}
	
	public void setText(String text) {
		antlrLexer.setCharStream(new org.antlr.runtime3_4_0.ANTLRStringStream(text));
	}
	
}
