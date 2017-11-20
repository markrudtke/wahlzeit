package org.wahlzeit.model;

public class Location {
	
	public CartesianCoordinate coord;
	private String name;

	/**
	 * @methodtype constructor
	 */
	public Location() {
		coord = new CartesianCoordinate();
	}

	/**
	 * @methodtype constructor
	 */
	public Location(String name) {
		coord = new CartesianCoordinate();
		this.name = name;
	}

	/**
	 * @methodtype get
	 */
	public String getName() {
		return name;
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
	public void setCoordinate(double x, double y, double z) {
		coord = new CartesianCoordinate(x, y, z);
	}
}
