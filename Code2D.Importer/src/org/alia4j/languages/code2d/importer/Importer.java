package org.alia4j.languages.code2d.importer;

import java.net.URL;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import nl.utwente.apc.Code2D.Code2DPackage;
import nl.utwente.apc.Code2D.Game;
import nl.utwente.apc.Code2D.base.Code2DGame;
import nl.utwente.apc.Code2D.base.Main;
import nl.utwente.apc.Code2D.base.core.Player;
import nl.utwente.apc.Code2D.impl.Code2DPackageImpl;

public class Importer implements org.alia4j.fial.Importer {

	private final ClassLoader systemClassLoader;
	private boolean initialized = false;

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
		player.x = 480 / 2 -64 /2;
		player.y = 20;
		player.width = 64;
		player.height = 64;
		player.setTexturePath("bucket.png");
		
		game.add(player);
	}

}
