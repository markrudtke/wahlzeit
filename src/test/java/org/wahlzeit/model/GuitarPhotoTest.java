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
	Guitar g = new Guitar(new GuitarType("Ukulele"));
	Location l = new Location("Nuremberg");
	
	@ClassRule
	public static RuleChain ruleChain = RuleChain.
		outerRule(new LocalDatastoreServiceTestConfigProvider()).
		around(new RegisteredOfyEnvironmentProvider()).
		around(new SysConfigProvider()).
		around(new UserServiceProvider()).
		around(new UserSessionProvider());
	
	@Test
	public void testSetGuitar() {
		p2.loc = l;
		p2.setGuitar(g);
		assertTrue(p2.getGuitar() == g);
		assertTrue(p2.loc.getName() == "Nuremberg");
	}
	
}
