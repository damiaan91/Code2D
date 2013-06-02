/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2d.ui;

/**
 * A class used to initialize default preference values.
 */
public class C2dPreferenceInitializer extends org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer {
	
	public void initializeDefaultPreferences() {
		
		initializeDefaultSyntaxHighlighting();
		initializeDefaultBrackets();
		
		org.eclipse.jface.preference.IPreferenceStore store = nl.utwente.apc.Code2D.resource.c2d.ui.C2dUIPlugin.getDefault().getPreferenceStore();
		// Set default value for matching brackets
		store.setDefault(nl.utwente.apc.Code2D.resource.c2d.ui.C2dPreferenceConstants.EDITOR_MATCHING_BRACKETS_COLOR, "192,192,192");
		store.setDefault(nl.utwente.apc.Code2D.resource.c2d.ui.C2dPreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX, true);
		
	}
	
	private void initializeDefaultBrackets() {
		org.eclipse.jface.preference.IPreferenceStore store = nl.utwente.apc.Code2D.resource.c2d.ui.C2dUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultBrackets(store, new nl.utwente.apc.Code2D.resource.c2d.mopp.C2dMetaInformation());
	}
	
	public void initializeDefaultSyntaxHighlighting() {
		org.eclipse.jface.preference.IPreferenceStore store = nl.utwente.apc.Code2D.resource.c2d.ui.C2dUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultSyntaxHighlighting(store, new nl.utwente.apc.Code2D.resource.c2d.mopp.C2dMetaInformation());
	}
	
	private void initializeDefaultBrackets(org.eclipse.jface.preference.IPreferenceStore store, nl.utwente.apc.Code2D.resource.c2d.IC2dMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		// set default brackets for ITextResource bracket set
		nl.utwente.apc.Code2D.resource.c2d.ui.C2dBracketSet bracketSet = new nl.utwente.apc.Code2D.resource.c2d.ui.C2dBracketSet(null, null);
		final java.util.Collection<nl.utwente.apc.Code2D.resource.c2d.IC2dBracketPair> bracketPairs = metaInformation.getBracketPairs();
		if (bracketPairs != null) {
			for (nl.utwente.apc.Code2D.resource.c2d.IC2dBracketPair bracketPair : bracketPairs) {
				bracketSet.addBracketPair(bracketPair.getOpeningBracket(), bracketPair.getClosingBracket(), bracketPair.isClosingEnabledInside());
			}
		}
		store.setDefault(languageId + nl.utwente.apc.Code2D.resource.c2d.ui.C2dPreferenceConstants.EDITOR_BRACKETS_SUFFIX, bracketSet.getBracketString());
	}
	
	private void initializeDefaultSyntaxHighlighting(org.eclipse.jface.preference.IPreferenceStore store, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		String[] tokenNames = metaInformation.getSyntaxHighlightableTokenNames();
		if (tokenNames == null) {
			return;
		}
		for (int i = 0; i < tokenNames.length; i++) {
			String tokenName = tokenNames[i];
			nl.utwente.apc.Code2D.resource.c2d.IC2dTokenStyle style = metaInformation.getDefaultTokenStyle(tokenName);
			if (style != null) {
				String color = getColorString(style.getColorAsRGB());
				setProperties(store, languageId, tokenName, color, style.isBold(), true, style.isItalic(), style.isStrikethrough(), style.isUnderline());
			} else {
				setProperties(store, languageId, tokenName, "0,0,0", false, false, false, false, false);
			}
		}
	}
	
	private void setProperties(org.eclipse.jface.preference.IPreferenceStore store, String languageID, String tokenName, String color, boolean bold, boolean enable, boolean italic, boolean strikethrough, boolean underline) {
		store.setDefault(nl.utwente.apc.Code2D.resource.c2d.ui.C2dSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, nl.utwente.apc.Code2D.resource.c2d.ui.C2dSyntaxColoringHelper.StyleProperty.BOLD), bold);
		store.setDefault(nl.utwente.apc.Code2D.resource.c2d.ui.C2dSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, nl.utwente.apc.Code2D.resource.c2d.ui.C2dSyntaxColoringHelper.StyleProperty.COLOR), color);
		store.setDefault(nl.utwente.apc.Code2D.resource.c2d.ui.C2dSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, nl.utwente.apc.Code2D.resource.c2d.ui.C2dSyntaxColoringHelper.StyleProperty.ENABLE), enable);
		store.setDefault(nl.utwente.apc.Code2D.resource.c2d.ui.C2dSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, nl.utwente.apc.Code2D.resource.c2d.ui.C2dSyntaxColoringHelper.StyleProperty.ITALIC), italic);
		store.setDefault(nl.utwente.apc.Code2D.resource.c2d.ui.C2dSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, nl.utwente.apc.Code2D.resource.c2d.ui.C2dSyntaxColoringHelper.StyleProperty.STRIKETHROUGH), strikethrough);
		store.setDefault(nl.utwente.apc.Code2D.resource.c2d.ui.C2dSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, nl.utwente.apc.Code2D.resource.c2d.ui.C2dSyntaxColoringHelper.StyleProperty.UNDERLINE), underline);
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
