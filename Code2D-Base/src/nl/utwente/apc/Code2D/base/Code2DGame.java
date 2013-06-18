package nl.utwente.apc.Code2D.base;

import java.util.Iterator;

import nl.utwente.apc.Code2D.base.core.NPC;
import nl.utwente.apc.Code2D.base.core.Player;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public class Code2DGame implements ApplicationListener {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	
	private Texture dropImage;
	private Texture bucketImage;

	private Sound dropSound;
	private Music rainMusic;

	private Player player;

	private Array<NPC> NPCs;
	private long lastDropTime;

	@Override
	public void create() {
		this.camera = new OrthographicCamera();
		this.camera.setToOrtho(false, 800, 480);

		this.batch = new SpriteBatch();

		// texture = new Texture(Gdx.files.internal("data/libgdx.png"));
		// texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		this.dropImage = new Texture(Gdx.files.internal("droplet.png"));
		this.bucketImage = new Texture(Gdx.files.internal("bucket.png"));

		this.dropSound = Gdx.audio.newSound(Gdx.files.internal("drop.wav"));
		this.rainMusic = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));

		this.rainMusic.setLooping(true);
		this.rainMusic.play();

		this.player = new Player(480 / 2 - 64 / 2, 20, 64, 64);

		NPCs = new Array<NPC>();
		spawnNPC();

		// TextureRegion region = new TextureRegion(texture, 0, 0, 512, 275);

		// sprite = new Sprite(region);
		// sprite.setSize(0.9f, 0.9f * sprite.getHeight() / sprite.getWidth());
		// sprite.setOrigin(sprite.getWidth()/2, sprite.getHeight()/2);
		// sprite.setPosition(-sprite.getWidth()/2, -sprite.getHeight()/2);
	}

	@Override
	public void dispose() {
		dropImage.dispose();
		bucketImage.dispose();
		dropSound.dispose();
		rainMusic.dispose();
		batch.dispose();
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		this.camera.update();

		this.batch.setProjectionMatrix(camera.combined);
		this.batch.begin();
		this.batch.draw(bucketImage, player.x, player.y);
		for (Rectangle npc : NPCs) {
			batch.draw(dropImage, npc.x, npc.y);
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
				dropSound.play();
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
		NPCs.add(npc);
		lastDropTime = TimeUtils.nanoTime();
	}
}
