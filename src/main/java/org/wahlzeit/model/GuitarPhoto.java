package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Subclass;

/**
 * @inv brand != null && model != null
 * 		&& noStrings <= Integer.MAX_VALUE && noStrings >= Integer.MIN_VALUE
 */
@Subclass
public class GuitarPhoto extends Photo {

	private String brand = "";
	private String model = "";
	private int noStrings;
	
	/**
	 * @methodtype constructor
	 */
	public GuitarPhoto() throws IllegalArgumentException {
		super();
		assertClassInvariants();
	}
	
	/**
	 * @methodtype constructor
	 */
	public GuitarPhoto(PhotoId myId) throws IllegalArgumentException {
		super(myId);
		assertClassInvariants();
	}
	
	/**
	 * @pre brand != null && model != null
	 * 		&& noStrings <= Integer.MAX_VALUE && noStrings >= Integer.MIN_VALUE
	 * @methodtype constructor
	 */
	public GuitarPhoto(String brand, String model, int noStrings) throws IllegalArgumentException {
		super();
		assertClassInvariants();
		
		assertIsNonNullArgument(brand);
		assertIsNonNullArgument(model);
		assertIsValidInt(noStrings);
		
		setGuitarPhoto(brand, model, noStrings);
		
		assertClassInvariants();
	}
	
	/**
	 * @pre brand != null && model != null
	 * 		&& noStrings <= Integer.MAX_VALUE && noStrings >= Integer.MIN_VALUE
	 * @methodtype constructor
	 */
	public GuitarPhoto(PhotoId myId, String brand, String model, int noStrings) throws IllegalArgumentException {
		super(myId);
		assertClassInvariants();
		
		assertIsNonNullArgument(brand);
		assertIsNonNullArgument(model);
		assertIsValidInt(noStrings);
		
		setGuitarPhoto(brand, model, noStrings);
		
		assertClassInvariants();
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
	 * @pre brand != null
	 * @methodtype set
	 */
	public void setBrand(String brand) throws IllegalArgumentException {
		assertClassInvariants();
		
		assertIsNonNullArgument(brand);
		
		doSetBrand(brand);
		
		assertClassInvariants();
	}
	
	/**
	 * @methodtype set
	 * @methodproperty primitive
	 */
	private void doSetBrand(String brand) {
		this.brand = brand;
	}
	
	/**
	 * @pres model != null
	 * @methodtype set
	 */
	public void setModel(String model) throws IllegalArgumentException {
		assertClassInvariants();
		
		assertIsNonNullArgument(model);
		
		doSetModel(model);
		
		assertClassInvariants();
	}
	
	/**
	 * @methodtype set
	 * @methodproperty primitive
	 */
	private void doSetModel(String model) {
		this.model = model;
	}
	
	/**
	 * @pre noStrings <= Integer.MAX_VALUE && noStrings >= Integer.MIN_VALUE
	 * @methodtype set
	 */
	public void setNoStrings(int noStrings) throws IllegalArgumentException {
		assertClassInvariants();
		
		assertIsValidInt(noStrings);
		
		doSetNoStrings(noStrings);
		
		assertClassInvariants();
	}
	
	/**
	 * @methodtype set
	 * @methodproperty primitive
	 */
	private void doSetNoStrings(int noStrings) {
		this.noStrings = noStrings;
	}
	
	/**
	 * @pre brand != null && model != null
	 * 		&& noStrings <= Integer.MAX_VALUE && noStrings >= Integer.MIN_VALUE
	 * @methodtype set
	 */
	public void setGuitarPhoto(String brand, String model, int noStrings) throws IllegalArgumentException {
		assertClassInvariants();
		
		assertIsNonNullArgument(brand);
		assertIsNonNullArgument(model);
		assertIsValidInt(noStrings);
		
		setBrand(brand);
		setModel(model);
		setNoStrings(noStrings);
		
		assertClassInvariants();
	}
	
	/**
	 * @methodtype assertion
	 */
	private void assertClassInvariants() throws IllegalArgumentException {
		assertIsNonNullArgument(brand);
		assertIsNonNullArgument(model);
		assertIsValidInt(noStrings);
	}
	
	/**
	 * @methodtype assertion
	 */
	private void assertIsValidInt(int i) throws IllegalArgumentException {
		if(i > Integer.MAX_VALUE || i < Integer.MIN_VALUE) {
			throw new IllegalArgumentException("An int value has to be: Integer.MIN_VALUE <= i <= Integer.MAX_VALUE");
		}
	}
	
	/**
	 * @methodtype assertion
	 */
	private void assertIsNonNullArgument(String s) throws IllegalArgumentException {
		if(s == null) {
			throw new IllegalArgumentException("String brand/model must not be null!");
		}
	}
}
