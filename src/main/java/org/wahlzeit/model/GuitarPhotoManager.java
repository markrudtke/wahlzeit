package org.wahlzeit.model;

import org.wahlzeit.utils.PatternInstance;

import com.google.appengine.api.images.Image;

@PatternInstance(
		patternName = "Singleton",
		participants = {
				"Singleton"
		}
)
public class GuitarPhotoManager extends PhotoManager{

	protected static final GuitarPhotoManager instance = new GuitarPhotoManager();
	
	/**
	 * @methodtype constructor
	 */
	public GuitarPhotoManager() {
		super();
	}
	
	/**
	 *
	 */
	@Override
	public Photo createPhoto(String filename, Image uploadedImage) throws GuitarPhotoInstantiationException {
		try {
			return super.createPhoto(filename, uploadedImage);
		} catch (Exception ex) {
			throw new GuitarPhotoInstantiationException("Cannot create guitar photo!");
		}
	}

}
