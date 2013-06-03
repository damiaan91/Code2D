/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.Code2D.mopp;

public class Code2DBracketInformationProvider {
	
	public class BracketPair implements nl.utwente.apc.Code2D.resource.Code2D.ICode2DBracketPair {
		
		private String opening;
		private String closing;
		private boolean closingEnabledInside;
		
		public BracketPair(String opening, String closing, boolean closingEnabledInside) {
			super();
			this.opening = opening;
			this.closing = closing;
			this.closingEnabledInside = closingEnabledInside;
		}
		
		public String getOpeningBracket() {
			return opening;
		}
		
		public String getClosingBracket() {
			return closing;
		}
		
		public boolean isClosingEnabledInside() {
			return closingEnabledInside;
		}
	}
	
	public java.util.Collection<nl.utwente.apc.Code2D.resource.Code2D.ICode2DBracketPair> getBracketPairs() {
		java.util.Collection<nl.utwente.apc.Code2D.resource.Code2D.ICode2DBracketPair> result = new java.util.ArrayList<nl.utwente.apc.Code2D.resource.Code2D.ICode2DBracketPair>();
		result.add(new BracketPair("{", "}", true));
		result.add(new BracketPair("\"", "\"", false));
		return result;
	}
	
}
