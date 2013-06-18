/**
 * 
 */
package nl.utwente.apc.Code2D.base.core;

import com.badlogic.gdx.math.Rectangle;

/**
 * @author Damiaan
 *
 */
public abstract class MoveableObject extends GameObject {

	/**
	 * 
	 */
	public MoveableObject() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param rect
	 */
	public MoveableObject(Rectangle rect) {
		super(rect);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public MoveableObject(float x, float y, float width, float height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	
	public abstract void updatePos();

}
