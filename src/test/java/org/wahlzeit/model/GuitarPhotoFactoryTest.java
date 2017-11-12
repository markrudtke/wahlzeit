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

public class GuitarPhotoFactoryTest {
	
	@ClassRule
	public static RuleChain ruleChain = RuleChain.
		outerRule(new LocalDatastoreServiceTestConfigProvider()).
		around(new RegisteredOfyEnvironmentProvider()).
		around(new SysConfigProvider()).
		around(new UserServiceProvider()).
		around(new UserSessionProvider());
	
	@Test
	public void testCreateGuitarPhoto() {
		GuitarPhotoFactory gpf = GuitarPhotoFactory.getInstance();
		PhotoId id = new PhotoId(1234);
		GuitarPhoto p1 = gpf.createGuitarPhoto();
		GuitarPhoto p2 = gpf.createGuitarPhoto(id);
		assertTrue(gpf instanceof GuitarPhotoFactory);
		assertTrue(p1 instanceof GuitarPhoto);
		assertTrue(p2 instanceof GuitarPhoto);
	}

}
