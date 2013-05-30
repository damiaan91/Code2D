/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.Code2D.mopp;

public class Code2DResource extends org.eclipse.emf.ecore.resource.impl.ResourceImpl implements nl.utwente.apc.Code2D.resource.Code2D.ICode2DTextResource {
	
	public class ElementBasedTextDiagnostic implements nl.utwente.apc.Code2D.resource.Code2D.ICode2DTextDiagnostic {
		
		private final nl.utwente.apc.Code2D.resource.Code2D.ICode2DLocationMap locationMap;
		private final org.eclipse.emf.common.util.URI uri;
		private final org.eclipse.emf.ecore.EObject element;
		private final nl.utwente.apc.Code2D.resource.Code2D.ICode2DProblem problem;
		
		public ElementBasedTextDiagnostic(nl.utwente.apc.Code2D.resource.Code2D.ICode2DLocationMap locationMap, org.eclipse.emf.common.util.URI uri, nl.utwente.apc.Code2D.resource.Code2D.ICode2DProblem problem, org.eclipse.emf.ecore.EObject element) {
			super();
			this.uri = uri;
			this.locationMap = locationMap;
			this.element = element;
			this.problem = problem;
		}
		
		public String getMessage() {
			return problem.getMessage();
		}
		
		public nl.utwente.apc.Code2D.resource.Code2D.ICode2DProblem getProblem() {
			return problem;
		}
		
		public String getLocation() {
			return uri.toString();
		}
		
		public int getCharStart() {
			return Math.max(0, locationMap.getCharStart(element));
		}
		
		public int getCharEnd() {
			return Math.max(0, locationMap.getCharEnd(element));
		}
		
		public int getColumn() {
			return Math.max(0, locationMap.getColumn(element));
		}
		
		public int getLine() {
			return Math.max(0, locationMap.getLine(element));
		}
		
		public org.eclipse.emf.ecore.EObject getElement() {
			return element;
		}
		
		public boolean wasCausedBy(org.eclipse.emf.ecore.EObject element) {
			if (this.element == null) {
				return false;
			}
			return this.element.equals(element);
		}
		
		public String toString() {
			return getMessage() + " at " + getLocation() + " line " + getLine() + ", column " + getColumn();
		}
	}
	
	public class PositionBasedTextDiagnostic implements nl.utwente.apc.Code2D.resource.Code2D.ICode2DTextDiagnostic {
		
		private final org.eclipse.emf.common.util.URI uri;
		
		private int column;
		private int line;
		private int charStart;
		private int charEnd;
		private nl.utwente.apc.Code2D.resource.Code2D.ICode2DProblem problem;
		
		public PositionBasedTextDiagnostic(org.eclipse.emf.common.util.URI uri, nl.utwente.apc.Code2D.resource.Code2D.ICode2DProblem problem, int column, int line, int charStart, int charEnd) {
			
			super();
			this.uri = uri;
			this.column = column;
			this.line = line;
			this.charStart = charStart;
			this.charEnd = charEnd;
			this.problem = problem;
		}
		
		public nl.utwente.apc.Code2D.resource.Code2D.ICode2DProblem getProblem() {
			return problem;
		}
		
		public int getCharStart() {
			return charStart;
		}
		
		public int getCharEnd() {
			return charEnd;
		}
		
		public int getColumn() {
			return column;
		}
		
		public int getLine() {
			return line;
		}
		
		public String getLocation() {
			return uri.toString();
		}
		
		public String getMessage() {
			return problem.getMessage();
		}
		
		public boolean wasCausedBy(org.eclipse.emf.ecore.EObject element) {
			return false;
		}
		
		public String toString() {
			return getMessage() + " at " + getLocation() + " line " + getLine() + ", column " + getColumn();
		}
	}
	
	private nl.utwente.apc.Code2D.resource.Code2D.ICode2DReferenceResolverSwitch resolverSwitch;
	private nl.utwente.apc.Code2D.resource.Code2D.ICode2DLocationMap locationMap;
	private int proxyCounter = 0;
	private nl.utwente.apc.Code2D.resource.Code2D.ICode2DTextParser parser;
	private nl.utwente.apc.Code2D.resource.Code2D.util.Code2DLayoutUtil layoutUtil = new nl.utwente.apc.Code2D.resource.Code2D.util.Code2DLayoutUtil();
	private nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DMarkerHelper markerHelper;
	private java.util.Map<String, nl.utwente.apc.Code2D.resource.Code2D.ICode2DContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject>> internalURIFragmentMap = new java.util.LinkedHashMap<String, nl.utwente.apc.Code2D.resource.Code2D.ICode2DContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject>>();
	private java.util.Map<String, nl.utwente.apc.Code2D.resource.Code2D.ICode2DQuickFix> quickFixMap = new java.util.LinkedHashMap<String, nl.utwente.apc.Code2D.resource.Code2D.ICode2DQuickFix>();
	private java.util.Map<?, ?> loadOptions;
	
