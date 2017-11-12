package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;
import org.wahlzeit.testEnvironmentProvider.RegisteredOfyEnvironmentProvider;
import org.wahlzeit.testEnvironmentProvider.SysConfigProvider;
import org.wahlzeit.testEnvironmentProvider.UserServiceProvider;
import org.wahlzeit.testEnvironmentProvider.UserSessionProvider;

public class GuitarPhotoTest {
	
	PhotoId id = new PhotoId(1234);
	GuitarPhoto p1 = new GuitarPhoto();
	GuitarPhoto p2 = new GuitarPhoto(id);
	GuitarPhoto p3 = new GuitarPhoto("Epiphone", "Single Cut", 7);
	GuitarPhoto p4 = new GuitarPhoto(id, "Epiphone", "Single Cut", 7);
	
	@ClassRule
	public static RuleChain ruleChain = RuleChain.
		outerRule(new LocalDatastoreServiceTestConfigProvider()).
		around(new RegisteredOfyEnvironmentProvider()).
		around(new SysConfigProvider()).
		around(new UserServiceProvider()).
		around(new UserSessionProvider());
	
	@Test
	public void testGetId() {
		assertEquals(p2.getId(), p4.getId());
		assertNotEquals(p1.getId(), p2.getId());
		assertNotEquals(p1.getId(), p3.getId());
		assertNotEquals(p2.getId(), p3.getId());
	}
	
	@Test
	public void testGetBrand() {
		assertEquals("Epiphone", p3.getBrand());
	}
	
	@Test
	public void testGetModel() {
		assertEquals("Single Cut", p3.getModel());
	}
	
	@Test
	public void testGetNoStrings() {
		assertEquals(7, p3.getNoStrings());
	}
	
	@Test
	public void testSetBrand() {
		p1.setBrand("Epiphone");
		assertEquals("Epiphone", p1.getBrand());
	}
	
	@Test
	public void testSetModel() {
		p1.setModel("Single Cut");
		assertEquals("Single Cut", p1.getModel());
	}
	
	@Test
	public void testSetNoStrings() {
		p1.setNoStrings(7);
		assertEquals(7, p1.getNoStrings());
	}

}
