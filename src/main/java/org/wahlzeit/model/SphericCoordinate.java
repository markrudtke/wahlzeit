package org.wahlzeit.model;

public class SphericCoordinate extends AbstractCoordinate {
	
	private double latitude;
	private double longitude;
	private double radius;
	
	/**
	 * @methodtype constructor
	 */
	public SphericCoordinate() {
		
	}

	/**
	 * Latitude, longitude and radius must be measured in degrees.
	 * 
	 * @methodtype constructor
	 */
	public SphericCoordinate(double latitude, double longitude, double radius) {
		setCoordinate(latitude, longitude, radius);
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
	 * @methodtype set
	 */
	public void setLatitude(double latitude) {
		assertIsValidLatitude(latitude);
		doSetLatitude(latitude);
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
	 * @methodtype set
	 */
	public void setLongitude(double longitude) {
		assertIsValidLongitude(longitude);
		doSetLongitude(longitude);
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
	 * @methodtype set
	 */
	public void setRadius(double radius) {
		assertIsValidRadius(radius);
		doSetRadius(radius);
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
	 * @methodtype set
	 */
	public void setCoordinate(double latitude, double longitude, double radius) {
		setLatitude(latitude);
		setLongitude(longitude);
		setRadius(radius);
	}
	
	/**
	 * @methodtype assertion
	 */
	private void assertIsValidLatitude(double latitude) {
		if(latitude < 0 || latitude > 180) {
			throw new IllegalArgumentException("Latitude value (degrees) has to be: 0 <= latitude <= 180");
		}
	}
	
	/**
	 * @methodtype assertion
	 */
	private void assertIsValidLongitude(double longitude) {
		if(longitude < -180 || longitude > 180) {
			throw new IllegalArgumentException("Longitude value (degrees) has to be: -180 <= longitude <= 180");
		}
	}
	
	/**
	 * @methodtype assertion
	 */
	private void assertIsValidRadius(double radius) {
		if(radius < 0) {
			throw new IllegalArgumentException("Radius value has to be: 0 <= radius");
		}
	}

	/**
	 * Computes the euclidean distance d(p,q) between this coordinate and q.
	 * 
	 * @methodtype get
	 */
	@Override
	public double getCartesianDistance(Coordinate q) {
		return this.asCartesianCoordinate().getDistance(q);
	}
	
	/**
	 * @methodtype conversion
	 */
	@Override
	public SphericCoordinate asSphericCoordinate() {
		return this;
	}

	/**
	 * Computes the distance d(p,q) between this coordinate and q.
	 * 
	 * @methodtype get
	 */
	@Override
	public double getDistance(Coordinate q) {
		return this.getSphericDistance(q);
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
		SphericCoordinate sc = q.asSphericCoordinate();
		if (Math.abs(this.latitude - sc.getLatitude()) < DELTA
				&& Math.abs(this.longitude - sc.getLongitude()) < DELTA
				&& Math.abs(this.radius - sc.getRadius()) < DELTA) {
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
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(radius);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}	
}
