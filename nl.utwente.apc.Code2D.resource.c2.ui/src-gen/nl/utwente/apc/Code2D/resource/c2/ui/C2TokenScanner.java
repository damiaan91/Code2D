/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2.ui;

/**
 * An adapter from the Eclipse
 * <code>org.eclipse.jface.text.rules.ITokenScanner</code> interface to the
 * generated lexer.
 */
public class C2TokenScanner implements org.eclipse.jface.text.rules.ITokenScanner {
	
	private nl.utwente.apc.Code2D.resource.c2.IC2TextScanner lexer;
	private nl.utwente.apc.Code2D.resource.c2.IC2TextToken currentToken;
	private java.util.List<nl.utwente.apc.Code2D.resource.c2.IC2TextToken> nextTokens;
	private int offset;
	private String languageId;
	private org.eclipse.jface.preference.IPreferenceStore store;
	private nl.utwente.apc.Code2D.resource.c2.ui.C2ColorManager colorManager;
	private nl.utwente.apc.Code2D.resource.c2.IC2TextResource resource;
	
	/**
	 * 
	 * @param colorManager A manager to obtain color objects
	 */
	public C2TokenScanner(nl.utwente.apc.Code2D.resource.c2.IC2TextResource resource, nl.utwente.apc.Code2D.resource.c2.ui.C2ColorManager colorManager) {
		this.resource = resource;
		this.colorManager = colorManager;
		this.lexer = new nl.utwente.apc.Code2D.resource.c2.mopp.C2MetaInformation().createLexer();
		this.languageId = new nl.utwente.apc.Code2D.resource.c2.mopp.C2MetaInformation().getSyntaxName();
		nl.utwente.apc.Code2D.resource.c2.ui.C2UIPlugin plugin = nl.utwente.apc.Code2D.resource.c2.ui.C2UIPlugin.getDefault();
		if (plugin != null) {
			this.store = plugin.getPreferenceStore();
		}
		this.nextTokens = new java.util.ArrayList<nl.utwente.apc.Code2D.resource.c2.IC2TextToken>();
	}
	
	public int getTokenLength() {
		return currentToken.getLength();
	}
	
	public int getTokenOffset() {
		return offset + currentToken.getOffset();
	}
	
	public org.eclipse.jface.text.rules.IToken nextToken() {
		boolean isOriginalToken = true;
		if (!nextTokens.isEmpty()) {
			currentToken = nextTokens.remove(0);
			isOriginalToken = false;
		} else {
			currentToken = lexer.getNextToken();
		}
		if (currentToken == null || !currentToken.canBeUsedForSyntaxHighlighting()) {
			return org.eclipse.jface.text.rules.Token.EOF;
		}
		
		if (isOriginalToken) {
			splitCurrentToken();
		}
		
		org.eclipse.jface.text.TextAttribute textAttribute = null;
		String tokenName = currentToken.getName();
		if (tokenName != null) {
			nl.utwente.apc.Code2D.resource.c2.IC2TokenStyle staticStyle = getStaticTokenStyle();
			// now call dynamic token styler to allow to apply modifications to the static
			// style
			nl.utwente.apc.Code2D.resource.c2.IC2TokenStyle dynamicStyle = getDynamicTokenStyle(staticStyle);
			if (dynamicStyle != null) {
				textAttribute = getTextAttribute(dynamicStyle);
			}
		}
		
		return new org.eclipse.jface.text.rules.Token(textAttribute);
	}
	
	public void setRange(org.eclipse.jface.text.IDocument document, int offset, int length) {
		this.offset = offset;
		try {
			lexer.setText(document.get(offset, length));
		} catch (org.eclipse.jface.text.BadLocationException e) {
			// ignore this error. It might occur during editing when locations are outdated
			// quickly.
		}
	}
	
	public String getTokenText() {
		return currentToken.getText();
	}
	