	/**
	 * If a post-processor is currently running, this field holds a reference to it.
	 * This reference is used to terminate post-processing if needed.
	 */
	private nl.utwente.apc.Code2D.resource.Code2D.ICode2DResourcePostProcessor runningPostProcessor;
	
	/**
	 * A flag (and lock) to indicate whether reloading of the resource shall be
	 * cancelled.
	 */
	private Boolean terminateReload = false;
	private Object terminateReloadLock = new Object();
	private Object loadingLock = new Object();
	private boolean delayNotifications = false;
	private java.util.List<org.eclipse.emf.common.notify.Notification> delayedNotifications = new java.util.ArrayList<org.eclipse.emf.common.notify.Notification>();
	private java.io.InputStream latestReloadInputStream = null;
	private java.util.Map<?, ?> latestReloadOptions = null;
	private nl.utwente.apc.Code2D.resource.Code2D.util.Code2DInterruptibleEcoreResolver interruptibleResolver;
	
	protected nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DMetaInformation metaInformation = new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DMetaInformation();
	
	public Code2DResource() {
		super();
		resetLocationMap();
	}
	
	public Code2DResource(org.eclipse.emf.common.util.URI uri) {
		super(uri);
		resetLocationMap();
	}
	
	protected void doLoad(java.io.InputStream inputStream, java.util.Map<?,?> options) throws java.io.IOException {
		synchronized (loadingLock) {
			if (processTerminationRequested()) {
				return;
			}
			this.loadOptions = options;
			delayNotifications = true;
			resetLocationMap();
			String encoding = getEncoding(options);
			java.io.InputStream actualInputStream = inputStream;
			Object inputStreamPreProcessorProvider = null;
			if (options != null) {
				inputStreamPreProcessorProvider = options.get(nl.utwente.apc.Code2D.resource.Code2D.ICode2DOptions.INPUT_STREAM_PREPROCESSOR_PROVIDER);
			}
			if (inputStreamPreProcessorProvider != null) {
				if (inputStreamPreProcessorProvider instanceof nl.utwente.apc.Code2D.resource.Code2D.ICode2DInputStreamProcessorProvider) {
					nl.utwente.apc.Code2D.resource.Code2D.ICode2DInputStreamProcessorProvider provider = (nl.utwente.apc.Code2D.resource.Code2D.ICode2DInputStreamProcessorProvider) inputStreamPreProcessorProvider;
					nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DInputStreamProcessor processor = provider.getInputStreamProcessor(inputStream);
					actualInputStream = processor;
				}
			}
			
			parser = getMetaInformation().createParser(actualInputStream, encoding);
			parser.setOptions(options);
			nl.utwente.apc.Code2D.resource.Code2D.ICode2DReferenceResolverSwitch referenceResolverSwitch = getReferenceResolverSwitch();
			referenceResolverSwitch.setOptions(options);
			nl.utwente.apc.Code2D.resource.Code2D.ICode2DParseResult result = parser.parse();
			// dispose parser, we don't need it anymore
			parser = null;
			
			if (processTerminationRequested()) {
				// do nothing if reload was already restarted
				return;
			}
			
			clearState();
			getContentsInternal().clear();
			org.eclipse.emf.ecore.EObject root = null;
			if (result != null) {
				root = result.getRoot();
				if (root != null) {
					if (isLayoutInformationRecordingEnabled()) {
						layoutUtil.transferAllLayoutInformationToModel(root);
					}
					if (processTerminationRequested()) {
						// the next reload will add new content
						return;
					}
					getContentsInternal().add(root);
				}
				java.util.Collection<nl.utwente.apc.Code2D.resource.Code2D.ICode2DCommand<nl.utwente.apc.Code2D.resource.Code2D.ICode2DTextResource>> commands = result.getPostParseCommands();
				if (commands != null) {
					for (nl.utwente.apc.Code2D.resource.Code2D.ICode2DCommand<nl.utwente.apc.Code2D.resource.Code2D.ICode2DTextResource>  command : commands) {
						command.execute(this);
					}
				}
			}
			getReferenceResolverSwitch().setOptions(options);
			if (getErrors().isEmpty()) {
				if (!runPostProcessors(options)) {
					return;
				}
				if (root != null) {
					runValidators(root);
				}
			}
			notifyDelayed();
		}
	}
	
