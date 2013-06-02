/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package nl.utwente.apc.Code2D.resource.c2d.util;

/**
 * This class provides basic infrastructure to interpret models. To implement
 * concrete interpreters, subclass this abstract interpreter and override the
 * interprete_* methods. The interpretation can be customized by binding the two
 * type parameters (ResultType, ContextType). The former is returned by all
 * interprete_* methods, while the latter is passed from method to method while
 * traversing the model. The concrete traversal strategy can also be exchanged.
 * One can use a static traversal strategy by pushing all objects to interpret on
 * the interpretation stack (using addObjectToInterprete()) before calling
 * interprete(). Alternatively, the traversal strategy can be dynamic by pushing
 * objects on the interpretation stack during interpretation.
 */
public class AbstractC2dInterpreter<ResultType, ContextType> {
	
	private java.util.Stack<org.eclipse.emf.ecore.EObject> interpretationStack = new java.util.Stack<org.eclipse.emf.ecore.EObject>();
	private java.util.List<nl.utwente.apc.Code2D.resource.c2d.IC2dInterpreterListener> listeners = new java.util.ArrayList<nl.utwente.apc.Code2D.resource.c2d.IC2dInterpreterListener>();
	private org.eclipse.emf.ecore.EObject nextObjectToInterprete;
	private Object currentContext;
	
	public ResultType interprete(ContextType context) {
		ResultType result = null;
		org.eclipse.emf.ecore.EObject next = null;
		currentContext = context;
		while (!interpretationStack.empty()) {
			try {
				next = interpretationStack.pop();
			} catch (java.util.EmptyStackException ese) {
				// this can happen when the interpreter was terminated between the call to empty()
				// and pop()
				break;
			}
			nextObjectToInterprete = next;
			notifyListeners(next);
			result = interprete(next, context);
			if (!continueInterpretation(context, result)) {
				break;
			}
		}
		currentContext = null;
		return result;
	}
	
	/**
	 * Override this method to stop the overall interpretation depending on the result
	 * of the interpretation of a single model elements.
	 */
	public boolean continueInterpretation(ContextType context, ResultType result) {
		return true;
	}
	
