/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.Code2D.debug;

/**
 * DebugMessages are exchanged between the debug server (the Eclipse debug
 * framework) and the debug client (a running process or interpreter). To exchange
 * messages they are serialized and sent over sockets.
 */
public class Code2DDebugMessage {
	
	private static final char DELIMITER = ':';
	private nl.utwente.apc.Code2D.resource.Code2D.debug.ECode2DDebugMessageTypes messageType;
	private String[] arguments;
	
	public Code2DDebugMessage(nl.utwente.apc.Code2D.resource.Code2D.debug.ECode2DDebugMessageTypes messageType, String[] arguments) {
		super();
		this.messageType = messageType;
		this.arguments = arguments;
	}
	
	public Code2DDebugMessage(nl.utwente.apc.Code2D.resource.Code2D.debug.ECode2DDebugMessageTypes messageType, java.util.List<String> arguments) {
		super();
		this.messageType = messageType;
		this.arguments = new String[arguments.size()];
		for (int i = 0; i < arguments.size(); i++) {
			this.arguments[i] = arguments.get(i);
		}
	}
	
	public nl.utwente.apc.Code2D.resource.Code2D.debug.ECode2DDebugMessageTypes getMessageType() {
		return messageType;
	}
	
	public String[] getArguments() {
		return arguments;
	}
	
	public String serialize() {
		java.util.List<String> parts = new java.util.ArrayList<String>();
		parts.add(messageType.name());
		for (String argument : arguments) {
			parts.add(argument);
		}
		return nl.utwente.apc.Code2D.resource.Code2D.util.Code2DStringUtil.encode(DELIMITER, parts);
	}
	
	public static Code2DDebugMessage deserialize(String response) {
		java.util.List<String> parts = nl.utwente.apc.Code2D.resource.Code2D.util.Code2DStringUtil.decode(response, DELIMITER);
		String messageType = parts.get(0);
		String[] arguments = new String[parts.size() - 1];
		for (int i = 1; i < parts.size(); i++) {
			arguments[i - 1] = parts.get(i);
		}
		nl.utwente.apc.Code2D.resource.Code2D.debug.ECode2DDebugMessageTypes type = nl.utwente.apc.Code2D.resource.Code2D.debug.ECode2DDebugMessageTypes.valueOf(messageType);
		Code2DDebugMessage message = new Code2DDebugMessage(type, arguments);
		return message;
	}
	
	public boolean hasType(nl.utwente.apc.Code2D.resource.Code2D.debug.ECode2DDebugMessageTypes type) {
		return this.messageType == type;
	}
	
	public String getArgument(int index) {
		return getArguments()[index];
	}
	
	public String toString() {
		return this.getClass().getSimpleName() + "[" + messageType.name() + ": " + nl.utwente.apc.Code2D.resource.Code2D.util.Code2DStringUtil.explode(arguments, ", ") + "]";
	}
	
}
