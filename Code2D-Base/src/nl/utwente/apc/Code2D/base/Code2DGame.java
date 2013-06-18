package nl.utwente.apc.Code2D.base;

import java.util.Iterator;

import nl.utwente.apc.Code2D.base.core.GameObject;
import nl.utwente.apc.Code2D.base.core.NPC;
import nl.utwente.apc.Code2D.base.core.Player;
import nl.utwente.apc.Code2D.base.core.TextureFactory;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public class Code2DGame implements ApplicationListener {
	private OrthographicCamera camera;
	private SpriteBatch batch;

	private Player player;

	private Array<NPC> NPCs;
	
	private long lastDropTime;

	@Override
	public void create() {
		this.camera = new OrthographicCamera();
		this.camera.setToOrtho(false, 800, 480);

		this.batch = new SpriteBatch();

		this.player = new Player(480 / 2 - 64 / 2, 20, 64, 64);
		this.player.setTexturePath("bucket.png");

		NPCs = new Array<NPC>();
		spawnNPC();
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
		this.batch.begin();
		this.player.draw(this.batch);
		for (GameObject npc : NPCs) {
			npc.draw(this.batch);
		}
		this.batch.end();

		/*if (Gdx.input.isTouched()) {
			Vector3 touchPos = new Vector3();
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touchPos);
			player.x = touchPos.x - 64 / 2;
		}*/

		this.player.updatePos();
		

		if ((TimeUtils.nanoTime() - lastDropTime > 1000000000) && NPCs.size < 5)
			spawnNPC();

		Iterator<NPC> iter = NPCs.iterator();
		while (iter.hasNext()) {
			NPC npc = iter.next();
			npc.updatePos();
			
			if (npc.overlaps(player)) {
				iter.remove();
			}
		}

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

	private void spawnNPC() {
		NPC npc = new NPC();
		npc.x = MathUtils.random(0, Gdx.graphics.getWidth() - 64);
		npc.y = MathUtils.random(0, Gdx.graphics.getHeight() - 64);
		npc.width = 64;
		npc.height = 64;
		npc.setTexturePath("droplet.png");
		NPCs.add(npc);
		lastDropTime = TimeUtils.nanoTime();
	}
}
