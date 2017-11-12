package org.wahlzeit.model;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;
import org.wahlzeit.testEnvironmentProvider.RegisteredOfyEnvironmentProvider;
import org.wahlzeit.testEnvironmentProvider.SysConfigProvider;
import org.wahlzeit.testEnvironmentProvider.UserServiceProvider;
import org.wahlzeit.testEnvironmentProvider.UserSessionProvider;

public class GuitarPhotoManagerTest {

	PhotoManager gpm = GuitarPhotoManager.getInstance();
	PhotoId id1 = new PhotoId(1234);
	PhotoId id2 = new PhotoId(5678);
	GuitarPhoto p1 = new GuitarPhoto(id1);
	GuitarPhoto p2 = new GuitarPhoto(id2);
	
	@ClassRule
	public static RuleChain ruleChain = RuleChain.
		outerRule(new LocalDatastoreServiceTestConfigProvider()).
		around(new RegisteredOfyEnvironmentProvider()).
		around(new SysConfigProvider()).
		around(new UserServiceProvider()).
		around(new UserSessionProvider());
	
	@Test
	public void testHasPhoto() {
		try {
			gpm.addPhoto(p1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertTrue(gpm.hasPhoto(id1));
	}
	
	@Test
	public void testGetPhoto() {
		try {
			gpm.addPhoto(p2);
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertEquals(p2, gpm.getPhoto(id2));
	}

}