	public int[] convertToIntArray(org.eclipse.swt.graphics.RGB rgb) {
		if (rgb == null) {
			return null;
		}
		return new int[] {rgb.red, rgb.green, rgb.blue};
	}
	
	public nl.utwente.apc.Code2D.resource.c2.IC2TokenStyle getStaticTokenStyle() {
		nl.utwente.apc.Code2D.resource.c2.IC2TokenStyle staticStyle = null;
		String tokenName = currentToken.getName();
		String enableKey = nl.utwente.apc.Code2D.resource.c2.ui.C2SyntaxColoringHelper.getPreferenceKey(languageId, tokenName, nl.utwente.apc.Code2D.resource.c2.ui.C2SyntaxColoringHelper.StyleProperty.ENABLE);
		boolean enabled = store.getBoolean(enableKey);
		if (enabled) {
			String colorKey = nl.utwente.apc.Code2D.resource.c2.ui.C2SyntaxColoringHelper.getPreferenceKey(languageId, tokenName, nl.utwente.apc.Code2D.resource.c2.ui.C2SyntaxColoringHelper.StyleProperty.COLOR);
			org.eclipse.swt.graphics.RGB foregroundRGB = org.eclipse.jface.preference.PreferenceConverter.getColor(store, colorKey);
			org.eclipse.swt.graphics.RGB backgroundRGB = null;
			boolean bold = store.getBoolean(nl.utwente.apc.Code2D.resource.c2.ui.C2SyntaxColoringHelper.getPreferenceKey(languageId, tokenName, nl.utwente.apc.Code2D.resource.c2.ui.C2SyntaxColoringHelper.StyleProperty.BOLD));
			boolean italic = store.getBoolean(nl.utwente.apc.Code2D.resource.c2.ui.C2SyntaxColoringHelper.getPreferenceKey(languageId, tokenName, nl.utwente.apc.Code2D.resource.c2.ui.C2SyntaxColoringHelper.StyleProperty.ITALIC));
			boolean strikethrough = store.getBoolean(nl.utwente.apc.Code2D.resource.c2.ui.C2SyntaxColoringHelper.getPreferenceKey(languageId, tokenName, nl.utwente.apc.Code2D.resource.c2.ui.C2SyntaxColoringHelper.StyleProperty.STRIKETHROUGH));
			boolean underline = store.getBoolean(nl.utwente.apc.Code2D.resource.c2.ui.C2SyntaxColoringHelper.getPreferenceKey(languageId, tokenName, nl.utwente.apc.Code2D.resource.c2.ui.C2SyntaxColoringHelper.StyleProperty.UNDERLINE));
			staticStyle = new nl.utwente.apc.Code2D.resource.c2.mopp.C2TokenStyle(convertToIntArray(foregroundRGB), convertToIntArray(backgroundRGB), bold, italic, strikethrough, underline);
		}
		return staticStyle;
	}
	
	public nl.utwente.apc.Code2D.resource.c2.IC2TokenStyle getDynamicTokenStyle(nl.utwente.apc.Code2D.resource.c2.IC2TokenStyle staticStyle) {
		nl.utwente.apc.Code2D.resource.c2.mopp.C2DynamicTokenStyler dynamicTokenStyler = new nl.utwente.apc.Code2D.resource.c2.mopp.C2DynamicTokenStyler();
		nl.utwente.apc.Code2D.resource.c2.IC2TokenStyle dynamicStyle = dynamicTokenStyler.getDynamicTokenStyle(resource, currentToken, staticStyle);
		return dynamicStyle;
	}
	