	protected boolean processTerminationRequested() {
		if (terminateReload) {
			delayNotifications = false;
			delayedNotifications.clear();
			return true;
		}
		return false;
	}
	protected void notifyDelayed() {
		delayNotifications = false;
		for (org.eclipse.emf.common.notify.Notification delayedNotification : delayedNotifications) {
			super.eNotify(delayedNotification);
		}
		delayedNotifications.clear();
	}
	public void eNotify(org.eclipse.emf.common.notify.Notification notification) {
		if (delayNotifications) {
			delayedNotifications.add(notification);
		} else {
			super.eNotify(notification);
		}
	}
	/**
	 * Reloads the contents of this resource from the given stream.
	 */
	public void reload(java.io.InputStream inputStream, java.util.Map<?,?> options) throws java.io.IOException {
		synchronized (terminateReloadLock) {
			latestReloadInputStream = inputStream;
			latestReloadOptions = options;
			if (terminateReload == true) {
				// //reload already requested
			}
			terminateReload = true;
		}
		cancelReload();
		synchronized (loadingLock) {
			synchronized (terminateReloadLock) {
				terminateReload = false;
			}
			isLoaded = false;
			java.util.Map<Object, Object> loadOptions = addDefaultLoadOptions(latestReloadOptions);
			try {
				doLoad(latestReloadInputStream, loadOptions);
			} catch (nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DTerminateParsingException tpe) {
				// do nothing - the resource is left unchanged if this exception is thrown
			}
			resolveAfterParsing();
			isLoaded = true;
		}
	}
	
	/**
	 * Cancels reloading this resource. The running parser and post processors are
	 * terminated.
	 */
	protected void cancelReload() {
		// Cancel parser
		nl.utwente.apc.Code2D.resource.Code2D.ICode2DTextParser parserCopy = parser;
		if (parserCopy != null) {
			parserCopy.terminate();
		}
		// Cancel post processor(s)
		nl.utwente.apc.Code2D.resource.Code2D.ICode2DResourcePostProcessor runningPostProcessorCopy = runningPostProcessor;
		if (runningPostProcessorCopy != null) {
			runningPostProcessorCopy.terminate();
		}
		// Cancel reference resolving
		nl.utwente.apc.Code2D.resource.Code2D.util.Code2DInterruptibleEcoreResolver interruptibleResolverCopy = interruptibleResolver;
		if (interruptibleResolverCopy != null) {
			interruptibleResolverCopy.terminate();
		}
	}
	
	protected void doSave(java.io.OutputStream outputStream, java.util.Map<?,?> options) throws java.io.IOException {
		nl.utwente.apc.Code2D.resource.Code2D.ICode2DTextPrinter printer = getMetaInformation().createPrinter(outputStream, this);
		nl.utwente.apc.Code2D.resource.Code2D.ICode2DReferenceResolverSwitch referenceResolverSwitch = getReferenceResolverSwitch();
		printer.setEncoding(getEncoding(options));
		referenceResolverSwitch.setOptions(options);
		for (org.eclipse.emf.ecore.EObject root : getContentsInternal()) {
			if (isLayoutInformationRecordingEnabled()) {
				layoutUtil.transferAllLayoutInformationFromModel(root);
			}
			printer.print(root);
			if (isLayoutInformationRecordingEnabled()) {
				layoutUtil.transferAllLayoutInformationToModel(root);
			}
		}
	}
	
	protected String getSyntaxName() {
		return "Code2D";
	}
	
	public String getEncoding(java.util.Map<?, ?> options) {
		String encoding = null;
		if (new nl.utwente.apc.Code2D.resource.Code2D.util.Code2DRuntimeUtil().isEclipsePlatformAvailable()) {
			encoding = new nl.utwente.apc.Code2D.resource.Code2D.util.Code2DEclipseProxy().getPlatformResourceEncoding(uri);
		}
		if (options != null) {
			Object encodingOption = options.get(nl.utwente.apc.Code2D.resource.Code2D.ICode2DOptions.OPTION_ENCODING);
			if (encodingOption != null) {
				encoding = encodingOption.toString();
			}
		}
		return encoding;
	}
	
	public nl.utwente.apc.Code2D.resource.Code2D.ICode2DReferenceResolverSwitch getReferenceResolverSwitch() {
		if (resolverSwitch == null) {
			resolverSwitch = new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DReferenceResolverSwitch();
		}
		return resolverSwitch;
	}
	
	public nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DMetaInformation getMetaInformation() {
		return new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DMetaInformation();
	}
	
	/**
	 * Clears the location map by replacing it with a new instance.
	 */
	protected void resetLocationMap() {
		if (isLocationMapEnabled()) {
			locationMap = new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DLocationMap();
		} else {
			locationMap = new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DDevNullLocationMap();
		}
	}
	
