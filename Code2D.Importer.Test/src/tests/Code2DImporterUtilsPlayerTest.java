package tests;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import mocks.PlayerMock;
import nl.utwente.apc.Code2D.base.core.GameObject;
import nl.utwente.apc.Code2D.base.core.NPC;
import nl.utwente.apc.Code2D.base.core.Player;

import org.alia4j.languages.code2d.importer.Code2DImporterUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * 
 */

/**
 * @author Damiaan
 *
 */
public class Code2DImporterUtilsPlayerTest {
	
	private nl.utwente.apc.Code2D.Player player;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		player = new PlayerMock();
		player.setHeight(64);
		player.setWidth(32);
		player.setTexture("PlayerTest.png");
		player.setName("Player0");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		Code2DImporterUtils.dispose();
	}

	@Test
	public void playerStandardPropertiesTest() {
		 GameObject player = Code2DImporterUtils.getGameObject(this.player);
		 assertEquals("Name is not right", this.player.getName(), player.getName());
		 assertEquals("Width is not right", this.player.getWidth(), (int) player.getWidth());
		 assertEquals("Height is not right", this.player.getHeight(), (int) player.getHeight());
		 assertEquals("Texture is not right", this.player.getTexture(), player.getTexturePath());
		 assertThat(player, instanceOf(Player.class));
		 assertSame(Player.class, Code2DImporterUtils.getObjectClass(this.player));
	}
	
	@Test
	public void playerIdTest() {
		 GameObject player0 = Code2DImporterUtils.getGameObject(this.player);
		 GameObject player1 = Code2DImporterUtils.getGameObject(this.player);
		 
		 assertEquals("Id's of the same objects are not the same", player0.getId(), player1.getId());
		 assertEquals("Id's are not the same", player0.getId(), Code2DImporterUtils.getObjectId(this.player));
	}
	
	@Test
	public void playerCloneTest() {
		GameObject player0 = Code2DImporterUtils.getGameObject(this.player);
		GameObject player1 = Code2DImporterUtils.getGameObject(this.player);
		
		assertThat(player0, not(sameInstance(player1)));
		assertEquals("Name is not the same", player0.getName(), player1.getName());
		assertEquals("Width is not the same", player0.getWidth(), player1.getWidth(), 0);
		assertEquals("Height is not the same", player0.getHeight(), player1.getHeight(), 0);
		assertEquals("Texture is not the same", player0.getTexturePath(), player1.getTexturePath());
	}

}
