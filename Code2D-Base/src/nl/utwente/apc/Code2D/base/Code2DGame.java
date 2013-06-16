package nl.utwente.apc.Code2D.base;

import java.util.Iterator;
import java.util.Random;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public class Code2DGame implements ApplicationListener {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Texture texture;
	private Sprite sprite;

	private Texture dropImage;
	private Texture bucketImage;

	private Sound dropSound;
	private Music rainMusic;

	private Rectangle bucket;

	private Array<Rectangle> raindrops;
	private long lastDropTime;
	
	private Random rng = new Random();

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

		this.bucket = new Rectangle();
		this.bucket.x = 480 / 2 - 64 / 2;
		this.bucket.y = 20;
		this.bucket.width = 64;
		this.bucket.height = 64;

		raindrops = new Array<Rectangle>();
		spawnRaindrop();

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
		this.batch.draw(bucketImage, bucket.x, bucket.y);
		for (Rectangle raindrop : raindrops) {
			batch.draw(dropImage, raindrop.x, raindrop.y);
		}
		this.batch.end();

		if (Gdx.input.isTouched()) {
			Vector3 touchPos = new Vector3();
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touchPos);
			bucket.x = touchPos.x - 64 / 2;
		}

		if (Gdx.input.isKeyPressed(Keys.LEFT))
			bucket.x -= 200 * Gdx.graphics.getDeltaTime();
		if (Gdx.input.isKeyPressed(Keys.RIGHT))
			bucket.x += 200 * Gdx.graphics.getDeltaTime();
		if (Gdx.input.isKeyPressed(Keys.UP))
			bucket.y += 200 * Gdx.graphics.getDeltaTime();
		if (Gdx.input.isKeyPressed(Keys.DOWN))
			bucket.y -= 200 * Gdx.graphics.getDeltaTime();

		if (bucket.x < 0)
			bucket.x = 0;
		if (bucket.x > Gdx.graphics.getWidth() - 64)
			bucket.x = Gdx.graphics.getWidth() - 64;
		if (bucket.y < 0)
			bucket.y = 0;
		if (bucket.y > Gdx.graphics.getHeight() - 64)
			bucket.y = Gdx.graphics.getHeight() - 64;
		

		if ((TimeUtils.nanoTime() - lastDropTime > 1000000000) && raindrops.size < 5)
			spawnRaindrop();

		Iterator<Rectangle> iter = raindrops.iterator();
		while (iter.hasNext()) {
			Rectangle raindrop = iter.next();
			raindrop.x += MathUtils.random(-200, 200) * Gdx.graphics.getDeltaTime();
			raindrop.y += MathUtils.random(-200, 200) * Gdx.graphics.getDeltaTime();
			if (raindrop.x + 64 < 0)
				raindrop.x = 0;
			if (raindrop.y + 64< 0)
				raindrop.y = 0;
			if (raindrop.x > Gdx.graphics.getWidth())
				raindrop.x = Gdx.graphics.getWidth() - 64;
			if (raindrop.y > Gdx.graphics.getHeight())
				raindrop.y = Gdx.graphics.getHeight() - 64;
			
			if (raindrop.overlaps(bucket)) {
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

	private void spawnRaindrop() {
		Rectangle raindrop = new Rectangle();
		raindrop.x = MathUtils.random(0, Gdx.graphics.getWidth() - 64);
		raindrop.y = MathUtils.random(0, Gdx.graphics.getHeight() - 64);
		raindrop.width = 64;
		raindrop.height = 64;
		raindrops.add(raindrop);
		lastDropTime = TimeUtils.nanoTime();
	}
}