	public void addURIFragment(String internalURIFragment, nl.utwente.apc.Code2D.resource.Code2D.ICode2DContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject> uriFragment) {
		internalURIFragmentMap.put(internalURIFragment, uriFragment);
	}
	
	public <ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> void registerContextDependentProxy(nl.utwente.apc.Code2D.resource.Code2D.ICode2DContextDependentURIFragmentFactory<ContainerType, ReferenceType> factory, ContainerType container, org.eclipse.emf.ecore.EReference reference, String id, org.eclipse.emf.ecore.EObject proxyElement, int position) {
		org.eclipse.emf.ecore.InternalEObject proxy = (org.eclipse.emf.ecore.InternalEObject) proxyElement;
		String internalURIFragment = nl.utwente.apc.Code2D.resource.Code2D.ICode2DContextDependentURIFragment.INTERNAL_URI_FRAGMENT_PREFIX + (proxyCounter++) + "_" + id;
		nl.utwente.apc.Code2D.resource.Code2D.ICode2DContextDependentURIFragment<?> uriFragment = factory.create(id, container, reference, position, proxy);
		proxy.eSetProxyURI(getURI().appendFragment(internalURIFragment));
		addURIFragment(internalURIFragment, uriFragment);
	}
	
	public org.eclipse.emf.ecore.EObject getEObject(String id) {
		if (internalURIFragmentMap.containsKey(id)) {
			nl.utwente.apc.Code2D.resource.Code2D.ICode2DContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject> uriFragment = internalURIFragmentMap.get(id);
			boolean wasResolvedBefore = uriFragment.isResolved();
			nl.utwente.apc.Code2D.resource.Code2D.ICode2DReferenceResolveResult<? extends org.eclipse.emf.ecore.EObject> result = null;
			// catch and report all Exceptions that occur during proxy resolving
			try {
				result = uriFragment.resolve();
			} catch (Exception e) {
				String message = "An expection occured while resolving the proxy for: "+ id + ". (" + e.toString() + ")";
				addProblem(new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DProblem(message, nl.utwente.apc.Code2D.resource.Code2D.Code2DEProblemType.UNRESOLVED_REFERENCE, nl.utwente.apc.Code2D.resource.Code2D.Code2DEProblemSeverity.ERROR), uriFragment.getProxy());
				new nl.utwente.apc.Code2D.resource.Code2D.util.Code2DRuntimeUtil().logError(message, e);
			}
			if (result == null) {
				// the resolving did call itself
				return null;
			}
			if (!wasResolvedBefore && !result.wasResolved()) {
				attachResolveError(result, uriFragment.getProxy());
				return null;
			} else if (!result.wasResolved()) {
				return null;
			} else {
				org.eclipse.emf.ecore.EObject proxy = uriFragment.getProxy();
				// remove an error that might have been added by an earlier attempt
				removeDiagnostics(proxy, getErrors());
				// remove old warnings and attach new
				removeDiagnostics(proxy, getWarnings());
				attachResolveWarnings(result, proxy);
				nl.utwente.apc.Code2D.resource.Code2D.ICode2DReferenceMapping<? extends org.eclipse.emf.ecore.EObject> mapping = result.getMappings().iterator().next();
				org.eclipse.emf.ecore.EObject resultElement = getResultElement(uriFragment, mapping, proxy, result.getErrorMessage());
				org.eclipse.emf.ecore.EObject container = uriFragment.getContainer();
				replaceProxyInLayoutAdapters(container, proxy, resultElement);
				return resultElement;
			}
		} else {
			return super.getEObject(id);
		}
	}
	
	protected void replaceProxyInLayoutAdapters(org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EObject proxy, org.eclipse.emf.ecore.EObject target) {
		for (org.eclipse.emf.common.notify.Adapter adapter : container.eAdapters()) {
			if (adapter instanceof nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DLayoutInformationAdapter) {
				nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DLayoutInformationAdapter layoutInformationAdapter = (nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DLayoutInformationAdapter) adapter;
				layoutInformationAdapter.replaceProxy(proxy, target);
			}
		}
	}
	
