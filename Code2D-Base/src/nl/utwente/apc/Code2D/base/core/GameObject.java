/**
 * 
 */
package nl.utwente.apc.Code2D.base.core;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * @author Damiaan
 *
 */
public abstract class GameObject extends Rectangle {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8035120117717494896L;

	protected int id;

	protected String name;
	
	protected String texturePath;
	
	protected Texture texture;

	/**
	 * 
	 */
	public GameObject() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param rect
	 */
	public GameObject(Rectangle rect) {
		super(rect);

		// TODO Auto-generated constructor stub
	}

	/**
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public GameObject(float x, float y, float width, float height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	
	public abstract void draw(SpriteBatch batch);

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTexturePath() {
		return texturePath;
	}

	public void setTexturePath(String texturePath) {
		this.texturePath = texturePath;
		this.texture = TextureFactory.getInstance().getTexture(texturePath);
	}

}
