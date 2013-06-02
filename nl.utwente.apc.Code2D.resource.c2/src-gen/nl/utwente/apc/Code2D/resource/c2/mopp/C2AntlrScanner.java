/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2.mopp;

public class C2AntlrScanner implements nl.utwente.apc.Code2D.resource.c2.IC2TextScanner {
	
	private org.antlr.runtime3_4_0.Lexer antlrLexer;
	
	public C2AntlrScanner(org.antlr.runtime3_4_0.Lexer antlrLexer) {
		this.antlrLexer = antlrLexer;
	}
	
	public nl.utwente.apc.Code2D.resource.c2.IC2TextToken getNextToken() {
		if (antlrLexer.getCharStream() == null) {
			return null;
		}
		final org.antlr.runtime3_4_0.Token current = antlrLexer.nextToken();
		if (current == null || current.getType() < 0) {
			return null;
		}
		nl.utwente.apc.Code2D.resource.c2.IC2TextToken result = new nl.utwente.apc.Code2D.resource.c2.mopp.C2ANTLRTextToken(current);
		return result;
	}
	
	public void setText(String text) {
		antlrLexer.setCharStream(new org.antlr.runtime3_4_0.ANTLRStringStream(text));
	}
	
}
