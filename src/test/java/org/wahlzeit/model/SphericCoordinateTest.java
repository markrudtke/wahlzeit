package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class SphericCoordinateTest {
	
	SphericCoordinate coord1 = new SphericCoordinate(1, 2, 3);
	SphericCoordinate coord2 = new SphericCoordinate();
	SphericCoordinate coord3 = new SphericCoordinate(1, 3, -2);
	SphericCoordinate coord4 = new SphericCoordinate(-4, 2, 5);
	CartesianCoordinate coord5 = new CartesianCoordinate(1, 2, 3);
	CartesianCoordinate coord6 = new CartesianCoordinate(4, 5, 6);
	
	@Test
	public void testGetLatitude() {
		assertEquals(1, coord1.getLatitude(), 0);
	}
	
	@Test
	public void testGetLongitude() {
		assertEquals(2, coord1.getLongitude(), 0);
	}
	
	@Test
	public void testGetRadius() {
		assertEquals(3, coord1.getRadius(), 0);
	}
	
	@Test
	public void testGetCoordinate() {
		assertEquals(1, coord1.getCoordinate()[0], 0);
		assertEquals(2, coord1.getCoordinate()[1], 0);
		assertEquals(3, coord1.getCoordinate()[2], 0);
	}
	
	@Test
	public void testSetLatitude() {
		coord2.setLatitude(4);
		assertEquals(4, coord2.getLatitude(), 0);
	}
	
	@Test
	public void testSetLongitude() {
		coord2.setLongitude(5);
		assertEquals(5, coord2.getLongitude(), 0);
	}
	
	@Test
	public void testSetRadius() {
		coord2.setRadius(6);
		assertEquals(6, coord2.getRadius(), 0);
	}
	
	@Test
	public void testSetCoordinate() {
		coord2.setCoordinate(7, 8, 9);
		assertEquals(7, coord2.getCoordinate()[0], 0);
		assertEquals(8, coord2.getCoordinate()[1], 0);
		assertEquals(9, coord2.getCoordinate()[2], 0);
	}
	
	@Test
	public void testAsCartesianCoordinate() {
		assertEquals(coord5, coord5.asSphericCoordinate().asCartesianCoordinate());
	}

	@Test
	public void testGetCartesianDistance() {
		assertEquals(Math.sqrt(27), coord5.asSphericCoordinate().getCartesianDistance(coord6), 0);
		assertNotEquals(Math.sqrt(27), coord5.asSphericCoordinate().getCartesianDistance(coord6.asSphericCoordinate()), 0);
	}

	@Test
	public void testAsSphericCoordinate() {
		assertEquals(coord1, coord1.asSphericCoordinate());
	}

	@Test
	public void testGetSphericDistance() {
		assertEquals(Math.sqrt(27), coord5.asSphericCoordinate().getSphericDistance(coord6), 0);
		assertNotEquals(Math.sqrt(27), coord5.asSphericCoordinate().getSphericDistance(coord6.asSphericCoordinate()), 0);
	}
	
	@Test
	public void testGetDistance() {
		assertEquals(Math.sqrt(27), coord5.asSphericCoordinate().getDistance(coord6), 0);
		assertNotEquals(Math.sqrt(27), coord5.asSphericCoordinate().getDistance(coord6.asSphericCoordinate()), 0);
	}
	
	@Test (expected = NullPointerException.class)
	public void testGetDistance_nullArgument() {
		coord1.getDistance(null);
	}
	
	@Test
	public void testIsEqual() {
		coord1.setCoordinate(69.82, 2, 3);
		coord2.setCoordinate(69.2 + 0.62, 2, 3);
		assertTrue(coord1.isEqual(coord2));
		assertFalse(coord1.isEqual(coord3));
//		assertTrue(coord1.isEqual(coord2.asCartesianCoordinate()));
//		assertFalse(coord1.isEqual(coord3.asCartesianCoordinate()));
	}
	
	@Test
	public void testEquals() {
		coord2.setCoordinate(1, 2, 3);
		assertTrue(coord1.equals(coord2));
		assertFalse(coord1.equals(coord3));
//		assertTrue(coord1.equals(coord2.asCartesianCoordinate()));
//		assertFalse(coord1.equals(coord3.asCartesianCoordinate()));
	}
	
	@Test
	public void testEquals_wrongArgument() {
		Object o = new Object();
		assertFalse(coord1.equals(o));
		assertFalse(coord1.equals(null));
	}
}
