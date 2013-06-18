/**
 * 
 */
package nl.utwente.apc.Code2D.base.core;

import com.badlogic.gdx.math.Rectangle;

/**
 * @author Damiaan
 *
 */
public abstract class ControllableObject extends MoveableObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5269520401704922475L;

	/**
	 * 
	 */
	public ControllableObject() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param rect
	 */
	public ControllableObject(Rectangle rect) {
		super(rect);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public ControllableObject(float x, float y, float width, float height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

}