	protected org.eclipse.emf.ecore.EObject getResultElement(nl.utwente.apc.Code2D.resource.Code2D.ICode2DContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject> uriFragment, nl.utwente.apc.Code2D.resource.Code2D.ICode2DReferenceMapping<? extends org.eclipse.emf.ecore.EObject> mapping, org.eclipse.emf.ecore.EObject proxy, final String errorMessage) {
		if (mapping instanceof nl.utwente.apc.Code2D.resource.Code2D.ICode2DURIMapping<?>) {
			org.eclipse.emf.common.util.URI uri = ((nl.utwente.apc.Code2D.resource.Code2D.ICode2DURIMapping<? extends org.eclipse.emf.ecore.EObject>)mapping).getTargetIdentifier();
			if (uri != null) {
				org.eclipse.emf.ecore.EObject result = null;
				try {
					result = this.getResourceSet().getEObject(uri, true);
				} catch (Exception e) {
					// we can catch exceptions here, because EMF will try to resolve again and handle
					// the exception
				}
				if (result == null || result.eIsProxy()) {
					// unable to resolve: attach error
					if (errorMessage == null) {
						assert(false);
					} else {
						addProblem(new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DProblem(errorMessage, nl.utwente.apc.Code2D.resource.Code2D.Code2DEProblemType.UNRESOLVED_REFERENCE, nl.utwente.apc.Code2D.resource.Code2D.Code2DEProblemSeverity.ERROR), proxy);
					}
				}
				return result;
			}
			return null;
		} else if (mapping instanceof nl.utwente.apc.Code2D.resource.Code2D.ICode2DElementMapping<?>) {
			org.eclipse.emf.ecore.EObject element = ((nl.utwente.apc.Code2D.resource.Code2D.ICode2DElementMapping<? extends org.eclipse.emf.ecore.EObject>)mapping).getTargetElement();
			org.eclipse.emf.ecore.EReference reference = uriFragment.getReference();
			org.eclipse.emf.ecore.EReference oppositeReference = uriFragment.getReference().getEOpposite();
			if (!uriFragment.getReference().isContainment() && oppositeReference != null) {
				if (reference.isMany()) {
					org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList.ManyInverse<org.eclipse.emf.ecore.EObject> list = nl.utwente.apc.Code2D.resource.Code2D.util.Code2DCastUtil.cast(element.eGet(oppositeReference, false));										// avoids duplicate entries in the reference caused by adding to the
					// oppositeReference
					list.basicAdd(uriFragment.getContainer(),null);
				} else {
					uriFragment.getContainer().eSet(uriFragment.getReference(), element);
				}
			}
			return element;
		} else {
			assert(false);
			return null;
		}
	}
	
	protected void removeDiagnostics(org.eclipse.emf.ecore.EObject cause, java.util.List<org.eclipse.emf.ecore.resource.Resource.Diagnostic> diagnostics) {
		// remove all errors/warnings from this resource
		for (org.eclipse.emf.ecore.resource.Resource.Diagnostic errorCand : new org.eclipse.emf.common.util.BasicEList<org.eclipse.emf.ecore.resource.Resource.Diagnostic>(diagnostics)) {
			if (errorCand instanceof nl.utwente.apc.Code2D.resource.Code2D.ICode2DTextDiagnostic) {
				if (((nl.utwente.apc.Code2D.resource.Code2D.ICode2DTextDiagnostic) errorCand).wasCausedBy(cause)) {
					diagnostics.remove(errorCand);
					unmark(cause);
				}
			}
		}
	}
	
	protected void attachResolveError(nl.utwente.apc.Code2D.resource.Code2D.ICode2DReferenceResolveResult<?> result, org.eclipse.emf.ecore.EObject proxy) {
		// attach errors to this resource
		assert result != null;
		final String errorMessage = result.getErrorMessage();
		if (errorMessage == null) {
			assert(false);
		} else {
			addProblem(new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DProblem(errorMessage, nl.utwente.apc.Code2D.resource.Code2D.Code2DEProblemType.UNRESOLVED_REFERENCE, nl.utwente.apc.Code2D.resource.Code2D.Code2DEProblemSeverity.ERROR, result.getQuickFixes()), proxy);
		}
	}
	
	protected void attachResolveWarnings(nl.utwente.apc.Code2D.resource.Code2D.ICode2DReferenceResolveResult<? extends org.eclipse.emf.ecore.EObject> result, org.eclipse.emf.ecore.EObject proxy) {
		assert result != null;
		assert result.wasResolved();
		if (result.wasResolved()) {
			for (nl.utwente.apc.Code2D.resource.Code2D.ICode2DReferenceMapping<? extends org.eclipse.emf.ecore.EObject> mapping : result.getMappings()) {
				final String warningMessage = mapping.getWarning();
				if (warningMessage == null) {
					continue;
				}
				addProblem(new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DProblem(warningMessage, nl.utwente.apc.Code2D.resource.Code2D.Code2DEProblemType.UNRESOLVED_REFERENCE, nl.utwente.apc.Code2D.resource.Code2D.Code2DEProblemSeverity.WARNING), proxy);
			}
		}
	}
	