	public ResultType interprete(org.eclipse.emf.ecore.EObject object, ContextType context) {
		ResultType result = null;
		if (object instanceof nl.utwente.apc.Code2D.Game) {
			result = interprete_nl_utwente_apc_Code2D_Game((nl.utwente.apc.Code2D.Game) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof nl.utwente.apc.Code2D.World) {
			result = interprete_nl_utwente_apc_Code2D_World((nl.utwente.apc.Code2D.World) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof nl.utwente.apc.Code2D.Player) {
			result = interprete_nl_utwente_apc_Code2D_Player((nl.utwente.apc.Code2D.Player) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof nl.utwente.apc.Code2D.ControllableObject) {
			result = interprete_nl_utwente_apc_Code2D_ControllableObject((nl.utwente.apc.Code2D.ControllableObject) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof nl.utwente.apc.Code2D.NPC) {
			result = interprete_nl_utwente_apc_Code2D_NPC((nl.utwente.apc.Code2D.NPC) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof nl.utwente.apc.Code2D.MoveableObject) {
			result = interprete_nl_utwente_apc_Code2D_MoveableObject((nl.utwente.apc.Code2D.MoveableObject) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof nl.utwente.apc.Code2D.Item) {
			result = interprete_nl_utwente_apc_Code2D_Item((nl.utwente.apc.Code2D.Item) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof nl.utwente.apc.Code2D.GameObject) {
			result = interprete_nl_utwente_apc_Code2D_GameObject((nl.utwente.apc.Code2D.GameObject) object, context);
		}
		if (result != null) {
			return result;
		}
		return result;
	}
	
	public ResultType interprete_nl_utwente_apc_Code2D_Game(nl.utwente.apc.Code2D.Game game, ContextType context) {
		return null;
	}
	
	public ResultType interprete_nl_utwente_apc_Code2D_World(nl.utwente.apc.Code2D.World world, ContextType context) {
		return null;
	}
	
	public ResultType interprete_nl_utwente_apc_Code2D_GameObject(nl.utwente.apc.Code2D.GameObject gameObject, ContextType context) {
		return null;
	}
	
	public ResultType interprete_nl_utwente_apc_Code2D_MoveableObject(nl.utwente.apc.Code2D.MoveableObject moveableObject, ContextType context) {
		return null;
	}
	
	public ResultType interprete_nl_utwente_apc_Code2D_ControllableObject(nl.utwente.apc.Code2D.ControllableObject controllableObject, ContextType context) {
		return null;
	}
	
	public ResultType interprete_nl_utwente_apc_Code2D_Player(nl.utwente.apc.Code2D.Player player, ContextType context) {
		return null;
	}
	
	public ResultType interprete_nl_utwente_apc_Code2D_NPC(nl.utwente.apc.Code2D.NPC nPC, ContextType context) {
		return null;
	}
	
	public ResultType interprete_nl_utwente_apc_Code2D_Item(nl.utwente.apc.Code2D.Item item, ContextType context) {
		return null;
	}
	
	private void notifyListeners(org.eclipse.emf.ecore.EObject element) {
		for (nl.utwente.apc.Code2D.resource.c2d.IC2dInterpreterListener listener : listeners) {
			listener.handleInterpreteObject(element);
		}
	}
	
	/**
	 * Adds the given object to the interpretation stack. Attention: Objects that are
	 * added first, are interpret last.
	 */
	public void addObjectToInterprete(org.eclipse.emf.ecore.EObject object) {
		interpretationStack.push(object);
	}
	
	/**
	 * Adds the given collection of objects to the interpretation stack. Attention:
	 * Collections that are added first, are interpret last.
	 */
	public void addObjectsToInterprete(java.util.Collection<? extends org.eclipse.emf.ecore.EObject> objects) {
		for (org.eclipse.emf.ecore.EObject object : objects) {
			addObjectToInterprete(object);
		}
	}
	
	/**
	 * Adds the given collection of objects in reverse order to the interpretation
	 * stack.
	 */
	public void addObjectsToInterpreteInReverseOrder(java.util.Collection<? extends org.eclipse.emf.ecore.EObject> objects) {
		java.util.List<org.eclipse.emf.ecore.EObject> reverse = new java.util.ArrayList<org.eclipse.emf.ecore.EObject>(objects.size());
		reverse.addAll(objects);
		java.util.Collections.reverse(reverse);
		addObjectsToInterprete(reverse);
	}
	
	/**
	 * Adds the given object and all its children to the interpretation stack such
	 * that they are interpret in top down order.
	 */
	public void addObjectTreeToInterpreteTopDown(org.eclipse.emf.ecore.EObject root) {
		java.util.List<org.eclipse.emf.ecore.EObject> objects = new java.util.ArrayList<org.eclipse.emf.ecore.EObject>();
		objects.add(root);
		java.util.Iterator<org.eclipse.emf.ecore.EObject> it = root.eAllContents();
		while (it.hasNext()) {
			org.eclipse.emf.ecore.EObject eObject = (org.eclipse.emf.ecore.EObject) it.next();
			objects.add(eObject);
		}
		addObjectsToInterpreteInReverseOrder(objects);
	}
	
	public void addListener(nl.utwente.apc.Code2D.resource.c2d.IC2dInterpreterListener newListener) {
		listeners.add(newListener);
	}
	
	public boolean removeListener(nl.utwente.apc.Code2D.resource.c2d.IC2dInterpreterListener listener) {
		return listeners.remove(listener);
	}
	
	public org.eclipse.emf.ecore.EObject getNextObjectToInterprete() {
		return nextObjectToInterprete;
	}
	
	public java.util.Stack<org.eclipse.emf.ecore.EObject> getInterpretationStack() {
		return interpretationStack;
	}
	
	public void terminate() {
		interpretationStack.clear();
	}
	
	public Object getCurrentContext() {
		return currentContext;
	}
	
}