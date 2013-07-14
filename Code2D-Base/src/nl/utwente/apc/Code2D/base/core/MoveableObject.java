package nl.utwente.apc.Code2D.base.core;

import com.badlogic.gdx.math.Rectangle;

/**
 * @author Damiaan
 *
 */
public abstract class MoveableObject extends GameObject {

	private static final long serialVersionUID = -7825267015403450575L;

	public MoveableObject() {
	}

	public MoveableObject(Rectangle rect) {
		super(rect);
	}

	public MoveableObject(float x, float y, float width, float height) {
		super(x, y, width, height);
	}
	
	public abstract void updatePos();

}
