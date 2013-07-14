package nl.utwente.apc.Code2D.base.core;

import com.badlogic.gdx.math.Rectangle;

/**
 * @author Damiaan
 *
 */
public class Scenery extends GameObject {

	private static final long serialVersionUID = 4840206120900954928L;

	public Scenery() {
	}

	public Scenery(Rectangle rect) {
		super(rect);
	}

	public Scenery(float x, float y, float width, float height) {
		super(x, y, width, height);
	}
}
