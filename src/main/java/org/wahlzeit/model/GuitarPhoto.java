package org.wahlzeit.model;

import org.wahlzeit.utils.PatternInstance;

import com.googlecode.objectify.annotation.Serialize;
import com.googlecode.objectify.annotation.Subclass;

@PatternInstance(
		patternName = "Abstract Factory",
		participants = {
				"ConcreteProduct"
		}
)
@Subclass
public class GuitarPhoto extends Photo {

	@Serialize
	private Guitar g = new Guitar(new GuitarType(""));
	
	/**
	 * @methodtype constructor
	 */
	public GuitarPhoto() {
		super();
	}
	
	/**
	 * @methodtype constructor
	 */
	public GuitarPhoto(PhotoId myId) {
		super(myId);
	}
	
	/**
	 * @methodtype get
	 */
	public Guitar getGuitar() {
		return g;
	}
	
	/**@pre guitar != null
	 * @methodtype set
	 */
	public void setGuitar(Guitar guitar) {
		assertIsValidGuitar(guitar);
		
		doSetGuitar(guitar);
	}
	
	/**
	 * @methodtype set
	 * @methodproperty primitive
	 */
	private void doSetGuitar(Guitar guitar) {
		this.g = guitar;
	}
	
	/**
	 * @methodtype assertion
	 */
	protected static void assertIsValidGuitar(Guitar guitar) {
		if(guitar == null) {
			throw new IllegalArgumentException("A Guitar must not be null!");
		}
	}
	
}
