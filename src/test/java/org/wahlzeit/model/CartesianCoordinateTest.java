package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class CartesianCoordinateTest {

	CartesianCoordinate cc1 = new CartesianCoordinate(1, 2, 3);
	CartesianCoordinate cc2 = new CartesianCoordinate();
	CartesianCoordinate cc3 = new CartesianCoordinate(1, 3, -2);
	CartesianCoordinate cc4 = new CartesianCoordinate(-4, 2, 5);
	CartesianCoordinate cc5 = new CartesianCoordinate(1, 3, 2);
	CartesianCoordinate cc6 = new CartesianCoordinate(4, 2, 5);
	
/*	@Test (expected = IllegalArgumentException.class)
	public void test() {
		CartesianCoordinate c = new CartesianCoordinate(0, 0, 0);
		c.asSphericCoordinate();
	}
*/	
	@Test
	public void testGetX() {
		assertTrue(1 == cc1.getX());
	}
	
	@Test
	public void testGetY() {
		assertTrue(2 == cc1.getY());
	}
	
	@Test
	public void testGetZ() {
		assertTrue(3 == cc1.getZ());
	}
	
	@Test
	public void testGetCoordinate() {
		assertTrue(1 == cc1.getCoordinate()[0]);
		assertTrue(2 == cc1.getCoordinate()[1]);
		assertTrue(3 == cc1.getCoordinate()[2]);
	}
	
	@Test
	public void testSetX() {
		cc2.setX(4);
		assertTrue(4 == cc2.getX());
	}
	
	@Test
	public void testSetY() {
		cc2.setY(5);
		assertTrue(5 == cc2.getY());
	}
	
	@Test
	public void testSetZ() {
		cc2.setZ(6);
		assertTrue(6 == cc2.getZ());
	}
	
	@Test
	public void testSetCoordinate() {
		cc2.setCoordinate(7, 8, 9);
		assertTrue(7 == cc2.getCoordinate()[0]);
		assertTrue(8 == cc2.getCoordinate()[1]);
		assertTrue(9 == cc2.getCoordinate()[2]);
	}
	
	@Test
	public void testAsCartesianCoordinate() {
		assertTrue(cc1.equals(cc1.asCartesianCoordinate()));
	}

	@Test (expected = IllegalArgumentException.class)
	public void testGetCartesianDistance() {
		assertTrue(Math.sqrt(75) == cc3.getCartesianDistance(cc4));
		cc3.getCartesianDistance(null);
	}

	@Test
	public void testAsSphericCoordinate() {
		assertTrue(cc1.equals(cc1.asSphericCoordinate().asCartesianCoordinate()));
	}

	@Test (expected = IllegalArgumentException.class)
	public void testGetSphericDistance() {
		assertTrue(cc5.asSphericCoordinate().getDistance(cc6) == cc5.getSphericDistance(cc6));
		cc3.getSphericDistance(null);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testGetDistance() {
		assertTrue(cc5.getCartesianDistance(cc6) == cc5.getDistance(cc6));
		cc1.getDistance(null);
	}
	
	@Test
	public void testIsEqual() {
		cc1.setCoordinate(69.82, 2, 3);
		cc2.setCoordinate(69.2 + 0.62, 2, 3);
		assertTrue(cc1.isEqual(cc1));
		assertTrue(cc1.isEqual(cc2));
		assertFalse(cc1.isEqual(cc3));
		assertFalse(cc1.isEqual(null));
		assertTrue(cc1.isEqual(cc2.asSphericCoordinate()));
	}
	
	@Test
	public void testEquals() {
		cc2.setCoordinate(1, 2, 3);
		assertTrue(cc1.equals(cc1));
		assertTrue(cc1.equals(cc2));
		assertFalse(cc1.equals(cc3));
		assertFalse(cc1.equals(null));
		assertTrue(cc1.equals(cc2.asSphericCoordinate()));
	}
}
