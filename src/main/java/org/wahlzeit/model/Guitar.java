package org.wahlzeit.model;

import org.wahlzeit.services.DataObject;

import com.googlecode.objectify.annotation.Entity;

/**
 * @inv location != null && brand != null && model != null
 * 		&& noStrings <= Integer.MAX_VALUE && noStrings >= Integer.MIN_VALUE
 */
@Entity
public class Guitar extends DataObject {

	protected GuitarType guitarType = null;
	
	private Location location = new Location();
	private String brand = "";
	private String model = "";
	private int noStrings;
	
	/**
	 * @pre guitarType != null
	 * @methodtype constructor
	 */
	public Guitar(GuitarType guitarType) {
		assertIsValidGuitarType(guitarType);
		
		this.guitarType = guitarType;
	}
	
	/**
	 * @methodtype get
	 */
	public GuitarType getType() {
		return guitarType;
	}
	
	/**
	 * @methodtype get
	 */
	public String getId() {
		return guitarType.getName();
	}
	
	/**
	 * @methodtype get
	 */
	public Location getLocation() {
		return location;
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
	 * @pre location != null
	 * @methodtype set
	 */
	public void setLocation(Location location) {
		assertClassInvariants();
		
		assertIsNonNullArgument(location);
		
		doSetLocation(location);
		
		assertClassInvariants();
	}
	
	/**
	 * @methodtype set
	 * @methodproperty primitive
	 */
	private void doSetLocation(Location location) {
		this.location = location;
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
	public void setGuitar(String brand, String model, int noStrings) {
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
		assertIsNonNullArgument(location);
		AssertionUtil.assertIsNonNullArgument(brand);
		AssertionUtil.assertIsNonNullArgument(model);
		AssertionUtil.assertIsValidInt(noStrings);
	}
	
	/**
	 * @methodtype assertion
	 */
	protected static void assertIsValidGuitarType(GuitarType guitarType) {
		if(guitarType== null) {
			throw new IllegalArgumentException("A GuitarType must not be null!");
		}
	}
	
	/**
	 * @methodtype assertion
	 */
	private void assertIsNonNullArgument(Location location) {
		if(location == null) {
			throw new IllegalArgumentException("A Location must not be null!");
		}
	}
	
}
