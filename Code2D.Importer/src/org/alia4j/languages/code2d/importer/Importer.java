package org.alia4j.languages.code2d.importer;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

import nl.utwente.apc.Code2D.Code2DPackage;
import nl.utwente.apc.Code2D.CollisionTrigger;
import nl.utwente.apc.Code2D.Event;
import nl.utwente.apc.Code2D.Game;
import nl.utwente.apc.Code2D.Instance;
import nl.utwente.apc.Code2D.ObjectInstance;
import nl.utwente.apc.Code2D.PlayerInstance;
import nl.utwente.apc.Code2D.Trigger;
import nl.utwente.apc.Code2D.World;
import nl.utwente.apc.Code2D.base.Code2DGame;
import nl.utwente.apc.Code2D.base.Main;
import nl.utwente.apc.Code2D.base.core.GameObject;
import nl.utwente.apc.Code2D.base.core.Player;
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
import org.alia4j.patterns.ExceptionsPattern;
import org.alia4j.patterns.ModifiersPattern;
import org.alia4j.patterns.ParametersPattern;
import org.alia4j.patterns.TypePattern;
import org.alia4j.patterns.names.ExactNamePattern;
import org.alia4j.patterns.types.ExactClassTypePattern;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

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

		URL mainFile = systemClassLoader.getResource(System.getProperty("code2.main") + ".xmi");

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
		Resource resource = resSet.getResource(URI.createURI(mainFile.toExternalForm()), true);
		// Get the first model element and cast it to the right type, in my
		// example everything is hierarchical included in this first node
		Game gameDefinition = (Game) resource.getContents().get(0);

		processPlayerInstance(gameDefinition.getGameWorld().getPlayerInstance(), Main.getGameInstance());
		processObjectInstances(gameDefinition.getGameWorld().getWorldInstances(), Main.getGameInstance());
		processEvents(gameDefinition.getGameWorld(), Main.getGameInstance());
	

		Attachment[] toDeploy = new Attachment[initialAttachments.size()];
		org.alia4j.fial.System.deploy(initialAttachments.toArray(toDeploy));
	}

	private ArrayList<Trigger> processTriggers(EList<Trigger> worldTriggers, Code2DGame game) {
		ArrayList<Trigger> trList = new ArrayList<Trigger>();
		for(Trigger tr : worldTriggers) {
			trList.add(tr);
		}
		return trList;
	}

	private void processEvents(World world, Code2DGame game) {
		EList<Event> evList = world.getWorldEvents();
		ArrayList<Trigger> trList = processTriggers(world.getWorldTriggers(), Main.getGameInstance());
		for(Event ev : evList) {
			for(Trigger tr : trList) {
				if(ev.getCollisionTrigger() == tr) {
					CollisionTrigger ctr = (CollisionTrigger) tr;
					setupCollisionTrigger(ctr.getObject1(), ctr.getObject2());
				}
			}
		}
	}

	private void processObjectInstances(EList<ObjectInstance> worldInstances, Code2DGame game) {

		GameObject gameObject;
		for (ObjectInstance instance : worldInstances) {
			gameObject = Code2DImporterUtils.getGameObject(instance.getObject());
			addInstance(gameObject, instance, game);
		}
	}

	private void addInstance(GameObject gameObject, Instance instance, Code2DGame game) {
		if (instance instanceof ObjectInstance) {
			ObjectInstance oInstance = (ObjectInstance) instance;
			if (oInstance.getX2() > -1 || oInstance.getY2() > -1) {
				addMultipleInstances(gameObject, oInstance, game);
				return;
			}
		}
		addInstance(gameObject, instance.getX1(), instance.getY1(), game);
	}

	private void addInstance(GameObject gameObject, int x1, int y1, Code2DGame game) {
		gameObject.x = x1 * game.getWorldBlockDemisions()[0];
		gameObject.y = y1 * game.getWorldBlockDemisions()[1];
		game.add(gameObject);
	}

	private void addMultipleInstances(final GameObject gameObject, final ObjectInstance oInstance, final Code2DGame game) {
		GameObject objectToAdd = gameObject;
		for (int x = oInstance.getX1(); x <= oInstance.getX2(); x++) {
			for (int y = oInstance.getY1(); y <= oInstance.getY2(); y++) {
				addInstance(objectToAdd, x, y, game);
				try {
					objectToAdd = (GameObject) objectToAdd.clone();
				} catch (CloneNotSupportedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	private void processPlayerInstance(PlayerInstance pInstance, Code2DGame game) {
		nl.utwente.apc.Code2D.Player ePlayer = (nl.utwente.apc.Code2D.Player) pInstance.getPlayer();
		Player player = (Player) Code2DImporterUtils.getGameObject(ePlayer);
		addInstance(player, pInstance, game);
	}

	private void setupCollisionTrigger(nl.utwente.apc.Code2D.GameObject one, nl.utwente.apc.Code2D.GameObject two) {
		MethodPattern pattern = new MethodPattern(ModifiersPattern.ANY, TypePattern.ANY, new ExactClassTypePattern(
				TypeHierarchyProvider.findOrCreateFromClass(Code2DGame.class)), new ExactNamePattern("drawUpdateGame"),
				ParametersPattern.ANY, ExceptionsPattern.ANY);

		Specialization specialization = new Specialization(pattern, new BasicPredicate<AtomicPredicate>(
				C2DAtomicPredicateFactory.findOrCreateCollisionContextPredicate(
						C2DContextFactory.findOrCreateCollisionListContext(
								C2DContextFactory.findOrCreateWrappedFieldValueContext("objects",
										ContextFactory.findOrCreateCallerContext()), Code2DImporterUtils.getObjectClass(one), Code2DImporterUtils.getObjectId(one)),
						C2DContextFactory.findOrCreateCollisionListContext(
								C2DContextFactory.findOrCreateWrappedFieldValueContext("objects",
										ContextFactory.findOrCreateCallerContext()), Code2DImporterUtils.getObjectClass(two), Code2DImporterUtils.getObjectId(two))), true),
				Collections.<Context> emptyList());

		Attachment collisionAttachment = new Attachment(Collections.singleton(specialization),
				ActionFactory.findOrCreateMethodCallAction(
						TypeHierarchyProvider.findOrCreateFromClass(BasicAction.class), "endGame",
						new TypeDescriptor[0], TypeDescriptorConstants.VOID_PRIMITIVE, ResolutionStrategy.STATIC),
				ScheduleInfo.AFTER);
		initialAttachments.add(collisionAttachment);

	}
}
