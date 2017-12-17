package org.wahlzeit.model;

public class AssertionUtil {
	
	/**
	 * @methodtype assertion
	 */
	protected static void assertIsValidDouble(double d) {
		if(Double.isInfinite(d) || Double.isNaN(d)) {
			throw new IllegalArgumentException("A double value must be a number and must not be infinite!");
		}
	}
	
	/**
	 * @methodtype assertion
	 */
	protected static void assertIsValidDistance(double d) {
		if(d < 0) {
			throw new IllegalArgumentException("A distance must not be negative!");
		}
	}
	
	/**
	 * @methodtype assertion
	 */
	protected static void assertIsValidInt(int i) {
		if(i > Integer.MAX_VALUE || i < Integer.MIN_VALUE) {
			throw new IllegalArgumentException("An int value has to be: Integer.MIN_VALUE <= i <= Integer.MAX_VALUE");
		}
	}
	
	/**
	 * @methodtype assertion
	 */
	protected static void assertIsNonNullArgument(String s) {
		if(s == null) {
			throw new IllegalArgumentException("A Location name must not be null! String brand/model must not be null!");
		}
	}

}