	/**
	 * Extends the super implementation by clearing all information about element
	 * positions.
	 */
	protected void doUnload() {
		super.doUnload();
		clearState();
		loadOptions = null;
	}
	
	/**
	 * Runs all post processors to process this resource.
	 */
	protected boolean runPostProcessors(java.util.Map<?, ?> loadOptions) {
		unmark(nl.utwente.apc.Code2D.resource.Code2D.Code2DEProblemType.ANALYSIS_PROBLEM);
		if (processTerminationRequested()) {
			return false;
		}
		// first, run the generated post processor
		runPostProcessor(new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DResourcePostProcessor());
		if (loadOptions == null) {
			return true;
		}
		// then, run post processors that are registered via the load options extension
		// point
		Object resourcePostProcessorProvider = loadOptions.get(nl.utwente.apc.Code2D.resource.Code2D.ICode2DOptions.RESOURCE_POSTPROCESSOR_PROVIDER);
		if (resourcePostProcessorProvider != null) {
			if (resourcePostProcessorProvider instanceof nl.utwente.apc.Code2D.resource.Code2D.ICode2DResourcePostProcessorProvider) {
				runPostProcessor(((nl.utwente.apc.Code2D.resource.Code2D.ICode2DResourcePostProcessorProvider) resourcePostProcessorProvider).getResourcePostProcessor());
			} else if (resourcePostProcessorProvider instanceof java.util.Collection<?>) {
				java.util.Collection<?> resourcePostProcessorProviderCollection = (java.util.Collection<?>) resourcePostProcessorProvider;
				for (Object processorProvider : resourcePostProcessorProviderCollection) {
					if (processTerminationRequested()) {
						return false;
					}
					if (processorProvider instanceof nl.utwente.apc.Code2D.resource.Code2D.ICode2DResourcePostProcessorProvider) {
						nl.utwente.apc.Code2D.resource.Code2D.ICode2DResourcePostProcessorProvider csProcessorProvider = (nl.utwente.apc.Code2D.resource.Code2D.ICode2DResourcePostProcessorProvider) processorProvider;
						nl.utwente.apc.Code2D.resource.Code2D.ICode2DResourcePostProcessor postProcessor = csProcessorProvider.getResourcePostProcessor();
						runPostProcessor(postProcessor);
					}
				}
			}
		}
		return true;
	}
	
	/**
	 * Runs the given post processor to process this resource.
	 */
	protected void runPostProcessor(nl.utwente.apc.Code2D.resource.Code2D.ICode2DResourcePostProcessor postProcessor) {
		try {
			this.runningPostProcessor = postProcessor;
			postProcessor.process(this);
		} catch (Exception e) {
			new nl.utwente.apc.Code2D.resource.Code2D.util.Code2DRuntimeUtil().logError("Exception while running a post-processor.", e);
		}
		this.runningPostProcessor = null;
	}
	
	public void load(java.util.Map<?, ?> options) throws java.io.IOException {
		java.util.Map<Object, Object> loadOptions = addDefaultLoadOptions(options);
		super.load(loadOptions);
		resolveAfterParsing();
	}
	
	protected void resolveAfterParsing() {
		interruptibleResolver = new nl.utwente.apc.Code2D.resource.Code2D.util.Code2DInterruptibleEcoreResolver();
		interruptibleResolver.resolveAll(this);
		interruptibleResolver = null;
	}
	
	public void setURI(org.eclipse.emf.common.util.URI uri) {
		// because of the context dependent proxy resolving it is essential to resolve all
		// proxies before the URI is changed which can cause loss of object identities
		org.eclipse.emf.ecore.util.EcoreUtil.resolveAll(this);
		super.setURI(uri);
	}
	
	/**
	 * Returns the location map that contains information about the position of the
	 * contents of this resource in the original textual representation.
	 */
	public nl.utwente.apc.Code2D.resource.Code2D.ICode2DLocationMap getLocationMap() {
		return locationMap;
	}
	
	public void addProblem(nl.utwente.apc.Code2D.resource.Code2D.ICode2DProblem problem, org.eclipse.emf.ecore.EObject element) {
		ElementBasedTextDiagnostic diagnostic = new ElementBasedTextDiagnostic(locationMap, getURI(), problem, element);
		getDiagnostics(problem.getSeverity()).add(diagnostic);
		mark(diagnostic);
		addQuickFixesToQuickFixMap(problem);
	}
	
