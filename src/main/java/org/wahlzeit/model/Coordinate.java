package org.wahlzeit.model;

public class Coordinate {

	private double x;
	private double y;
	private double z;
	
	public Coordinate() {
		
	}
	
	public Coordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getZ() {
		return z;
	}
	
	public double[] getCoordinate() {
		return new double[] {x, y, z};
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public void setZ(double z) {
		this.z = z;
	}
	
	public void setCoordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	/**
	 * d(P,Q)
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
	
	public boolean isEqual(Coordinate q) {
		if (this.x == q.getX() && this.y == q.getY() && this.z == q.getZ()) {
			return true;
		}
		return false;
	}
	
	/**
	 * forwards equals() to isEqual();
	 */
	public boolean equals(Object q) {
		return this.isEqual((Coordinate) q);
	}
}
