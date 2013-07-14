/**
 * 
 */
package nl.utwente.apc.Code2D.base.core;

import java.util.HashMap;

import com.badlogic.gdx.graphics.Texture;

/**
 * @author Damiaan
 *
 */
public class TextureFactory {
	
	private static TextureFactory instance;
	
	private HashMap<String, Texture> textures;
	
	public static TextureFactory getInstance() {
		if(instance == null) {
			instance = new TextureFactory();
		}
		return instance;
	}

	private TextureFactory() {
		this.textures = new HashMap<String, Texture>();
	}
	
	public Texture getTexture(String internalPath) {
		if(this.textures.containsKey(internalPath)) {
			return this.textures.get(internalPath);
		}
		Texture texture = new Texture(internalPath);
		this.textures.put(internalPath, texture);
		return texture;
	}
	
	public void dispose(String internalPath) {
		Texture texture = this.textures.remove(internalPath);
		texture.dispose();
	}
	
	public void dispose() {
		for (Texture texture : this.textures.values()) {
			texture.dispose();
		}
		this.textures.clear();
	}

}
