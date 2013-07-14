package nl.utwente.apc.Code2D.base.core;

import com.badlogic.gdx.math.Rectangle;

/**
 * @author Damiaan
 *
 */
public class Terrain extends GameObject {

	private static final long serialVersionUID = 574051303998267711L;

	public Terrain() {
	}

	public Terrain(Rectangle rect) {
		super(rect);
	}

	public Terrain(float x, float y, float width, float height) {
		super(x, y, width, height);
	}
}
