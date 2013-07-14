package nl.utwente.apc.Code2D.base;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	
	private static Code2DGame game;
	
	private static LwjglApplication app;
	
	public static Code2DGame getGameInstance() {
		if(game == null) {
			game = new Code2DGame();
		}
		return game;
	}
	
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Code2D-Base";
		cfg.useGL20 = false;
		cfg.width = 800;
		cfg.height = 480;
		
		app = new LwjglApplication(game, cfg);
	}
	
	public static void exit() {
		app.exit();
	}
}
