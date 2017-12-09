package org.wahlzeit.model;

public interface Coordinate {

	/**
	 * @methodtype conversion
	 */
	public CartesianCoordinate asCartesianCoordinate() throws IllegalArgumentException;
	
	/**
	 * @methodtype get
	 */
	public double getCartesianDistance(Coordinate coord) throws IllegalArgumentException;
	
	/**
	 * @methodtype conversion
	 */
	public SphericCoordinate asSphericCoordinate() throws IllegalArgumentException;
	
	/**
	 * @methodtype get
	 */
	public double getSphericDistance(Coordinate coord) throws IllegalArgumentException;
	
	/**
	 * @methodtype get
	 */
	public double getDistance(Coordinate coord) throws IllegalArgumentException;
	
	/**
	 * @methodtype boolean query
	 */
	public boolean isEqual(Coordinate coord) throws IllegalArgumentException;
}
