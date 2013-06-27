package org.alia4j.languages.code2d.importer;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

import org.alia4j.hierarchy.TypeDescriptor;
import org.alia4j.hierarchy.TypeDescriptorConstants;
import org.alia4j.hierarchy.TypeHierarchyProvider;
import org.alia4j.languages.code2d.actions.BasicAction;
import org.alia4j.languages.code2d.context.C2DContextFactory;
import org.alia4j.languages.code2d.predicate.C2DAtomicPredicateFactory;
import org.alia4j.liam.ActionFactory;
import org.alia4j.liam.AtomicPredicate;
import org.alia4j.liam.Attachment;
import org.alia4j.liam.BasicPredicate;
import org.alia4j.liam.Context;
import org.alia4j.liam.ContextFactory;
import org.alia4j.liam.ScheduleInfo;
import org.alia4j.liam.Specialization;
import org.alia4j.liam.pattern.MethodPattern;
import org.alia4j.liam.signature.ResolutionStrategy;
import org.alia4j.patterns.ClassTypePattern;
import org.alia4j.patterns.ExceptionsPattern;
import org.alia4j.patterns.ModifiersPattern;
import org.alia4j.patterns.ParametersPattern;
import org.alia4j.patterns.TypePattern;
import org.alia4j.patterns.names.ExactNamePattern;
import org.alia4j.patterns.types.ExactClassTypePattern;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.ui.List;

import nl.utwente.apc.Code2D.Code2DPackage;
import nl.utwente.apc.Code2D.Game;
import nl.utwente.apc.Code2D.base.Code2DGame;
import nl.utwente.apc.Code2D.base.Main;
import nl.utwente.apc.Code2D.base.core.NPC;
import nl.utwente.apc.Code2D.base.core.Player;
import nl.utwente.apc.Code2D.impl.Code2DPackageImpl;

public class Importer implements org.alia4j.fial.Importer {

	private final ClassLoader systemClassLoader;
	private boolean initialized = false;
	
	private ArrayList<Attachment> initialAttachments = new ArrayList<Attachment>();

	public Importer(ClassLoader systemClassLoader) {
		this.systemClassLoader = systemClassLoader;
	}

	@Override
	public void performImport() {
		if (initialized)
			throw new Error("Importer has already been executed.");
		initialized = true;

		URL mainFile = systemClassLoader.getResource(System
				.getProperty("code2.main") + ".xmi");

		if (mainFile == null) {
			System.out
					.println("No Code2D file specified (use VM argument -Dcode2.main=<class-path-relative-file-name>");
		}

		// Initialize the model
		Code2DPackage.eINSTANCE.eClass();

		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("*", new XMIResourceFactoryImpl());

		// Obtain a new resource set
		ResourceSet resSet = new ResourceSetImpl();

		// Get the resource
		Resource resource = resSet.getResource(
				URI.createURI(mainFile.toExternalForm()), true);
		// Get the first model element and cast it to the right type, in my
		// example everything is hierarchical included in this first node
		Game gameDefinition = (Game) resource.getContents().get(0);

		Code2DGame game = Main.getGameInstance();
			
		Player player = new Player();
		player.x = 480 / 2 - 64 /2;
		player.y = 20;
		player.width = 64;
		player.height = 64;
		player.setId(1);
		player.setTexturePath("bucket.png");
		
		NPC npc = new NPC();
		npc.x = MathUtils.random(0, 800 - 64);
		npc.y = MathUtils.random(0, 480 - 64);
		npc.width = 64;
		npc.height = 64;
		npc.setId(2);
		npc.setTexturePath("droplet.png");
		
		game.add(player);
		game.add(npc);
		
		setupCollisionTrigger(player, npc);
		
		Attachment[] toDeploy = new Attachment[initialAttachments.size()];
		org.alia4j.fial.System.deploy(initialAttachments.toArray(toDeploy));
	}
		
	private void setupCollisionTrigger(Player player, NPC npc) {
		MethodPattern pattern = new MethodPattern(
				ModifiersPattern.ANY,
				TypePattern.ANY, 
				new ExactClassTypePattern(TypeHierarchyProvider.findOrCreateFromClass(Code2DGame.class)),
				new ExactNamePattern("drawUpdateGame"), 
				ParametersPattern.ANY,
				ExceptionsPattern.ANY);
		
		Specialization specialization = new Specialization(
				pattern,
				new BasicPredicate<AtomicPredicate>(
						C2DAtomicPredicateFactory.findOrCreateCollisionContextPredicate(
								C2DContextFactory.findOrCreateCollisionListContext(C2DContextFactory.findOrCreateWrappedFieldValueContext("objects", ContextFactory.findOrCreateCallerContext()), Player.class, 1),
								C2DContextFactory.findOrCreateCollisionListContext(C2DContextFactory.findOrCreateWrappedFieldValueContext("objects", ContextFactory.findOrCreateCallerContext()), NPC.class, 2)),
								true),
				Collections.<Context>emptyList());

		Attachment collisionAttachment = new Attachment(
				Collections.singleton(specialization),
				ActionFactory.findOrCreateMethodCallAction(TypeHierarchyProvider.findOrCreateFromClass(BasicAction.class),
				"endGame", new TypeDescriptor[0], TypeDescriptorConstants.VOID_PRIMITIVE, ResolutionStrategy.STATIC), ScheduleInfo.AFTER);
		initialAttachments.add(collisionAttachment);
		
	}
}
