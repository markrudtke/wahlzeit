package org.wahlzeit.model;

public class Coordinate {

	private static final double DELTA = 0.0001;
	
	private double x;
	private double y;
	private double z;
	
	/**
	 * @methodtype constructor
	 */
	public Coordinate() {
		
	}

	/**
	 * @methodtype constructor
	 */
	public Coordinate(double x, double y, double z) {
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
	 * Computes the euclidean distance d(p,q) between this coordinate and q.
	 * 
	 * @methodtype get
	 */
	public double getDistance(Coordinate q) {
		double px = this.x;
		double py = this.y;
		double pz = this.z;
		double qx = q.getX();
		double qy = q.getY();
		double qz = q.getZ();
		double sum = Math.pow(qx-px, 2) + Math.pow(qy-py, 2) + Math.pow(qz-pz, 2);
		return Math.sqrt(sum);
	}
	
	/**
	 * Compares two coordinates and returns true if this coordinate equals q.
	 * 
	 * @methodtype boolean query
	 */
	public boolean isEqual(Coordinate q) {
		if (Math.abs(this.x - q.getX()) < DELTA
				&& Math.abs(this.y - q.getY()) < DELTA
				&& Math.abs(this.z - q.getZ()) < DELTA) {
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
		if (q instanceof Coordinate) {
			return this.isEqual((Coordinate) q);
		}
		return false;
	}
}
