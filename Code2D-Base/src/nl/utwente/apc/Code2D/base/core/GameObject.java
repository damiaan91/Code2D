package nl.utwente.apc.Code2D.base.core;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * @author Damiaan
 *
 */
public abstract class GameObject extends Rectangle implements Cloneable {
	
	private static final long serialVersionUID = -8035120117717494896L;

	protected int id;

	protected String name;
	
	protected String texturePath;
	
	protected Texture texture;

	public GameObject() {
	}

	public GameObject(Rectangle rect) {
		super(rect);
	}

	public GameObject(float x, float y, float width, float height) {
		super(x, y, width, height);
	}
	
	public void draw(SpriteBatch batch) {
		batch.draw(this.texture, this.x, this.y, this.width, this.height);
	}

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
	}
	
	public void init() {
		this.texture = TextureFactory.getInstance().getTexture(texturePath);
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
