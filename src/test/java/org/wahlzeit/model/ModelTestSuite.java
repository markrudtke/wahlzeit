package org.wahlzeit.model;

import org.junit.runner.*;
import org.junit.runners.*;
import org.wahlzeit.model.persistence.PersistenceTestSuite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	AccessRightsTest.class,
	CartesianCoordinateTest.class,
	FlagReasonTest.class,
	GenderTest.class,
	GuestTest.class,
	GuitarManagerTest.class,
	GuitarPhotoFactoryTest.class,
	GuitarPhotoManagerTest.class,
	GuitarPhotoTest.class,
	GuitarTest.class,
	GuitarTypeTest.class,
	LocationTest.class,
	PhotoFilterTest.class,
	SphericCoordinateTest.class,
	TagsTest.class,
	UserStatusTest.class,
	ValueTest.class,
	PersistenceTestSuite.class
})

public class ModelTestSuite {

}
