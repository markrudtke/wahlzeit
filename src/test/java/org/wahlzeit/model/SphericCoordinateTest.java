package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class SphericCoordinateTest {
	
	SphericCoordinate sc1 = SphericCoordinate.getCoordinate(1, 2, 3);
	SphericCoordinate sc2 = SphericCoordinate.getCoordinate(0, 0, 0);
	SphericCoordinate sc3 = SphericCoordinate.getCoordinate(1, 90, 90);
	SphericCoordinate sc4 = SphericCoordinate.getCoordinate(2, 90, 90);
	SphericCoordinate sc5 = SphericCoordinate.getCoordinate(1, 2, 3);
	SphericCoordinate sc6 = SphericCoordinate.getCoordinate(4, 5, 6);
	CartesianCoordinate cc1 = CartesianCoordinate.getCoordinate(1, 2, 3);
	
	@Test
	public void testGetLatitude() {
		assertTrue(1 == sc1.getLatitude());
	}
	
	@Test
	public void testGetLongitude() {
		assertTrue(2 == sc1.getLongitude());
	}
	
	@Test
	public void testGetRadius() {
		assertTrue(3 == sc1.getRadius());
	}
	
	@Test
	public void testGetCoordinate() {
		assertTrue(1 == sc1.getCoordinate(1, 2, 3).getLatitude());
		assertTrue(2 == sc1.getCoordinate(1, 2, 3).getLongitude());
		assertTrue(3 == sc1.getCoordinate(1, 2, 3).getRadius());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSetLatitude() {
		sc2 = sc2.setLatitude(4);
		assertTrue(4 == sc2.getLatitude());
		sc2.setLatitude(-1);
		sc2.setLatitude(181);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSetLongitude() {
		sc2 = sc2.setLongitude(5);
		assertTrue(5 == sc2.getLongitude());
		sc2.setLongitude(-181);
		sc2.setLongitude(181);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSetRadius() {
		sc2 = sc2.setRadius(6);
		assertTrue(6 == sc2.getRadius());
		sc2.setRadius(-1);
	}
	
	@Test
	public void testSetCoordinate() {
		sc2 = sc2.setCoordinate(7, 8, 9);
		assertTrue(7 == sc2.getLatitude());
		assertTrue(8 == sc2.getLongitude());
		assertTrue(9 == sc2.getRadius());
	}
	
	@Test
	public void testAsCartesianCoordinate() {
		assertTrue(sc1.equals(sc1.asCartesianCoordinate().asSphericCoordinate()));
		assertTrue(cc1.equals(cc1.asSphericCoordinate().asCartesianCoordinate()));
	}

	@Test (expected = IllegalArgumentException.class)
	public void testGetCartesianDistance() {
		assertTrue(sc5.asCartesianCoordinate().getDistance(sc6) == sc5.getCartesianDistance(sc6));
		sc3.getCartesianDistance(null);
	}

	@Test
	public void testAsSphericCoordinate() {
		assertTrue(sc1.equals(sc1.asSphericCoordinate()));
	}

	@Test (expected = IllegalArgumentException.class)
	public void testGetSphericDistance() {
		assertTrue(sc3.getDistance(sc4) == sc3.getSphericDistance(sc4));
		sc3.getSphericDistance(null);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testGetDistance() {
		assertEquals(Math.sqrt(0.05), sc5.getDistance(sc6), 0.01);
		sc1.getDistance(null);
	}
	
	@Test
	public void testIsEqual() {
		sc1 = sc1.setCoordinate(69.82, 2, 3);
		sc2 = sc2.setCoordinate(69.2 + 0.62, 2, 3);
		assertTrue(sc1.isEqual(sc1));
		assertTrue(sc1.isEqual(sc2));
		assertFalse(sc1.isEqual(sc3));
		assertFalse(sc1.isEqual(null));
		assertTrue(sc1.isEqual(sc2.asCartesianCoordinate()));
	}
	
	@Test
	public void testEquals() {
		sc2 = sc2.setCoordinate(1, 2, 3);
		assertTrue(sc1.equals(sc1));
		assertTrue(sc1.equals(sc2));
		assertFalse(sc1.equals(sc3));
		assertFalse(sc1.equals(null));
		assertTrue(sc1.equals(sc2.asCartesianCoordinate()));
	}
}
