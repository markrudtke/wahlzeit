package org.wahlzeit.model;

public interface Coordinate {

	/**
	 * @methodtype conversion
	 */
	public CartesianCoordinate asCartesianCoordinate();
	
	/**
	 * @methodtype get
	 */
	public double getCartesianDistance(Coordinate coord);
	
	/**
	 * @methodtype conversion
	 */
	public SphericCoordinate asSphericCoordinate();
	
	/**
	 * @methodtype get
	 */
	public double getSphericDistance(Coordinate coord);
	
	/**
	 * @methodtype get
	 */
	public double getDistance(Coordinate coord);
	
	/**
	 * @methodtype boolean query
	 */
	public boolean isEqual(Coordinate coord);
}
