package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;
import org.wahlzeit.testEnvironmentProvider.RegisteredOfyEnvironmentProvider;
import org.wahlzeit.testEnvironmentProvider.SysConfigProvider;
import org.wahlzeit.testEnvironmentProvider.UserServiceProvider;
import org.wahlzeit.testEnvironmentProvider.UserSessionProvider;

public class GuitarTest {

	PhotoId id = new PhotoId(1234);
	Guitar g1 = new Guitar(new GuitarType("E-Gitarre"));
	GuitarPhoto p1 = new GuitarPhoto();
	Guitar g2 = new Guitar(new GuitarType("E-Gitarre"));
	GuitarPhoto p2 = new GuitarPhoto(id);
	Location l = new Location("Nuremberg");
	
	
	@ClassRule
	public static RuleChain ruleChain = RuleChain.
		outerRule(new LocalDatastoreServiceTestConfigProvider()).
		around(new RegisteredOfyEnvironmentProvider()).
		around(new SysConfigProvider()).
		around(new UserServiceProvider()).
		around(new UserSessionProvider());
	
	@Before
	public void setUp() {
		g1.setGuitar("Epiphone", "Single Cut", 7);
		p1.setGuitar(g1);
		g2.setGuitar("Epiphone", "Single Cut", 7);
		p2.setGuitar(g2);
	}
	
	@Test
	public void testGetType() {
		assertEquals("E-Gitarre", g1.getType().getName());
	}
	
	
	@Test
	public void testGetId() {
		assertEquals("E-Gitarre", g1.getId());
	}
	
	@Test
	public void testGetLocation() {
		g1.setLocation(new Location("Nuremberg"));
		assertEquals("Nuremberg", g1.getLocation().getName());
	}
	
	@Test
	public void testGetBrand() {
		assertEquals("Epiphone", g1.getBrand());
	}
	
	@Test
	public void testGetModel() {
		assertEquals("Single Cut", g1.getModel());
	}
	
	@Test
	public void testGetNoStrings() {
		assertEquals(7, g1.getNoStrings());
	}
	
	@Test
	public void testSetLocation() {
		g1.setLocation(l);
		assertEquals("Nuremberg", g1.getLocation().getName());
	}
	
	@Test
	public void testSetBrand() {
		g1.setBrand("Epiphone");
		assertEquals("Epiphone", g1.getBrand());
	}
	
	@Test
	public void testSetModel() {
		g1.setModel("Single Cut");
		assertEquals("Single Cut", g1.getModel());
	}
	
	@Test
	public void testSetNoStrings() {
		g1.setNoStrings(7);
		assertEquals(7, g1.getNoStrings());
	}
	
	@Test
	public void testSetGuitar() {
		g1.setBrand("Epiphone");
		g1.setModel("Single Cut");
		g1.setNoStrings(7);
		assertEquals("Epiphone", g1.getBrand());
		assertEquals("Single Cut", g1.getModel());
		assertEquals(7, g1.getNoStrings());
	}
	
}
