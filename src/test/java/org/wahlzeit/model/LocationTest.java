package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class LocationTest {

	Location loc = new Location("test1");
	Coordinate coord = new Coordinate(1, 2, 3);
	
	@Test
	public void testGetName() {
		assertEquals("test1", loc.getName());
	}
	
	@Test
	public void testSetName() {
		loc.setName("test2");
		assertEquals("test2", loc.getName());
	}
	
	@Test
	public void testSetCoordinate() {
		loc.setCoordinate(1, 2, 3);
		assertEquals(coord, loc.coord);
	}
}
