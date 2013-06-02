/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2.debug;

/**
 * The DebugProxy allows to communicate between the interpreter, which runs in a
 * separate thread or process and the Eclipse Debug framework (i.e., the
 * DebugTarget class).
 */
public class C2DebugProxy {
	
	public static final int STARTUP_DELAY = 1000;
	
	private java.io.PrintStream output;
	
	private java.io.BufferedReader reader;
	
	private nl.utwente.apc.Code2D.resource.c2.debug.C2DebugTarget debugTarget;
	
	private nl.utwente.apc.Code2D.resource.c2.debug.C2DebugCommunicationHelper communicationHelper = new nl.utwente.apc.Code2D.resource.c2.debug.C2DebugCommunicationHelper();
	
	public C2DebugProxy(nl.utwente.apc.Code2D.resource.c2.debug.C2DebugTarget debugTarget, int requestPort) throws java.net.UnknownHostException, java.io.IOException {
		this.debugTarget = debugTarget;
		// give interpreter a chance to start
		try {
			Thread.sleep(STARTUP_DELAY);
		} catch (InterruptedException e) {
		}
		startSocket(requestPort);
	}
	
	private void startSocket(int requestPort) throws java.net.UnknownHostException, java.io.IOException {
		// creating client proxy socket (trying to connect)...
		java.net.Socket client = new java.net.Socket("localhost", requestPort);
		// creating client proxy socket - done. (connected)
		try {
			java.io.BufferedInputStream input = new java.io.BufferedInputStream(client.getInputStream());
			reader = new java.io.BufferedReader(new java.io.InputStreamReader(input));
		} catch (java.io.IOException e) {
			System.out.println(e);
		}
		try {
			output = new java.io.PrintStream(client.getOutputStream());
		} catch (java.io.IOException e) {
			System.out.println(e);
		}
	}
	
	public void resume() {
		sendCommand(nl.utwente.apc.Code2D.resource.c2.debug.EC2DebugMessageTypes.RESUME);
	}
	
	public void stepOver() {
		sendCommand(nl.utwente.apc.Code2D.resource.c2.debug.EC2DebugMessageTypes.STEP_OVER);
	}
	
	public void stepInto() {
		sendCommand(nl.utwente.apc.Code2D.resource.c2.debug.EC2DebugMessageTypes.STEP_INTO);
	}
	
	public void stepReturn() {
		sendCommand(nl.utwente.apc.Code2D.resource.c2.debug.EC2DebugMessageTypes.STEP_RETURN);
	}
	
	public void terminate() {
		sendCommand(nl.utwente.apc.Code2D.resource.c2.debug.EC2DebugMessageTypes.EXIT);
	}
	
	public nl.utwente.apc.Code2D.resource.c2.debug.C2DebugMessage getStack() {
		return sendCommandAndRead(nl.utwente.apc.Code2D.resource.c2.debug.EC2DebugMessageTypes.GET_STACK);
	}
	
	public void addLineBreakpoint(String location, int line) {
		nl.utwente.apc.Code2D.resource.c2.debug.C2DebugMessage message = new nl.utwente.apc.Code2D.resource.c2.debug.C2DebugMessage(nl.utwente.apc.Code2D.resource.c2.debug.EC2DebugMessageTypes.ADD_LINE_BREAKPOINT, new String[] {location, Integer.toString(line)});
		communicationHelper.sendEvent(message, output);
	}
	
	public void removeLineBreakpoint(String location, int line) {
		nl.utwente.apc.Code2D.resource.c2.debug.C2DebugMessage message = new nl.utwente.apc.Code2D.resource.c2.debug.C2DebugMessage(nl.utwente.apc.Code2D.resource.c2.debug.EC2DebugMessageTypes.REMOVE_LINE_BREAKPOINT, new String[] {location, Integer.toString(line)});
		communicationHelper.sendEvent(message, output);
	}
	
	public org.eclipse.debug.core.model.IVariable[] getStackVariables(String stackFrame) {
		nl.utwente.apc.Code2D.resource.c2.debug.C2DebugMessage response = sendCommandAndRead(nl.utwente.apc.Code2D.resource.c2.debug.EC2DebugMessageTypes.GET_FRAME_VARIABLES, new String[] {stackFrame});
		String[] ids = response.getArguments();
		// fetch all variables
		org.eclipse.debug.core.model.IVariable[] variables = getVariables(ids);
		return variables;
	}
	
	public org.eclipse.debug.core.model.IVariable[] getVariables(String... requestedIDs) {
		nl.utwente.apc.Code2D.resource.c2.debug.C2DebugMessage response = sendCommandAndRead(nl.utwente.apc.Code2D.resource.c2.debug.EC2DebugMessageTypes.GET_VARIABLES, requestedIDs);
		String[] varStrings = response.getArguments();
		nl.utwente.apc.Code2D.resource.c2.debug.C2DebugVariable[] variables  = new nl.utwente.apc.Code2D.resource.c2.debug.C2DebugVariable[varStrings.length];
		int i = 0;
		for (String varString : varStrings) {
			java.util.Map<String, String> properties = nl.utwente.apc.Code2D.resource.c2.util.C2StringUtil.convertFromString(varString);
			
			// convert varString to variables and values
			String valueString = properties.get("!valueString");
			String valueRefType = "valueRefType";
			java.util.Map<String, Long> childVariables = new java.util.TreeMap<String, Long>(new java.util.Comparator<String>() {
				public int compare(String s1, String s2) {
					return s1.compareToIgnoreCase(s2);
				}
			});
			for (String property : properties.keySet()) {
				// ignore special properties - they are not children
				if (property.startsWith("!")) {
					continue;
				}
				childVariables.put(property, Long.parseLong(properties.get(property)));
			}
			String id = properties.get("!id");
			org.eclipse.debug.core.model.IValue value = new nl.utwente.apc.Code2D.resource.c2.debug.C2DebugValue(debugTarget, id, valueString, valueRefType, childVariables);
			
			String variableName = properties.get("!name");
			String variableRefType = properties.get("!type");
			
			nl.utwente.apc.Code2D.resource.c2.debug.C2DebugVariable variable = new nl.utwente.apc.Code2D.resource.c2.debug.C2DebugVariable(debugTarget, variableName, value, variableRefType);
			variables[i++] = variable;
		}
		return variables;
	}
	
	private void sendCommand(nl.utwente.apc.Code2D.resource.c2.debug.EC2DebugMessageTypes command, String... parameters) {
		nl.utwente.apc.Code2D.resource.c2.debug.C2DebugMessage message = new nl.utwente.apc.Code2D.resource.c2.debug.C2DebugMessage(command, parameters);
		communicationHelper.sendEvent(message, output);
	}
	
	private nl.utwente.apc.Code2D.resource.c2.debug.C2DebugMessage sendCommandAndRead(nl.utwente.apc.Code2D.resource.c2.debug.EC2DebugMessageTypes command, String... parameters) {
		nl.utwente.apc.Code2D.resource.c2.debug.C2DebugMessage message = new nl.utwente.apc.Code2D.resource.c2.debug.C2DebugMessage(command, parameters);
		return communicationHelper.sendAndReceive(message, output, reader);
	}
	
}
