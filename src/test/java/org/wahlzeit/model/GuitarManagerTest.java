package org.wahlzeit.model;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;
import org.wahlzeit.testEnvironmentProvider.RegisteredOfyEnvironmentProvider;
import org.wahlzeit.testEnvironmentProvider.SysConfigProvider;
import org.wahlzeit.testEnvironmentProvider.UserServiceProvider;
import org.wahlzeit.testEnvironmentProvider.UserSessionProvider;

public class GuitarManagerTest {

	GuitarManager gm = GuitarManager.getInstance();
	
	@ClassRule
	public static RuleChain ruleChain = RuleChain.
		outerRule(new LocalDatastoreServiceTestConfigProvider()).
		around(new RegisteredOfyEnvironmentProvider()).
		around(new SysConfigProvider()).
		around(new UserServiceProvider()).
		around(new UserSessionProvider());
	
	@Test
	public void testCreateGuitar() {
		HashMap<String, Guitar> guitars = gm.getGuitars();
		assertTrue(guitars.size() == 0);
		Guitar g1 = gm.createGuitar("Westerngitarre");
		assertTrue(guitars.size() == 1);
		assertTrue(guitars.containsKey("Westerngitarre"));
		Guitar g2 = gm.createGuitar("Konzertgitarre");
		assertTrue(guitars.size() == 2);
		assertTrue(guitars.containsKey("Konzertgitarre"));
		Guitar g3 = gm.createGuitar("Westerngitarre");
		assertTrue(guitars.size() == 2);
		assertTrue(g3.getType().getName() == "Westerngitarre");
	}
	
}
