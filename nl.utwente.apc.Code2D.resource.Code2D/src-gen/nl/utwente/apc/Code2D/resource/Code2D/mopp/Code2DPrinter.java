/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.Code2D.mopp;

public class Code2DPrinter implements nl.utwente.apc.Code2D.resource.Code2D.ICode2DTextPrinter {
	
	protected nl.utwente.apc.Code2D.resource.Code2D.ICode2DTokenResolverFactory tokenResolverFactory = new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DTokenResolverFactory();
	
	protected java.io.OutputStream outputStream;
	
	/**
	 * Holds the resource that is associated with this printer. This may be null if
	 * the printer is used stand alone.
	 */
	private nl.utwente.apc.Code2D.resource.Code2D.ICode2DTextResource resource;
	
	private java.util.Map<?, ?> options;
	private String encoding = System.getProperty("file.encoding");
	
	public Code2DPrinter(java.io.OutputStream outputStream, nl.utwente.apc.Code2D.resource.Code2D.ICode2DTextResource resource) {
		super();
		this.outputStream = outputStream;
		this.resource = resource;
	}
	
	protected int matchCount(java.util.Map<String, Integer> featureCounter, java.util.Collection<String> needed) {
		int pos = 0;
		int neg = 0;
		
		for (String featureName : featureCounter.keySet()) {
			if (needed.contains(featureName)) {
				int value = featureCounter.get(featureName);
				if (value == 0) {
					neg += 1;
				} else {
					pos += 1;
				}
			}
		}
		return neg > 0 ? -neg : pos;
	}
	
	protected void doPrint(org.eclipse.emf.ecore.EObject element, java.io.PrintWriter out, String globaltab) {
		if (element == null) {
			throw new java.lang.IllegalArgumentException("Nothing to write.");
		}
		if (out == null) {
			throw new java.lang.IllegalArgumentException("Nothing to write on.");
		}
		
		if (element instanceof nl.utwente.apc.Code2D.Game) {
			print_nl_utwente_apc_Code2D_Game((nl.utwente.apc.Code2D.Game) element, globaltab, out);
			return;
		}
		if (element instanceof nl.utwente.apc.Code2D.World) {
			print_nl_utwente_apc_Code2D_World((nl.utwente.apc.Code2D.World) element, globaltab, out);
			return;
		}
		if (element instanceof nl.utwente.apc.Code2D.Player) {
			print_nl_utwente_apc_Code2D_Player((nl.utwente.apc.Code2D.Player) element, globaltab, out);
			return;
		}
		if (element instanceof nl.utwente.apc.Code2D.NPC) {
			print_nl_utwente_apc_Code2D_NPC((nl.utwente.apc.Code2D.NPC) element, globaltab, out);
			return;
		}
		if (element instanceof nl.utwente.apc.Code2D.Item) {
			print_nl_utwente_apc_Code2D_Item((nl.utwente.apc.Code2D.Item) element, globaltab, out);
			return;
		}
		
		addWarningToResource("The printer can not handle " + element.eClass().getName() + " elements", element);
	}
	
	protected nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DReferenceResolverSwitch getReferenceResolverSwitch() {
		return (nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DReferenceResolverSwitch) new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DMetaInformation().getReferenceResolverSwitch();
	}
	
	protected void addWarningToResource(final String errorMessage, org.eclipse.emf.ecore.EObject cause) {
		nl.utwente.apc.Code2D.resource.Code2D.ICode2DTextResource resource = getResource();
		if (resource == null) {
			// the resource can be null if the printer is used stand alone
			return;
		}
		resource.addProblem(new nl.utwente.apc.Code2D.resource.Code2D.mopp.Code2DProblem(errorMessage, nl.utwente.apc.Code2D.resource.Code2D.Code2DEProblemType.PRINT_PROBLEM, nl.utwente.apc.Code2D.resource.Code2D.Code2DEProblemSeverity.WARNING), cause);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		this.options = options;
	}
	
