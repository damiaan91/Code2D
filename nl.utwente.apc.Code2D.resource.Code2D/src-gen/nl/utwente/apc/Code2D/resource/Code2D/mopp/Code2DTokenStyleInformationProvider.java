/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.Code2D.mopp;

public class Code2DTokenStyleInformationProvider {
	
	public static String TASK_ITEM_TOKEN_NAME = "TASK_ITEM";
	
	public nl.utwente.apc.Code2D.resource.Code2D.ICode2DTokenStyle getDefaultTokenStyle(String tokenName) {
		if ("Game".equals(tokenName)) {
			return new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("World".equals(tokenName)) {
			return new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Player".equals(tokenName)) {
			return new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Texture".equals(tokenName)) {
			return new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("NPC".equals(tokenName)) {
			return new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Item".equals(tokenName)) {
			return new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Behaviour".equals(tokenName)) {
			return new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Terrain".equals(tokenName)) {
			return new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("WorldBlocks".equals(tokenName)) {
			return new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Trap".equals(tokenName)) {
			return new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Scenery".equals(tokenName)) {
			return new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Friendly".equals(tokenName)) {
			return new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Neutral".equals(tokenName)) {
			return new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Hostile".equals(tokenName)) {
			return new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("Name".equals(tokenName)) {
			return new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("CanStand".equals(tokenName)) {
			return new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("CanHaveItem".equals(tokenName)) {
			return new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("QUOTED_34_34".equals(tokenName)) {
			return new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DTokenStyle(new int[] {0x2A, 0x00, 0xFF}, null, false, false, false, false);
		}
		if ("TASK_ITEM".equals(tokenName)) {
			return new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DTokenStyle(new int[] {0x7F, 0x9F, 0xBF}, null, true, false, false, false);
		}
		return null;
	}
	
}
