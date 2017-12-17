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
	public GuitarPhoto() {
		super();
		assertClassInvariants();
	}
	
	/**
	 * @methodtype constructor
	 */
	public GuitarPhoto(PhotoId myId) {
		super(myId);
		assertClassInvariants();
	}
	
	/**
	 * @pre brand != null && model != null
	 * 		&& noStrings <= Integer.MAX_VALUE && noStrings >= Integer.MIN_VALUE
	 * @methodtype constructor
	 */
	public GuitarPhoto(String brand, String model, int noStrings) {
		super();
		assertClassInvariants();
		
		AssertionUtil.assertIsNonNullArgument(brand);
		AssertionUtil.assertIsNonNullArgument(model);
		AssertionUtil.assertIsValidInt(noStrings);
		
		setGuitarPhoto(brand, model, noStrings);
		
		assertClassInvariants();
	}
	
	/**
	 * @pre brand != null && model != null
	 * 		&& noStrings <= Integer.MAX_VALUE && noStrings >= Integer.MIN_VALUE
	 * @methodtype constructor
	 */
	public GuitarPhoto(PhotoId myId, String brand, String model, int noStrings) {
		super(myId);
		assertClassInvariants();
		
		AssertionUtil.assertIsNonNullArgument(brand);
		AssertionUtil.assertIsNonNullArgument(model);
		AssertionUtil.assertIsValidInt(noStrings);
		
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
	public void setBrand(String brand) {
		assertClassInvariants();
		
		AssertionUtil.assertIsNonNullArgument(brand);
		
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
	public void setModel(String model) {
		assertClassInvariants();
		
		AssertionUtil.assertIsNonNullArgument(model);
		
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
	public void setNoStrings(int noStrings) {
		assertClassInvariants();
		
		AssertionUtil.assertIsValidInt(noStrings);
		
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
	public void setGuitarPhoto(String brand, String model, int noStrings) {
		assertClassInvariants();
		
		AssertionUtil.assertIsNonNullArgument(brand);
		AssertionUtil.assertIsNonNullArgument(model);
		AssertionUtil.assertIsValidInt(noStrings);
		
		setBrand(brand);
		setModel(model);
		setNoStrings(noStrings);
		
		assertClassInvariants();
	}
	
	/**
	 * @methodtype assertion
	 */
	private void assertClassInvariants() {
		AssertionUtil.assertIsNonNullArgument(brand);
		AssertionUtil.assertIsNonNullArgument(model);
		AssertionUtil.assertIsValidInt(noStrings);
	}
}
