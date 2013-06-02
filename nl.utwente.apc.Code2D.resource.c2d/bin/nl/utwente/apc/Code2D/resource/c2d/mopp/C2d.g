grammar C2d;

options {
	superClass = C2dANTLRParserBase;
	backtrack = true;
	memoize = true;
}

@lexer::header {
	package nl.utwente.apc.Code2D.resource.c2d.mopp;
}

@lexer::members {
	public java.util.List<org.antlr.runtime3_4_0.RecognitionException> lexerExceptions  = new java.util.ArrayList<org.antlr.runtime3_4_0.RecognitionException>();
	public java.util.List<Integer> lexerExceptionsPosition = new java.util.ArrayList<Integer>();
	
	public void reportError(org.antlr.runtime3_4_0.RecognitionException e) {
		lexerExceptions.add(e);
		lexerExceptionsPosition.add(((org.antlr.runtime3_4_0.ANTLRStringStream) input).index());
	}
}
@header{
	package nl.utwente.apc.Code2D.resource.c2d.mopp;
}

@members{
	private nl.utwente.apc.Code2D.resource.c2d.IC2dTokenResolverFactory tokenResolverFactory = new nl.utwente.apc.Code2D.resource.c2d.mopp.C2dTokenResolverFactory();
	
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
	private java.util.List<nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectedTerminal> expectedElements = new java.util.ArrayList<nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectedTerminal>();
	
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
		postParseCommands.add(new nl.utwente.apc.Code2D.resource.c2d.IC2dCommand<nl.utwente.apc.Code2D.resource.c2d.IC2dTextResource>() {
			public boolean execute(nl.utwente.apc.Code2D.resource.c2d.IC2dTextResource resource) {
				if (resource == null) {
					// the resource can be null if the parser is used for code completion
					return true;
				}
				resource.addProblem(new nl.utwente.apc.Code2D.resource.c2d.IC2dProblem() {
					public nl.utwente.apc.Code2D.resource.c2d.C2dEProblemSeverity getSeverity() {
						return nl.utwente.apc.Code2D.resource.c2d.C2dEProblemSeverity.ERROR;
					}
					public nl.utwente.apc.Code2D.resource.c2d.C2dEProblemType getType() {
						return nl.utwente.apc.Code2D.resource.c2d.C2dEProblemType.SYNTAX_ERROR;
					}
					public String getMessage() {
						return errorMessage;
					}
					public java.util.Collection<nl.utwente.apc.Code2D.resource.c2d.IC2dQuickFix> getQuickFixes() {
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
		nl.utwente.apc.Code2D.resource.c2d.IC2dExpectedElement terminal = nl.utwente.apc.Code2D.resource.c2d.grammar.C2dFollowSetProvider.TERMINALS[terminalID];
		nl.utwente.apc.Code2D.resource.c2d.mopp.C2dContainedFeature[] containmentFeatures = new nl.utwente.apc.Code2D.resource.c2d.mopp.C2dContainedFeature[ids.length - 2];
		for (int i = 2; i < ids.length; i++) {
			containmentFeatures[i - 2] = nl.utwente.apc.Code2D.resource.c2d.grammar.C2dFollowSetProvider.LINKS[ids[i]];
		}
		nl.utwente.apc.Code2D.resource.c2d.grammar.C2dContainmentTrace containmentTrace = new nl.utwente.apc.Code2D.resource.c2d.grammar.C2dContainmentTrace(eClass, containmentFeatures);
		org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
		nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectedTerminal expectedElement = new nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectedTerminal(container, terminal, followSetID, containmentTrace);
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
		postParseCommands.add(new nl.utwente.apc.Code2D.resource.c2d.IC2dCommand<nl.utwente.apc.Code2D.resource.c2d.IC2dTextResource>() {
			public boolean execute(nl.utwente.apc.Code2D.resource.c2d.IC2dTextResource resource) {
				nl.utwente.apc.Code2D.resource.c2d.IC2dLocationMap locationMap = resource.getLocationMap();
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
		postParseCommands.add(new nl.utwente.apc.Code2D.resource.c2d.IC2dCommand<nl.utwente.apc.Code2D.resource.c2d.IC2dTextResource>() {
			public boolean execute(nl.utwente.apc.Code2D.resource.c2d.IC2dTextResource resource) {
				nl.utwente.apc.Code2D.resource.c2d.IC2dLocationMap locationMap = resource.getLocationMap();
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
	protected void setLocalizationEnd(java.util.Collection<nl.utwente.apc.Code2D.resource.c2d.IC2dCommand<nl.utwente.apc.Code2D.resource.c2d.IC2dTextResource>> postParseCommands , final org.eclipse.emf.ecore.EObject object, final int endChar, final int endLine) {
		if (disableLocationMap) {
			return;
		}
		postParseCommands.add(new nl.utwente.apc.Code2D.resource.c2d.IC2dCommand<nl.utwente.apc.Code2D.resource.c2d.IC2dTextResource>() {
			public boolean execute(nl.utwente.apc.Code2D.resource.c2d.IC2dTextResource resource) {
				nl.utwente.apc.Code2D.resource.c2d.IC2dLocationMap locationMap = resource.getLocationMap();
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
	
	public nl.utwente.apc.Code2D.resource.c2d.IC2dTextParser createInstance(java.io.InputStream actualInputStream, String encoding) {
		try {
			if (encoding == null) {
				return new C2dParser(new org.antlr.runtime3_4_0.CommonTokenStream(new C2dLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream))));
			} else {
				return new C2dParser(new org.antlr.runtime3_4_0.CommonTokenStream(new C2dLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream, encoding))));
			}
		} catch (java.io.IOException e) {
			new nl.utwente.apc.Code2D.resource.c2d.util.C2dRuntimeUtil().logError("Error while creating parser.", e);
			return null;
		}
	}
	
	/**
	 * This default constructor is only used to call createInstance() on it.
	 */
	public C2dParser() {
		super(null);
	}
	
	protected org.eclipse.emf.ecore.EObject doParse() throws org.antlr.runtime3_4_0.RecognitionException {
		this.lastPosition = 0;
		// required because the lexer class can not be subclassed
		((C2dLexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
		((C2dLexer) getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
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
		throw new nl.utwente.apc.Code2D.resource.c2d.mopp.C2dUnexpectedContentTypeException(typeObject);
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
			typeObject = options.get(nl.utwente.apc.Code2D.resource.c2d.IC2dOptions.RESOURCE_CONTENT_TYPE);
		}
		return typeObject;
	}
	
	/**
	 * Implementation that calls {@link #doParse()} and handles the thrown
	 * RecognitionExceptions.
	 */
	public nl.utwente.apc.Code2D.resource.c2d.IC2dParseResult parse() {
		terminateParsing = false;
		postParseCommands = new java.util.ArrayList<nl.utwente.apc.Code2D.resource.c2d.IC2dCommand<nl.utwente.apc.Code2D.resource.c2d.IC2dTextResource>>();
		nl.utwente.apc.Code2D.resource.c2d.mopp.C2dParseResult parseResult = new nl.utwente.apc.Code2D.resource.c2d.mopp.C2dParseResult();
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
	
	public java.util.List<nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectedTerminal> parseToExpectedElements(org.eclipse.emf.ecore.EClass type, nl.utwente.apc.Code2D.resource.c2d.IC2dTextResource dummyResource, int cursorOffset) {
		this.rememberExpectedElements = true;
		this.parseToIndexTypeObject = type;
		this.cursorOffset = cursorOffset;
		this.lastStartIncludingHidden = -1;
		final org.antlr.runtime3_4_0.CommonTokenStream tokenStream = (org.antlr.runtime3_4_0.CommonTokenStream) getTokenStream();
		nl.utwente.apc.Code2D.resource.c2d.IC2dParseResult result = parse();
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
			for (nl.utwente.apc.Code2D.resource.c2d.IC2dCommand<nl.utwente.apc.Code2D.resource.c2d.IC2dTextResource> command : result.getPostParseCommands()) {
				command.execute(dummyResource);
			}
		}
		// remove all expected elements that were added after the last complete element
		expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);
		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
		java.util.Set<nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectedTerminal> currentFollowSet = new java.util.LinkedHashSet<nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectedTerminal>();
		java.util.List<nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectedTerminal> newFollowSet = new java.util.ArrayList<nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectedTerminal>();
		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
			nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectedTerminal expectedElementI = expectedElements.get(i);
			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
				currentFollowSet.add(expectedElementI);
			} else {
				break;
			}
		}
		int followSetID = 27;
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
				for (nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectedTerminal nextFollow : newFollowSet) {
					lastTokenIndex = 0;
					setPosition(nextFollow, i);
				}
				newFollowSet.clear();
				// normal tokens do reduce the follow set - only elements that match the token are
				// kept
				for (nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectedTerminal nextFollow : currentFollowSet) {
					if (nextFollow.getTerminal().getTokenNames().contains(getTokenNames()[nextToken.getType()])) {
						// keep this one - it matches
						java.util.Collection<nl.utwente.apc.Code2D.resource.c2d.util.C2dPair<nl.utwente.apc.Code2D.resource.c2d.IC2dExpectedElement, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dContainedFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
						for (nl.utwente.apc.Code2D.resource.c2d.util.C2dPair<nl.utwente.apc.Code2D.resource.c2d.IC2dExpectedElement, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dContainedFeature[]> newFollowerPair : newFollowers) {
							nl.utwente.apc.Code2D.resource.c2d.IC2dExpectedElement newFollower = newFollowerPair.getLeft();
							org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
							nl.utwente.apc.Code2D.resource.c2d.grammar.C2dContainmentTrace containmentTrace = new nl.utwente.apc.Code2D.resource.c2d.grammar.C2dContainmentTrace(null, newFollowerPair.getRight());
							nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectedTerminal newFollowTerminal = new nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectedTerminal(container, newFollower, followSetID, containmentTrace);
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
		for (nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectedTerminal nextFollow : newFollowSet) {
			lastTokenIndex = 0;
			setPosition(nextFollow, i);
		}
		return this.expectedElements;
	}
	
	public void setPosition(nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectedTerminal expectedElement, int tokenIndex) {
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
	
}

start returns [ org.eclipse.emf.ecore.EObject element = null]
:
	{
		// follow set for start rule(s)
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[0]);
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[1]);
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[2]);
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[3]);
		expectedElementsIndexOfLastCompleteElement = 0;
	}
	(
		c0 = parse_nl_utwente_apc_Code2D_Game{ element = c0; }
		|  		c1 = parse_nl_utwente_apc_Code2D_Player{ element = c1; }
		|  		c2 = parse_nl_utwente_apc_Code2D_NPC{ element = c2; }
		|  		c3 = parse_nl_utwente_apc_Code2D_Item{ element = c3; }
	)
	EOF	{
		retrieveLayoutInformation(element, null, null, false);
	}
	
;

parse_nl_utwente_apc_Code2D_Game returns [nl.utwente.apc.Code2D.Game element = null]
@init{
}
:
	a0 = 'Game' {
		if (element == null) {
			element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createGame();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.c2d.grammar.C2dGrammarInformationProvider.C2D_0_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[4]);
	}
	
	a1 = '{' {
		if (element == null) {
			element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createGame();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.c2d.grammar.C2dGrammarInformationProvider.C2D_0_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[5]);
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[6]);
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[7]);
	}
	
	(
		(
			(
				a2 = TEXT				
				{
					if (terminateParsing) {
						throw new nl.utwente.apc.Code2D.resource.c2d.mopp.C2dTerminateParsingException();
					}
					if (element == null) {
						element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createGame();
						startIncompleteElement(element);
					}
					if (a2 != null) {
						nl.utwente.apc.Code2D.resource.c2d.IC2dTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
						tokenResolver.setOptions(getOptions());
						nl.utwente.apc.Code2D.resource.c2d.IC2dTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.GAME__NAME), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
						}
						java.lang.String resolved = (java.lang.String) resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							addObjectToList(element, nl.utwente.apc.Code2D.Code2DPackage.GAME__NAME, value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.c2d.grammar.C2dGrammarInformationProvider.C2D_0_0_0_2_0_0_0, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[8]);
				addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[9]);
				addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[10]);
			}
			
			
			|			a3 = 'GameWorld' {
				if (element == null) {
					element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createGame();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.c2d.grammar.C2dGrammarInformationProvider.C2D_0_0_0_2_0_1_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[11]);
			}
			
			a4 = ':' {
				if (element == null) {
					element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createGame();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.c2d.grammar.C2dGrammarInformationProvider.C2D_0_0_0_2_0_1_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[12]);
			}
			
			(
				a5_0 = parse_nl_utwente_apc_Code2D_World				{
					if (terminateParsing) {
						throw new nl.utwente.apc.Code2D.resource.c2d.mopp.C2dTerminateParsingException();
					}
					if (element == null) {
						element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createGame();
						startIncompleteElement(element);
					}
					if (a5_0 != null) {
						if (a5_0 != null) {
							Object value = a5_0;
							element.eSet(element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.GAME__GAME_WORLD), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.c2d.grammar.C2dGrammarInformationProvider.C2D_0_0_0_2_0_1_2, a5_0, true);
						copyLocalizationInfos(a5_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[13]);
				addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[14]);
				addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[15]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[16]);
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[17]);
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[18]);
	}
	
	a6 = '}' {
		if (element == null) {
			element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createGame();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.c2d.grammar.C2dGrammarInformationProvider.C2D_0_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
	}
	
;

parse_nl_utwente_apc_Code2D_World returns [nl.utwente.apc.Code2D.World element = null]
@init{
}
:
	a0 = 'World' {
		if (element == null) {
			element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createWorld();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.c2d.grammar.C2dGrammarInformationProvider.C2D_1_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[19]);
	}
	
	a1 = ';' {
		if (element == null) {
			element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createWorld();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.c2d.grammar.C2dGrammarInformationProvider.C2D_1_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[20]);
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[21]);
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[22]);
	}
	
;

parse_nl_utwente_apc_Code2D_Player returns [nl.utwente.apc.Code2D.Player element = null]
@init{
}
:
	a0 = 'Player' {
		if (element == null) {
			element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createPlayer();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.c2d.grammar.C2dGrammarInformationProvider.C2D_2_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[23]);
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[24]);
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[25]);
	}
	
	(
		(
			(
				a1 = QUOTED_34_34				
				{
					if (terminateParsing) {
						throw new nl.utwente.apc.Code2D.resource.c2d.mopp.C2dTerminateParsingException();
					}
					if (element == null) {
						element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createPlayer();
						startIncompleteElement(element);
					}
					if (a1 != null) {
						nl.utwente.apc.Code2D.resource.c2d.IC2dTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
						tokenResolver.setOptions(getOptions());
						nl.utwente.apc.Code2D.resource.c2d.IC2dTokenResolveResult result = getFreshTokenResolveResult();
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
						retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.c2d.grammar.C2dGrammarInformationProvider.C2D_2_0_0_1_0_0_0, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[26]);
				addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[27]);
				addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[28]);
			}
			
			
			|			(
				a2 = QUOTED_34_34				
				{
					if (terminateParsing) {
						throw new nl.utwente.apc.Code2D.resource.c2d.mopp.C2dTerminateParsingException();
					}
					if (element == null) {
						element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createPlayer();
						startIncompleteElement(element);
					}
					if (a2 != null) {
						nl.utwente.apc.Code2D.resource.c2d.IC2dTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
						tokenResolver.setOptions(getOptions());
						nl.utwente.apc.Code2D.resource.c2d.IC2dTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.PLAYER__TEXTURE), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
						}
						java.lang.String resolved = (java.lang.String) resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							element.eSet(element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.PLAYER__TEXTURE), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.c2d.grammar.C2dGrammarInformationProvider.C2D_2_0_0_1_0_1_0, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[29]);
				addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[30]);
				addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[31]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[32]);
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[33]);
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[34]);
	}
	
	a3 = ';' {
		if (element == null) {
			element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createPlayer();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.c2d.grammar.C2dGrammarInformationProvider.C2D_2_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
	}
	
;

parse_nl_utwente_apc_Code2D_NPC returns [nl.utwente.apc.Code2D.NPC element = null]
@init{
}
:
	a0 = 'NPC' {
		if (element == null) {
			element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createNPC();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.c2d.grammar.C2dGrammarInformationProvider.C2D_3_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[35]);
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[36]);
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[37]);
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[38]);
	}
	
	(
		(
			(
				a1 = QUOTED_34_34				
				{
					if (terminateParsing) {
						throw new nl.utwente.apc.Code2D.resource.c2d.mopp.C2dTerminateParsingException();
					}
					if (element == null) {
						element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createNPC();
						startIncompleteElement(element);
					}
					if (a1 != null) {
						nl.utwente.apc.Code2D.resource.c2d.IC2dTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
						tokenResolver.setOptions(getOptions());
						nl.utwente.apc.Code2D.resource.c2d.IC2dTokenResolveResult result = getFreshTokenResolveResult();
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
						retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.c2d.grammar.C2dGrammarInformationProvider.C2D_3_0_0_1_0_0_0, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[39]);
				addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[40]);
				addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[41]);
				addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[42]);
			}
			
			
			|			(
				a2 = QUOTED_34_34				
				{
					if (terminateParsing) {
						throw new nl.utwente.apc.Code2D.resource.c2d.mopp.C2dTerminateParsingException();
					}
					if (element == null) {
						element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createNPC();
						startIncompleteElement(element);
					}
					if (a2 != null) {
						nl.utwente.apc.Code2D.resource.c2d.IC2dTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
						tokenResolver.setOptions(getOptions());
						nl.utwente.apc.Code2D.resource.c2d.IC2dTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.NPC__TEXTURE), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
						}
						java.lang.String resolved = (java.lang.String) resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							element.eSet(element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.NPC__TEXTURE), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.c2d.grammar.C2dGrammarInformationProvider.C2D_3_0_0_1_0_1_0, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[43]);
				addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[44]);
				addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[45]);
				addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[46]);
			}
			
			
			|			(
				(
					a3 = 'Friendly' {
						if (element == null) {
							element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createNPC();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.c2d.grammar.C2dGrammarInformationProvider.C2D_3_0_0_1_0_2_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
						// set value of enumeration attribute
						Object value = nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getNPCBehaviour().getEEnumLiteral(nl.utwente.apc.Code2D.NPCBehaviour.FRIENDLY_VALUE).getInstance();
						element.eSet(element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.NPC__BEHAVIOUR), value);
						completedElement(value, false);
					}
					|					a4 = 'Neutral' {
						if (element == null) {
							element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createNPC();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.c2d.grammar.C2dGrammarInformationProvider.C2D_3_0_0_1_0_2_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
						// set value of enumeration attribute
						Object value = nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getNPCBehaviour().getEEnumLiteral(nl.utwente.apc.Code2D.NPCBehaviour.NEUTRAL_VALUE).getInstance();
						element.eSet(element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.NPC__BEHAVIOUR), value);
						completedElement(value, false);
					}
					|					a5 = 'Hostile' {
						if (element == null) {
							element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createNPC();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.c2d.grammar.C2dGrammarInformationProvider.C2D_3_0_0_1_0_2_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
						// set value of enumeration attribute
						Object value = nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getNPCBehaviour().getEEnumLiteral(nl.utwente.apc.Code2D.NPCBehaviour.HOSTILE_VALUE).getInstance();
						element.eSet(element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.NPC__BEHAVIOUR), value);
						completedElement(value, false);
					}
				)
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[47]);
				addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[48]);
				addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[49]);
				addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[50]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[51]);
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[52]);
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[53]);
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[54]);
	}
	
	a8 = ';' {
		if (element == null) {
			element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createNPC();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.c2d.grammar.C2dGrammarInformationProvider.C2D_3_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
	}
	{
		// expected elements (follow set)
	}
	
;

parse_nl_utwente_apc_Code2D_Item returns [nl.utwente.apc.Code2D.Item element = null]
@init{
}
:
	a0 = 'Item' {
		if (element == null) {
			element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createItem();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.c2d.grammar.C2dGrammarInformationProvider.C2D_4_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[55]);
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[56]);
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[57]);
	}
	
	(
		(
			(
				a1 = QUOTED_34_34				
				{
					if (terminateParsing) {
						throw new nl.utwente.apc.Code2D.resource.c2d.mopp.C2dTerminateParsingException();
					}
					if (element == null) {
						element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createItem();
						startIncompleteElement(element);
					}
					if (a1 != null) {
						nl.utwente.apc.Code2D.resource.c2d.IC2dTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
						tokenResolver.setOptions(getOptions());
						nl.utwente.apc.Code2D.resource.c2d.IC2dTokenResolveResult result = getFreshTokenResolveResult();
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
						retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.c2d.grammar.C2dGrammarInformationProvider.C2D_4_0_0_1_0_0_0, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[58]);
				addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[59]);
				addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[60]);
			}
			
			
			|			(
				a2 = QUOTED_34_34				
				{
					if (terminateParsing) {
						throw new nl.utwente.apc.Code2D.resource.c2d.mopp.C2dTerminateParsingException();
					}
					if (element == null) {
						element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createItem();
						startIncompleteElement(element);
					}
					if (a2 != null) {
						nl.utwente.apc.Code2D.resource.c2d.IC2dTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
						tokenResolver.setOptions(getOptions());
						nl.utwente.apc.Code2D.resource.c2d.IC2dTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.ITEM__TEXTURE), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
						}
						java.lang.String resolved = (java.lang.String) resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							element.eSet(element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.ITEM__TEXTURE), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.c2d.grammar.C2dGrammarInformationProvider.C2D_4_0_0_1_0_1_0, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[61]);
				addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[62]);
				addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[63]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[64]);
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[65]);
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.c2d.mopp.C2dExpectationConstants.EXPECTATIONS[66]);
	}
	
	a3 = ';' {
		if (element == null) {
			element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createItem();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.c2d.grammar.C2dGrammarInformationProvider.C2D_4_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
	}
	
;

COMMENT:
	('//'(~('\n'|'\r'|'\uffff'))*)
	{ _channel = 99; }
;
INTEGER:
	(('-')?('1'..'9')('0'..'9')*|'0')
	{ _channel = 99; }
;
FLOAT:
	(('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ )
	{ _channel = 99; }
;
TEXT:
	(('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+)
;
WHITESPACE:
	((' ' | '\t' | '\f'))
	{ _channel = 99; }
;
LINEBREAK:
	(('\r\n' | '\r' | '\n'))
	{ _channel = 99; }
;
QUOTED_34_34:
	(('"')(~('"'))*('"'))
;

