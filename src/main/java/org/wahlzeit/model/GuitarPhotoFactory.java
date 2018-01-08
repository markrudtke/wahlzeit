package org.wahlzeit.model;

import java.util.logging.Logger;

import org.wahlzeit.services.LogBuilder;
import org.wahlzeit.utils.PatternInstance;

@PatternInstance(
		patternName = "Abstract Factory",
		participants = {
				"ConcreteFactory"
		}
)
public class GuitarPhotoFactory extends PhotoFactory{

	private static final Logger log = Logger.getLogger(GuitarPhotoFactory.class.getName());
	/**
	 * Hidden singleton instance; needs to be initialized from the outside.
	 */
	private static GuitarPhotoFactory instance = null;

	/**
	 * @methodtype constructor
	 */
	protected GuitarPhotoFactory() {
		// do nothing
	}
	
	/**
	 * Hidden singleton instance; needs to be initialized from the outside.
	 */
	public static void initialize() {
		GuitarPhotoFactory.getInstance(); // drops result due to getInstance() side-effects
	}

	/**
	 * Public singleton access method.
	 * 
	 * @methodtype get
	 */
	public static synchronized GuitarPhotoFactory getInstance() {
		if (instance == null) {
			log.config(LogBuilder.createSystemMessage().addAction("setting generic GuitarPhotoFactory").toString());
			setInstance(new GuitarPhotoFactory());
		}

		return instance;
	}

	/**
	 * Method to set the singleton instance of GuitarPhotoFactory.
	 * 
	 * @methodtype set
	 */
	protected static synchronized void setInstance(GuitarPhotoFactory guitarPhotoFactory) {
		if (instance != null) {
			throw new IllegalStateException("attempt to initalize GuitarPhotoFactory twice");
		}

		instance = guitarPhotoFactory;
	}

	/**
	 * @methodtype factory
	 */
	@Override
	public GuitarPhoto createPhoto() {
		return new GuitarPhoto();
	}

	/**
	 * Creates a new guitar photo with the specified id
	 * @throws GuitarPhotoInstantiationException 
	 * 
	 * @methodtype factory
	 */
	@Override
	public GuitarPhoto createPhoto(PhotoId id) {
		return new GuitarPhoto(id);
	}
	
	/**
	 * Creates a new guitar photo with the specified brand, model and number of strings
	 * 
	 * @methodtype factory
	 */
	public GuitarPhoto createPhoto(String brand, String model, int noStrings) {
		return new GuitarPhoto(brand, model, noStrings);
	}
	
	/**
	 * Creates a new guitar photo with the specified id, brand, model and number of strings
	 * 
	 * @methodtype factory
	 */
	public GuitarPhoto createPhoto(PhotoId id, String brand, String model, int noStrings) {
		return new GuitarPhoto(id, brand, model, noStrings);
	}

}
