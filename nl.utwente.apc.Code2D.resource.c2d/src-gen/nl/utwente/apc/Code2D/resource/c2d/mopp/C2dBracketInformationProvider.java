/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2d.mopp;

public class C2dBracketInformationProvider {
	
	public class BracketPair implements nl.utwente.apc.Code2D.resource.c2d.IC2dBracketPair {
		
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
	
	public java.util.Collection<nl.utwente.apc.Code2D.resource.c2d.IC2dBracketPair> getBracketPairs() {
		java.util.Collection<nl.utwente.apc.Code2D.resource.c2d.IC2dBracketPair> result = new java.util.ArrayList<nl.utwente.apc.Code2D.resource.c2d.IC2dBracketPair>();
		result.add(new BracketPair("{", "}", true));
		result.add(new BracketPair("\"", "\"", false));
		return result;
	}
	
}
