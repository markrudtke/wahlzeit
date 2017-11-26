package org.wahlzeit.model;

public class CartesianCoordinate extends AbstractCoordinate{
	
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
		setCoordinate(x, y, z);
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
		setX(x);
		setY(y);
		setZ(z);
	}
	
	/**
	 * @methodtype conversion
	 */
	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		return this;
	}

	/**
	 * Computes the spherical distance d(p,q) between this coordinate and q.
	 * 
	 * @methodtype get
	 */
	@Override
	public double getSphericDistance(Coordinate q) {
		return this.asSphericCoordinate().getDistance(q);
	}

	/**
	 * Computes the distance d(p,q) between this coordinate and q.
	 * 
	 * @methodtype get
	 */
	@Override
	public double getDistance(Coordinate q) {
			return this.getCartesianDistance(q);		
	}
	
	/**
	 * Compares two coordinates and returns true if this coordinate equals q.
	 * 
	 * @methodtype boolean query
	 */
	@Override
	public boolean isEqual(Coordinate q) {
		if(q == null) {
			return false;
		}
		CartesianCoordinate cc = q.asCartesianCoordinate();
		if (Math.abs(this.x - cc.getX()) < DELTA
				&& Math.abs(this.y - cc.getY()) < DELTA
				&& Math.abs(this.z - cc.getZ()) < DELTA) {
			return true;
		}
		return false;
	}

	/**
	 * Generated hashCode() override.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(z);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
}
