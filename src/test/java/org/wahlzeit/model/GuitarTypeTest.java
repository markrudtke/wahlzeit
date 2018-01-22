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

public class GuitarTypeTest {

	GuitarType gt1 = new GuitarType("E-Gitarre");
	GuitarType gt2 = new GuitarType("T-Modell");
	GuitarType gt3 = new GuitarType("ST-Modell");
	Guitar g = new Guitar(gt2);
	
	@ClassRule
	public static RuleChain ruleChain = RuleChain.
		outerRule(new LocalDatastoreServiceTestConfigProvider()).
		around(new RegisteredOfyEnvironmentProvider()).
		around(new SysConfigProvider()).
		around(new UserServiceProvider()).
		around(new UserSessionProvider());
	
	@Test
	public void testGetName() {
		assertTrue(gt1.getName() == "E-Gitarre");
	}
	
	@Test
	public void testGetSuperType() {
		assertTrue(gt1.getSuperType() == null);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testAddSubType() {
		gt1.addSubType(gt2);
		assertTrue(gt1.subTypes.contains(gt2));
		gt1.addSubType(null);
		
	}
	
	@Test
	public void testHasInstance() {
		gt1.addSubType(gt2);
		assertTrue(gt1.hasInstance(g));
		assertTrue(gt2.hasInstance(g));
		assertFalse(gt3.hasInstance(g));
	}
	
	@Test
	public void testIsSubtype() {
		gt1.addSubType(gt2);
		assertTrue(gt2.isSubtype());
		assertFalse(gt1.isSubtype());
		assertTrue(gt2.isSubtype(gt1));
		assertFalse(gt1.isSubtype(gt2));
	}
	
	@Test
	public void testIsSupertype() {
		gt1.addSubType(gt2);
		assertTrue(gt1.isSupertype());
		assertFalse(gt2.isSupertype());
		assertTrue(gt1.isSupertype(gt2));
		assertFalse(gt2.isSupertype(gt1));
	}
	
	@Test
	public void testCreateInstance() {
		Guitar stGuitar = gt3.createInstance();
		assertTrue("ST-Modell" == stGuitar.getId());
	}

}
