// $ANTLR 3.4

	package nl.utwente.apc.Code2D.resource.c2.mopp;


import org.antlr.runtime3_4_0.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class C2Parser extends C2ANTLRParserBase {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMENT", "FLOAT", "INTEGER", "LINEBREAK", "TEXT", "WHITESPACE", "'Game'", "'Name:'", "'World'", "'{'", "'}'"
    };

    public static final int EOF=-1;
    public static final int T__10=10;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int COMMENT=4;
    public static final int FLOAT=5;
    public static final int INTEGER=6;
    public static final int LINEBREAK=7;
    public static final int TEXT=8;
    public static final int WHITESPACE=9;

    // delegates
    public C2ANTLRParserBase[] getDelegates() {
        return new C2ANTLRParserBase[] {};
    }

    // delegators


    public C2Parser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public C2Parser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
        this.state.initializeRuleMemo(3 + 1);
         

    }

    public String[] getTokenNames() { return C2Parser.tokenNames; }
    public String getGrammarFileName() { return "C2.g"; }


    	private nl.utwente.apc.Code2D.resource.c2.IC2TokenResolverFactory tokenResolverFactory = new nl.utwente.apc.Code2D.resource.c2.mopp.C2TokenResolverFactory();
    	
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
    	private java.util.List<nl.utwente.apc.Code2D.resource.c2.mopp.C2ExpectedTerminal> expectedElements = new java.util.ArrayList<nl.utwente.apc.Code2D.resource.c2.mopp.C2ExpectedTerminal>();
    	
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
    		postParseCommands.add(new nl.utwente.apc.Code2D.resource.c2.IC2Command<nl.utwente.apc.Code2D.resource.c2.IC2TextResource>() {
    			public boolean execute(nl.utwente.apc.Code2D.resource.c2.IC2TextResource resource) {
    				if (resource == null) {
    					// the resource can be null if the parser is used for code completion
    					return true;
    				}
    				resource.addProblem(new nl.utwente.apc.Code2D.resource.c2.IC2Problem() {
    					public nl.utwente.apc.Code2D.resource.c2.C2EProblemSeverity getSeverity() {
    						return nl.utwente.apc.Code2D.resource.c2.C2EProblemSeverity.ERROR;
    					}
    					public nl.utwente.apc.Code2D.resource.c2.C2EProblemType getType() {
    						return nl.utwente.apc.Code2D.resource.c2.C2EProblemType.SYNTAX_ERROR;
    					}
    					public String getMessage() {
    						return errorMessage;
    					}
    					public java.util.Collection<nl.utwente.apc.Code2D.resource.c2.IC2QuickFix> getQuickFixes() {
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
    		nl.utwente.apc.Code2D.resource.c2.IC2ExpectedElement terminal = nl.utwente.apc.Code2D.resource.c2.grammar.C2FollowSetProvider.TERMINALS[terminalID];
    		nl.utwente.apc.Code2D.resource.c2.mopp.C2ContainedFeature[] containmentFeatures = new nl.utwente.apc.Code2D.resource.c2.mopp.C2ContainedFeature[ids.length - 2];
    		for (int i = 2; i < ids.length; i++) {
    			containmentFeatures[i - 2] = nl.utwente.apc.Code2D.resource.c2.grammar.C2FollowSetProvider.LINKS[ids[i]];
    		}
    		nl.utwente.apc.Code2D.resource.c2.grammar.C2ContainmentTrace containmentTrace = new nl.utwente.apc.Code2D.resource.c2.grammar.C2ContainmentTrace(eClass, containmentFeatures);
    		org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
    		nl.utwente.apc.Code2D.resource.c2.mopp.C2ExpectedTerminal expectedElement = new nl.utwente.apc.Code2D.resource.c2.mopp.C2ExpectedTerminal(container, terminal, followSetID, containmentTrace);
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
    		postParseCommands.add(new nl.utwente.apc.Code2D.resource.c2.IC2Command<nl.utwente.apc.Code2D.resource.c2.IC2TextResource>() {
    			public boolean execute(nl.utwente.apc.Code2D.resource.c2.IC2TextResource resource) {
    				nl.utwente.apc.Code2D.resource.c2.IC2LocationMap locationMap = resource.getLocationMap();
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
    		postParseCommands.add(new nl.utwente.apc.Code2D.resource.c2.IC2Command<nl.utwente.apc.Code2D.resource.c2.IC2TextResource>() {
    			public boolean execute(nl.utwente.apc.Code2D.resource.c2.IC2TextResource resource) {
    				nl.utwente.apc.Code2D.resource.c2.IC2LocationMap locationMap = resource.getLocationMap();
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
    	protected void setLocalizationEnd(java.util.Collection<nl.utwente.apc.Code2D.resource.c2.IC2Command<nl.utwente.apc.Code2D.resource.c2.IC2TextResource>> postParseCommands , final org.eclipse.emf.ecore.EObject object, final int endChar, final int endLine) {
    		if (disableLocationMap) {
    			return;
    		}
    		postParseCommands.add(new nl.utwente.apc.Code2D.resource.c2.IC2Command<nl.utwente.apc.Code2D.resource.c2.IC2TextResource>() {
    			public boolean execute(nl.utwente.apc.Code2D.resource.c2.IC2TextResource resource) {
    				nl.utwente.apc.Code2D.resource.c2.IC2LocationMap locationMap = resource.getLocationMap();
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
    	
    	public nl.utwente.apc.Code2D.resource.c2.IC2TextParser createInstance(java.io.InputStream actualInputStream, String encoding) {
    		try {
    			if (encoding == null) {
    				return new C2Parser(new org.antlr.runtime3_4_0.CommonTokenStream(new C2Lexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream))));
    			} else {
    				return new C2Parser(new org.antlr.runtime3_4_0.CommonTokenStream(new C2Lexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream, encoding))));
    			}
    		} catch (java.io.IOException e) {
    			new nl.utwente.apc.Code2D.resource.c2.util.C2RuntimeUtil().logError("Error while creating parser.", e);
    			return null;
    		}
    	}
    	
    	/**
    	 * This default constructor is only used to call createInstance() on it.
    	 */
    	public C2Parser() {
    		super(null);
    	}
    	
    	protected org.eclipse.emf.ecore.EObject doParse() throws org.antlr.runtime3_4_0.RecognitionException {
    		this.lastPosition = 0;
    		// required because the lexer class can not be subclassed
    		((C2Lexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
    		((C2Lexer) getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
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
    		}
    		throw new nl.utwente.apc.Code2D.resource.c2.mopp.C2UnexpectedContentTypeException(typeObject);
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
    			typeObject = options.get(nl.utwente.apc.Code2D.resource.c2.IC2Options.RESOURCE_CONTENT_TYPE);
    		}
    		return typeObject;
    	}
    	
    	/**
    	 * Implementation that calls {@link #doParse()} and handles the thrown
    	 * RecognitionExceptions.
    	 */
    	public nl.utwente.apc.Code2D.resource.c2.IC2ParseResult parse() {
    		terminateParsing = false;
    		postParseCommands = new java.util.ArrayList<nl.utwente.apc.Code2D.resource.c2.IC2Command<nl.utwente.apc.Code2D.resource.c2.IC2TextResource>>();
    		nl.utwente.apc.Code2D.resource.c2.mopp.C2ParseResult parseResult = new nl.utwente.apc.Code2D.resource.c2.mopp.C2ParseResult();
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
    	
    	public java.util.List<nl.utwente.apc.Code2D.resource.c2.mopp.C2ExpectedTerminal> parseToExpectedElements(org.eclipse.emf.ecore.EClass type, nl.utwente.apc.Code2D.resource.c2.IC2TextResource dummyResource, int cursorOffset) {
    		this.rememberExpectedElements = true;
    		this.parseToIndexTypeObject = type;
    		this.cursorOffset = cursorOffset;
    		this.lastStartIncludingHidden = -1;
    		final org.antlr.runtime3_4_0.CommonTokenStream tokenStream = (org.antlr.runtime3_4_0.CommonTokenStream) getTokenStream();
    		nl.utwente.apc.Code2D.resource.c2.IC2ParseResult result = parse();
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
    			for (nl.utwente.apc.Code2D.resource.c2.IC2Command<nl.utwente.apc.Code2D.resource.c2.IC2TextResource> command : result.getPostParseCommands()) {
    				command.execute(dummyResource);
    			}
    		}
    		// remove all expected elements that were added after the last complete element
    		expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);
    		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
    		java.util.Set<nl.utwente.apc.Code2D.resource.c2.mopp.C2ExpectedTerminal> currentFollowSet = new java.util.LinkedHashSet<nl.utwente.apc.Code2D.resource.c2.mopp.C2ExpectedTerminal>();
    		java.util.List<nl.utwente.apc.Code2D.resource.c2.mopp.C2ExpectedTerminal> newFollowSet = new java.util.ArrayList<nl.utwente.apc.Code2D.resource.c2.mopp.C2ExpectedTerminal>();
    		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
    			nl.utwente.apc.Code2D.resource.c2.mopp.C2ExpectedTerminal expectedElementI = expectedElements.get(i);
    			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
    				currentFollowSet.add(expectedElementI);
    			} else {
    				break;
    			}
    		}
    		int followSetID = 11;
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
    				for (nl.utwente.apc.Code2D.resource.c2.mopp.C2ExpectedTerminal nextFollow : newFollowSet) {
    					lastTokenIndex = 0;
    					setPosition(nextFollow, i);
    				}
    				newFollowSet.clear();
    				// normal tokens do reduce the follow set - only elements that match the token are
    				// kept
    				for (nl.utwente.apc.Code2D.resource.c2.mopp.C2ExpectedTerminal nextFollow : currentFollowSet) {
    					if (nextFollow.getTerminal().getTokenNames().contains(getTokenNames()[nextToken.getType()])) {
    						// keep this one - it matches
    						java.util.Collection<nl.utwente.apc.Code2D.resource.c2.util.C2Pair<nl.utwente.apc.Code2D.resource.c2.IC2ExpectedElement, nl.utwente.apc.Code2D.resource.c2.mopp.C2ContainedFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
    						for (nl.utwente.apc.Code2D.resource.c2.util.C2Pair<nl.utwente.apc.Code2D.resource.c2.IC2ExpectedElement, nl.utwente.apc.Code2D.resource.c2.mopp.C2ContainedFeature[]> newFollowerPair : newFollowers) {
    							nl.utwente.apc.Code2D.resource.c2.IC2ExpectedElement newFollower = newFollowerPair.getLeft();
    							org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
    							nl.utwente.apc.Code2D.resource.c2.grammar.C2ContainmentTrace containmentTrace = new nl.utwente.apc.Code2D.resource.c2.grammar.C2ContainmentTrace(null, newFollowerPair.getRight());
    							nl.utwente.apc.Code2D.resource.c2.mopp.C2ExpectedTerminal newFollowTerminal = new nl.utwente.apc.Code2D.resource.c2.mopp.C2ExpectedTerminal(container, newFollower, followSetID, containmentTrace);
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
    		for (nl.utwente.apc.Code2D.resource.c2.mopp.C2ExpectedTerminal nextFollow : newFollowSet) {
    			lastTokenIndex = 0;
    			setPosition(nextFollow, i);
    		}
    		return this.expectedElements;
    	}
    	
    	public void setPosition(nl.utwente.apc.Code2D.resource.c2.mopp.C2ExpectedTerminal expectedElement, int tokenIndex) {
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
    // C2.g:502:1: start returns [ org.eclipse.emf.ecore.EObject element = null] : (c0= parse_nl_utwente_apc_Code2D_Game ) EOF ;
    public final org.eclipse.emf.ecore.EObject start() throws RecognitionException {
        org.eclipse.emf.ecore.EObject element =  null;

        int start_StartIndex = input.index();

        nl.utwente.apc.Code2D.Game c0 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }

            // C2.g:503:2: ( (c0= parse_nl_utwente_apc_Code2D_Game ) EOF )
            // C2.g:504:2: (c0= parse_nl_utwente_apc_Code2D_Game ) EOF
            {
            if ( state.backtracking==0 ) {
            		// follow set for start rule(s)
            		addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2.mopp.C2ExpectationConstants.EXPECTATIONS[0]);
            		expectedElementsIndexOfLastCompleteElement = 0;
            	}

            // C2.g:509:2: (c0= parse_nl_utwente_apc_Code2D_Game )
            // C2.g:510:3: c0= parse_nl_utwente_apc_Code2D_Game
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
    // C2.g:518:1: parse_nl_utwente_apc_Code2D_Game returns [nl.utwente.apc.Code2D.Game element = null] : a0= 'Game' (a1= TEXT ) a2= '{' (a3_0= parse_nl_utwente_apc_Code2D_World ) a4= '}' ;
    public final nl.utwente.apc.Code2D.Game parse_nl_utwente_apc_Code2D_Game() throws RecognitionException {
        nl.utwente.apc.Code2D.Game element =  null;

        int parse_nl_utwente_apc_Code2D_Game_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a4=null;
        nl.utwente.apc.Code2D.World a3_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }

            // C2.g:521:2: (a0= 'Game' (a1= TEXT ) a2= '{' (a3_0= parse_nl_utwente_apc_Code2D_World ) a4= '}' )
            // C2.g:522:2: a0= 'Game' (a1= TEXT ) a2= '{' (a3_0= parse_nl_utwente_apc_Code2D_World ) a4= '}'
            {
            a0=(Token)match(input,10,FOLLOW_10_in_parse_nl_utwente_apc_Code2D_Game115); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createGame();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.c2.grammar.C2GrammarInformationProvider.C2_0_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2.mopp.C2ExpectationConstants.EXPECTATIONS[1]);
            	}

            // C2.g:536:2: (a1= TEXT )
            // C2.g:537:3: a1= TEXT
            {
            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_nl_utwente_apc_Code2D_Game133); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new nl.utwente.apc.Code2D.resource.c2.mopp.C2TerminateParsingException();
            			}
            			if (element == null) {
            				element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createGame();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				nl.utwente.apc.Code2D.resource.c2.IC2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				nl.utwente.apc.Code2D.resource.c2.IC2TokenResolveResult result = getFreshTokenResolveResult();
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
            				retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.c2.grammar.C2GrammarInformationProvider.C2_0_0_0_1, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2.mopp.C2ExpectationConstants.EXPECTATIONS[2]);
            	}

            a2=(Token)match(input,13,FOLLOW_13_in_parse_nl_utwente_apc_Code2D_Game154); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createGame();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.c2.grammar.C2GrammarInformationProvider.C2_0_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.c2.mopp.C2ExpectationConstants.EXPECTATIONS[3]);
            	}

            // C2.g:586:2: (a3_0= parse_nl_utwente_apc_Code2D_World )
            // C2.g:587:3: a3_0= parse_nl_utwente_apc_Code2D_World
            {
            pushFollow(FOLLOW_parse_nl_utwente_apc_Code2D_World_in_parse_nl_utwente_apc_Code2D_Game172);
            a3_0=parse_nl_utwente_apc_Code2D_World();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new nl.utwente.apc.Code2D.resource.c2.mopp.C2TerminateParsingException();
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
            				retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.c2.grammar.C2GrammarInformationProvider.C2_0_0_0_3, a3_0, true);
            				copyLocalizationInfos(a3_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2.mopp.C2ExpectationConstants.EXPECTATIONS[4]);
            	}

            a4=(Token)match(input,14,FOLLOW_14_in_parse_nl_utwente_apc_Code2D_Game190); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createGame();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.c2.grammar.C2GrammarInformationProvider.C2_0_0_0_4, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
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
    // C2.g:627:1: parse_nl_utwente_apc_Code2D_World returns [nl.utwente.apc.Code2D.World element = null] : a0= 'World' a1= '{' a2= 'Name:' (a3= TEXT ) a4= '}' ;
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

            // C2.g:630:2: (a0= 'World' a1= '{' a2= 'Name:' (a3= TEXT ) a4= '}' )
            // C2.g:631:2: a0= 'World' a1= '{' a2= 'Name:' (a3= TEXT ) a4= '}'
            {
            a0=(Token)match(input,12,FOLLOW_12_in_parse_nl_utwente_apc_Code2D_World219); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createWorld();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.c2.grammar.C2GrammarInformationProvider.C2_1_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2.mopp.C2ExpectationConstants.EXPECTATIONS[5]);
            	}

            a1=(Token)match(input,13,FOLLOW_13_in_parse_nl_utwente_apc_Code2D_World233); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createWorld();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.c2.grammar.C2GrammarInformationProvider.C2_1_0_0_1, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2.mopp.C2ExpectationConstants.EXPECTATIONS[6]);
            	}

            a2=(Token)match(input,11,FOLLOW_11_in_parse_nl_utwente_apc_Code2D_World247); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createWorld();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.c2.grammar.C2GrammarInformationProvider.C2_1_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2.mopp.C2ExpectationConstants.EXPECTATIONS[7]);
            	}

            // C2.g:673:2: (a3= TEXT )
            // C2.g:674:3: a3= TEXT
            {
            a3=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_nl_utwente_apc_Code2D_World265); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new nl.utwente.apc.Code2D.resource.c2.mopp.C2TerminateParsingException();
            			}
            			if (element == null) {
            				element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createWorld();
            				startIncompleteElement(element);
            			}
            			if (a3 != null) {
            				nl.utwente.apc.Code2D.resource.c2.IC2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            				tokenResolver.setOptions(getOptions());
            				nl.utwente.apc.Code2D.resource.c2.IC2TokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.WORLD__NAME), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.WORLD__NAME), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.c2.grammar.C2GrammarInformationProvider.C2_1_0_0_3, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2.mopp.C2ExpectationConstants.EXPECTATIONS[8]);
            	}

            a4=(Token)match(input,14,FOLLOW_14_in_parse_nl_utwente_apc_Code2D_World286); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createWorld();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.c2.grammar.C2GrammarInformationProvider.C2_1_0_0_4, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2.mopp.C2ExpectationConstants.EXPECTATIONS[9]);
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

    // Delegated rules


 

    public static final BitSet FOLLOW_parse_nl_utwente_apc_Code2D_Game_in_start82 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_parse_nl_utwente_apc_Code2D_Game115 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_nl_utwente_apc_Code2D_Game133 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parse_nl_utwente_apc_Code2D_Game154 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_parse_nl_utwente_apc_Code2D_World_in_parse_nl_utwente_apc_Code2D_Game172 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_parse_nl_utwente_apc_Code2D_Game190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_parse_nl_utwente_apc_Code2D_World219 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parse_nl_utwente_apc_Code2D_World233 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parse_nl_utwente_apc_Code2D_World247 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_TEXT_in_parse_nl_utwente_apc_Code2D_World265 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_parse_nl_utwente_apc_Code2D_World286 = new BitSet(new long[]{0x0000000000000002L});

}