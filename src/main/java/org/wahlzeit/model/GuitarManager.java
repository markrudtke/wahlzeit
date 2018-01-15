package org.wahlzeit.model;

import java.util.HashMap;

public class GuitarManager {

	private static final GuitarManager instance = new GuitarManager();
	
	private static final HashMap<String, Guitar> guitars = new HashMap<>();
	
	/**
	 * @methodtype constructor
	 */
	private GuitarManager() {
		
	}
	
	/**
	 * 
	 */
	public static final GuitarManager getInstance() {
		return instance;
	}
	
	/**
	 * Creates a new Guitar with the given type name.
	 * 
	 * @pre typeName != null
	 */
	public Guitar createGuitar(String typeName) {
		assertIsValidGuitarTypeName(typeName);
		
		GuitarType gt = getGuitarType(typeName);
		Guitar result = gt.createInstance();
		guitars.put(result.getId(), result);
		return result;
	}
	
	/**
	 * Returns a GuitarType with the given type name.
	 */
	private GuitarType getGuitarType(String typeName) {
		Guitar result = guitars.get(typeName);
		if(result == null) {
			synchronized (guitars) {
				result = guitars.get(typeName);
				if(result == null) {
					result = new Guitar(new GuitarType(typeName));
					guitars.put(typeName, result);
				}
			}
		}
		return result.getType();
	}

	/**
	 * @methodtype assertion
	 */
	protected static void assertIsValidGuitarTypeName(String typeName) {
		if(typeName == null) {
			throw new IllegalArgumentException("A type name must not be null!");
		}
	}
	
}
