/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2.ui;

/**
 * A class used to initialize default preference values.
 */
public class C2PreferenceInitializer extends org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer {
	
	public void initializeDefaultPreferences() {
		
		initializeDefaultSyntaxHighlighting();
		initializeDefaultBrackets();
		
		org.eclipse.jface.preference.IPreferenceStore store = nl.utwente.apc.Code2D.resource.c2.ui.C2UIPlugin.getDefault().getPreferenceStore();
		// Set default value for matching brackets
		store.setDefault(nl.utwente.apc.Code2D.resource.c2.ui.C2PreferenceConstants.EDITOR_MATCHING_BRACKETS_COLOR, "192,192,192");
		store.setDefault(nl.utwente.apc.Code2D.resource.c2.ui.C2PreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX, true);
		
	}
	
	private void initializeDefaultBrackets() {
		org.eclipse.jface.preference.IPreferenceStore store = nl.utwente.apc.Code2D.resource.c2.ui.C2UIPlugin.getDefault().getPreferenceStore();
		initializeDefaultBrackets(store, new nl.utwente.apc.Code2D.resource.c2.mopp.C2MetaInformation());
	}
	
	public void initializeDefaultSyntaxHighlighting() {
		org.eclipse.jface.preference.IPreferenceStore store = nl.utwente.apc.Code2D.resource.c2.ui.C2UIPlugin.getDefault().getPreferenceStore();
		initializeDefaultSyntaxHighlighting(store, new nl.utwente.apc.Code2D.resource.c2.mopp.C2MetaInformation());
	}
	
	private void initializeDefaultBrackets(org.eclipse.jface.preference.IPreferenceStore store, nl.utwente.apc.Code2D.resource.c2.IC2MetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		// set default brackets for ITextResource bracket set
		nl.utwente.apc.Code2D.resource.c2.ui.C2BracketSet bracketSet = new nl.utwente.apc.Code2D.resource.c2.ui.C2BracketSet(null, null);
		final java.util.Collection<nl.utwente.apc.Code2D.resource.c2.IC2BracketPair> bracketPairs = metaInformation.getBracketPairs();
		if (bracketPairs != null) {
			for (nl.utwente.apc.Code2D.resource.c2.IC2BracketPair bracketPair : bracketPairs) {
				bracketSet.addBracketPair(bracketPair.getOpeningBracket(), bracketPair.getClosingBracket(), bracketPair.isClosingEnabledInside());
			}
		}
		store.setDefault(languageId + nl.utwente.apc.Code2D.resource.c2.ui.C2PreferenceConstants.EDITOR_BRACKETS_SUFFIX, bracketSet.getBracketString());
	}
	
	private void initializeDefaultSyntaxHighlighting(org.eclipse.jface.preference.IPreferenceStore store, nl.utwente.apc.Code2D.resource.c2.mopp.C2MetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		String[] tokenNames = metaInformation.getSyntaxHighlightableTokenNames();
		if (tokenNames == null) {
			return;
		}
		for (int i = 0; i < tokenNames.length; i++) {
			String tokenName = tokenNames[i];
			nl.utwente.apc.Code2D.resource.c2.IC2TokenStyle style = metaInformation.getDefaultTokenStyle(tokenName);
			if (style != null) {
				String color = getColorString(style.getColorAsRGB());
				setProperties(store, languageId, tokenName, color, style.isBold(), true, style.isItalic(), style.isStrikethrough(), style.isUnderline());
			} else {
				setProperties(store, languageId, tokenName, "0,0,0", false, false, false, false, false);
			}
		}
	}
	
	private void setProperties(org.eclipse.jface.preference.IPreferenceStore store, String languageID, String tokenName, String color, boolean bold, boolean enable, boolean italic, boolean strikethrough, boolean underline) {
		store.setDefault(nl.utwente.apc.Code2D.resource.c2.ui.C2SyntaxColoringHelper.getPreferenceKey(languageID, tokenName, nl.utwente.apc.Code2D.resource.c2.ui.C2SyntaxColoringHelper.StyleProperty.BOLD), bold);
		store.setDefault(nl.utwente.apc.Code2D.resource.c2.ui.C2SyntaxColoringHelper.getPreferenceKey(languageID, tokenName, nl.utwente.apc.Code2D.resource.c2.ui.C2SyntaxColoringHelper.StyleProperty.COLOR), color);
		store.setDefault(nl.utwente.apc.Code2D.resource.c2.ui.C2SyntaxColoringHelper.getPreferenceKey(languageID, tokenName, nl.utwente.apc.Code2D.resource.c2.ui.C2SyntaxColoringHelper.StyleProperty.ENABLE), enable);
		store.setDefault(nl.utwente.apc.Code2D.resource.c2.ui.C2SyntaxColoringHelper.getPreferenceKey(languageID, tokenName, nl.utwente.apc.Code2D.resource.c2.ui.C2SyntaxColoringHelper.StyleProperty.ITALIC), italic);
		store.setDefault(nl.utwente.apc.Code2D.resource.c2.ui.C2SyntaxColoringHelper.getPreferenceKey(languageID, tokenName, nl.utwente.apc.Code2D.resource.c2.ui.C2SyntaxColoringHelper.StyleProperty.STRIKETHROUGH), strikethrough);
		store.setDefault(nl.utwente.apc.Code2D.resource.c2.ui.C2SyntaxColoringHelper.getPreferenceKey(languageID, tokenName, nl.utwente.apc.Code2D.resource.c2.ui.C2SyntaxColoringHelper.StyleProperty.UNDERLINE), underline);
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
