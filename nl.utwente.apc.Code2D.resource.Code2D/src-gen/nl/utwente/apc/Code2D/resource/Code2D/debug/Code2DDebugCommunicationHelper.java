/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.Code2D.debug;

public class Code2DDebugCommunicationHelper {
	
	public void sendEvent(nl.utwente.apc.Code2D.resource.Code2D.debug.Code2DDebugMessage message, java.io.PrintStream stream) {
		synchronized (stream) {
			stream.println(message.serialize());
		}
	}
	
	/**
	 * Sends a message using the given stream and waits for an answer.
	 * 
	 * @param messageType the type of message to send
	 * @param stream the stream to send the message to
	 * @param reader the reader to obtain the answer from
	 * @param parameters additional parameter to send
	 * 
	 * @return the answer that is received
	 */
	public nl.utwente.apc.Code2D.resource.Code2D.debug.Code2DDebugMessage sendAndReceive(nl.utwente.apc.Code2D.resource.Code2D.debug.Code2DDebugMessage message, java.io.PrintStream stream, java.io.BufferedReader reader) {
		synchronized (stream) {
			sendEvent(message, stream);
			nl.utwente.apc.Code2D.resource.Code2D.debug.Code2DDebugMessage response = receive(reader);
			return response;
		}
	}
	
	/**
	 * Receives a message from the given reader. This method block until a message has
	 * arrived.
	 * 
	 * @param reader the read to obtain the message from
	 * 
	 * @return the received message
	 */
	public nl.utwente.apc.Code2D.resource.Code2D.debug.Code2DDebugMessage receive(java.io.BufferedReader reader) {
		try {
			String response = reader.readLine();
			if (response == null) {
				return null;
			}
			nl.utwente.apc.Code2D.resource.Code2D.debug.Code2DDebugMessage receivedMessage = nl.utwente.apc.Code2D.resource.Code2D.debug.Code2DDebugMessage.deserialize(response);
			return receivedMessage;
		} catch (java.io.IOException e) {
			return null;
		}
	}
	
}
