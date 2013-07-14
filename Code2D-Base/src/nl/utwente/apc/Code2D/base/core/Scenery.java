/**
 * 
 */
package nl.utwente.apc.Code2D.base.core;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * @author Damiaan
 *
 */
public class Scenery extends GameObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4840206120900954928L;

	/**
	 * 
	 */
	public Scenery() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param rect
	 */
	public Scenery(Rectangle rect) {
		super(rect);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public Scenery(float x, float y, float width, float height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see nl.utwente.apc.Code2D.base.core.GameObject#draw(com.badlogic.gdx.graphics.g2d.SpriteBatch)
	 */
	@Override
	public void draw(SpriteBatch batch) {
		batch.draw(this.texture, this.x, this.y, this.width, this.height);
	}

}
