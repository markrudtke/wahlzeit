package org.wahlzeit.model;

/**
 * @inv !Double.isInfinite(latitude) && !Double.isNaN(latitude)
 * 		&& !Double.isInfinite(longitude) && !Double.isNaN(longitude)
 * 		&& !Double.isInfinite(radius) && !Double.isNaN(radius)
 * 		&& latitude >= 0 && latitude <= 180
 * 		&& longitude >= -180 && longitude <= 180
 * 		&& radius >= 0
 */
public class SphericCoordinate extends AbstractCoordinate {
	
	private double latitude;
	private double longitude;
	private double radius;
	
	/**
	 * @methodtype constructor
	 */
	public SphericCoordinate() {
		assertClassInvariants();
	}

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
	public SphericCoordinate(double latitude, double longitude, double radius) {
		assertClassInvariants();
		
		assertIsValidDouble(latitude);
		assertIsValidDouble(longitude);
		assertIsValidDouble(radius);
		assertIsValidLatitude(latitude);
		assertIsValidLongitude(longitude);
		assertIsValidRadius(radius);
		
		setCoordinate(latitude, longitude, radius);
		
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
	 * Returns all spheric coordinates of this coordinate.
	 * 
	 * @methodtype get
	 */
	public double[] getCoordinate() {
		return new double[] {latitude, longitude, radius};
	}

	/**
	 * Latitude must be measured in degrees.
	 * 
	 * @pre !Double.isInfinite(latitude) && !Double.isNaN(latitude)
	 * 		&& latitude >= 0 && latitude <= 180
	 * @methodtype set
	 */
	public void setLatitude(double latitude) {
		assertClassInvariants();
		
		assertIsValidDouble(latitude);
		assertIsValidLatitude(latitude);
		
		doSetLatitude(latitude);
		
		assertClassInvariants();
	}
	
	/**
	 * @methodtype set
	 * @methodproperty primitive
	 */
	private void doSetLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * Longitude must be measured in degrees.
	 * 
	 * @pre !Double.isInfinite(longitude) && !Double.isNaN(longitude)
	 * 		&& longitude >= -180 && longitude <= 180
	 * @methodtype set
	 */
	public void setLongitude(double longitude) {
		assertClassInvariants();
		
		assertIsValidDouble(longitude);
		assertIsValidLongitude(longitude);
		
		doSetLongitude(longitude);
		
		assertClassInvariants();
	}
	
	/**
	 * @methodtype set
	 * @methodproperty primitive
	 */
	private void doSetLongitude(double longitude) {
		this.longitude = longitude;
	}

	/**
	 * Radius must be measured in degrees.
	 * 
	 * @pre !Double.isInfinite(radius) && !Double.isNaN(radius)
	 * 		&& radius >= 0
	 * @methodtype set
	 */
	public void setRadius(double radius) {
		assertClassInvariants();
		
		assertIsValidDouble(radius);
		assertIsValidRadius(radius);
		
		doSetRadius(radius);
		
		assertClassInvariants();
	}
	
	/**
	 * @methodtype set
	 * @methodproperty primitive
	 */
	private void doSetRadius(double radius) {
		this.radius = radius;
	}
	
	/**
	 * Sets all spheric coordinates of this coordinate.
	 * 
	 * @pre !Double.isInfinite(latitude) && !Double.isNaN(latitude)
	 * 		&& !Double.isInfinite(longitude) && !Double.isNaN(longitude)
	 * 		&& !Double.isInfinite(radius) && !Double.isNaN(radius)
	 * 		&& latitude >= 0 && latitude <= 180
	 * 		&& longitude >= -180 && longitude <= 180
	 * 		&& radius >= 0
	 * @methodtype set
	 */
	public void setCoordinate(double latitude, double longitude, double radius) {
		assertClassInvariants();
		
		assertIsValidDouble(latitude);
		assertIsValidDouble(longitude);
		assertIsValidDouble(radius);
		assertIsValidLatitude(latitude);
		assertIsValidLongitude(longitude);
		assertIsValidRadius(radius);
		
		setLatitude(latitude);
		setLongitude(longitude);
		setRadius(radius);
		
		assertClassInvariants();
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
	 * @post !Double.isInfinite(return) && !Double.isNaN(return)
	 * @methodtype get
	 */
	@Override
	public double getCartesianDistance(Coordinate q) {
		assertClassInvariants();
		
		assertIsNonNullArgument(q);
		
		double result = this.asCartesianCoordinate().getDistance(q);
		
		assertIsValidDouble(result);
		
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
	 * @post !Double.isInfinite(return) && !Double.isNaN(return)
	 * @methodtype get
	 */
	@Override
	public double getSphericDistance(Coordinate q) {
		assertClassInvariants();
		
		assertIsNonNullArgument(q);
		
		double result = super.getSphericDistance(q);
		
		assertIsValidDouble(result);
		
		assertClassInvariants();
		return result;
	}

	/**
	 * Computes the distance d(p,q) between this coordinate and q.
	 * 
	 * @pre q != null
	 * @post !Double.isInfinite(return) && !Double.isNaN(return)
	 * @methodtype get
	 */
	@Override
	public double getDistance(Coordinate q) {
		assertClassInvariants();
		
		assertIsNonNullArgument(q);
		
		double result = this.getSphericDistance(q);
		
		assertIsValidDouble(result);
		
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
	private void assertClassInvariants() {
		assertIsValidDouble(latitude);
		assertIsValidDouble(longitude);
		assertIsValidDouble(radius);
		assertIsValidLatitude(latitude);
		assertIsValidLongitude(longitude);
		assertIsValidRadius(radius);
	}
	
	/**
	 * @methodtype assertion
	 */
	private void assertIsCorrectConversion(CartesianCoordinate cc) {
		assert this.isEqual(doAsSphericCoordinate(cc));
	}
	
	/**
	 * @methodtype assertion
	 */
	private void assertIsValidLatitude(double latitude) throws IllegalArgumentException {
		if(latitude < 0 || latitude > 180) {
			throw new IllegalArgumentException("Latitude value (degrees) has to be: 0 <= latitude <= 180");
		}
	}
	
	/**
	 * @methodtype assertion
	 */
	private void assertIsValidLongitude(double longitude) throws IllegalArgumentException{
		if(longitude < -180 || longitude > 180) {
			throw new IllegalArgumentException("Longitude value (degrees) has to be: -180 <= longitude <= 180");
		}
	}
	
	/**
	 * @methodtype assertion
	 */
	private void assertIsValidRadius(double radius) throws IllegalArgumentException{
		if(radius < 0) {
			throw new IllegalArgumentException("Radius value has to be: 0 <= radius");
		}
	}
}
