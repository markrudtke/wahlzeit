package org.wahlzeit.model;

/**
 * @inv name != null && coord != null 
 */
public class Location {
	
	public Coordinate coord;
	private String name = "";

	/**
	 * @methodtype constructor
	 */
	public Location() {
		assertClassInvariants();
	}

	/**
	 * @pre name != null
	 * @methodtype constructor
	 */
	public Location(String name) {
		assertClassInvariants();
		
		assertIsNonNullArgument(name);
		
		setName(name);
		
		assertClassInvariants();
	}
	
	/**
	 * @pre name != null && coord != null 
	 * @methodtype constructor
	 */
	public Location(String name, Coordinate coord) {
		assertClassInvariants();
		
		assertIsNonNullArgument(name);
		assertIsNonNullArgument(coord);
		
		setName(name);
		setCoordinate(coord);
		
		assertClassInvariants();
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
	public Coordinate getCoordinate() {
		return coord;
	}

	/**
	 * @pre name != null
	 * @methodtype set
	 */
	public void setName(String name) {
		assertClassInvariants();
		
		assertIsNonNullArgument(name);
		
		doSetName(name);
		
		assertClassInvariants();
	}
	
	/**
	 * @methodtype set
	 * @methodproperty primitive
	 */
	private void doSetName(String name) {
		this.name = name;
	}

	/**
	 * @pre coord != null 
	 * @methodtype set
	 */
	public void setCoordinate(Coordinate coord) {
		assertClassInvariants();
		
		assertIsNonNullArgument(coord);
		
		doSetCoordinate(coord);
		
		assertClassInvariants();
	}
	
	/**
	 * @methodtype set
	 * @methodproperty primitive
	 */
	private void doSetCoordinate(Coordinate coord) {
		this.coord = coord;
	}
	
	/**
	 * @methodtype assertion
	 */
	private void assertClassInvariants() {
		assertIsNonNullArgument(name);
	}
	
	/**
	 * @methodtype assertion
	 */
	private void assertIsNonNullArgument(String s) throws IllegalArgumentException {
		if(s == null) {
			throw new IllegalArgumentException("A Location name must not be null!");
		}
	}
	
	/**
	 * @methodtype assertion
	 */
	private void assertIsNonNullArgument(Coordinate c) throws IllegalArgumentException {
		if(c == null) {
			throw new IllegalArgumentException("A Location coordinate must not be null!");
		}
	}
	
}
