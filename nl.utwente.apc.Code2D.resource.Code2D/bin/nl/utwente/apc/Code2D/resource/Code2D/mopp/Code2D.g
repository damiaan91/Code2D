grammar Code2D;

options {
	superClass = Code2DANTLRParserBase;
	backtrack = true;
	memoize = true;
}

@lexer::header {
	package nl.utwente.apc.Code2D.resource.Code2D.mopp;
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
	package nl.utwente.apc.Code2D.resource.Code2D.mopp;
}

@members{
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
	
}

start returns [ org.eclipse.emf.ecore.EObject element = null]
:
	{
		// follow set for start rule(s)
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[0]);
		expectedElementsIndexOfLastCompleteElement = 0;
	}
	(
		c0 = parse_nl_utwente_apc_Code2D_Game{ element = c0; }
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
		retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_0_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[1]);
	}
	
	(
		a1 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[2]);
	}
	
	a2 = '{' {
		if (element == null) {
			element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createGame();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_0_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[3]);
		addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[4]);
		addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[5]);
		addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[6]);
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[7]);
	}
	
	(
		(
			(
				a3_0 = parse_nl_utwente_apc_Code2D_World				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[8]);
				addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[9]);
				addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[10]);
				addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[11]);
				addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[12]);
			}
			
			
			|			(
				a4_0 = parse_nl_utwente_apc_Code2D_GameObject				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[13]);
				addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[14]);
				addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[15]);
				addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[16]);
				addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[17]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[18]);
		addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[19]);
		addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[20]);
		addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[21]);
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[22]);
	}
	
	a5 = '}' {
		if (element == null) {
			element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createGame();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_0_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
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
		retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_1_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[23]);
	}
	
	(
		a1 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[24]);
	}
	
	a2 = '{' {
		if (element == null) {
			element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createWorld();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_1_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[25]);
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[26]);
	}
	
	(
		(
			a3 = 'Other things;' {
				if (element == null) {
					element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createWorld();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_1_0_0_3_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[27]);
				addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[28]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[29]);
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[30]);
	}
	
	a4 = '}' {
		if (element == null) {
			element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createWorld();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_1_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[31]);
		addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[32]);
		addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[33]);
		addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[34]);
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[35]);
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
		retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_2_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[36]);
	}
	
	(
		a1 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[37]);
	}
	
	a2 = '{' {
		if (element == null) {
			element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createPlayer();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_2_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[38]);
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[39]);
	}
	
	(
		(
			a3 = 'Texture' {
				if (element == null) {
					element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createPlayer();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_2_0_0_3_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[40]);
			}
			
			a4 = ':' {
				if (element == null) {
					element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createPlayer();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_2_0_0_3_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[41]);
			}
			
			(
				a5 = QUOTED_4748_59				
				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[42]);
				addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[43]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[44]);
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[45]);
	}
	
	a6 = '}' {
		if (element == null) {
			element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createPlayer();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_2_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[46]);
		addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[47]);
		addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[48]);
		addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[49]);
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[50]);
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
		retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_3_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[51]);
	}
	
	(
		a1 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[52]);
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[53]);
	}
	
	(
		(
			a2 = ':' {
				if (element == null) {
					element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createNPC();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_3_0_0_2_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[54]);
			}
			
			(
				a3 = TEXT				
				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[55]);
				addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[56]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[57]);
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[58]);
	}
	
	a4 = '{' {
		if (element == null) {
			element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createNPC();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_3_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[59]);
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[60]);
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[61]);
	}
	
	(
		(
			a5 = 'Texture' {
				if (element == null) {
					element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createNPC();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_3_0_0_4_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[62]);
			}
			
			a6 = ':' {
				if (element == null) {
					element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createNPC();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_3_0_0_4_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[63]);
			}
			
			(
				a7 = TEXT				
				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[64]);
			}
			
			a8 = ';' {
				if (element == null) {
					element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createNPC();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_3_0_0_4_0_0_3, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[65]);
				addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[66]);
				addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[67]);
			}
			
			
			|			a9 = 'Behaviour' {
				if (element == null) {
					element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createNPC();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_3_0_0_4_0_1_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[68]);
			}
			
			a10 = ':' {
				if (element == null) {
					element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createNPC();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_3_0_0_4_0_1_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a10, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[69]);
			}
			
			(
				(
					a11 = 'Friendly' {
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
					|					a12 = 'Neutral' {
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
					|					a13 = 'Hostile' {
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
				)
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[70]);
			}
			
			a16 = ';' {
				if (element == null) {
					element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createNPC();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_3_0_0_4_0_1_3, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a16, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[71]);
				addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[72]);
				addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[73]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[74]);
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[75]);
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[76]);
	}
	
	a17 = '}' {
		if (element == null) {
			element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createNPC();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_3_0_0_5, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a17, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[77]);
		addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[78]);
		addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[79]);
		addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[80]);
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[81]);
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
		retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_4_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[82]);
	}
	
	(
		a1 = TEXT		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[83]);
	}
	
	a2 = '{' {
		if (element == null) {
			element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createItem();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_4_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[84]);
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[85]);
	}
	
	(
		(
			a3 = 'Texture' {
				if (element == null) {
					element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createItem();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_4_0_0_3_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[86]);
			}
			
			a4 = ':' {
				if (element == null) {
					element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createItem();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_4_0_0_3_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[87]);
			}
			
			(
				a5 = TEXT				
				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[88]);
			}
			
			a6 = ';' {
				if (element == null) {
					element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createItem();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_4_0_0_3_0_0_3, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[89]);
				addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[90]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[91]);
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[92]);
	}
	
	a7 = '}' {
		if (element == null) {
			element = nl.utwente.apc.Code2D.Code2DFactory.eINSTANCE.createItem();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, nl.utwente.apc.Code2D.resource.Code2D.grammar.Code2DGrammarInformationProvider.CODE2D_4_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[93]);
		addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[94]);
		addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[95]);
		addExpectedElement(nl.utwente.apc.Code2D.Code2DPackage.eINSTANCE.getGame(), nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[96]);
		addExpectedElement(null, nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DExpectationConstants.EXPECTATIONS[97]);
	}
	
;

parse_nl_utwente_apc_Code2D_GameObject returns [nl.utwente.apc.Code2D.GameObject element = null]
:
	c0 = parse_nl_utwente_apc_Code2D_Player{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_nl_utwente_apc_Code2D_NPC{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_nl_utwente_apc_Code2D_Item{ element = c2; /* this is a subclass or primitive expression choice */ }
	
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
QUOTED_4748_59:
	(('/0')(~(';'))*(';'))
;

