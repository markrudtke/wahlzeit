package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class LocationTest {

	CartesianCoordinate coord1 = CartesianCoordinate.getCoordinate(1, 2, 3);
	SphericCoordinate coord2 = SphericCoordinate.getCoordinate(4, 5, 6);
	Location loc1 = new Location("test1", coord1);
	Location loc2 = new Location("test2");
	Location loc3 = new Location();
	
	@Test
	public void testGetName() {
		assertEquals("test1", loc1.getName());
	}
	
	@Test
	public void testGetCoordinate() {
		assertEquals(coord1, loc1.getCoordinate());
	}
	
	@Test
	public void testSetName() {
		loc3.setName("test3");
		assertEquals("test3", loc3.getName());
	}
	
	@Test
	public void testSetCoordinate() {
		loc2.setCoordinate(coord2);
		loc3.setCoordinate(coord1);
		assertEquals(coord2, loc2.getCoordinate());
		assertEquals(coord1, loc3.getCoordinate());
	}
}