	public org.eclipse.jface.text.TextAttribute getTextAttribute(nl.utwente.apc.Code2D.resource.c2.IC2TokenStyle tokeStyle) {
		int[] foregroundColorArray = tokeStyle.getColorAsRGB();
		org.eclipse.swt.graphics.Color foregroundColor = null;
		if (colorManager != null) {
			foregroundColor = colorManager.getColor(new org.eclipse.swt.graphics.RGB(foregroundColorArray[0], foregroundColorArray[1], foregroundColorArray[2]));
		}
		int[] backgroundColorArray = tokeStyle.getBackgroundColorAsRGB();
		org.eclipse.swt.graphics.Color backgroundColor = null;
		if (backgroundColorArray != null) {
			org.eclipse.swt.graphics.RGB backgroundRGB = new org.eclipse.swt.graphics.RGB(backgroundColorArray[0], backgroundColorArray[1], backgroundColorArray[2]);
			if (colorManager != null) {
				backgroundColor = colorManager.getColor(backgroundRGB);
			}
		}
		int style = org.eclipse.swt.SWT.NORMAL;
		if (tokeStyle.isBold()) {
			style = style | org.eclipse.swt.SWT.BOLD;
		}
		if (tokeStyle.isItalic()) {
			style = style | org.eclipse.swt.SWT.ITALIC;
		}
		if (tokeStyle.isStrikethrough()) {
			style = style | org.eclipse.jface.text.TextAttribute.STRIKETHROUGH;
		}
		if (tokeStyle.isUnderline()) {
			style = style | org.eclipse.jface.text.TextAttribute.UNDERLINE;
		}
		return new org.eclipse.jface.text.TextAttribute(foregroundColor, backgroundColor, style);
	}
	
	/**
	 * Tries to split the current token if it contains task items.
	 */
	public void splitCurrentToken() {
		final String text = currentToken.getText();
		final String name = currentToken.getName();
		final int line = currentToken.getLine();
		final int charStart = currentToken.getOffset();
		final int column = currentToken.getColumn();
		
		java.util.List<nl.utwente.apc.Code2D.resource.c2.mopp.C2TaskItem> taskItems = new nl.utwente.apc.Code2D.resource.c2.mopp.C2TaskItemDetector().findTaskItems(text, line, charStart);
		
		// this is the offset for the next token to be added
		int offset = charStart;
		int itemBeginRelative;
		java.util.List<nl.utwente.apc.Code2D.resource.c2.IC2TextToken> newItems = new java.util.ArrayList<nl.utwente.apc.Code2D.resource.c2.IC2TextToken>();
		for (nl.utwente.apc.Code2D.resource.c2.mopp.C2TaskItem taskItem : taskItems) {
			int itemBegin = taskItem.getCharStart();
			int itemLine = taskItem.getLine();
			int itemColumn = 0;
			
			itemBeginRelative = itemBegin - charStart;
			// create token before task item (TODO if required)
			String textBefore = text.substring(offset - charStart, itemBeginRelative);
			int textBeforeLength = textBefore.length();
			newItems.add(new nl.utwente.apc.Code2D.resource.c2.mopp.C2TextToken(name, textBefore, offset, textBeforeLength, line, column, true));
			
			// create token for the task item itself
			offset = offset + textBeforeLength;
			String itemText = taskItem.getKeyword();
			int itemTextLength = itemText.length();
			newItems.add(new nl.utwente.apc.Code2D.resource.c2.mopp.C2TextToken(nl.utwente.apc.Code2D.resource.c2.mopp.C2TokenStyleInformationProvider.TASK_ITEM_TOKEN_NAME, itemText, offset, itemTextLength, itemLine, itemColumn, true));
			
			offset = offset + itemTextLength;
		}
		
		if (!taskItems.isEmpty()) {
			// create token after last task item (TODO if required)
			String textAfter = text.substring(offset - charStart);
			newItems.add(new nl.utwente.apc.Code2D.resource.c2.mopp.C2TextToken(name, textAfter, offset, textAfter.length(), line, column, true));
		}
		
		if (!newItems.isEmpty()) {
			// replace tokens
			currentToken = newItems.remove(0);
			nextTokens = newItems;
		}
		
	}
}
