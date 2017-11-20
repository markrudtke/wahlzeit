package org.wahlzeit.model;

public class CartesianCoordinate implements Coordinate{

	private static final double DELTA = 0.0001;
	
	private double x;
	private double y;
	private double z;
	
	/**
	 * @methodtype constructor
	 */
	public CartesianCoordinate() {
		
	}

	/**
	 * @methodtype constructor
	 */
	public CartesianCoordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	/**
	 * @methodtype get
	 */
	public double getX() {
		return x;
	}

	/**
	 * @methodtype get
	 */
	public double getY() {
		return y;
	}

	/**
	 * @methodtype get
	 */
	public double getZ() {
		return z;
	}
	
	/**
	 * Returns all cartesian coordinates of this coordinate.
	 * 
	 * @methodtype get
	 */
	public double[] getCoordinate() {
		return new double[] {x, y, z};
	}

	/**
	 * @methodtype set
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * @methodtype set
	 */
	public void setY(double y) {
		this.y = y;
	}

	/**
	 * @methodtype set
	 */
	public void setZ(double z) {
		this.z = z;
	}
	
	/**
	 * Sets all cartesian coordinates of this coordinate.
	 * 
	 * @methodtype set
	 */
	public void setCoordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * @methodtype conversion
	 */
	public CartesianCoordinate asCartesianCoordinate() {
		return this;
	}

	/**
	 * Computes the euclidean distance d(p,q) between this coordinate and q.
	 * 
	 * @methodtype get
	 */
	public double getCartesianDistance(Coordinate q) {
		CartesianCoordinate cc = q.asCartesianCoordinate();
		double px = this.x;
		double py = this.y;
		double pz = this.z;
		double qx = cc.getX();
		double qy = cc.getY();
		double qz = cc.getZ();
		double sum = Math.pow(qx-px, 2) + Math.pow(qy-py, 2) + Math.pow(qz-pz, 2);
		return Math.sqrt(sum);
	}

	/**
	 * @methodtype conversion
	 */
	public SphericCoordinate asSphericCoordinate() {
		double radius = Math.sqrt(x*x + y*y + z*z);
		double latitude = Math.acos(z / radius);
		double longitude = Math.atan(y / x);
		return new SphericCoordinate(latitude, longitude, radius);
	}

	/**
	 * Computes the spherical distance d(p,q) between this coordinate and q.
	 * 
	 * @methodtype get
	 */
	public double getSphericDistance(Coordinate q) {
		return this.asSphericCoordinate().getSphericDistance(q);
	}

	/**
	 * Computes the distance d(p,q) between this coordinate and q.
	 * 
	 * @methodtype get
	 */
	public double getDistance(Coordinate q) {
			return this.getCartesianDistance(q);		
	}
	
	/**
	 * Compares two coordinates and returns true if this coordinate equals q.
	 * 
	 * @methodtype boolean query
	 */
	public boolean isEqual(Coordinate q) {
		CartesianCoordinate cc = q.asCartesianCoordinate();
		if (Math.abs(this.x - cc.getX()) < DELTA
				&& Math.abs(this.y - cc.getY()) < DELTA
				&& Math.abs(this.z - cc.getZ()) < DELTA) {
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
