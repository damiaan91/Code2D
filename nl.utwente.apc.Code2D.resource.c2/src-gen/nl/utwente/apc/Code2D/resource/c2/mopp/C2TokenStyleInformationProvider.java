/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2.mopp;

public class C2TokenStyleInformationProvider {
	
	public static String TASK_ITEM_TOKEN_NAME = "TASK_ITEM";
	
	public nl.utwente.apc.Code2D.resource.c2.IC2TokenStyle getDefaultTokenStyle(String tokenName) {
		if ("Game".equals(tokenName)) {
			return new nl.utwente.apc.Code2D.resource.c2.mopp.C2TokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("World".equals(tokenName)) {
			return new nl.utwente.apc.Code2D.resource.c2.mopp.C2TokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Name:".equals(tokenName)) {
			return new nl.utwente.apc.Code2D.resource.c2.mopp.C2TokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("TASK_ITEM".equals(tokenName)) {
			return new nl.utwente.apc.Code2D.resource.c2.mopp.C2TokenStyle(new int[] {0x7F, 0x9F, 0xBF}, null, true, false, false, false);
		}
		return null;
	}
	
}