	public void addProblem(nl.utwente.apc.Code2D.resource.Code2D.ICode2DProblem problem, int column, int line, int charStart, int charEnd) {
		PositionBasedTextDiagnostic diagnostic = new PositionBasedTextDiagnostic(getURI(), problem, column, line, charStart, charEnd);
		getDiagnostics(problem.getSeverity()).add(diagnostic);
		mark(diagnostic);
		addQuickFixesToQuickFixMap(problem);
	}
	
	protected void addQuickFixesToQuickFixMap(nl.utwente.apc.Code2D.resource.Code2D.ICode2DProblem problem) {
		java.util.Collection<nl.utwente.apc.Code2D.resource.Code2D.ICode2DQuickFix> quickFixes = problem.getQuickFixes();
		if (quickFixes != null) {
			for (nl.utwente.apc.Code2D.resource.Code2D.ICode2DQuickFix quickFix : quickFixes) {
				if (quickFix != null) {
					quickFixMap.put(quickFix.getContextAsString(), quickFix);
				}
			}
		}
	}
	
	@Deprecated	
	public void addError(String message, org.eclipse.emf.ecore.EObject cause) {
		addError(message, nl.utwente.apc.Code2D.resource.Code2D.Code2DEProblemType.UNKNOWN, cause);
	}
	
	public void addError(String message, nl.utwente.apc.Code2D.resource.Code2D.Code2DEProblemType type, org.eclipse.emf.ecore.EObject cause) {
		addProblem(new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DProblem(message, type, nl.utwente.apc.Code2D.resource.Code2D.Code2DEProblemSeverity.ERROR), cause);
	}
	
	@Deprecated	
	public void addWarning(String message, org.eclipse.emf.ecore.EObject cause) {
		addWarning(message, nl.utwente.apc.Code2D.resource.Code2D.Code2DEProblemType.UNKNOWN, cause);
	}
	
	public void addWarning(String message, nl.utwente.apc.Code2D.resource.Code2D.Code2DEProblemType type, org.eclipse.emf.ecore.EObject cause) {
		addProblem(new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DProblem(message, type, nl.utwente.apc.Code2D.resource.Code2D.Code2DEProblemSeverity.WARNING), cause);
	}
	
	protected java.util.List<org.eclipse.emf.ecore.resource.Resource.Diagnostic> getDiagnostics(nl.utwente.apc.Code2D.resource.Code2D.Code2DEProblemSeverity severity) {
		if (severity == nl.utwente.apc.Code2D.resource.Code2D.Code2DEProblemSeverity.ERROR) {
			return getErrors();
		} else {
			return getWarnings();
		}
	}
	
	protected java.util.Map<Object, Object> addDefaultLoadOptions(java.util.Map<?, ?> loadOptions) {
		java.util.Map<Object, Object> loadOptionsCopy = nl.utwente.apc.Code2D.resource.Code2D.util.Code2DMapUtil.copySafelyToObjectToObjectMap(loadOptions);
		// first add static option provider
		loadOptionsCopy.putAll(new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DOptionProvider().getOptions());
		
		// second, add dynamic option providers that are registered via extension
		if (new nl.utwente.apc.Code2D.resource.Code2D.util.Code2DRuntimeUtil().isEclipsePlatformAvailable()) {
			new nl.utwente.apc.Code2D.resource.Code2D.util.Code2DEclipseProxy().getDefaultLoadOptionProviderExtensions(loadOptionsCopy);
		}
		return loadOptionsCopy;
	}
	
	/**
	 * Extends the super implementation by clearing all information about element
	 * positions.
	 */
	protected void clearState() {
		// clear concrete syntax information
		resetLocationMap();
		internalURIFragmentMap.clear();
		getErrors().clear();
		getWarnings().clear();
		unmark(nl.utwente.apc.Code2D.resource.Code2D.Code2DEProblemType.UNKNOWN);
		unmark(nl.utwente.apc.Code2D.resource.Code2D.Code2DEProblemType.SYNTAX_ERROR);
		unmark(nl.utwente.apc.Code2D.resource.Code2D.Code2DEProblemType.UNRESOLVED_REFERENCE);
		proxyCounter = 0;
		resolverSwitch = null;
	}
	
	/**
	 * Returns a copy of the contents of this resource wrapped in a list that
	 * propagates changes to the original resource list. Wrapping is required to make
	 * sure that clients which obtain a reference to the list of contents do not
	 * interfere when changing the list.
	 */
	public org.eclipse.emf.common.util.EList<org.eclipse.emf.ecore.EObject> getContents() {
		if (terminateReload) {
			// the contents' state is currently unclear
			return new org.eclipse.emf.common.util.BasicEList<org.eclipse.emf.ecore.EObject>();
		}
		return new nl.utwente.apc.Code2D.resource.Code2D.util.Code2DCopiedEObjectInternalEList((org.eclipse.emf.ecore.util.InternalEList<org.eclipse.emf.ecore.EObject>) super.getContents());
	}
	
