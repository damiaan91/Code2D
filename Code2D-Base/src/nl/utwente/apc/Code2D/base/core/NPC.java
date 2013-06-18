/**
 * 
 */
package nl.utwente.apc.Code2D.base.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;

/**
 * @author Damiaan
 *
 */
public class NPC extends MoveableObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2547115459843233657L;
	
	protected NPCBehaviour behaviour;

	/**
	 * 
	 */
	public NPC() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param rect
	 */
	public NPC(Rectangle rect) {
		super(rect);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public NPC(float x, float y, float width, float height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see nl.utwente.apc.Code2D.base.core.MoveableObject#updatePos()
	 */
	@Override
	public void updatePos() {
		this.x += MathUtils.random(-200, 200) * Gdx.graphics.getDeltaTime();
		this.y += MathUtils.random(-200, 200) * Gdx.graphics.getDeltaTime();
		if (this.x + 64 < 0)
			this.x = 0;
		if (this.y + 64< 0)
			this.y = 0;
		if (this.x > Gdx.graphics.getWidth() - 64)
			this.x = Gdx.graphics.getWidth() - 64;
		if (this.y > Gdx.graphics.getHeight() - 64)
			this.y = Gdx.graphics.getHeight() - 64;
	}

	public NPCBehaviour getBehaviour() {
		return behaviour;
	}

	public void setBehaviour(NPCBehaviour behaviour) {
		this.behaviour = behaviour;
	}

	/* (non-Javadoc)
	 * @see nl.utwente.apc.Code2D.base.core.GameObject#updateRender(com.badlogic.gdx.graphics.g2d.SpriteBatch)
	 */
	@Override
	public void draw(SpriteBatch batch) {
		batch.draw(this.texture, this.x, this.y);
	}

}
