package org.wahlzeit.model;

import java.util.HashMap;

import org.wahlzeit.utils.PatternInstance;

/**
 * @inv !Double.isInfinite(latitude) && !Double.isNaN(latitude)
 * 		&& !Double.isInfinite(longitude) && !Double.isNaN(longitude)
 * 		&& !Double.isInfinite(radius) && !Double.isNaN(radius)
 * 		&& latitude >= 0 && latitude <= 180
 * 		&& longitude >= -180 && longitude <= 180
 * 		&& radius >= 0
 */
@PatternInstance(
		patternName = "Template Method",
		participants = {
				"ConcreteClass B"
		}
)
/*@PatternInstance(
		patternName = "Value Object",
		participants = {
				"ValueObject"
		}
)*/
public class SphericCoordinate extends AbstractCoordinate {
	
	private final double latitude;
	private final double longitude;
	private final double radius;
	
	private static final HashMap<Integer, SphericCoordinate> coordinates = new HashMap<>();

	/**
	 * Latitude, longitude and radius must be measured in degrees.
	 * 
	 * @pre !Double.isInfinite(latitude) && !Double.isNaN(latitude)
	 * 		&& !Double.isInfinite(longitude) && !Double.isNaN(longitude)
	 * 		&& !Double.isInfinite(radius) && !Double.isNaN(radius)
	 * 		&& latitude >= 0 && latitude <= 180
	 * 		&& longitude >= -180 && longitude <= 180
	 * 		&& radius >= 0
	 * @methodtype constructor
	 */
	private SphericCoordinate(double latitude, double longitude, double radius) {
		assertClassInvariants();
		
		AssertionUtil.assertIsValidDouble(latitude);
		AssertionUtil.assertIsValidDouble(longitude);
		AssertionUtil.assertIsValidDouble(radius);
		assertIsValidLatitude(latitude);
		assertIsValidLongitude(longitude);
		assertIsValidRadius(radius);
		
		this.latitude = latitude;
		this.longitude = longitude;
		this.radius = radius;
		
		assertClassInvariants();
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
	 * Returns a spheric coordinate with the given parameters.
	 */
	public static SphericCoordinate getCoordinate(double latitude, double longitude, double radius) {
		int key = (new SphericCoordinate(latitude, longitude, radius).hashCode());
		SphericCoordinate result = coordinates.get(key);
		if(result == null) {
			synchronized (coordinates) {
				result = coordinates.get(key);
				if(result == null) {
					result = new SphericCoordinate(latitude, longitude, radius);
					coordinates.put(key, result);
				}
			}
		}
		return result;
	}

	/**
	 * Latitude must be measured in degrees.
	 * 
	 * @pre !Double.isInfinite(latitude) && !Double.isNaN(latitude)
	 * 		&& latitude >= 0 && latitude <= 180
	 * @post return != null
	 */
	public SphericCoordinate setLatitude(double latitude) {
		assertClassInvariants();
		
		AssertionUtil.assertIsValidDouble(latitude);
		assertIsValidLatitude(latitude);
		
		SphericCoordinate result = doSetLatitude(latitude);
		
		assertIsNonNullArgument(result);
		
		assertClassInvariants();
		return result;
	}
	
	/**
	 * @methodproperty primitive
	 */
	private SphericCoordinate doSetLatitude(double latitude) {
		return getCoordinate(latitude, longitude, radius);
	}

	/**
	 * Longitude must be measured in degrees.
	 * 
	 * @pre !Double.isInfinite(longitude) && !Double.isNaN(longitude)
	 * 		&& longitude >= -180 && longitude <= 180
	 * @post return != null
	 */
	public SphericCoordinate setLongitude(double longitude) {
		assertClassInvariants();
		
		AssertionUtil.assertIsValidDouble(longitude);
		assertIsValidLongitude(longitude);
		
		SphericCoordinate result = doSetLongitude(longitude);
		
		assertIsNonNullArgument(result);
		
		assertClassInvariants();
		return result;
	}
	
	/**
	 * @methodproperty primitive
	 */
	private SphericCoordinate doSetLongitude(double longitude) {
		return getCoordinate(latitude, longitude, radius);
	}

	/**
	 * Radius must be measured in degrees.
	 * 
	 * @pre !Double.isInfinite(radius) && !Double.isNaN(radius)
	 * 		&& radius >= 0
	 * @post return != null
	 */
	public SphericCoordinate setRadius(double radius) {
		assertClassInvariants();
		
		AssertionUtil.assertIsValidDouble(radius);
		assertIsValidRadius(radius);
		
		SphericCoordinate result = doSetRadius(radius);
		
		assertIsNonNullArgument(result);
		
		assertClassInvariants();
		return result;
	}
	
	/**
	 * @methodproperty primitive
	 */
	private SphericCoordinate doSetRadius(double radius) {
		return getCoordinate(latitude, longitude, radius);
	}
	
	/**
	 * Returns a new spheric coordinate with the given parameters.
	 * 
	 * @pre !Double.isInfinite(latitude) && !Double.isNaN(latitude)
	 * 		&& !Double.isInfinite(longitude) && !Double.isNaN(longitude)
	 * 		&& !Double.isInfinite(radius) && !Double.isNaN(radius)
	 * 		&& latitude >= 0 && latitude <= 180
	 * 		&& longitude >= -180 && longitude <= 180
	 * 		&& radius >= 0
	 * @post return != null
	 */
	public SphericCoordinate setCoordinate(double latitude, double longitude, double radius) {
		assertClassInvariants();
		
		AssertionUtil.assertIsValidDouble(latitude);
		AssertionUtil.assertIsValidDouble(longitude);
		AssertionUtil.assertIsValidDouble(radius);
		assertIsValidLatitude(latitude);
		assertIsValidLongitude(longitude);
		assertIsValidRadius(radius);
		
		SphericCoordinate result = getCoordinate(latitude, longitude, radius);
		
		assertIsNonNullArgument(result);
		
		assertClassInvariants();
		return result;
	}

	/**
	 * @post return != null && this.isEqual(return.asSphericCoordinate())
	 * @methodtype conversion
	 */
	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		assertClassInvariants();
		
		CartesianCoordinate result = super.asCartesianCoordinate();
		
		assertIsNonNullArgument(result);
		assertIsCorrectConversion(result);
		
		assertClassInvariants();
		return result;
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
		
		double result = this.asCartesianCoordinate().getDistance(q);
		
		AssertionUtil.assertIsValidDouble(result);
		AssertionUtil.assertIsValidDistance(result);
		
		assertClassInvariants();
		return result;
	}
	
