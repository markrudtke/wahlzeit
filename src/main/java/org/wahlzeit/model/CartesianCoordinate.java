package org.wahlzeit.model;

/**
 * @inv !Double.isInfinite(x) && !Double.isNaN(x)
 * 		&& !Double.isInfinite(y) && !Double.isNaN(y)
 * 		&& !Double.isInfinite(z) && !Double.isNaN(z)
 */
public class CartesianCoordinate extends AbstractCoordinate{
	
	private double x;
	private double y;
	private double z;
	
	/**
	 * @methodtype constructor
	 */
	public CartesianCoordinate() throws IllegalArgumentException {
		assertClassInvariants();
	}

	/**
	 * @pre !Double.isInfinite(x) && !Double.isNaN(x)
	 * 		&& !Double.isInfinite(y) && !Double.isNaN(y) 
	 * 		&& !Double.isInfinite(z) && !Double.isNaN(z) 
	 * @methodtype constructor
	 */
	public CartesianCoordinate(double x, double y, double z) throws IllegalArgumentException {
		assertClassInvariants();
		
		assertIsValidDouble(x);
		assertIsValidDouble(y);
		assertIsValidDouble(z);
		
		setCoordinate(x, y, z);		
		
		assertClassInvariants();
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
	 * @pre !Double.isInfinite(x) && !Double.isNaN(x)
	 * @methodtype set
	 */
	public void setX(double x) throws IllegalArgumentException {
		assertClassInvariants();
		
		assertIsValidDouble(x);
		
		doSetX(x);
		
		assertClassInvariants();
	}
	
	/**
	 * @methodtype set
	 * @methodproperty primitive
	 */
	private void doSetX(double x) {
		this.x = x;
	}

	/**
	 * @pre !Double.isInfinite(y) && !Double.isNaN(y)
	 * @methodtype set
	 */
	public void setY(double y) throws IllegalArgumentException {
		assertClassInvariants();
		
		assertIsValidDouble(y);
		
		doSetY(y);
		
		assertClassInvariants();
	}
	
	/**
	 * @methodtype set
	 * @methodproperty primitive
	 */
	private void doSetY(double y) {
		this.y = y;
	}

	/**
	 * @pre !Double.isInfinite(z) && !Double.isNaN(z)
	 * @methodtype set
	 */
	public void setZ(double z) throws IllegalArgumentException {
		assertClassInvariants();
		
		assertIsValidDouble(z);
		
		doSetZ(z);
		
		assertClassInvariants();
	}
	
	/**
	 * @methodtype set
	 * @methodproperty primitive
	 */
	private void doSetZ(double z) {
		this.z = z;
	}
	
	/**
	 * Sets all cartesian coordinates of this coordinate.
	 * 
	 * @pre !Double.isInfinite(x) && !Double.isNaN(x)
	 * 		&& !Double.isInfinite(y) && !Double.isNaN(y) 
	 * 		&& !Double.isInfinite(z) && !Double.isNaN(z) 
	 * @methodtype set
	 */
	public void setCoordinate(double x, double y, double z) throws IllegalArgumentException {
		assertClassInvariants();
		
		assertIsValidDouble(x);
		assertIsValidDouble(y);
		assertIsValidDouble(z);
		
		setX(x);
		setY(y);
		setZ(z);
		
		assertClassInvariants();
	}
	
	/**
	 * @methodtype conversion
	 */
	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		return this;
	}

	/**
	 * Computes the euclidean distance d(p,q) between this coordinate and q.
	 *
	 * @pre q != null
	 * @post !Double.isInfinite(return) && !Double.isNaN(return) && return >= 0
	 * @methodtype get
	 */
	@Override
	public double getCartesianDistance(Coordinate q) throws IllegalArgumentException {
		assertClassInvariants();
		
		assertIsNonNullArgument(q);
		
		double result = super.getCartesianDistance(q);
		
		assertIsValidDouble(result);
		assertIsValidDistance(result);
		
		assertClassInvariants();
		return result;
	}

	/**
	 * @post return != null && this.isEqual(return.asCartesianCoordinate())
	 * @methodtype conversion
	 */
	@Override
	public SphericCoordinate asSphericCoordinate() throws IllegalArgumentException {
		assertClassInvariants();
		
		SphericCoordinate result = super.asSphericCoordinate();
		
		assertIsNonNullArgument(result);
		assertIsCorrectConversion(result);
		
		assertClassInvariants();
		return result;
	}
	
	/**
	 * Computes the spherical distance d(p,q) between this coordinate and q.
	 * 
	 * @pre q != null
	 * @post !Double.isInfinite(return) && !Double.isNaN(return) && return >= 0
	 * @methodtype get
	 */
	@Override
	public double getSphericDistance(Coordinate q) throws IllegalArgumentException {
		assertClassInvariants();
		
		assertIsNonNullArgument(q);
		
		double result = this.asSphericCoordinate().getDistance(q);
		
		assertIsValidDouble(result);
		assertIsValidDistance(result);
		
		assertClassInvariants();
		return result;
	}
	
	/**
	 * Computes the distance d(p,q) between this coordinate and q.
	 * 
	 * @pre q != null
	 * @post !Double.isInfinite(return) && !Double.isNaN(return) && return >= 0
	 * @methodtype get
	 */
	@Override
	public double getDistance(Coordinate q) throws IllegalArgumentException {
		assertClassInvariants();
		
		assertIsNonNullArgument(q);
		
		double result = this.getCartesianDistance(q);
		
		assertIsValidDouble(result);
		assertIsValidDistance(result);
		
		assertClassInvariants();
		return result;
	}
	
	/**
	 * Compares two coordinates and returns true if this coordinate equals q.
	 * 
	 * @methodtype boolean query
	 */
	@Override
	public boolean isEqual(Coordinate q) throws IllegalArgumentException {
		assertClassInvariants();
		
		if(q == null) {
			return false;
		}
		CartesianCoordinate cc = q.asCartesianCoordinate();
		boolean result = (Math.abs(this.x - cc.getX()) < DELTA
				&& Math.abs(this.y - cc.getY()) < DELTA
				&& Math.abs(this.z - cc.getZ()) < DELTA);
		
		assertClassInvariants();
		return result;
	}

	/**
	 * Generated hashCode() override.
	 */
	@Override
	public int hashCode() throws IllegalArgumentException {
		assertClassInvariants();
		
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(z);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		
		assertClassInvariants();
		return result;
	}
	
	/**
	 * @methodtype assertion
	 */
	@Override
	protected void assertClassInvariants() throws IllegalArgumentException {
		assertIsValidDouble(x);
		assertIsValidDouble(y);
		assertIsValidDouble(z);
	}
	
	/**
	 * @methodtype assertion
	 */
	private void assertIsCorrectConversion(SphericCoordinate sc) throws IllegalArgumentException {
		if(!this.isEqual(doAsCartesianCoordinate(sc))) {
			throw new IllegalArgumentException("A coordinate must be converted correctly!");
		}
	}
}
