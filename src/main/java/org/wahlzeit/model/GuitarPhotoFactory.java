package org.wahlzeit.model;

import java.util.logging.Logger;

import org.wahlzeit.services.LogBuilder;

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
	public GuitarPhoto createPhoto() throws IllegalStateException {
		try {
			return new GuitarPhoto();
		} catch (IllegalArgumentException e) {
			throw new IllegalStateException("Cannot create photo!");
		}
	}

	/**
	 * Creates a new guitar photo with the specified id
	 * 
	 * @methodtype factory
	 */
	@Override
	public GuitarPhoto createPhoto(PhotoId id) throws IllegalStateException {
		try {
			return new GuitarPhoto(id);
		} catch (IllegalArgumentException e) {
			throw new IllegalStateException("Cannot create photo!");
		}
	}
	
	/**
	 * Creates a new guitar photo with the specified brand, model and number of strings
	 * 
	 * @methodtype factory
	 */
	public GuitarPhoto createPhoto(String brand, String model, int noStrings) throws IllegalArgumentException {
		try {
			return new GuitarPhoto(brand, model, noStrings);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Invalid parameters. Cannot create photo!");
		}
	}
	
	/**
	 * Creates a new guitar photo with the specified id, brand, model and number of strings
	 * 
	 * @methodtype factory
	 */
	public GuitarPhoto createPhoto(PhotoId id, String brand, String model, int noStrings) throws IllegalArgumentException {
		try {
			return new GuitarPhoto(id, brand, model, noStrings);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Invalid parameters. Cannot create photo!");
		}
	}

}
