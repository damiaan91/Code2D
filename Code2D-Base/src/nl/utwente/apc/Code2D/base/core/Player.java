/**
 * 
 */
package nl.utwente.apc.Code2D.base.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * @author Damiaan
 *
 */
public class Player extends ControllableObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2893765007138991339L;

	/**
	 * 
	 */
	public Player() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param rect
	 */
	public Player(Rectangle rect) {
		super(rect);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public Player(float x, float y, float width, float height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see nl.utwente.apc.Code2D.base.core.MoveableObject#updatePos()
	 */
	@Override
	public void updatePos() {
		if (Gdx.input.isKeyPressed(Keys.LEFT))
			this.x -= 64 * Gdx.graphics.getDeltaTime();
		if (Gdx.input.isKeyPressed(Keys.RIGHT))
			this.x += 64 * Gdx.graphics.getDeltaTime();
		if (Gdx.input.isKeyPressed(Keys.UP))
			this.y += 64 * Gdx.graphics.getDeltaTime();
		if (Gdx.input.isKeyPressed(Keys.DOWN))
			this.y -= 64 * Gdx.graphics.getDeltaTime();
		
		if (this.x < 0)
			this.x = 0;
		if (this.x > Gdx.graphics.getWidth() - 32)
			this.x = Gdx.graphics.getWidth() - 32;
		if (this.y < 0)
			this.y = 0;
		if (this.y > Gdx.graphics.getHeight() - 32)
			this.y = Gdx.graphics.getHeight() - 32;
	}

	/* (non-Javadoc)
	 * @see nl.utwente.apc.Code2D.base.core.GameObject#updateRender(com.badlogic.gdx.graphics.g2d.SpriteBatch)
	 */
	@Override
	public void draw(SpriteBatch batch) {
		batch.draw(this.texture, this.x, this.y, this.width, this.height);
	}

}
