package org.alia4j.languages.code2d.importer;

import java.util.HashMap;

import nl.utwente.apc.Code2D.base.core.*;

public class Code2DImporterUtils {

	private static HashMap<nl.utwente.apc.Code2D.GameObject, GameObject> gameObjectMap = new HashMap<nl.utwente.apc.Code2D.GameObject, GameObject>();

	public static int getObjectId(nl.utwente.apc.Code2D.GameObject gameObjectDef) {
		if (gameObjectMap.containsKey(gameObjectDef)) {
			return gameObjectMap.get(gameObjectDef).getId();
		}
		return getGameObject(gameObjectDef).getId();
	}
	
	public static Class<? extends GameObject> getObjectClass(nl.utwente.apc.Code2D.GameObject gameObjectDef) {
		if (gameObjectMap.containsKey(gameObjectDef)) {
			return gameObjectMap.get(gameObjectDef).getClass();
		}
		return getGameObject(gameObjectDef).getClass();
	}

	public static GameObject getGameObject(final nl.utwente.apc.Code2D.GameObject gameObjectDef) {
		GameObject gameObjectTemplate;
		
		if (gameObjectMap.containsKey(gameObjectDef)) {
			gameObjectTemplate = gameObjectMap.get(gameObjectDef);
		} else {
			gameObjectTemplate = createGameObject(gameObjectDef);
		}
		
		try {
			return (GameObject) gameObjectTemplate.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}

	public static void dispose() {
		gameObjectMap.clear();
	}

	private static GameObject createGameObject(final nl.utwente.apc.Code2D.GameObject gameObjectDef) {
		GameObject gameObject = null;
		
		 //TODO: extend with other GameObject types
		if (gameObjectDef instanceof nl.utwente.apc.Code2D.Scenery) {
			gameObject = createScenery((nl.utwente.apc.Code2D.Scenery) gameObjectDef);
		} else if (gameObjectDef instanceof nl.utwente.apc.Code2D.Player) {
			gameObject = createPlayer((nl.utwente.apc.Code2D.Player) gameObjectDef);
		} else if (gameObjectDef instanceof nl.utwente.apc.Code2D.NPC) {
			gameObject = createNPC((nl.utwente.apc.Code2D.NPC) gameObjectDef);
		} else {
			throw new UnsupportedOperationException(String.format("Object %s is not supported.",
					gameObjectDef.getName()));
		}
		setGameObjectProps(gameObject, gameObjectDef);
		gameObjectMap.put(gameObjectDef, gameObject);
		return gameObject;
	}

	private static GameObject createNPC(nl.utwente.apc.Code2D.NPC gameObjectDef) {
		NPC npc = new NPC();
		switch(gameObjectDef.getBehaviour()) {
			case FRIENDLY: npc.setBehaviour(NPCBehaviour.FRIENDLY); break;
			case HOSTILE: npc.setBehaviour(NPCBehaviour.HOSTILE); break;
			case NEUTRAL: npc.setBehaviour(NPCBehaviour.NEUTRAL); break;
			default: throw new UnsupportedOperationException(gameObjectDef.getBehaviour() + "is not support NPC behaviour");
		}
		return npc;
	}

	private static GameObject createPlayer(nl.utwente.apc.Code2D.Player gameObjectDef) {
		return new Player();
	}

	private static GameObject createScenery(nl.utwente.apc.Code2D.Scenery sceneryDef) {
		return new Scenery();
	}

	private static GameObject setGameObjectProps(GameObject gameObject, nl.utwente.apc.Code2D.GameObject gameObjectDef) {
		gameObject.setName(gameObjectDef.getName());
		gameObject.width = gameObjectDef.getWidth();
		gameObject.height = gameObjectDef.getHeight();
		gameObject.setTexturePath(gameObjectDef.getTexture());
		gameObject.setId(gameObjectMap.size());
		return gameObject;
	}
}
