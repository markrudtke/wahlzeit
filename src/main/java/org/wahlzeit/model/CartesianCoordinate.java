package org.wahlzeit.model;

import java.util.HashMap;

/**
 * @inv !Double.isInfinite(x) && !Double.isNaN(x)
 * 		&& !Double.isInfinite(y) && !Double.isNaN(y)
 * 		&& !Double.isInfinite(z) && !Double.isNaN(z)
 */
public class CartesianCoordinate extends AbstractCoordinate{
	
	private final double x;
	private final double y;
	private final double z;
	
	private static final HashMap<Integer, CartesianCoordinate> coordinates = new HashMap<>();

	/**
	 * @pre !Double.isInfinite(x) && !Double.isNaN(x)
	 * 		&& !Double.isInfinite(y) && !Double.isNaN(y) 
	 * 		&& !Double.isInfinite(z) && !Double.isNaN(z) 
	 * @methodtype constructor
	 */
	private CartesianCoordinate(double x, double y, double z) {
		assertClassInvariants();
		
		AssertionUtil.assertIsValidDouble(x);
		AssertionUtil.assertIsValidDouble(y);
		AssertionUtil.assertIsValidDouble(z);
		
		this.x = x;
		this.y = y;
		this.z = z;		
		
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
	 * Returns a cartesian coordinate with the given parameters.
	 */
	public static CartesianCoordinate getCoordinate(double x, double y, double z) {
		int key = (new CartesianCoordinate(x, y, z)).hashCode();
		CartesianCoordinate result = coordinates.get(key);
		if(result == null) {
			synchronized (coordinates) {
				result = coordinates.get(key);
				if(result == null) {
					result = new CartesianCoordinate(x, y, z);
					coordinates.put(key, result);
				}
			}
		}
		return result;
	}

	/**
	 * @pre !Double.isInfinite(x) && !Double.isNaN(x)
	 * @post return != null
	 */
	public CartesianCoordinate setX(double x) {
		assertClassInvariants();
		
		AssertionUtil.assertIsValidDouble(x);
		
		CartesianCoordinate result = doSetX(x);
		
		assertIsNonNullArgument(result);
		
		assertClassInvariants();
		return result;
	}
	
	/**
	 * @methodproperty primitive
	 */
	private CartesianCoordinate doSetX(double x) {
		return getCoordinate(x, y, z);
	}

	/**
	 * @pre !Double.isInfinite(y) && !Double.isNaN(y)
	 * @post return != null
	 */
	public CartesianCoordinate setY(double y) {
		assertClassInvariants();
		
		AssertionUtil.assertIsValidDouble(y);
		
		CartesianCoordinate result = doSetY(y);
		
		assertIsNonNullArgument(result);
		
		assertClassInvariants();
		return result;
	}
	
	/**
	 * @methodproperty primitive
	 */
	private CartesianCoordinate doSetY(double y) {
		return getCoordinate(x, y, z);
	}

	/**
	 * @pre !Double.isInfinite(z) && !Double.isNaN(z)
	 * @post return != null
	 */
	public CartesianCoordinate setZ(double z) {
		assertClassInvariants();
		
		AssertionUtil.assertIsValidDouble(z);
		
		CartesianCoordinate result = doSetZ(z);
		
		assertIsNonNullArgument(result);
		
		assertClassInvariants();
		return result;
	}
	
	/**
	 * @methodproperty primitive
	 */
	private CartesianCoordinate doSetZ(double z) {
		return getCoordinate(x, y, z);
	}
	
	/**
	 * Returns a new cartesian coordinate with the given parameters.
	 * 
	 * @pre !Double.isInfinite(x) && !Double.isNaN(x)
	 * 		&& !Double.isInfinite(y) && !Double.isNaN(y) 
	 * 		&& !Double.isInfinite(z) && !Double.isNaN(z) 
	 * @post return != null
	 */
	public CartesianCoordinate setCoordinate(double x, double y, double z) {
		assertClassInvariants();
		
		AssertionUtil.assertIsValidDouble(x);
		AssertionUtil.assertIsValidDouble(y);
		AssertionUtil.assertIsValidDouble(z);
		
		CartesianCoordinate result = getCoordinate(x, y, z);
		
		assertIsNonNullArgument(result);
		
		assertClassInvariants();
		return result;
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
	public double getCartesianDistance(Coordinate q) {
		assertClassInvariants();
		
		assertIsNonNullArgument(q);
		
		double result = super.getCartesianDistance(q);
		
		AssertionUtil.assertIsValidDouble(result);
		AssertionUtil.assertIsValidDistance(result);
		
		assertClassInvariants();
		return result;
	}

	/**
	 * @post return != null && this.isEqual(return.asCartesianCoordinate())
	 * @methodtype conversion
	 */
	@Override
	public SphericCoordinate asSphericCoordinate() {
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
	public double getSphericDistance(Coordinate q) {
		assertClassInvariants();
		
		assertIsNonNullArgument(q);
		
		double result = this.asSphericCoordinate().getDistance(q);
		
		AssertionUtil.assertIsValidDouble(result);
		AssertionUtil.assertIsValidDistance(result);
		
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
	public double getDistance(Coordinate q) {
		assertClassInvariants();
		
		assertIsNonNullArgument(q);
		
		double result = this.getCartesianDistance(q);
		
		AssertionUtil.assertIsValidDouble(result);
		AssertionUtil.assertIsValidDistance(result);
		
		assertClassInvariants();
		return result;
	}
	
	/**
	 * Compares two coordinates and returns true if this coordinate equals q.
	 * 
	 * @methodtype boolean query
	 */
	@Override
	public boolean isEqual(Coordinate q) {
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
	public int hashCode() {
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
	protected void assertClassInvariants() {
		AssertionUtil.assertIsValidDouble(x);
		AssertionUtil.assertIsValidDouble(y);
		AssertionUtil.assertIsValidDouble(z);
	}
	
	/**
	 * @methodtype assertion
	 */
	private void assertIsCorrectConversion(SphericCoordinate sc) {
		if(!this.isEqual(doAsCartesianCoordinate(sc))) {
			throw new IllegalArgumentException("A coordinate must be converted correctly!");
		}
	}
}
