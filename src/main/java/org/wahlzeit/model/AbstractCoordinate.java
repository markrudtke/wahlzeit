package org.wahlzeit.model;

public abstract class AbstractCoordinate implements Coordinate {

	protected static final double DELTA = 0.0001;
	
	/**
	 * @methodtype conversion
	 */
	public CartesianCoordinate asCartesianCoordinate() {
		SphericCoordinate sc = this.asSphericCoordinate();
		double x = sc.getRadius() * Math.sin(sc.getLatitude()) * Math.cos(sc.getLongitude());
		double y = sc.getRadius() * Math.sin(sc.getLatitude()) * Math.sin(sc.getLongitude());
		double z = sc.getRadius() * Math.cos(sc.getLatitude());
		return new CartesianCoordinate(x, y, z);
	}
	
	/**
	 * Computes the euclidean distance d(p,q) between this coordinate and q.
	 * 
	 * @methodtype get
	 */
	public double getCartesianDistance(Coordinate q) {
		assertIsNotNull(q);
		CartesianCoordinate p = this.asCartesianCoordinate();
		CartesianCoordinate cc = q.asCartesianCoordinate();
		return doGetCartesianDistance(p, cc);
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
	 */
	public SphericCoordinate asSphericCoordinate() {
		CartesianCoordinate cc = this.asCartesianCoordinate();
		double radius = Math.sqrt(Math.pow(cc.getX(), 2) + Math.pow(cc.getY(), 2) + Math.pow(cc.getZ(), 2));
		double latitude = Math.acos(cc.getZ() / radius);
		double longitude = Math.atan(cc.getY() / cc.getX());
		return new SphericCoordinate(latitude, longitude, radius);
	}
	
	/**
	 * Computes the spherical distance d(p,q) between this coordinate and q.
	 * 
	 * @methodtype get
	 */
	public double getSphericDistance(Coordinate q) {
		assertIsNotNull(q);
		SphericCoordinate p = this.asSphericCoordinate();
		SphericCoordinate sc = q.asSphericCoordinate();
		return doGetSphericDistance(p, sc);
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
	 * @methodtype assertion
	 */
	private void assertIsNotNull(Coordinate coord) {
		if(coord == null) {
			throw new IllegalArgumentException();
		}
	}
	
	public abstract double getDistance(Coordinate q);
	
	public abstract boolean isEqual(Coordinate q);
	
	/**
	 * Forwards equals() to isEqual();
	 * 
	 * @methodtype boolean query
	 */
	@Override
	public boolean equals(Object o) {
		if(o == null) {
			return false;
		}
		if(o == this) {
			return true;
		}
		if (o instanceof Coordinate) {
			return this.isEqual((Coordinate) o);
		}
		return false;
	}
}
