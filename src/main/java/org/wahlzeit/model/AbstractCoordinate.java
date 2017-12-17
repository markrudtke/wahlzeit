package org.wahlzeit.model;

public abstract class AbstractCoordinate implements Coordinate {

	protected static final double DELTA = 0.0001;
	
	/**
	 * @post !Double.isInfinite(x) && !Double.isNaN(x)
	 * 		&& !Double.isInfinite(y) && !Double.isNaN(y) 
	 * 		&& !Double.isInfinite(z) && !Double.isNaN(z)
	 * @methodtype conversion
	 */
	public CartesianCoordinate asCartesianCoordinate() {
		assertClassInvariants();
		
		SphericCoordinate sc = this.asSphericCoordinate();
		CartesianCoordinate result = doAsCartesianCoordinate(sc);
		
		AssertionUtil.assertIsValidDouble(result.getX());
		AssertionUtil.assertIsValidDouble(result.getY());
		AssertionUtil.assertIsValidDouble(result.getZ());
		
		assertClassInvariants();
		return result;
	}
	
	/**
	 * @methodtype conversion
	 * @methodproperty primitive
	 */
	protected CartesianCoordinate doAsCartesianCoordinate (SphericCoordinate sc) {
		double x = sc.getRadius() * Math.sin(Math.toRadians(sc.getLatitude())) * Math.cos(Math.toRadians(sc.getLongitude()));
		double y = sc.getRadius() * Math.sin(Math.toRadians(sc.getLatitude())) * Math.sin(Math.toRadians(sc.getLongitude()));
		double z = sc.getRadius() * Math.cos(Math.toRadians(sc.getLatitude()));
		CartesianCoordinate result = CartesianCoordinate.getCoordinate(x, y, z);
		return result;
	}
	
	/**
	 * Computes the euclidean distance d(p,q) between this coordinate and q.
	 * 
	 * @pre q != null
	 * @post !Double.isInfinite(return) && !Double.isNaN(return) && return >= 0
	 * @methodtype get
	 */
	public double getCartesianDistance(Coordinate q) {
		assertClassInvariants();
		
		assertIsNonNullArgument(q);
		
		CartesianCoordinate p = this.asCartesianCoordinate();
		CartesianCoordinate cc = q.asCartesianCoordinate();
		double result = doGetCartesianDistance(p, cc);
		
		AssertionUtil.assertIsValidDouble(result);
		AssertionUtil.assertIsValidDistance(result);
		
		assertClassInvariants();
		return result;
	}
	
	/**
	 * @methodtype get
	 * @methodproperty primitive
	 */
	private double doGetCartesianDistance(CartesianCoordinate p, CartesianCoordinate cc) {
		double px = p.getX();
		double py = p.getY();
		double pz = p.getZ();
		double qx = cc.getX();
		double qy = cc.getY();
		double qz = cc.getZ();
		double sum = Math.pow(qx - px, 2) +Math.pow(qy - py, 2) + Math.pow(qz - pz, 2);
		return Math.sqrt(sum);
	}
	
	/**
	 * @methodtype conversion
	 * @post !Double.isInfinite(latitude) && !Double.isNaN(latitude)
	 * 		&& !Double.isInfinite(longitude) && !Double.isNaN(longitude) 
	 * 		&& !Double.isInfinite(radius) && !Double.isNaN(radius)
	 */
	public SphericCoordinate asSphericCoordinate() {
		assertClassInvariants();
		
		CartesianCoordinate cc = this.asCartesianCoordinate();
		SphericCoordinate result = doAsSphericCoordinate(cc);
		
		AssertionUtil.assertIsValidDouble(result.getLatitude());
		AssertionUtil.assertIsValidDouble(result.getLongitude());
		AssertionUtil.assertIsValidDouble(result.getRadius());
		
		assertClassInvariants();
		return result;
	}
	
	/**
	 * @methodtype conversion
	 * @methodproperty primitive
	 */
	protected SphericCoordinate doAsSphericCoordinate (CartesianCoordinate cc) {
		double radius = Math.sqrt(Math.pow(cc.getX(), 2) + Math.pow(cc.getY(), 2) + Math.pow(cc.getZ(), 2));
		double latitude = Math.toDegrees(Math.acos(cc.getZ() / radius));
		double longitude = Math.toDegrees(Math.atan2(cc.getY() , cc.getX()));
		SphericCoordinate result = SphericCoordinate.getCoordinate(latitude, longitude, radius);
		return result;
	}
	
	/**
	 * Computes the spherical distance d(p,q) between this coordinate and q.
	 * 
	 * @pre q != null
	 * @post !Double.isInfinite(return) && !Double.isNaN(return) && return >= 0
	 * @methodtype get
	 */
	public double getSphericDistance(Coordinate q) {
		assertClassInvariants();
		
		assertIsNonNullArgument(q);
		
		SphericCoordinate p = this.asSphericCoordinate();
		SphericCoordinate sc = q.asSphericCoordinate();
		double result = doGetSphericDistance(p, sc);
		
		AssertionUtil.assertIsValidDouble(result);
		AssertionUtil.assertIsValidDistance(result);
		
		assertClassInvariants();
		return result;
	}
	
	/**
	 * @methodtype get
	 * @methodproperty primitive
	 */
	private double doGetSphericDistance(SphericCoordinate p, SphericCoordinate sc) {
		double pPhi = Math.toRadians(p.getLatitude());
 		double qPhi = Math.toRadians(sc.getLatitude());
 		double phi = Math.abs(pPhi - qPhi);
 		double pTheta = Math.toRadians(p.getLongitude());
 		double qTheta = Math.toRadians(sc.getLongitude());
 		double theta = Math.abs(pTheta - qTheta);
 		double sigma = 2 * Math.asin(Math.sqrt(
 				Math.pow(Math.sin(phi / 2), 2) +
 				Math.cos(pPhi) * Math.cos(qPhi) * Math.pow(Math.sin(theta / 2), 2)
 				));
 		return p.getRadius() * sigma;
	}
	
	/**
	 *
	 */
	public abstract double getDistance(Coordinate q);
	
	/**
	 *
	 */
	public abstract boolean isEqual(Coordinate q);
	
	/**
	 * Forwards equals() to isEqual().
	 * 
	 * @methodtype boolean query
	 */
	@Override
	public boolean equals(Object o) {
		assertClassInvariants();
		
		boolean result = false;
		if(o == null) {
			result = false;
		}
		if(o == this) {
			result = true;
		}
		if (o instanceof Coordinate) {
			result = this.isEqual((Coordinate) o);
		}
		
		assertClassInvariants();
		return result;
	}
	
	/**
	 *
	 */
	protected abstract void assertClassInvariants();
	
	/**
	 * @methodtype assertion
	 */
	protected void assertIsNonNullArgument(Coordinate coord) {
		if(coord == null) {
			throw new IllegalArgumentException("A Coordinate must not be null!");
		}
	}
}