	/**
	 * @methodtype conversion
	 */
	@Override
	public SphericCoordinate asSphericCoordinate() {
		return this;
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
		
		double result = super.getSphericDistance(q);
		
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
		
		double result = this.getSphericDistance(q);
		
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
		SphericCoordinate sc = q.asSphericCoordinate();
		boolean result = (Math.abs(this.latitude - sc.getLatitude()) < DELTA
				&& Math.abs(this.longitude - sc.getLongitude()) < DELTA
				&& Math.abs(this.radius - sc.getRadius()) < DELTA);
		
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
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(radius);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		
		assertClassInvariants();
		return result;
	}
	
	/**
	 * @methodtype assertion
	 */
	@Override
	protected void assertClassInvariants() {
		AssertionUtil.assertIsValidDouble(latitude);
		AssertionUtil.assertIsValidDouble(longitude);
		AssertionUtil.assertIsValidDouble(radius);
		assertIsValidLatitude(latitude);
		assertIsValidLongitude(longitude);
		assertIsValidRadius(radius);
	}
	
	/**
	 * @methodtype assertion
	 */
	private void assertIsCorrectConversion(CartesianCoordinate cc) {
		if(!this.isEqual(doAsSphericCoordinate(cc))) {
			throw new IllegalArgumentException("A coordinate must be converted correctly!");
		}
	}
	
	/**
	 * @methodtype assertion
	 */
	private void assertIsValidLatitude(double latitude) {
		if(latitude < 0 || latitude > 180) {
			throw new IllegalArgumentException("A Latitude value (degrees) has to be: 0 <= latitude <= 180");
		}
	}
	
	/**
	 * @methodtype assertion
	 */
	private void assertIsValidLongitude(double longitude) {
		if(longitude < -180 || longitude > 180) {
			throw new IllegalArgumentException("A Longitude value (degrees) has to be: -180 <= longitude <= 180");
		}
	}
	
	/**
	 * @methodtype assertion
	 */
	private void assertIsValidRadius(double radius) {
		if(radius < 0) {
			throw new IllegalArgumentException("A Radius value has to be: 0 <= radius");
		}
	}
}
