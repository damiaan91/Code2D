/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2d.mopp;

public class C2dTokenStyleInformationProvider {
	
	public static String TASK_ITEM_TOKEN_NAME = "TASK_ITEM";
	
	public nl.utwente.apc.Code2D.resource.c2d.IC2dTokenStyle getDefaultTokenStyle(String tokenName) {
		if ("Game".equals(tokenName)) {
			return new nl.utwente.apc.Code2D.resource.c2d.mopp.C2dTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("GameWorld".equals(tokenName)) {
			return new nl.utwente.apc.Code2D.resource.c2d.mopp.C2dTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("World".equals(tokenName)) {
			return new nl.utwente.apc.Code2D.resource.c2d.mopp.C2dTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Player".equals(tokenName)) {
			return new nl.utwente.apc.Code2D.resource.c2d.mopp.C2dTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("NPC".equals(tokenName)) {
			return new nl.utwente.apc.Code2D.resource.c2d.mopp.C2dTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Item".equals(tokenName)) {
			return new nl.utwente.apc.Code2D.resource.c2d.mopp.C2dTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Friendly".equals(tokenName)) {
			return new nl.utwente.apc.Code2D.resource.c2d.mopp.C2dTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Neutral".equals(tokenName)) {
			return new nl.utwente.apc.Code2D.resource.c2d.mopp.C2dTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Hostile".equals(tokenName)) {
			return new nl.utwente.apc.Code2D.resource.c2d.mopp.C2dTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("QUOTED_34_34".equals(tokenName)) {
			return new nl.utwente.apc.Code2D.resource.c2d.mopp.C2dTokenStyle(new int[] {0x2A, 0x00, 0xFF}, null, false, false, false, false);
		}
		if ("TASK_ITEM".equals(tokenName)) {
			return new nl.utwente.apc.Code2D.resource.c2d.mopp.C2dTokenStyle(new int[] {0x7F, 0x9F, 0xBF}, null, true, false, false, false);
		}
		return null;
	}
	
}
