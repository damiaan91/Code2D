package tests;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import mocks.NPCMock;
import nl.utwente.apc.Code2D.NPCBehaviour;
import nl.utwente.apc.Code2D.base.core.GameObject;
import nl.utwente.apc.Code2D.base.core.NPC;

import org.alia4j.languages.code2d.importer.Code2DImporterUtils;
import org.hamcrest.core.IsAnything;
import org.hamcrest.core.IsSame;
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
public class Code2DImporterUtilsNPCTest {
	
	private nl.utwente.apc.Code2D.NPC npc;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		npc = createNPC();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		Code2DImporterUtils.dispose();
	}

	@Test
	public void NPCStandardPropertiesTest() {
		 GameObject NPC = Code2DImporterUtils.getGameObject(this.npc);
		 assertEquals("Name is not right", this.npc.getName(), NPC.getName());
		 assertEquals("Width is not right", this.npc.getWidth(), (int) NPC.getWidth());
		 assertEquals("Height is not right", this.npc.getHeight(), (int) NPC.getHeight());
		 assertEquals("Texture is not right", this.npc.getTexture(), NPC.getTexturePath());
		 assertThat(NPC, instanceOf(NPC.class));
		 assertSame(NPC.class, Code2DImporterUtils.getObjectClass(this.npc));
	}
	
	@Test
	public void NPCIdTest() {
		 GameObject NPC0 = Code2DImporterUtils.getGameObject(this.npc);
		 GameObject NPC1 = Code2DImporterUtils.getGameObject(this.npc);
		 
		 assertEquals("Id's of the same objects are not the same", NPC0.getId(), NPC1.getId());
		 assertEquals("Id's are not the same", NPC0.getId(), Code2DImporterUtils.getObjectId(this.npc));
	}
	
	@Test
	public void NPCCloneTest() {
		GameObject NPC0 = Code2DImporterUtils.getGameObject(this.npc);
		GameObject NPC1 = Code2DImporterUtils.getGameObject(this.npc);
		
		assertThat(NPC0, not(sameInstance(NPC1)));
		assertEquals("Name is not the same", NPC0.getName(), NPC1.getName());
		assertEquals("Width is not the same", NPC0.getWidth(), NPC1.getWidth(), 0);
		assertEquals("Height is not the same", NPC0.getHeight(), NPC1.getHeight(), 0);
		assertEquals("Texture is not the same", NPC0.getTexturePath(), NPC1.getTexturePath());
	}
	
	@Test
	public void NPCBehaviourTest() {
		NPC NPC0 = (NPC) Code2DImporterUtils.getGameObject(this.npc);
		nl.utwente.apc.Code2D.NPC npc1def = createNPC();
		npc1def.setBehaviour(NPCBehaviour.HOSTILE);
		NPC NPC1 = (NPC) Code2DImporterUtils.getGameObject(npc1def);
		nl.utwente.apc.Code2D.NPC npc2def = createNPC();
		npc2def.setBehaviour(NPCBehaviour.NEUTRAL);
		NPC NPC2 = (NPC) Code2DImporterUtils.getGameObject(npc2def);
		
		assertThat(NPC0.getBehaviour(), is(nl.utwente.apc.Code2D.base.core.NPCBehaviour.FRIENDLY));
		assertThat(NPC1.getBehaviour(), is(nl.utwente.apc.Code2D.base.core.NPCBehaviour.HOSTILE));
		assertThat(NPC2.getBehaviour(), is(nl.utwente.apc.Code2D.base.core.NPCBehaviour.NEUTRAL));
	}
	
	public nl.utwente.apc.Code2D.NPC createNPC() {
		nl.utwente.apc.Code2D.NPC npc = new NPCMock();
		npc.setHeight(64);
		npc.setWidth(32);
		npc.setTexture("NPCTest.png");
		npc.setName("NPC0");
		npc.setBehaviour(NPCBehaviour.FRIENDLY);
		return npc;
	}

}