	public java.util.Map<?,?> getOptions() {
		return options;
	}
	
	public void setEncoding(String encoding) {
		if (encoding != null) {
			this.encoding = encoding;
		}
	}
	
	public String getEncoding() {
		return encoding;
	}
	
	public nl.utwente.apc.Code2D.resource.Code2D.ICode2DTextResource getResource() {
		return resource;
	}
	
	/**
	 * Calls {@link #doPrint(EObject, PrintWriter, String)} and writes the result to
	 * the underlying output stream.
	 */
	public void print(org.eclipse.emf.ecore.EObject element) throws java.io.IOException {
		java.io.PrintWriter out = new java.io.PrintWriter(new java.io.OutputStreamWriter(new java.io.BufferedOutputStream(outputStream), encoding));
		doPrint(element, out, "");
		out.flush();
		out.close();
	}
	
	public void print_nl_utwente_apc_Code2D_Game(nl.utwente.apc.Code2D.Game element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(3);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.GAME__NAME));
		printCountingMap.put("Name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.GAME__GAME_WORLD));
		printCountingMap.put("GameWorld", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.GAME__GAME_OBJECTS));
		printCountingMap.put("GameObjects", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("Game");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("Name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.GAME__NAME));
			if (o != null) {
				nl.utwente.apc.Code2D.resource.Code2D.ICode2DTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.GAME__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("Name", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_nl_utwente_apc_Code2D_Game_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
		out.print(" ");
	}
	
	public void print_nl_utwente_apc_Code2D_Game_0(nl.utwente.apc.Code2D.Game element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		int alt = -1;
		alt = 0;
		int matches = 		matchCount(printCountingMap, java.util.Arrays.asList(		"GameWorld"		));
		int tempMatchCount;
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"GameObjects"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (Containment)
				count = printCountingMap.get("GameObjects");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.GAME__GAME_OBJECTS));
					java.util.List<?> list = (java.util.List<?>) o;
					int index = list.size() - count;
					if (index >= 0) {
						o = list.get(index);
					} else {
						o = null;
					}
					if (o != null) {
						doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
					}
					printCountingMap.put("GameObjects", count - 1);
				}
			}
			break;
			default:			// DEFINITION PART BEGINS (Containment)
			count = printCountingMap.get("GameWorld");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.GAME__GAME_WORLD));
				if (o != null) {
					doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
				}
				printCountingMap.put("GameWorld", count - 1);
			}
		}
	}
	
	
	public void print_nl_utwente_apc_Code2D_World(nl.utwente.apc.Code2D.World element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.WORLD__NAME));
		printCountingMap.put("Name", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("World");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("Name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.WORLD__NAME));
			if (o != null) {
				nl.utwente.apc.Code2D.resource.Code2D.ICode2DTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.WORLD__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("Name", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_nl_utwente_apc_Code2D_World_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
		out.print(" ");
	}
	
	public void print_nl_utwente_apc_Code2D_World_0(nl.utwente.apc.Code2D.World element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		// DEFINITION PART BEGINS (CsString)
		out.print("Other things;");
		out.print(" ");
	}
	
	
	public void print_nl_utwente_apc_Code2D_Player(nl.utwente.apc.Code2D.Player element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.PLAYER__NAME));
		printCountingMap.put("Name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.PLAYER__TEXTURE));
		printCountingMap.put("Texture", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("Player");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("Name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.PLAYER__NAME));
			if (o != null) {
				nl.utwente.apc.Code2D.resource.Code2D.ICode2DTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.PLAYER__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("Name", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_nl_utwente_apc_Code2D_Player_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
		out.print(" ");
	}
	
	public void print_nl_utwente_apc_Code2D_Player_0(nl.utwente.apc.Code2D.Player element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("Texture");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("Texture");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.PLAYER__TEXTURE));
			if (o != null) {
				nl.utwente.apc.Code2D.resource.Code2D.ICode2DTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_4748_59");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.PLAYER__TEXTURE), element));
				out.print(" ");
			}
			printCountingMap.put("Texture", count - 1);
		}
	}
	
	
	public void print_nl_utwente_apc_Code2D_NPC(nl.utwente.apc.Code2D.NPC element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(4);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.NPC__NAME));
		printCountingMap.put("Name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.NPC__TEXTURE));
		printCountingMap.put("Texture", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.NPC__BEHAVIOUR));
		printCountingMap.put("Behaviour", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.NPC__EXTENDS));
		printCountingMap.put("Extends", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("NPC");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("Name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.NPC__NAME));
			if (o != null) {
				nl.utwente.apc.Code2D.resource.Code2D.ICode2DTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.NPC__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("Name", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_nl_utwente_apc_Code2D_NPC_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_nl_utwente_apc_Code2D_NPC_1(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
		out.print(" ");
	}
	
	public void print_nl_utwente_apc_Code2D_NPC_0(nl.utwente.apc.Code2D.NPC element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("Extends");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.NPC__EXTENDS));
			if (o != null) {
				nl.utwente.apc.Code2D.resource.Code2D.ICode2DTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getNPCExtendsReferenceResolver().deResolve((nl.utwente.apc.Code2D.NPC) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.NPC__EXTENDS)), element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.NPC__EXTENDS), element));
				out.print(" ");
			}
			printCountingMap.put("Extends", count - 1);
		}
	}
	
	public void print_nl_utwente_apc_Code2D_NPC_1(nl.utwente.apc.Code2D.NPC element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		int alt = -1;
		alt = 0;
		int matches = 		matchCount(printCountingMap, java.util.Arrays.asList(		"Texture"		));
		int tempMatchCount;
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"Behaviour"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("Behaviour");
				out.print(" ");
				// DEFINITION PART BEGINS (CsString)
				out.print(":");
				out.print(" ");
				// DEFINITION PART BEGINS (EnumTerminal)
				count = printCountingMap.get("Behaviour");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.NPC__BEHAVIOUR));
					if (o != null) {
					}
					printCountingMap.put("Behaviour", count - 1);
				}
				// DEFINITION PART BEGINS (CsString)
				out.print(";");
				out.print(" ");
			}
			break;
			default:			// DEFINITION PART BEGINS (CsString)
			out.print("Texture");
			out.print(" ");
			// DEFINITION PART BEGINS (CsString)
			out.print(":");
			out.print(" ");
			// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
			count = printCountingMap.get("Texture");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.NPC__TEXTURE));
				if (o != null) {
					nl.utwente.apc.Code2D.resource.Code2D.ICode2DTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.NPC__TEXTURE), element));
					out.print(" ");
				}
				printCountingMap.put("Texture", count - 1);
			}
			// DEFINITION PART BEGINS (CsString)
			out.print(";");
			out.print(" ");
		}
	}
	
	
	public void print_nl_utwente_apc_Code2D_Item(nl.utwente.apc.Code2D.Item element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.ITEM__NAME));
		printCountingMap.put("Name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.ITEM__TEXTURE));
		printCountingMap.put("Texture", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("Item");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("Name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.ITEM__NAME));
			if (o != null) {
				nl.utwente.apc.Code2D.resource.Code2D.ICode2DTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.ITEM__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("Name", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_nl_utwente_apc_Code2D_Item_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
		out.print(" ");
	}
	
	public void print_nl_utwente_apc_Code2D_Item_0(nl.utwente.apc.Code2D.Item element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("Texture");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("Texture");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.ITEM__TEXTURE));
			if (o != null) {
				nl.utwente.apc.Code2D.resource.Code2D.ICode2DTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(nl.utwente.apc.Code2D.Code2DPackage.ITEM__TEXTURE), element));
				out.print(" ");
			}
			printCountingMap.put("Texture", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(";");
		out.print(" ");
	}
	
	
}
