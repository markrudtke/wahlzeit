package org.wahlzeit.model;

public class SphericCoordinate implements Coordinate {

	private static final double DELTA = 0.0001;
	
	private double latitude;
	private double longitude;
	private double radius;
	
	/**
	 * @methodtype constructor
	 */
	public SphericCoordinate() {
		
	}

	/**
	 * @methodtype constructor
	 */
	public SphericCoordinate(double latitude, double longitude, double radius) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.radius = radius;
	}
	
	/**
	 * @methodtype get
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * @methodtype get
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * @methodtype get
	 */
	public double getRadius() {
		return radius;
	}
	
	/**
	 * Returns all spheric coordinates of this coordinate.
	 * 
	 * @methodtype get
	 */
	public double[] getCoordinate() {
		return new double[] {latitude, longitude, radius};
	}

	/**
	 * @methodtype set
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @methodtype set
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/**
	 * @methodtype set
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	/**
	 * Sets all spheric coordinates of this coordinate.
	 * 
	 * @methodtype set
	 */
	public void setCoordinate(double latitude, double longitude, double radius) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.radius = radius;
	}
	
	/**
	 * @methodtype conversion
	 */
	public CartesianCoordinate asCartesianCoordinate() {
		double x = radius * Math.sin(latitude) * Math.cos(longitude);
		double y = radius * Math.sin(latitude) * Math.sin(longitude);
		double z = radius * Math.cos(latitude);
		return new CartesianCoordinate(x, y, z);

	}

	/**
	 * Computes the euclidean distance d(p,q) between this coordinate and q.
	 * 
	 * @methodtype get
	 */
	public double getCartesianDistance(Coordinate q) {
		return this.asCartesianCoordinate().getCartesianDistance(q);
	}

	/**
	 * @methodtype conversion
	 */
	public SphericCoordinate asSphericCoordinate() {
		return this;
	}

	/**
	 * Computes the spherical distance d(p,q) between this coordinate and q.
	 * 
	 * @methodtype get
	 */
	public double getSphericDistance(Coordinate q) {
		return this.getCartesianDistance(q); // using conversion for distance calculation
	}

	/**
	 * Computes the distance d(p,q) between this coordinate and q.
	 * 
	 * @methodtype get
	 */
	public double getDistance(Coordinate q) {
		return this.getSphericDistance(q);
	}

	/**
	 * Compares two coordinates and returns true if this coordinate equals q.
	 * 
	 * @methodtype boolean query
	 */
	public boolean isEqual(Coordinate q) {
		SphericCoordinate sc = q.asSphericCoordinate();
		if (Math.abs(this.latitude - sc.getLatitude()) < DELTA
				&& Math.abs(this.longitude - sc.getLongitude()) < DELTA
				&& Math.abs(this.radius - sc.getRadius()) < DELTA) {
			return true;
		}
		return false;
	}
	
	/**
	 * Forwards equals() to isEqual();
	 * 
	 * @methodtype boolean query
	 */
	@Override
	public boolean equals(Object q) {
		if (q instanceof CartesianCoordinate) {
			return this.isEqual((CartesianCoordinate) q);
		}
		if (q instanceof SphericCoordinate) {
			return this.isEqual((SphericCoordinate) q);
		}
		return false;
	}
}
