/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.Code2D.ui;

/**
 * A class used to initialize default preference values.
 */
public class Code2DPreferenceInitializer extends org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer {
	
	public void initializeDefaultPreferences() {
		
		initializeDefaultSyntaxHighlighting();
		initializeDefaultBrackets();
		
		org.eclipse.jface.preference.IPreferenceStore store = nl.utwente.apc.Code2D.resource.Code2D.ui.Code2DUIPlugin.getDefault().getPreferenceStore();
		// Set default value for matching brackets
		store.setDefault(nl.utwente.apc.Code2D.resource.Code2D.ui.Code2DPreferenceConstants.EDITOR_MATCHING_BRACKETS_COLOR, "192,192,192");
		store.setDefault(nl.utwente.apc.Code2D.resource.Code2D.ui.Code2DPreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX, true);
		
	}
	
	private void initializeDefaultBrackets() {
		org.eclipse.jface.preference.IPreferenceStore store = nl.utwente.apc.Code2D.resource.Code2D.ui.Code2DUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultBrackets(store, new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DMetaInformation());
	}
	
	public void initializeDefaultSyntaxHighlighting() {
		org.eclipse.jface.preference.IPreferenceStore store = nl.utwente.apc.Code2D.resource.Code2D.ui.Code2DUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultSyntaxHighlighting(store, new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DMetaInformation());
	}
	
	private void initializeDefaultBrackets(org.eclipse.jface.preference.IPreferenceStore store, nl.utwente.apc.Code2D.resource.Code2D.ICode2DMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		// set default brackets for ITextResource bracket set
		nl.utwente.apc.Code2D.resource.Code2D.ui.Code2DBracketSet bracketSet = new nl.utwente.apc.Code2D.resource.Code2D.ui.Code2DBracketSet(null, null);
		final java.util.Collection<nl.utwente.apc.Code2D.resource.Code2D.ICode2DBracketPair> bracketPairs = metaInformation.getBracketPairs();
		if (bracketPairs != null) {
			for (nl.utwente.apc.Code2D.resource.Code2D.ICode2DBracketPair bracketPair : bracketPairs) {
				bracketSet.addBracketPair(bracketPair.getOpeningBracket(), bracketPair.getClosingBracket(), bracketPair.isClosingEnabledInside());
			}
		}
		store.setDefault(languageId + nl.utwente.apc.Code2D.resource.Code2D.ui.Code2DPreferenceConstants.EDITOR_BRACKETS_SUFFIX, bracketSet.getBracketString());
	}
	
	private void initializeDefaultSyntaxHighlighting(org.eclipse.jface.preference.IPreferenceStore store, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		String[] tokenNames = metaInformation.getSyntaxHighlightableTokenNames();
		if (tokenNames == null) {
			return;
		}
		for (int i = 0; i < tokenNames.length; i++) {
			String tokenName = tokenNames[i];
			nl.utwente.apc.Code2D.resource.Code2D.ICode2DTokenStyle style = metaInformation.getDefaultTokenStyle(tokenName);
			if (style != null) {
				String color = getColorString(style.getColorAsRGB());
				setProperties(store, languageId, tokenName, color, style.isBold(), true, style.isItalic(), style.isStrikethrough(), style.isUnderline());
			} else {
				setProperties(store, languageId, tokenName, "0,0,0", false, false, false, false, false);
			}
		}
	}
	
	private void setProperties(org.eclipse.jface.preference.IPreferenceStore store, String languageID, String tokenName, String color, boolean bold, boolean enable, boolean italic, boolean strikethrough, boolean underline) {
		store.setDefault(nl.utwente.apc.Code2D.resource.Code2D.ui.Code2DSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, nl.utwente.apc.Code2D.resource.Code2D.ui.Code2DSyntaxColoringHelper.StyleProperty.BOLD), bold);
		store.setDefault(nl.utwente.apc.Code2D.resource.Code2D.ui.Code2DSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, nl.utwente.apc.Code2D.resource.Code2D.ui.Code2DSyntaxColoringHelper.StyleProperty.COLOR), color);
		store.setDefault(nl.utwente.apc.Code2D.resource.Code2D.ui.Code2DSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, nl.utwente.apc.Code2D.resource.Code2D.ui.Code2DSyntaxColoringHelper.StyleProperty.ENABLE), enable);
		store.setDefault(nl.utwente.apc.Code2D.resource.Code2D.ui.Code2DSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, nl.utwente.apc.Code2D.resource.Code2D.ui.Code2DSyntaxColoringHelper.StyleProperty.ITALIC), italic);
		store.setDefault(nl.utwente.apc.Code2D.resource.Code2D.ui.Code2DSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, nl.utwente.apc.Code2D.resource.Code2D.ui.Code2DSyntaxColoringHelper.StyleProperty.STRIKETHROUGH), strikethrough);
		store.setDefault(nl.utwente.apc.Code2D.resource.Code2D.ui.Code2DSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, nl.utwente.apc.Code2D.resource.Code2D.ui.Code2DSyntaxColoringHelper.StyleProperty.UNDERLINE), underline);
	}
	
	private String getColorString(int[] colorAsRGB) {
		if (colorAsRGB == null) {
			return "0,0,0";
		}
		if (colorAsRGB.length != 3) {
			return "0,0,0";
		}
		return colorAsRGB[0] + "," +colorAsRGB[1] + ","+ colorAsRGB[2];
	}
}
