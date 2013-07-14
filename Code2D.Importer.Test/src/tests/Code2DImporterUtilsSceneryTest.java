package tests;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import mocks.SceneryMock;
import nl.utwente.apc.Code2D.base.core.GameObject;
import nl.utwente.apc.Code2D.base.core.Player;
import nl.utwente.apc.Code2D.base.core.Scenery;

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
public class Code2DImporterUtilsSceneryTest {
	
	private nl.utwente.apc.Code2D.Scenery scenery;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		scenery = new SceneryMock();
		scenery.setHeight(64);
		scenery.setWidth(32);
		scenery.setTexture("TestSceneryTest.png");
		scenery.setName("Scenery0");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		Code2DImporterUtils.dispose();
	}

	@Test
	public void sceneryStandardPropertiesTest() {
		 GameObject scenery = Code2DImporterUtils.getGameObject(this.scenery);
		 assertEquals("Name is not right", this.scenery.getName(), scenery.getName());
		 assertEquals("Width is not right", this.scenery.getWidth(), (int) scenery.getWidth());
		 assertEquals("Height is not right", this.scenery.getHeight(), (int) scenery.getHeight());
		 assertEquals("Texture is not right", this.scenery.getTexture(), scenery.getTexturePath());
		 assertThat(scenery, instanceOf(Scenery.class));
		 assertSame(Scenery.class, Code2DImporterUtils.getObjectClass(this.scenery));
	}
	
	@Test
	public void sceneryIdTest() {
		 GameObject scenery0 = Code2DImporterUtils.getGameObject(this.scenery);
		 GameObject scenery1 = Code2DImporterUtils.getGameObject(this.scenery);
		 
		 assertEquals("Id's of the same objects are not the same", scenery0.getId(), scenery1.getId());
		 assertEquals("Id's are not the same", scenery0.getId(), Code2DImporterUtils.getObjectId(this.scenery));
	}
	
	@Test
	public void sceneryCloneTest() {
		GameObject scenery0 = Code2DImporterUtils.getGameObject(this.scenery);
		GameObject scenery1 = Code2DImporterUtils.getGameObject(this.scenery);
		
		assertThat(scenery0, not(sameInstance(scenery1)));
		assertEquals("Name is not the same", scenery0.getName(), scenery1.getName());
		assertEquals("Width is not the same", scenery0.getWidth(), scenery1.getWidth(), 0);
		assertEquals("Height is not the same", scenery0.getHeight(), scenery1.getHeight(), 0);
		assertEquals("Texture is not the same", scenery0.getTexturePath(), scenery1.getTexturePath());
	}

}
