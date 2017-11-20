package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Subclass;

@Subclass
public class GuitarPhoto extends Photo {

	private String brand;
	private String model;
	private int noStrings;
	
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
	 * @methodtype constructor
	 */
	public GuitarPhoto(String brand, String model, int noStrings) {
		super();
		this.brand = brand;
		this.model = model;
		this.noStrings = noStrings;
	}
	
	/**
	 * @methodtype constructor
	 */
	public GuitarPhoto(PhotoId myId, String brand, String model, int noStrings) {
		super(myId);
		this.brand = brand;
		this.model = model;
		this.noStrings = noStrings;
	}
	
	/**
	 * @methodtype get
	 */
	public String getBrand() {
		return brand;
	}
	
	/**
	 * @methodtype get
	 */
	public String getModel() {
		return model;
	}
	
	/**
	 * @methodtype get
	 */
	public int getNoStrings() {
		return noStrings;
	}
	
	/**
	 * @methodtype set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	/**
	 * @methodtype set
	 */
	public void setModel(String model) {
		this.model = model;
	}
	
	/**
	 * @methodtype set
	 */
	public void setNoStrings(int noStrings) {
		this.noStrings = noStrings;
	}

}
