package org.wahlzeit.model;

import org.junit.runner.*;
import org.junit.runners.*;
import org.wahlzeit.model.persistence.PersistenceTestSuite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	AccessRightsTest.class,
	CoordinateTest.class,
	FlagReasonTest.class,
	GenderTest.class,
	GuestTest.class,
	GuitarPhotoFactoryTest.class,
	GuitarPhotoManagerTest.class,
	GuitarPhotoTest.class,
	LocationTest.class,
	PhotoFilterTest.class,
	TagsTest.class,
	UserStatusTest.class,
	ValueTest.class,
	PersistenceTestSuite.class
})

public class ModelTestSuite {

}
