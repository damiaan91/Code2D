package nl.utwente.apc.Code2D.base.core;

import com.badlogic.gdx.math.Rectangle;

/**
 * @author Damiaan
 *
 */
public abstract class ControllableObject extends MoveableObject {

	private static final long serialVersionUID = 5269520401704922475L;

	public ControllableObject() {
	}

	public ControllableObject(Rectangle rect) {
		super(rect);
	}

	public ControllableObject(float x, float y, float width, float height) {
		super(x, y, width, height);
	}

}
