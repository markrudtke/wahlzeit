package org.wahlzeit.model;

public class Location {
	
	public Coordinate coord;
	private String name;

	/**
	 * @methodtype constructor
	 */
	public Location() {
		
	}

	/**
	 * @methodtype constructor
	 */
	public Location(String name) {
		this.name = name;
	}
	
	/**
	 * @methodtype constructor
	 */
	public Location(String name, Coordinate coord) {
		this.name = name;
		this.coord = coord;
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
	 * @methodtype set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @methodtype set
	 */
	public void setCoordinate(Coordinate coord) {
		this.coord = coord;
	}
}
