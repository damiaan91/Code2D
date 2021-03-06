package nl.utwente.apc.Code2D.base;

import java.util.ArrayList;
import java.util.List;

import nl.utwente.apc.Code2D.base.core.GameObject;
import nl.utwente.apc.Code2D.base.core.MoveableObject;
import nl.utwente.apc.Code2D.base.core.TextureFactory;
import static nl.utwente.apc.Code2D.base.utils.Reversed.reversed;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Code2DGame implements ApplicationListener {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	
	private List<GameObject> objects;
	
	private int[] worldBlockDemisions = {32, 32};
	
	public Code2DGame() {
		super();
		this.objects = new ArrayList<GameObject>();
	}
	
	public void add(GameObject object) {
		this.objects.add(object);
	}

	@Override
	public void create() {
		this.camera = new OrthographicCamera();
		this.camera.setToOrtho(false, 800, 480);

		this.batch = new SpriteBatch(300);
		
		for(GameObject object : this.objects) {
			object.init();
		}
	}

	@Override
	public void dispose() {
		batch.dispose();
		TextureFactory.getInstance().dispose();
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		this.camera.update();
		
		this.batch.setProjectionMatrix(camera.combined);
		drawUpdateGame();
	}

	private void drawUpdateGame() {
		this.batch.begin();
		for(GameObject object : reversed(this.objects)) {
			object.draw(batch);
			if(object instanceof MoveableObject) {
				((MoveableObject) object).updatePos();
			}
		}
		this.batch.end();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	public int[] getWorldBlockDemisions() {
		return worldBlockDemisions;
	}
	
}
