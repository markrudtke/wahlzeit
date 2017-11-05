package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoordinateTest {

	Coordinate coord1 = new Coordinate(1, 2, 3);
	Coordinate coord2 = new Coordinate();
	Coordinate coord3 = new Coordinate(1, 3, -2);
	Coordinate coord4 = new Coordinate(-4, 2, 5);
	
	@Test
	public void testGetX() {
		assertEquals(1, coord1.getX(), 0);
	}
	
	@Test
	public void testGetY() {
		assertEquals(2, coord1.getY(), 0);
	}
	
	@Test
	public void testGetZ() {
		assertEquals(3, coord1.getZ(), 0);
	}
	
	@Test
	public void testGetCoordinate() {
		assertEquals(1, coord1.getCoordinate()[0], 0);
		assertEquals(2, coord1.getCoordinate()[1], 0);
		assertEquals(3, coord1.getCoordinate()[2], 0);
	}
	
	@Test
	public void testSetX() {
		coord2.setX(4);
		assertEquals(4, coord2.getX(), 0);
	}
	
	@Test
	public void testSetY() {
		coord2.setY(5);
		assertEquals(5, coord2.getY(), 0);
	}
	
	@Test
	public void testSetZ() {
		coord2.setZ(6);
		assertEquals(6, coord2.getZ(), 0);
	}
	
	@Test
	public void testSetCoordinate() {
		coord2.setCoordinate(7, 8, 9);
		assertEquals(7, coord2.getCoordinate()[0], 0);
		assertEquals(8, coord2.getCoordinate()[1], 0);
		assertEquals(9, coord2.getCoordinate()[2], 0);
	}
	
	@Test
	public void testGetDistance() {
		assertEquals(Math.sqrt(75), coord3.getDistance(coord4), 0);
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
	}
	
	@Test
	public void testEquals() {
		coord2.setCoordinate(1, 2, 3);
		assertTrue(coord1.equals(coord2));
		assertFalse(coord1.equals(coord3));
	}
	
	@Test
	public void testEquals_wrongArgument() {
		Object o = new Object();
		assertFalse(coord1.equals(o));
		assertFalse(coord1.equals(null));
	}
}