	/**
	 * Returns the raw contents of this resource. In contrast to getContents(), this
	 * methods does not return a copy of the content list, but the original list.
	 */
	public org.eclipse.emf.common.util.EList<org.eclipse.emf.ecore.EObject> getContentsInternal() {
		if (terminateReload) {
			// the contents' state is currently unclear
			return new org.eclipse.emf.common.util.BasicEList<org.eclipse.emf.ecore.EObject>();
		}
		return super.getContents();
	}
	
	/**
	 * Returns all warnings that are associated with this resource.
	 */
	public org.eclipse.emf.common.util.EList<org.eclipse.emf.ecore.resource.Resource.Diagnostic> getWarnings() {
		if (terminateReload) {
			// the contents' state is currently unclear
			return new org.eclipse.emf.common.util.BasicEList<org.eclipse.emf.ecore.resource.Resource.Diagnostic>();
		}
		return new nl.utwente.apc.Code2D.resource.Code2D.util.Code2DCopiedEList<org.eclipse.emf.ecore.resource.Resource.Diagnostic>(super.getWarnings());
	}
	
	/**
	 * Returns all errors that are associated with this resource.
	 */
	public org.eclipse.emf.common.util.EList<org.eclipse.emf.ecore.resource.Resource.Diagnostic> getErrors() {
		if (terminateReload) {
			// the contents' state is currently unclear
			return new org.eclipse.emf.common.util.BasicEList<org.eclipse.emf.ecore.resource.Resource.Diagnostic>();
		}
		return new nl.utwente.apc.Code2D.resource.Code2D.util.Code2DCopiedEList<org.eclipse.emf.ecore.resource.Resource.Diagnostic>(super.getErrors());
	}
	
	protected void runValidators(org.eclipse.emf.ecore.EObject root) {
		// checking constraints provided by EMF validator classes was disabled by option
		// 'disableEValidators'.
		
		if (new nl.utwente.apc.Code2D.resource.Code2D.util.Code2DRuntimeUtil().isEclipsePlatformAvailable()) {
			new nl.utwente.apc.Code2D.resource.Code2D.util.Code2DEclipseProxy().checkEMFValidationConstraints(this, root);
		}
	}
	
	public nl.utwente.apc.Code2D.resource.Code2D.ICode2DQuickFix getQuickFix(String quickFixContext) {
		return quickFixMap.get(quickFixContext);
	}
	
	protected void mark(nl.utwente.apc.Code2D.resource.Code2D.ICode2DTextDiagnostic diagnostic) {
		nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DMarkerHelper markerHelper = getMarkerHelper();
		if (markerHelper != null) {
			markerHelper.mark(this, diagnostic);
		}
	}
	
	protected void unmark(org.eclipse.emf.ecore.EObject cause) {
		nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DMarkerHelper markerHelper = getMarkerHelper();
		if (markerHelper != null) {
			markerHelper.unmark(this, cause);
		}
	}
	
	protected void unmark(nl.utwente.apc.Code2D.resource.Code2D.Code2DEProblemType analysisProblem) {
		nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DMarkerHelper markerHelper = getMarkerHelper();
		if (markerHelper != null) {
			markerHelper.unmark(this, analysisProblem);
		}
	}
	
	protected nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DMarkerHelper getMarkerHelper() {
		if (isMarkerCreationEnabled() && new nl.utwente.apc.Code2D.resource.Code2D.util.Code2DRuntimeUtil().isEclipsePlatformAvailable()) {
			if (markerHelper == null) {
				markerHelper = new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DMarkerHelper();
			}
			return markerHelper;
		}
		return null;
	}
	
	public boolean isMarkerCreationEnabled() {
		if (loadOptions == null) {
			return true;
		}
		return !loadOptions.containsKey(nl.utwente.apc.Code2D.resource.Code2D.ICode2DOptions.DISABLE_CREATING_MARKERS_FOR_PROBLEMS);
	}
	
	protected boolean isLocationMapEnabled() {
		if (loadOptions == null) {
			return true;
		}
		return !loadOptions.containsKey(nl.utwente.apc.Code2D.resource.Code2D.ICode2DOptions.DISABLE_LOCATION_MAP);
	}
	
	protected boolean isLayoutInformationRecordingEnabled() {
		if (loadOptions == null) {
			return true;
		}
		return !loadOptions.containsKey(nl.utwente.apc.Code2D.resource.Code2D.ICode2DOptions.DISABLE_LAYOUT_INFORMATION_RECORDING);
	}
	
}
