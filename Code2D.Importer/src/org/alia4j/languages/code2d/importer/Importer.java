package org.alia4j.languages.code2d.importer;

import java.net.URL;

import nl.utwente.apc.Code2D.Code2DPackage;
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

		URL mainFile = systemClassLoader.getResource(System.getProperty("code2.main") + ".xmi");
		
		if (mainFile == null) {
			System.out.println("No text adventure file specified (use VM argument -Dcode2.main=<class-path-relative-file-name>");
		}
		
		Code2DPackage.eINSTANCE.eClass();
		//Code2DPackage.eINSTANCE.eClass();
	}

}
