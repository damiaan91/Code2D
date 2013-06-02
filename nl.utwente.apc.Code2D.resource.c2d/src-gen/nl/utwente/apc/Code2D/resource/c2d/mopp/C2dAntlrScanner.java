/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2d.mopp;

public class C2dAntlrScanner implements nl.utwente.apc.Code2D.resource.c2d.IC2dTextScanner {
	
	private org.antlr.runtime3_4_0.Lexer antlrLexer;
	
	public C2dAntlrScanner(org.antlr.runtime3_4_0.Lexer antlrLexer) {
		this.antlrLexer = antlrLexer;
	}
	
	public nl.utwente.apc.Code2D.resource.c2d.IC2dTextToken getNextToken() {
		if (antlrLexer.getCharStream() == null) {
			return null;
		}
		final org.antlr.runtime3_4_0.Token current = antlrLexer.nextToken();
		if (current == null || current.getType() < 0) {
			return null;
		}
		nl.utwente.apc.Code2D.resource.c2d.IC2dTextToken result = new nl.utwente.apc.Code2D.resource.c2d.mopp.C2dANTLRTextToken(current);
		return result;
	}
	
	public void setText(String text) {
		antlrLexer.setCharStream(new org.antlr.runtime3_4_0.ANTLRStringStream(text));
	}
	
}
