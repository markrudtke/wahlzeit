package org.wahlzeit.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.wahlzeit.services.DataObject;

public class GuitarType extends DataObject {
	
	private String name;
	
	protected GuitarType superType = null;
	protected Set<GuitarType> subTypes = new HashSet<GuitarType>();
	
	/**
	 * @pre name != null
	 * @methodtype constructor
	 */
	public GuitarType(String name) {
		AssertionUtil.assertIsNonNullArgument(name);
		
		this.name = name;
	}
	
	/**
	 * @methodtype get
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @methodtype get
	 */
	public GuitarType getSuperType() {
		return superType;
	}
	
	/**
	 * @methodtype get
	 */
	public Iterator<GuitarType> getSubTypeIterator() {
		return subTypes.iterator();
	}
	
	/**
	 * @pre guitarType != null
	 */
	public void addSubType(GuitarType guitarType) {
		assertIsValidGuitarType(guitarType);
		
		guitarType.setSuperType(this);
		subTypes.add(guitarType);
	}
	
	/**
	 * @methodtype set
	 */
	private void setSuperType(GuitarType guitarType) {
		superType = guitarType;
	}

	/**
	 * @pre guitar != null
	 * @methodtype boolean query
	 */
	public boolean hasInstance(Guitar guitar) {
		assertIsValidGuitar(guitar);
		
		if(guitar.getType() == this) {
			return true;
		}
		for(GuitarType type : subTypes) {
			if(type.hasInstance(guitar)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @methodtype boolean query
	 */
	public boolean isSubtype() {
		if(superType != null) {
			return true;
		}
		return false;
	}
	
	/**
	 * @pre guitarType != null
	 * @methodtype boolean query
	 */
	public boolean isSubtype(GuitarType guitarType) {
		assertIsValidGuitarType(guitarType);
		
		if(superType == guitarType) {
			return true;
		}
		return false;
	}
	
	/**
	 * @methodtype boolean query
	 */
	public boolean isSupertype() {
		if(superType == null) {
			return true;
		}
		return false;
	}
	
	/**
	 * @pre guitarType != null
	 * @methodtype boolean query
	 */
	public boolean isSupertype(GuitarType guitarType) {
		assertIsValidGuitarType(guitarType);
		
		if(subTypes.contains(guitarType)) {
			return true;
		}
		return false;
	}
	
	/**
	 * @methodtype factory
	 */
	public Guitar createInstance() {
		return new Guitar(this);
	}
	
	/**
	 * @methodtype assertion
	 */
	protected static void assertIsValidGuitarType(GuitarType guitarType) {
		if(guitarType== null) {
			throw new IllegalArgumentException("A GuitarType must not be null!");
		}
	}
	
	/**
	 * @methodtype assertion
	 */
	protected static void assertIsValidGuitar(Guitar guitar) {
		if(guitar == null) {
			throw new IllegalArgumentException("A Guitar must not be null!");
		}
	}
	
}
