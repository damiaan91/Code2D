// $ANTLR 3.4

	package nl.utwente.apc.Code2D.resource.Code2D.mopp;


import org.antlr.runtime3_4_0.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class Code2DParser extends Code2DANTLRParserBase {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMENT", "FLOAT", "INTEGER", "LINEBREAK", "QUOTED_4748_59", "TEXT", "WHITESPACE", "':'", "';'", "'Behaviour'", "'Friendly'", "'Game'", "'Hostile'", "'Item'", "'NPC'", "'Neutral'", "'Other things;'", "'Player'", "'Texture'", "'World'", "'{'", "'}'"
    };

    public static final int EOF=-1;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int COMMENT=4;
    public static final int FLOAT=5;
    public static final int INTEGER=6;
    public static final int LINEBREAK=7;
    public static final int QUOTED_4748_59=8;
    public static final int TEXT=9;
    public static final int WHITESPACE=10;

    // delegates
    public Code2DANTLRParserBase[] getDelegates() {
        return new Code2DANTLRParserBase[] {};
    }

    // delegators


    public Code2DParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public Code2DParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
        this.state.initializeRuleMemo(19 + 1);
         

    }

    public String[] getTokenNames() { return Code2DParser.tokenNames; }
    public String getGrammarFileName() { return "Code2D.g"; }


    	private nl.utwente.apc.Code2D.resource.Code2D.ICode2DTokenResolverFactory tokenResolverFactory = new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DTokenResolverFactory();
    	
    	/**
    	 * the index of the last token that was handled by collectHiddenTokens()
    	 */
    	private int lastPosition;
    	
    	/**
    	 * A flag that indicates whether the parser should remember all expected elements.
    	 * This flag is set to true when using the parse for code completion. Otherwise it
    	 * is set to false.
    	 */
    	private boolean rememberExpectedElements = false;
    	
    	private Object parseToIndexTypeObject;
    	private int lastTokenIndex = 0;
    	
    	/**
    	 * A list of expected elements the were collected while parsing the input stream.
    	 * This list is only filled if <code>rememberExpectedElements</code> is set to
    	 * true.
    	 */
    	private java.util.List<nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectedTerminal> expectedElements = new java.util.ArrayList<nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectedTerminal>();
    	
    	private int mismatchedTokenRecoveryTries = 0;
    	/**
    	 * A helper list to allow a lexer to pass errors to its parser
    	 */
    	protected java.util.List<org.antlr.runtime3_4_0.RecognitionException> lexerExceptions = java.util.Collections.synchronizedList(new java.util.ArrayList<org.antlr.runtime3_4_0.RecognitionException>());
    	
    	/**
    	 * Another helper list to allow a lexer to pass positions of errors to its parser
    	 */
    	protected java.util.List<Integer> lexerExceptionsPosition = java.util.Collections.synchronizedList(new java.util.ArrayList<Integer>());
    	
    	/**
    	 * A stack for incomplete objects. This stack is used filled when the parser is
    	 * used for code completion. Whenever the parser starts to read an object it is
    	 * pushed on the stack. Once the element was parser completely it is popped from
    	 * the stack.
    	 */
    	java.util.List<org.eclipse.emf.ecore.EObject> incompleteObjects = new java.util.ArrayList<org.eclipse.emf.ecore.EObject>();
    	
    	private int stopIncludingHiddenTokens;
    	private int stopExcludingHiddenTokens;
    	private int tokenIndexOfLastCompleteElement;
    	
    	private int expectedElementsIndexOfLastCompleteElement;
    	
    	/**
    	 * The offset indicating the cursor position when the parser is used for code
    	 * completion by calling parseToExpectedElements().
    	 */
    	private int cursorOffset;
    	
    	/**
    	 * The offset of the first hidden token of the last expected element. This offset
    	 * is used to discard expected elements, which are not needed for code completion.
    	 */
    	private int lastStartIncludingHidden;
    	
    	protected void addErrorToResource(final String errorMessage, final int column, final int line, final int startIndex, final int stopIndex) {
    		postParseCommands.add(new nl.utwente.apc.Code2D.resource.Code2D.ICode2DCommand<nl.utwente.apc.Code2D.resource.Code2D.ICode2DTextResource>() {
    			public boolean execute(nl.utwente.apc.Code2D.resource.Code2D.ICode2DTextResource resource) {
    				if (resource == null) {
    					// the resource can be null if the parser is used for code completion
    					return true;
    				}
    				resource.addProblem(new nl.utwente.apc.Code2D.resource.Code2D.ICode2DProblem() {
    					public nl.utwente.apc.Code2D.resource.Code2D.Code2DEProblemSeverity getSeverity() {
    						return nl.utwente.apc.Code2D.resource.Code2D.Code2DEProblemSeverity.ERROR;
    					}
    					public nl.utwente.apc.Code2D.resource.Code2D.Code2DEProblemType getType() {
    						return nl.utwente.apc.Code2D.resource.Code2D.Code2DEProblemType.SYNTAX_ERROR;
    					}
    					public String getMessage() {
    						return errorMessage;
    					}
    					public java.util.Collection<nl.utwente.apc.Code2D.resource.Code2D.ICode2DQuickFix> getQuickFixes() {
    						return null;
    					}
    				}, column, line, startIndex, stopIndex);
    				return true;
    			}
    		});
    	}
    	
    	public void addExpectedElement(org.eclipse.emf.ecore.EClass eClass, int[] ids) {
    		if (!this.rememberExpectedElements) {
    			return;
    		}
    		int terminalID = ids[0];
    		int followSetID = ids[1];
    		nl.utwente.apc.Code2D.resource.Code2D.ICode2DExpectedElement terminal = nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DFollowSetProvider.TERMINALS[terminalID];
    		nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DContainedFeature[] containmentFeatures = new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DContainedFeature[ids.length - 2];
    		for (int i = 2; i < ids.length; i++) {
    			containmentFeatures[i - 2] = nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DFollowSetProvider.LINKS[ids[i]];
    		}
    		nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DContainmentTrace containmentTrace = new nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DContainmentTrace(eClass, containmentFeatures);
    		org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
    		nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectedTerminal expectedElement = new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectedTerminal(container, terminal, followSetID, containmentTrace);
    		setPosition(expectedElement, input.index());
    		int startIncludingHiddenTokens = expectedElement.getStartIncludingHiddenTokens();
    		if (lastStartIncludingHidden >= 0 && lastStartIncludingHidden < startIncludingHiddenTokens && cursorOffset > startIncludingHiddenTokens) {
    			// clear list of expected elements
    			this.expectedElements.clear();
    			this.expectedElementsIndexOfLastCompleteElement = 0;
    		}
    		lastStartIncludingHidden = startIncludingHiddenTokens;
    		this.expectedElements.add(expectedElement);
    	}
    	
    	protected void collectHiddenTokens(org.eclipse.emf.ecore.EObject element) {
    	}
    	
    	protected void copyLocalizationInfos(final org.eclipse.emf.ecore.EObject source, final org.eclipse.emf.ecore.EObject target) {
    		if (disableLocationMap) {
    			return;
    		}
    		postParseCommands.add(new nl.utwente.apc.Code2D.resource.Code2D.ICode2DCommand<nl.utwente.apc.Code2D.resource.Code2D.ICode2DTextResource>() {
    			public boolean execute(nl.utwente.apc.Code2D.resource.Code2D.ICode2DTextResource resource) {
    				nl.utwente.apc.Code2D.resource.Code2D.ICode2DLocationMap locationMap = resource.getLocationMap();
    				if (locationMap == null) {
    					// the locationMap can be null if the parser is used for code completion
    					return true;
    				}
    				locationMap.setCharStart(target, locationMap.getCharStart(source));
    				locationMap.setCharEnd(target, locationMap.getCharEnd(source));
    				locationMap.setColumn(target, locationMap.getColumn(source));
    				locationMap.setLine(target, locationMap.getLine(source));
    				return true;
    			}
    		});
    	}
    	
    	protected void copyLocalizationInfos(final org.antlr.runtime3_4_0.CommonToken source, final org.eclipse.emf.ecore.EObject target) {
    		if (disableLocationMap) {
    			return;
    		}
    		postParseCommands.add(new nl.utwente.apc.Code2D.resource.Code2D.ICode2DCommand<nl.utwente.apc.Code2D.resource.Code2D.ICode2DTextResource>() {
    			public boolean execute(nl.utwente.apc.Code2D.resource.Code2D.ICode2DTextResource resource) {
    				nl.utwente.apc.Code2D.resource.Code2D.ICode2DLocationMap locationMap = resource.getLocationMap();
    				if (locationMap == null) {
    					// the locationMap can be null if the parser is used for code completion
    					return true;
    				}
    				if (source == null) {
    					return true;
    				}
    				locationMap.setCharStart(target, source.getStartIndex());
    				locationMap.setCharEnd(target, source.getStopIndex());
    				locationMap.setColumn(target, source.getCharPositionInLine());
    				locationMap.setLine(target, source.getLine());
    				return true;
    			}
    		});
    	}
    	
    	/**
    	 * Sets the end character index and the last line for the given object in the
    	 * location map.
    	 */
    	protected void setLocalizationEnd(java.util.Collection<nl.utwente.apc.Code2D.resource.Code2D.ICode2DCommand<nl.utwente.apc.Code2D.resource.Code2D.ICode2DTextResource>> postParseCommands , final org.eclipse.emf.ecore.EObject object, final int endChar, final int endLine) {
    		if (disableLocationMap) {
    			return;
    		}
    		postParseCommands.add(new nl.utwente.apc.Code2D.resource.Code2D.ICode2DCommand<nl.utwente.apc.Code2D.resource.Code2D.ICode2DTextResource>() {
    			public boolean execute(nl.utwente.apc.Code2D.resource.Code2D.ICode2DTextResource resource) {
    				nl.utwente.apc.Code2D.resource.Code2D.ICode2DLocationMap locationMap = resource.getLocationMap();
    				if (locationMap == null) {
    					// the locationMap can be null if the parser is used for code completion
    					return true;
    				}
    				locationMap.setCharEnd(object, endChar);
    				locationMap.setLine(object, endLine);
    				return true;
    			}
    		});
    	}
    	
    	public nl.utwente.apc.Code2D.resource.Code2D.ICode2DTextParser createInstance(java.io.InputStream actualInputStream, String encoding) {
    		try {
    			if (encoding == null) {
    				return new Code2DParser(new org.antlr.runtime3_4_0.CommonTokenStream(new Code2DLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream))));
    			} else {
    				return new Code2DParser(new org.antlr.runtime3_4_0.CommonTokenStream(new Code2DLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream, encoding))));
    			}
    		} catch (java.io.IOException e) {
    			new nl.utwente.apc.Code2D.resource.Code2D.util.Code2DRuntimeUtil().logError("Error while creating parser.", e);
    			return null;
    		}
    	}
    	
    	/**
    	 * This default constructor is only used to call createInstance() on it.
    	 */
    	public Code2DParser() {
    		super(null);
    	}
    	
    	protected org.eclipse.emf.ecore.EObject doParse() throws org.antlr.runtime3_4_0.RecognitionException {
    		this.lastPosition = 0;
    		// required because the lexer class can not be subclassed
    		((Code2DLexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
    		((Code2DLexer) getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
    		Object typeObject = getTypeObject();
    		if (typeObject == null) {
    			return start();
    		} else if (typeObject instanceof org.eclipse.emf.ecore.EClass) {
    			org.eclipse.emf.ecore.EClass type = (org.eclipse.emf.ecore.EClass) typeObject;
    			if (type.getInstanceClass() == nl.utwente.apc.Code2D.Game.class) {
    				return parse_nl_utwente_apc_Code2D_Game();
    			}
    			if (type.getInstanceClass() == nl.utwente.apc.Code2D.World.class) {
    				return parse_nl_utwente_apc_Code2D_World();
    			}
    			if (type.getInstanceClass() == nl.utwente.apc.Code2D.Player.class) {
    				return parse_nl_utwente_apc_Code2D_Player();
    			}
    			if (type.getInstanceClass() == nl.utwente.apc.Code2D.NPC.class) {
    				return parse_nl_utwente_apc_Code2D_NPC();
    			}
    			if (type.getInstanceClass() == nl.utwente.apc.Code2D.Item.class) {
    				return parse_nl_utwente_apc_Code2D_Item();
    			}
    		}
    		throw new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DUnexpectedContentTypeException(typeObject);
    	}
    	
    	public int getMismatchedTokenRecoveryTries() {
    		return mismatchedTokenRecoveryTries;
    	}
    	
    	public Object getMissingSymbol(org.antlr.runtime3_4_0.IntStream arg0, org.antlr.runtime3_4_0.RecognitionException arg1, int arg2, org.antlr.runtime3_4_0.BitSet arg3) {
    		mismatchedTokenRecoveryTries++;
    		return super.getMissingSymbol(arg0, arg1, arg2, arg3);
    	}
    	
    	public Object getParseToIndexTypeObject() {
    		return parseToIndexTypeObject;
    	}
    	
    	protected Object getTypeObject() {
    		Object typeObject = getParseToIndexTypeObject();
    		if (typeObject != null) {
    			return typeObject;
    		}
    		java.util.Map<?,?> options = getOptions();
    		if (options != null) {
    			typeObject = options.get(nl.utwente.apc.Code2D.resource.Code2D.ICode2DOptions.RESOURCE_CONTENT_TYPE);
    		}
    		return typeObject;
    	}
    	
    	/**
    	 * Implementation that calls {@link #doParse()} and handles the thrown
    	 * RecognitionExceptions.
    	 */
    	public nl.utwente.apc.Code2D.resource.Code2D.ICode2DParseResult parse() {
    		terminateParsing = false;
    		postParseCommands = new java.util.ArrayList<nl.utwente.apc.Code2D.resource.Code2D.ICode2DCommand<nl.utwente.apc.Code2D.resource.Code2D.ICode2DTextResource>>();
    		nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DParseResult parseResult = new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DParseResult();
    		try {
    			org.eclipse.emf.ecore.EObject result =  doParse();
    			if (lexerExceptions.isEmpty()) {
    				parseResult.setRoot(result);
    			}
    		} catch (org.antlr.runtime3_4_0.RecognitionException re) {
    			reportError(re);
    		} catch (java.lang.IllegalArgumentException iae) {
    			if ("The 'no null' constraint is violated".equals(iae.getMessage())) {
    				// can be caused if a null is set on EMF models where not allowed. this will just
    				// happen if other errors occurred before
    			} else {
    				iae.printStackTrace();
    			}
    		}
    		for (org.antlr.runtime3_4_0.RecognitionException re : lexerExceptions) {
    			reportLexicalError(re);
    		}
    		parseResult.getPostParseCommands().addAll(postParseCommands);
    		return parseResult;
    	}
    	
    	public java.util.List<nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectedTerminal> parseToExpectedElements(org.eclipse.emf.ecore.EClass type, nl.utwente.apc.Code2D.resource.Code2D.ICode2DTextResource dummyResource, int cursorOffset) {
    		this.rememberExpectedElements = true;
    		this.parseToIndexTypeObject = type;
    		this.cursorOffset = cursorOffset;
    		this.lastStartIncludingHidden = -1;
    		final org.antlr.runtime3_4_0.CommonTokenStream tokenStream = (org.antlr.runtime3_4_0.CommonTokenStream) getTokenStream();
    		nl.utwente.apc.Code2D.resource.Code2D.ICode2DParseResult result = parse();
    		for (org.eclipse.emf.ecore.EObject incompleteObject : incompleteObjects) {
    			org.antlr.runtime3_4_0.Lexer lexer = (org.antlr.runtime3_4_0.Lexer) tokenStream.getTokenSource();
    			int endChar = lexer.getCharIndex();
    			int endLine = lexer.getLine();
    			setLocalizationEnd(result.getPostParseCommands(), incompleteObject, endChar, endLine);
    		}
    		if (result != null) {
    			org.eclipse.emf.ecore.EObject root = result.getRoot();
    			if (root != null) {
    				dummyResource.getContentsInternal().add(root);
    			}
    			for (nl.utwente.apc.Code2D.resource.Code2D.ICode2DCommand<nl.utwente.apc.Code2D.resource.Code2D.ICode2DTextResource> command : result.getPostParseCommands()) {
    				command.execute(dummyResource);
    			}
    		}
    		// remove all expected elements that were added after the last complete element
    		expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);
    		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
    		java.util.Set<nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectedTerminal> currentFollowSet = new java.util.LinkedHashSet<nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectedTerminal>();
    		java.util.List<nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectedTerminal> newFollowSet = new java.util.ArrayList<nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectedTerminal>();
    		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
    			nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectedTerminal expectedElementI = expectedElements.get(i);
    			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
    				currentFollowSet.add(expectedElementI);
    			} else {
    				break;
    			}
    		}
    		int followSetID = 47;
    		int i;
    		for (i = tokenIndexOfLastCompleteElement; i < tokenStream.size(); i++) {
    			org.antlr.runtime3_4_0.CommonToken nextToken = (org.antlr.runtime3_4_0.CommonToken) tokenStream.get(i);
    			if (nextToken.getType() < 0) {
    				break;
    			}
    			if (nextToken.getChannel() == 99) {
    				// hidden tokens do not reduce the follow set
    			} else {
    				// now that we have found the next visible token the position for that expected
    				// terminals can be set
    				for (nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectedTerminal nextFollow : newFollowSet) {
    					lastTokenIndex = 0;
    					setPosition(nextFollow, i);
    				}
    				newFollowSet.clear();
    				// normal tokens do reduce the follow set - only elements that match the token are
    				// kept
    				for (nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectedTerminal nextFollow : currentFollowSet) {
    					if (nextFollow.getTerminal().getTokenNames().contains(getTokenNames()[nextToken.getType()])) {
    						// keep this one - it matches
    						java.util.Collection<nl.utwente.apc.Code2D.resource.Code2D.util.Code2DPair<nl.utwente.apc.Code2D.resource.Code2D.ICode2DExpectedElement, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DContainedFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
    						for (nl.utwente.apc.Code2D.resource.Code2D.util.Code2DPair<nl.utwente.apc.Code2D.resource.Code2D.ICode2DExpectedElement, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DContainedFeature[]> newFollowerPair : newFollowers) {
    							nl.utwente.apc.Code2D.resource.Code2D.ICode2DExpectedElement newFollower = newFollowerPair.getLeft();
    							org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
    							nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DContainmentTrace containmentTrace = new nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DContainmentTrace(null, newFollowerPair.getRight());
    							nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectedTerminal newFollowTerminal = new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectedTerminal(container, newFollower, followSetID, containmentTrace);
    							newFollowSet.add(newFollowTerminal);
    							expectedElements.add(newFollowTerminal);
    						}
    					}
    				}
    				currentFollowSet.clear();
    				currentFollowSet.addAll(newFollowSet);
    			}
    			followSetID++;
    		}
    		// after the last token in the stream we must set the position for the elements
    		// that were added during the last iteration of the loop
    		for (nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectedTerminal nextFollow : newFollowSet) {
    			lastTokenIndex = 0;
    			setPosition(nextFollow, i);
    		}
    		return this.expectedElements;
    	}
    	
    	public void setPosition(nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectedTerminal expectedElement, int tokenIndex) {
    		int currentIndex = Math.max(0, tokenIndex);
    		for (int index = lastTokenIndex; index < currentIndex; index++) {
    			if (index >= input.size()) {
    				break;
    			}
    			org.antlr.runtime3_4_0.CommonToken tokenAtIndex = (org.antlr.runtime3_4_0.CommonToken) input.get(index);
    			stopIncludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;
    			if (tokenAtIndex.getChannel() != 99 && !anonymousTokens.contains(tokenAtIndex)) {
    				stopExcludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;
    			}
    		}
    		lastTokenIndex = Math.max(0, currentIndex);
    		expectedElement.setPosition(stopExcludingHiddenTokens, stopIncludingHiddenTokens);
    	}
    	
    	public Object recoverFromMismatchedToken(org.antlr.runtime3_4_0.IntStream input, int ttype, org.antlr.runtime3_4_0.BitSet follow) throws org.antlr.runtime3_4_0.RecognitionException {
    		if (!rememberExpectedElements) {
    			return super.recoverFromMismatchedToken(input, ttype, follow);
    		} else {
    			return null;
    		}
    	}
    	
    	/**
    	 * Translates errors thrown by the parser into human readable messages.
    	 */
    	public void reportError(final org.antlr.runtime3_4_0.RecognitionException e)  {
    		String message = e.getMessage();
    		if (e instanceof org.antlr.runtime3_4_0.MismatchedTokenException) {
    			org.antlr.runtime3_4_0.MismatchedTokenException mte = (org.antlr.runtime3_4_0.MismatchedTokenException) e;
    			String expectedTokenName = formatTokenName(mte.expecting);
    			String actualTokenName = formatTokenName(e.token.getType());
    			message = "Syntax error on token \"" + e.token.getText() + " (" + actualTokenName + ")\", \"" + expectedTokenName + "\" expected";
    		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedTreeNodeException) {
    			org.antlr.runtime3_4_0.MismatchedTreeNodeException mtne = (org.antlr.runtime3_4_0.MismatchedTreeNodeException) e;
    			String expectedTokenName = formatTokenName(mtne.expecting);
    			message = "mismatched tree node: " + "xxx" + "; tokenName " + expectedTokenName;
    		} else if (e instanceof org.antlr.runtime3_4_0.NoViableAltException) {
    			message = "Syntax error on token \"" + e.token.getText() + "\", check following tokens";
    		} else if (e instanceof org.antlr.runtime3_4_0.EarlyExitException) {
    			message = "Syntax error on token \"" + e.token.getText() + "\", delete this token";
    		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedSetException) {
    			org.antlr.runtime3_4_0.MismatchedSetException mse = (org.antlr.runtime3_4_0.MismatchedSetException) e;
    			message = "mismatched token: " + e.token + "; expecting set " + mse.expecting;
    		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedNotSetException) {
    			org.antlr.runtime3_4_0.MismatchedNotSetException mse = (org.antlr.runtime3_4_0.MismatchedNotSetException) e;
    			message = "mismatched token: " +  e.token + "; expecting set " + mse.expecting;
    		} else if (e instanceof org.antlr.runtime3_4_0.FailedPredicateException) {
    			org.antlr.runtime3_4_0.FailedPredicateException fpe = (org.antlr.runtime3_4_0.FailedPredicateException) e;
    			message = "rule " + fpe.ruleName + " failed predicate: {" +  fpe.predicateText + "}?";
    		}
    		// the resource may be null if the parser is used for code completion
    		final String finalMessage = message;
    		if (e.token instanceof org.antlr.runtime3_4_0.CommonToken) {
    			final org.antlr.runtime3_4_0.CommonToken ct = (org.antlr.runtime3_4_0.CommonToken) e.token;
    			addErrorToResource(finalMessage, ct.getCharPositionInLine(), ct.getLine(), ct.getStartIndex(), ct.getStopIndex());
    		} else {
    			addErrorToResource(finalMessage, e.token.getCharPositionInLine(), e.token.getLine(), 1, 5);
    		}
    	}
    	
    	/**
    	 * Translates errors thrown by the lexer into human readable messages.
    	 */
    	public void reportLexicalError(final org.antlr.runtime3_4_0.RecognitionException e)  {
    		String message = "";
    		if (e instanceof org.antlr.runtime3_4_0.MismatchedTokenException) {
    			org.antlr.runtime3_4_0.MismatchedTokenException mte = (org.antlr.runtime3_4_0.MismatchedTokenException) e;
    			message = "Syntax error on token \"" + ((char) e.c) + "\", \"" + (char) mte.expecting + "\" expected";
    		} else if (e instanceof org.antlr.runtime3_4_0.NoViableAltException) {
    			message = "Syntax error on token \"" + ((char) e.c) + "\", delete this token";
    		} else if (e instanceof org.antlr.runtime3_4_0.EarlyExitException) {
    			org.antlr.runtime3_4_0.EarlyExitException eee = (org.antlr.runtime3_4_0.EarlyExitException) e;
    			message = "required (...)+ loop (decision=" + eee.decisionNumber + ") did not match anything; on line " + e.line + ":" + e.charPositionInLine + " char=" + ((char) e.c) + "'";
    		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedSetException) {
    			org.antlr.runtime3_4_0.MismatchedSetException mse = (org.antlr.runtime3_4_0.MismatchedSetException) e;
    			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set " + mse.expecting;
    		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedNotSetException) {
    			org.antlr.runtime3_4_0.MismatchedNotSetException mse = (org.antlr.runtime3_4_0.MismatchedNotSetException) e;
    			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set " + mse.expecting;
    		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedRangeException) {
    			org.antlr.runtime3_4_0.MismatchedRangeException mre = (org.antlr.runtime3_4_0.MismatchedRangeException) e;
    			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set '" + (char) mre.a + "'..'" + (char) mre.b + "'";
    		} else if (e instanceof org.antlr.runtime3_4_0.FailedPredicateException) {
    			org.antlr.runtime3_4_0.FailedPredicateException fpe = (org.antlr.runtime3_4_0.FailedPredicateException) e;
    			message = "rule " + fpe.ruleName + " failed predicate: {" + fpe.predicateText + "}?";
    		}
    		addErrorToResource(message, e.charPositionInLine, e.line, lexerExceptionsPosition.get(lexerExceptions.indexOf(e)), lexerExceptionsPosition.get(lexerExceptions.indexOf(e)));
    	}
    	
    	private void startIncompleteElement(Object object) {
    		if (object instanceof org.eclipse.emf.ecore.EObject) {
    			this.incompleteObjects.add((org.eclipse.emf.ecore.EObject) object);
    		}
    	}
    	
    	private void completedElement(Object object, boolean isContainment) {
    		if (isContainment && !this.incompleteObjects.isEmpty()) {
    			boolean exists = this.incompleteObjects.remove(object);
    			if (!exists) {
    			}
    		}
    		if (object instanceof org.eclipse.emf.ecore.EObject) {
    			this.tokenIndexOfLastCompleteElement = getTokenStream().index();
    			this.expectedElementsIndexOfLastCompleteElement = expectedElements.size() - 1;
    		}
    	}
    	
    	private org.eclipse.emf.ecore.EObject getLastIncompleteElement() {
    		if (incompleteObjects.isEmpty()) {
    			return null;
    		}
    		return incompleteObjects.get(incompleteObjects.size() - 1);
    	}
    	



    // $ANTLR start "start"
    // Code2D.g:511:1: start returns [ org.eclipse.emf.ecore.EObject element = null] : (c0= parse_nl_utwente_apc_Code2D_Game ) EOF ;
    public final org.eclipse.emf.ecore.EObject start() throws RecognitionException {
        org.eclipse.emf.ecore.EObject element =  null;

        int start_StartIndex = input.index();

        nl.utwente.apc.Code2D.Game c0 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }

            // Code2D.g:512:2: ( (c0= parse_nl_utwente_apc_Code2D_Game ) EOF )
            // Code2D.g:513:2: (c0= parse_nl_utwente_apc_Code2D_Game ) EOF
            {
            if ( state.backtracking==0 ) {
            		// follow set for start rule(s)
            		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[0]);
            		expectedElementsIndexOfLastCompleteElement = 0;
            	}

            // Code2D.g:518:2: (c0= parse_nl_utwente_apc_Code2D_Game )
            // Code2D.g:519:3: c0= parse_nl_utwente_apc_Code2D_Game
            {
            pushFollow(FOLLOW_parse_nl_utwente_apc_Code2D_Game_in_start82);
            c0=parse_nl_utwente_apc_Code2D_Game();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) { element = c0; }

            }


            match(input,EOF,FOLLOW_EOF_in_start89); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		retrieveLayoutInformation(element, null, null, false);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 1, start_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "start"



    // $ANTLR start "parse_nl_utwente_apc_Code2D_Game"
    // Code2D.g:527:1: parse_nl_utwente_apc_Code2D_Game returns [nl.utwente.apc.Code2D.Game element = null] : a0= 'Game' (a1= TEXT ) a2= '{' ( ( (a3_0= parse_nl_utwente_apc_Code2D_World ) | (a4_0= parse_nl_utwente_apc_Code2D_GameObject ) ) )* a5= '}' ;
    public final nl.utwente.apc.Code2D.Game parse_nl_utwente_apc_Code2D_Game() throws RecognitionException {
        nl.utwente.apc.Code2D.Game element =  null;

        int parse_nl_utwente_apc_Code2D_Game_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a5=null;
        nl.utwente.apc.Code2D.World a3_0 =null;

        nl.utwente.apc.Code2D.GameObject a4_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }

            // Code2D.g:530:2: (a0= 'Game' (a1= TEXT ) a2= '{' ( ( (a3_0= parse_nl_utwente_apc_Code2D_World ) | (a4_0= parse_nl_utwente_apc_Code2D_GameObject ) ) )* a5= '}' )
            // Code2D.g:531:2: a0= 'Game' (a1= TEXT ) a2= '{' ( ( (a3_0= parse_nl_utwente_apc_Code2D_World ) | (a4_0= parse_nl_utwente_apc_Code2D_GameObject ) ) )* a5= '}'
            {
            a0=(Token)match(input,15,FOLLOW_15_in_parse_nl_utwente_apc_Code2D_Game115); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createGame();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_0_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[1]);
            	}

            // Code2D.g:545:2: (a1= TEXT )
            // Code2D.g:546:3: a1= TEXT
            {
            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_nl_utwente_apc_Code2D_Game133); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DTerminateParsingException();
            			}
            			if (element == null) {
            				element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createGame();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				nl.utwente.apc.Code2D.resource.Code2D.ICode2DTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				nl.utwente.apc.Code2D.resource.Code2D.ICode2DTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.GAME__NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.GAME__NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_0_0_0_1, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[2]);
            	}

            a2=(Token)match(input,24,FOLLOW_24_in_parse_nl_utwente_apc_Code2D_Game154); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createGame();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_0_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[3]);
            		addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[4]);
            		addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[5]);
            		addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[6]);
            		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[7]);
            	}

            // Code2D.g:599:2: ( ( (a3_0= parse_nl_utwente_apc_Code2D_World ) | (a4_0= parse_nl_utwente_apc_Code2D_GameObject ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= 17 && LA2_0 <= 18)||LA2_0==21||LA2_0==23) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Code2D.g:600:3: ( (a3_0= parse_nl_utwente_apc_Code2D_World ) | (a4_0= parse_nl_utwente_apc_Code2D_GameObject ) )
            	    {
            	    // Code2D.g:600:3: ( (a3_0= parse_nl_utwente_apc_Code2D_World ) | (a4_0= parse_nl_utwente_apc_Code2D_GameObject ) )
            	    int alt1=2;
            	    int LA1_0 = input.LA(1);

            	    if ( (LA1_0==23) ) {
            	        alt1=1;
            	    }
            	    else if ( ((LA1_0 >= 17 && LA1_0 <= 18)||LA1_0==21) ) {
            	        alt1=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return element;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 1, 0, input);

            	        throw nvae;

            	    }
            	    switch (alt1) {
            	        case 1 :
            	            // Code2D.g:601:4: (a3_0= parse_nl_utwente_apc_Code2D_World )
            	            {
            	            // Code2D.g:601:4: (a3_0= parse_nl_utwente_apc_Code2D_World )
            	            // Code2D.g:602:5: a3_0= parse_nl_utwente_apc_Code2D_World
            	            {
            	            pushFollow(FOLLOW_parse_nl_utwente_apc_Code2D_World_in_parse_nl_utwente_apc_Code2D_Game183);
            	            a3_0=parse_nl_utwente_apc_Code2D_World();

            	            state._fsp--;
            	            if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createGame();
            	            						startIncompleteElement(element);
            	            					}
            	            					if (a3_0 != null) {
            	            						if (a3_0 != null) {
            	            							Object value = a3_0;
            	            							element.eSet(element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.GAME__GAME_WORLD), value);
            	            							completedElement(value, true);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_0_0_0_3_0_0_0, a3_0, true);
            	            						copyLocalizationInfos(a3_0, element);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[8]);
            	            				addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[9]);
            	            				addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[10]);
            	            				addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[11]);
            	            				addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[12]);
            	            			}

            	            }
            	            break;
            	        case 2 :
            	            // Code2D.g:632:8: (a4_0= parse_nl_utwente_apc_Code2D_GameObject )
            	            {
            	            // Code2D.g:632:8: (a4_0= parse_nl_utwente_apc_Code2D_GameObject )
            	            // Code2D.g:633:5: a4_0= parse_nl_utwente_apc_Code2D_GameObject
            	            {
            	            pushFollow(FOLLOW_parse_nl_utwente_apc_Code2D_GameObject_in_parse_nl_utwente_apc_Code2D_Game225);
            	            a4_0=parse_nl_utwente_apc_Code2D_GameObject();

            	            state._fsp--;
            	            if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createGame();
            	            						startIncompleteElement(element);
            	            					}
            	            					if (a4_0 != null) {
            	            						if (a4_0 != null) {
            	            							Object value = a4_0;
            	            							addObjectToList(element, nl.utwente.apc.Code2D.Code2DPackage.GAME__GAME_OBJECTS, value);
            	            							completedElement(value, true);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_0_0_0_3_0_1_0, a4_0, true);
            	            						copyLocalizationInfos(a4_0, element);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[13]);
            	            				addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[14]);
            	            				addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[15]);
            	            				addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[16]);
            	            				addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[17]);
            	            			}

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[18]);
            		addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[19]);
            		addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[20]);
            		addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[21]);
            		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[22]);
            	}

            a5=(Token)match(input,25,FOLLOW_25_in_parse_nl_utwente_apc_Code2D_Game266); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createGame();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_0_0_0_4, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 2, parse_nl_utwente_apc_Code2D_Game_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_nl_utwente_apc_Code2D_Game"



    // $ANTLR start "parse_nl_utwente_apc_Code2D_World"
    // Code2D.g:688:1: parse_nl_utwente_apc_Code2D_World returns [nl.utwente.apc.Code2D.World element = null] : a0= 'World' (a1= TEXT ) a2= '{' ( (a3= 'Other things;' ) )* a4= '}' ;
    public final nl.utwente.apc.Code2D.World parse_nl_utwente_apc_Code2D_World() throws RecognitionException {
        nl.utwente.apc.Code2D.World element =  null;

        int parse_nl_utwente_apc_Code2D_World_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return element; }

            // Code2D.g:691:2: (a0= 'World' (a1= TEXT ) a2= '{' ( (a3= 'Other things;' ) )* a4= '}' )
            // Code2D.g:692:2: a0= 'World' (a1= TEXT ) a2= '{' ( (a3= 'Other things;' ) )* a4= '}'
            {
            a0=(Token)match(input,23,FOLLOW_23_in_parse_nl_utwente_apc_Code2D_World295); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createWorld();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_1_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[23]);
            	}

            // Code2D.g:706:2: (a1= TEXT )
            // Code2D.g:707:3: a1= TEXT
            {
            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_nl_utwente_apc_Code2D_World313); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DTerminateParsingException();
            			}
            			if (element == null) {
            				element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createWorld();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				nl.utwente.apc.Code2D.resource.Code2D.ICode2DTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				nl.utwente.apc.Code2D.resource.Code2D.ICode2DTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.WORLD__NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.WORLD__NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_1_0_0_1, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[24]);
            	}

            a2=(Token)match(input,24,FOLLOW_24_in_parse_nl_utwente_apc_Code2D_World334); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createWorld();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_1_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[25]);
            		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[26]);
            	}

            // Code2D.g:757:2: ( (a3= 'Other things;' ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==20) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Code2D.g:758:3: (a3= 'Other things;' )
            	    {
            	    // Code2D.g:758:3: (a3= 'Other things;' )
            	    // Code2D.g:759:4: a3= 'Other things;'
            	    {
            	    a3=(Token)match(input,20,FOLLOW_20_in_parse_nl_utwente_apc_Code2D_World357); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createWorld();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_1_0_0_3_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[27]);
            	    				addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[28]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[29]);
            		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[30]);
            	}

            a4=(Token)match(input,25,FOLLOW_25_in_parse_nl_utwente_apc_Code2D_World390); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createWorld();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_1_0_0_4, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[31]);
            		addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[32]);
            		addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[33]);
            		addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[34]);
            		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[35]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, parse_nl_utwente_apc_Code2D_World_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_nl_utwente_apc_Code2D_World"



    // $ANTLR start "parse_nl_utwente_apc_Code2D_Player"
    // Code2D.g:802:1: parse_nl_utwente_apc_Code2D_Player returns [nl.utwente.apc.Code2D.Player element = null] : a0= 'Player' (a1= TEXT ) a2= '{' ( (a3= 'Texture' a4= ':' (a5= QUOTED_4748_59 ) ) )* a6= '}' ;
    public final nl.utwente.apc.Code2D.Player parse_nl_utwente_apc_Code2D_Player() throws RecognitionException {
        nl.utwente.apc.Code2D.Player element =  null;

        int parse_nl_utwente_apc_Code2D_Player_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }

            // Code2D.g:805:2: (a0= 'Player' (a1= TEXT ) a2= '{' ( (a3= 'Texture' a4= ':' (a5= QUOTED_4748_59 ) ) )* a6= '}' )
            // Code2D.g:806:2: a0= 'Player' (a1= TEXT ) a2= '{' ( (a3= 'Texture' a4= ':' (a5= QUOTED_4748_59 ) ) )* a6= '}'
            {
            a0=(Token)match(input,21,FOLLOW_21_in_parse_nl_utwente_apc_Code2D_Player419); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createPlayer();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_2_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[36]);
            	}

            // Code2D.g:820:2: (a1= TEXT )
            // Code2D.g:821:3: a1= TEXT
            {
            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_nl_utwente_apc_Code2D_Player437); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DTerminateParsingException();
            			}
            			if (element == null) {
            				element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createPlayer();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				nl.utwente.apc.Code2D.resource.Code2D.ICode2DTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				nl.utwente.apc.Code2D.resource.Code2D.ICode2DTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.PLAYER__NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.PLAYER__NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_2_0_0_1, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[37]);
            	}

            a2=(Token)match(input,24,FOLLOW_24_in_parse_nl_utwente_apc_Code2D_Player458); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createPlayer();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_2_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[38]);
            		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[39]);
            	}

            // Code2D.g:871:2: ( (a3= 'Texture' a4= ':' (a5= QUOTED_4748_59 ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==22) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // Code2D.g:872:3: (a3= 'Texture' a4= ':' (a5= QUOTED_4748_59 ) )
            	    {
            	    // Code2D.g:872:3: (a3= 'Texture' a4= ':' (a5= QUOTED_4748_59 ) )
            	    // Code2D.g:873:4: a3= 'Texture' a4= ':' (a5= QUOTED_4748_59 )
            	    {
            	    a3=(Token)match(input,22,FOLLOW_22_in_parse_nl_utwente_apc_Code2D_Player481); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createPlayer();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_2_0_0_3_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[40]);
            	    			}

            	    a4=(Token)match(input,11,FOLLOW_11_in_parse_nl_utwente_apc_Code2D_Player501); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createPlayer();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_2_0_0_3_0_0_1, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[41]);
            	    			}

            	    // Code2D.g:901:4: (a5= QUOTED_4748_59 )
            	    // Code2D.g:902:5: a5= QUOTED_4748_59
            	    {
            	    a5=(Token)match(input,QUOTED_4748_59,FOLLOW_QUOTED_4748_59_in_parse_nl_utwente_apc_Code2D_Player527); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createPlayer();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a5 != null) {
            	    						nl.utwente.apc.Code2D.resource.Code2D.ICode2DTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_4748_59");
            	    						tokenResolver.setOptions(getOptions());
            	    						nl.utwente.apc.Code2D.resource.Code2D.ICode2DTokenResolveResult result = getFreshTokenResolveResult();
            	    						tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.PLAYER__TEXTURE), result);
            	    						Object resolvedObject = result.getResolvedToken();
            	    						if (resolvedObject == null) {
            	    							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a5).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a5).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a5).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a5).getStopIndex());
            	    						}
            	    						java.lang.String resolved = (java.lang.String) resolvedObject;
            	    						if (resolved != null) {
            	    							Object value = resolved;
            	    							element.eSet(element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.PLAYER__TEXTURE), value);
            	    							completedElement(value, false);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_2_0_0_3_0_0_2, resolved, true);
            	    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a5, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[42]);
            	    				addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[43]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[44]);
            		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[45]);
            	}

            a6=(Token)match(input,25,FOLLOW_25_in_parse_nl_utwente_apc_Code2D_Player573); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createPlayer();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_2_0_0_4, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[46]);
            		addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[47]);
            		addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[48]);
            		addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[49]);
            		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[50]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 4, parse_nl_utwente_apc_Code2D_Player_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_nl_utwente_apc_Code2D_Player"



    // $ANTLR start "parse_nl_utwente_apc_Code2D_NPC"
    // Code2D.g:966:1: parse_nl_utwente_apc_Code2D_NPC returns [nl.utwente.apc.Code2D.NPC element = null] : a0= 'NPC' (a1= TEXT ) ( (a2= ':' (a3= TEXT ) ) )* a4= '{' ( (a5= 'Texture' a6= ':' (a7= TEXT ) a8= ';' |a9= 'Behaviour' a10= ':' ( (a11= 'Friendly' |a12= 'Neutral' |a13= 'Hostile' ) ) a16= ';' ) )* a17= '}' ;
    public final nl.utwente.apc.Code2D.NPC parse_nl_utwente_apc_Code2D_NPC() throws RecognitionException {
        nl.utwente.apc.Code2D.NPC element =  null;

        int parse_nl_utwente_apc_Code2D_NPC_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;
        Token a7=null;
        Token a8=null;
        Token a9=null;
        Token a10=null;
        Token a11=null;
        Token a12=null;
        Token a13=null;
        Token a16=null;
        Token a17=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return element; }

            // Code2D.g:969:2: (a0= 'NPC' (a1= TEXT ) ( (a2= ':' (a3= TEXT ) ) )* a4= '{' ( (a5= 'Texture' a6= ':' (a7= TEXT ) a8= ';' |a9= 'Behaviour' a10= ':' ( (a11= 'Friendly' |a12= 'Neutral' |a13= 'Hostile' ) ) a16= ';' ) )* a17= '}' )
            // Code2D.g:970:2: a0= 'NPC' (a1= TEXT ) ( (a2= ':' (a3= TEXT ) ) )* a4= '{' ( (a5= 'Texture' a6= ':' (a7= TEXT ) a8= ';' |a9= 'Behaviour' a10= ':' ( (a11= 'Friendly' |a12= 'Neutral' |a13= 'Hostile' ) ) a16= ';' ) )* a17= '}'
            {
            a0=(Token)match(input,18,FOLLOW_18_in_parse_nl_utwente_apc_Code2D_NPC602); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createNPC();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_3_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[51]);
            	}

            // Code2D.g:984:2: (a1= TEXT )
            // Code2D.g:985:3: a1= TEXT
            {
            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_nl_utwente_apc_Code2D_NPC620); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DTerminateParsingException();
            			}
            			if (element == null) {
            				element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createNPC();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				nl.utwente.apc.Code2D.resource.Code2D.ICode2DTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				nl.utwente.apc.Code2D.resource.Code2D.ICode2DTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.NPC__NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.NPC__NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_3_0_0_1, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[52]);
            		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[53]);
            	}

            // Code2D.g:1021:2: ( (a2= ':' (a3= TEXT ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==11) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // Code2D.g:1022:3: (a2= ':' (a3= TEXT ) )
            	    {
            	    // Code2D.g:1022:3: (a2= ':' (a3= TEXT ) )
            	    // Code2D.g:1023:4: a2= ':' (a3= TEXT )
            	    {
            	    a2=(Token)match(input,11,FOLLOW_11_in_parse_nl_utwente_apc_Code2D_NPC650); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createNPC();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_3_0_0_2_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[54]);
            	    			}

            	    // Code2D.g:1037:4: (a3= TEXT )
            	    // Code2D.g:1038:5: a3= TEXT
            	    {
            	    a3=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_nl_utwente_apc_Code2D_NPC676); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createNPC();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a3 != null) {
            	    						nl.utwente.apc.Code2D.resource.Code2D.ICode2DTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            	    						tokenResolver.setOptions(getOptions());
            	    						nl.utwente.apc.Code2D.resource.Code2D.ICode2DTokenResolveResult result = getFreshTokenResolveResult();
            	    						tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.NPC__EXTENDS), result);
            	    						Object resolvedObject = result.getResolvedToken();
            	    						if (resolvedObject == null) {
            	    							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStopIndex());
            	    						}
            	    						String resolved = (String) resolvedObject;
            	    						nl.utwente.apc.Code2D.NPC proxy = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createNPC();
            	    						collectHiddenTokens(element);
            	    						registerContextDependentProxy(new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DContextDependentURIFragmentFactory<nl.utwente.apc.Code2D.NPC, nl.utwente.apc.Code2D.NPC>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getNPCExtendsReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.NPC__EXTENDS), resolved, proxy);
            	    						if (proxy != null) {
            	    							Object value = proxy;
            	    							element.eSet(element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.NPC__EXTENDS), value);
            	    							completedElement(value, false);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_3_0_0_2_0_0_1, proxy, true);
            	    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, element);
            	    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, proxy);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[55]);
            	    				addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[56]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[57]);
            		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[58]);
            	}

            a4=(Token)match(input,24,FOLLOW_24_in_parse_nl_utwente_apc_Code2D_NPC722); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createNPC();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_3_0_0_3, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[59]);
            		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[60]);
            		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[61]);
            	}

            // Code2D.g:1102:2: ( (a5= 'Texture' a6= ':' (a7= TEXT ) a8= ';' |a9= 'Behaviour' a10= ':' ( (a11= 'Friendly' |a12= 'Neutral' |a13= 'Hostile' ) ) a16= ';' ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==13||LA8_0==22) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // Code2D.g:1103:3: (a5= 'Texture' a6= ':' (a7= TEXT ) a8= ';' |a9= 'Behaviour' a10= ':' ( (a11= 'Friendly' |a12= 'Neutral' |a13= 'Hostile' ) ) a16= ';' )
            	    {
            	    // Code2D.g:1103:3: (a5= 'Texture' a6= ':' (a7= TEXT ) a8= ';' |a9= 'Behaviour' a10= ':' ( (a11= 'Friendly' |a12= 'Neutral' |a13= 'Hostile' ) ) a16= ';' )
            	    int alt7=2;
            	    int LA7_0 = input.LA(1);

            	    if ( (LA7_0==22) ) {
            	        alt7=1;
            	    }
            	    else if ( (LA7_0==13) ) {
            	        alt7=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return element;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 7, 0, input);

            	        throw nvae;

            	    }
            	    switch (alt7) {
            	        case 1 :
            	            // Code2D.g:1104:4: a5= 'Texture' a6= ':' (a7= TEXT ) a8= ';'
            	            {
            	            a5=(Token)match(input,22,FOLLOW_22_in_parse_nl_utwente_apc_Code2D_NPC745); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createNPC();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_3_0_0_4_0_0_0, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[62]);
            	            			}

            	            a6=(Token)match(input,11,FOLLOW_11_in_parse_nl_utwente_apc_Code2D_NPC765); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createNPC();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_3_0_0_4_0_0_1, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[63]);
            	            			}

            	            // Code2D.g:1132:4: (a7= TEXT )
            	            // Code2D.g:1133:5: a7= TEXT
            	            {
            	            a7=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_nl_utwente_apc_Code2D_NPC791); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createNPC();
            	            						startIncompleteElement(element);
            	            					}
            	            					if (a7 != null) {
            	            						nl.utwente.apc.Code2D.resource.Code2D.ICode2DTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            	            						tokenResolver.setOptions(getOptions());
            	            						nl.utwente.apc.Code2D.resource.Code2D.ICode2DTokenResolveResult result = getFreshTokenResolveResult();
            	            						tokenResolver.resolve(a7.getText(), element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.NPC__TEXTURE), result);
            	            						Object resolvedObject = result.getResolvedToken();
            	            						if (resolvedObject == null) {
            	            							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a7).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStopIndex());
            	            						}
            	            						java.lang.String resolved = (java.lang.String) resolvedObject;
            	            						if (resolved != null) {
            	            							Object value = resolved;
            	            							element.eSet(element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.NPC__TEXTURE), value);
            	            							completedElement(value, false);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_3_0_0_4_0_0_2, resolved, true);
            	            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a7, element);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[64]);
            	            			}

            	            a8=(Token)match(input,12,FOLLOW_12_in_parse_nl_utwente_apc_Code2D_NPC824); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createNPC();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_3_0_0_4_0_0_3, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[65]);
            	            				addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[66]);
            	            				addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[67]);
            	            			}

            	            }
            	            break;
            	        case 2 :
            	            // Code2D.g:1185:8: a9= 'Behaviour' a10= ':' ( (a11= 'Friendly' |a12= 'Neutral' |a13= 'Hostile' ) ) a16= ';'
            	            {
            	            a9=(Token)match(input,13,FOLLOW_13_in_parse_nl_utwente_apc_Code2D_NPC852); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createNPC();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_3_0_0_4_0_1_0, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[68]);
            	            			}

            	            a10=(Token)match(input,11,FOLLOW_11_in_parse_nl_utwente_apc_Code2D_NPC872); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createNPC();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_3_0_0_4_0_1_1, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a10, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[69]);
            	            			}

            	            // Code2D.g:1213:4: ( (a11= 'Friendly' |a12= 'Neutral' |a13= 'Hostile' ) )
            	            // Code2D.g:1214:5: (a11= 'Friendly' |a12= 'Neutral' |a13= 'Hostile' )
            	            {
            	            // Code2D.g:1214:5: (a11= 'Friendly' |a12= 'Neutral' |a13= 'Hostile' )
            	            int alt6=3;
            	            switch ( input.LA(1) ) {
            	            case 14:
            	                {
            	                alt6=1;
            	                }
            	                break;
            	            case 19:
            	                {
            	                alt6=2;
            	                }
            	                break;
            	            case 16:
            	                {
            	                alt6=3;
            	                }
            	                break;
            	            default:
            	                if (state.backtracking>0) {state.failed=true; return element;}
            	                NoViableAltException nvae =
            	                    new NoViableAltException("", 6, 0, input);

            	                throw nvae;

            	            }

            	            switch (alt6) {
            	                case 1 :
            	                    // Code2D.g:1215:6: a11= 'Friendly'
            	                    {
            	                    a11=(Token)match(input,14,FOLLOW_14_in_parse_nl_utwente_apc_Code2D_NPC905); if (state.failed) return element;

            	                    if ( state.backtracking==0 ) {
            	                    						if (element == null) {
            	                    							element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createNPC();
            	                    							startIncompleteElement(element);
            	                    						}
            	                    						collectHiddenTokens(element);
            	                    						retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_3_0_0_4_0_1_2, null, true);
            	                    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a11, element);
            	                    						// set value of enumeration attribute
            	                    						Object value = nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getNPCBehaviour().getEEnumLiteral(nl.utwente.apc.Code2D.NPCBehaviour.FRIENDLY_VALUE).getInstance();
            	                    						element.eSet(element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.NPC__BEHAVIOUR), value);
            	                    						completedElement(value, false);
            	                    					}

            	                    }
            	                    break;
            	                case 2 :
            	                    // Code2D.g:1228:12: a12= 'Neutral'
            	                    {
            	                    a12=(Token)match(input,19,FOLLOW_19_in_parse_nl_utwente_apc_Code2D_NPC924); if (state.failed) return element;

            	                    if ( state.backtracking==0 ) {
            	                    						if (element == null) {
            	                    							element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createNPC();
            	                    							startIncompleteElement(element);
            	                    						}
            	                    						collectHiddenTokens(element);
            	                    						retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_3_0_0_4_0_1_2, null, true);
            	                    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a12, element);
            	                    						// set value of enumeration attribute
            	                    						Object value = nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getNPCBehaviour().getEEnumLiteral(nl.utwente.apc.Code2D.NPCBehaviour.NEUTRAL_VALUE).getInstance();
            	                    						element.eSet(element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.NPC__BEHAVIOUR), value);
            	                    						completedElement(value, false);
            	                    					}

            	                    }
            	                    break;
            	                case 3 :
            	                    // Code2D.g:1241:12: a13= 'Hostile'
            	                    {
            	                    a13=(Token)match(input,16,FOLLOW_16_in_parse_nl_utwente_apc_Code2D_NPC943); if (state.failed) return element;

            	                    if ( state.backtracking==0 ) {
            	                    						if (element == null) {
            	                    							element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createNPC();
            	                    							startIncompleteElement(element);
            	                    						}
            	                    						collectHiddenTokens(element);
            	                    						retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_3_0_0_4_0_1_2, null, true);
            	                    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a13, element);
            	                    						// set value of enumeration attribute
            	                    						Object value = nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getNPCBehaviour().getEEnumLiteral(nl.utwente.apc.Code2D.NPCBehaviour.HOSTILE_VALUE).getInstance();
            	                    						element.eSet(element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.NPC__BEHAVIOUR), value);
            	                    						completedElement(value, false);
            	                    					}

            	                    }
            	                    break;

            	            }


            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[70]);
            	            			}

            	            a16=(Token)match(input,12,FOLLOW_12_in_parse_nl_utwente_apc_Code2D_NPC974); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createNPC();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_3_0_0_4_0_1_3, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a16, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[71]);
            	            				addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[72]);
            	            				addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[73]);
            	            			}

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[74]);
            		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[75]);
            		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[76]);
            	}

            a17=(Token)match(input,25,FOLLOW_25_in_parse_nl_utwente_apc_Code2D_NPC1007); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createNPC();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_3_0_0_5, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a17, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[77]);
            		addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[78]);
            		addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[79]);
            		addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[80]);
            		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[81]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 5, parse_nl_utwente_apc_Code2D_NPC_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_nl_utwente_apc_Code2D_NPC"



    // $ANTLR start "parse_nl_utwente_apc_Code2D_Item"
    // Code2D.g:1306:1: parse_nl_utwente_apc_Code2D_Item returns [nl.utwente.apc.Code2D.Item element = null] : a0= 'Item' (a1= TEXT ) a2= '{' ( (a3= 'Texture' a4= ':' (a5= TEXT ) a6= ';' ) )* a7= '}' ;
    public final nl.utwente.apc.Code2D.Item parse_nl_utwente_apc_Code2D_Item() throws RecognitionException {
        nl.utwente.apc.Code2D.Item element =  null;

        int parse_nl_utwente_apc_Code2D_Item_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;
        Token a7=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return element; }

            // Code2D.g:1309:2: (a0= 'Item' (a1= TEXT ) a2= '{' ( (a3= 'Texture' a4= ':' (a5= TEXT ) a6= ';' ) )* a7= '}' )
            // Code2D.g:1310:2: a0= 'Item' (a1= TEXT ) a2= '{' ( (a3= 'Texture' a4= ':' (a5= TEXT ) a6= ';' ) )* a7= '}'
            {
            a0=(Token)match(input,17,FOLLOW_17_in_parse_nl_utwente_apc_Code2D_Item1036); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createItem();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_4_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[82]);
            	}

            // Code2D.g:1324:2: (a1= TEXT )
            // Code2D.g:1325:3: a1= TEXT
            {
            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_nl_utwente_apc_Code2D_Item1054); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DTerminateParsingException();
            			}
            			if (element == null) {
            				element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createItem();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				nl.utwente.apc.Code2D.resource.Code2D.ICode2DTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				nl.utwente.apc.Code2D.resource.Code2D.ICode2DTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.ITEM__NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.ITEM__NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_4_0_0_1, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[83]);
            	}

            a2=(Token)match(input,24,FOLLOW_24_in_parse_nl_utwente_apc_Code2D_Item1075); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createItem();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_4_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[84]);
            		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[85]);
            	}

            // Code2D.g:1375:2: ( (a3= 'Texture' a4= ':' (a5= TEXT ) a6= ';' ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==22) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // Code2D.g:1376:3: (a3= 'Texture' a4= ':' (a5= TEXT ) a6= ';' )
            	    {
            	    // Code2D.g:1376:3: (a3= 'Texture' a4= ':' (a5= TEXT ) a6= ';' )
            	    // Code2D.g:1377:4: a3= 'Texture' a4= ':' (a5= TEXT ) a6= ';'
            	    {
            	    a3=(Token)match(input,22,FOLLOW_22_in_parse_nl_utwente_apc_Code2D_Item1098); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createItem();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_4_0_0_3_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[86]);
            	    			}

            	    a4=(Token)match(input,11,FOLLOW_11_in_parse_nl_utwente_apc_Code2D_Item1118); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createItem();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_4_0_0_3_0_0_1, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[87]);
            	    			}

            	    // Code2D.g:1405:4: (a5= TEXT )
            	    // Code2D.g:1406:5: a5= TEXT
            	    {
            	    a5=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_nl_utwente_apc_Code2D_Item1144); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createItem();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a5 != null) {
            	    						nl.utwente.apc.Code2D.resource.Code2D.ICode2DTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            	    						tokenResolver.setOptions(getOptions());
            	    						nl.utwente.apc.Code2D.resource.Code2D.ICode2DTokenResolveResult result = getFreshTokenResolveResult();
            	    						tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.ITEM__TEXTURE), result);
            	    						Object resolvedObject = result.getResolvedToken();
            	    						if (resolvedObject == null) {
            	    							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a5).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a5).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a5).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a5).getStopIndex());
            	    						}
            	    						java.lang.String resolved = (java.lang.String) resolvedObject;
            	    						if (resolved != null) {
            	    							Object value = resolved;
            	    							element.eSet(element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.ITEM__TEXTURE), value);
            	    							completedElement(value, false);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_4_0_0_3_0_0_2, resolved, true);
            	    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a5, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[88]);
            	    			}

            	    a6=(Token)match(input,12,FOLLOW_12_in_parse_nl_utwente_apc_Code2D_Item1177); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createItem();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_4_0_0_3_0_0_3, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[89]);
            	    				addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[90]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[91]);
            		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[92]);
            	}

            a7=(Token)match(input,25,FOLLOW_25_in_parse_nl_utwente_apc_Code2D_Item1210); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createItem();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_4_0_0_4, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[93]);
            		addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[94]);
            		addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[95]);
            		addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[96]);
            		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[97]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 6, parse_nl_utwente_apc_Code2D_Item_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_nl_utwente_apc_Code2D_Item"



    // $ANTLR start "parse_nl_utwente_apc_Code2D_GameObject"
    // Code2D.g:1484:1: parse_nl_utwente_apc_Code2D_GameObject returns [nl.utwente.apc.Code2D.GameObject element = null] : (c0= parse_nl_utwente_apc_Code2D_Player |c1= parse_nl_utwente_apc_Code2D_NPC |c2= parse_nl_utwente_apc_Code2D_Item );
    public final nl.utwente.apc.Code2D.GameObject parse_nl_utwente_apc_Code2D_GameObject() throws RecognitionException {
        nl.utwente.apc.Code2D.GameObject element =  null;

        int parse_nl_utwente_apc_Code2D_GameObject_StartIndex = input.index();

        nl.utwente.apc.Code2D.Player c0 =null;

        nl.utwente.apc.Code2D.NPC c1 =null;

        nl.utwente.apc.Code2D.Item c2 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return element; }

            // Code2D.g:1485:2: (c0= parse_nl_utwente_apc_Code2D_Player |c1= parse_nl_utwente_apc_Code2D_NPC |c2= parse_nl_utwente_apc_Code2D_Item )
            int alt10=3;
            switch ( input.LA(1) ) {
            case 21:
                {
                alt10=1;
                }
                break;
            case 18:
                {
                alt10=2;
                }
                break;
            case 17:
                {
                alt10=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;

            }

            switch (alt10) {
                case 1 :
                    // Code2D.g:1486:2: c0= parse_nl_utwente_apc_Code2D_Player
                    {
                    pushFollow(FOLLOW_parse_nl_utwente_apc_Code2D_Player_in_parse_nl_utwente_apc_Code2D_GameObject1235);
                    c0=parse_nl_utwente_apc_Code2D_Player();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Code2D.g:1487:4: c1= parse_nl_utwente_apc_Code2D_NPC
                    {
                    pushFollow(FOLLOW_parse_nl_utwente_apc_Code2D_NPC_in_parse_nl_utwente_apc_Code2D_GameObject1245);
                    c1=parse_nl_utwente_apc_Code2D_NPC();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Code2D.g:1488:4: c2= parse_nl_utwente_apc_Code2D_Item
                    {
                    pushFollow(FOLLOW_parse_nl_utwente_apc_Code2D_Item_in_parse_nl_utwente_apc_Code2D_GameObject1255);
                    c2=parse_nl_utwente_apc_Code2D_Item();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c2; /* this is a subclass or primitive expression choice */ }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 7, parse_nl_utwente_apc_Code2D_GameObject_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_nl_utwente_apc_Code2D_GameObject"

    // Delegated rules


 

    public static final BitSet FOLLOW_parse_nl_utwente_apc_Code2D_Game_in_start82 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_parse_nl_utwente_apc_Code2D_Game115 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_TEXT_in_parse_nl_utwente_apc_Code2D_Game133 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_parse_nl_utwente_apc_Code2D_Game154 = new BitSet(new long[]{0x0000000002A60000L});
    public static final BitSet FOLLOW_parse_nl_utwente_apc_Code2D_World_in_parse_nl_utwente_apc_Code2D_Game183 = new BitSet(new long[]{0x0000000002A60000L});
    public static final BitSet FOLLOW_parse_nl_utwente_apc_Code2D_GameObject_in_parse_nl_utwente_apc_Code2D_Game225 = new BitSet(new long[]{0x0000000002A60000L});
    public static final BitSet FOLLOW_25_in_parse_nl_utwente_apc_Code2D_Game266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_parse_nl_utwente_apc_Code2D_World295 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_TEXT_in_parse_nl_utwente_apc_Code2D_World313 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_parse_nl_utwente_apc_Code2D_World334 = new BitSet(new long[]{0x0000000002100000L});
    public static final BitSet FOLLOW_20_in_parse_nl_utwente_apc_Code2D_World357 = new BitSet(new long[]{0x0000000002100000L});
    public static final BitSet FOLLOW_25_in_parse_nl_utwente_apc_Code2D_World390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_parse_nl_utwente_apc_Code2D_Player419 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_TEXT_in_parse_nl_utwente_apc_Code2D_Player437 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_parse_nl_utwente_apc_Code2D_Player458 = new BitSet(new long[]{0x0000000002400000L});
    public static final BitSet FOLLOW_22_in_parse_nl_utwente_apc_Code2D_Player481 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_nl_utwente_apc_Code2D_Player501 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_4748_59_in_parse_nl_utwente_apc_Code2D_Player527 = new BitSet(new long[]{0x0000000002400000L});
    public static final BitSet FOLLOW_25_in_parse_nl_utwente_apc_Code2D_Player573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_parse_nl_utwente_apc_Code2D_NPC602 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_TEXT_in_parse_nl_utwente_apc_Code2D_NPC620 = new BitSet(new long[]{0x0000000001000800L});
    public static final BitSet FOLLOW_11_in_parse_nl_utwente_apc_Code2D_NPC650 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_TEXT_in_parse_nl_utwente_apc_Code2D_NPC676 = new BitSet(new long[]{0x0000000001000800L});
    public static final BitSet FOLLOW_24_in_parse_nl_utwente_apc_Code2D_NPC722 = new BitSet(new long[]{0x0000000002402000L});
    public static final BitSet FOLLOW_22_in_parse_nl_utwente_apc_Code2D_NPC745 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_nl_utwente_apc_Code2D_NPC765 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_TEXT_in_parse_nl_utwente_apc_Code2D_NPC791 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_nl_utwente_apc_Code2D_NPC824 = new BitSet(new long[]{0x0000000002402000L});
    public static final BitSet FOLLOW_13_in_parse_nl_utwente_apc_Code2D_NPC852 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_nl_utwente_apc_Code2D_NPC872 = new BitSet(new long[]{0x0000000000094000L});
    public static final BitSet FOLLOW_14_in_parse_nl_utwente_apc_Code2D_NPC905 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_19_in_parse_nl_utwente_apc_Code2D_NPC924 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_16_in_parse_nl_utwente_apc_Code2D_NPC943 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_nl_utwente_apc_Code2D_NPC974 = new BitSet(new long[]{0x0000000002402000L});
    public static final BitSet FOLLOW_25_in_parse_nl_utwente_apc_Code2D_NPC1007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_parse_nl_utwente_apc_Code2D_Item1036 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_TEXT_in_parse_nl_utwente_apc_Code2D_Item1054 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_parse_nl_utwente_apc_Code2D_Item1075 = new BitSet(new long[]{0x0000000002400000L});
    public static final BitSet FOLLOW_22_in_parse_nl_utwente_apc_Code2D_Item1098 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_nl_utwente_apc_Code2D_Item1118 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_TEXT_in_parse_nl_utwente_apc_Code2D_Item1144 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_nl_utwente_apc_Code2D_Item1177 = new BitSet(new long[]{0x0000000002400000L});
    public static final BitSet FOLLOW_25_in_parse_nl_utwente_apc_Code2D_Item1210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_nl_utwente_apc_Code2D_Player_in_parse_nl_utwente_apc_Code2D_GameObject1235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_nl_utwente_apc_Code2D_NPC_in_parse_nl_utwente_apc_Code2D_GameObject1245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_nl_utwente_apc_Code2D_Item_in_parse_nl_utwente_apc_Code2D_GameObject1255 = new BitSet(new long[]{0x0000000000000002L});

}