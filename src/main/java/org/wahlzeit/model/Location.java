package org.wahlzeit.model;

public class Location {
	
	public Coordinate coord;
	private String name;
	
	public Location() {
		coord = new Coordinate();
	}
	
	public Location(String name) {
		coord = new Coordinate();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setCoordinate(double x, double y, double z) {
		coord = new Coordinate(x, y, z);
	}
}
