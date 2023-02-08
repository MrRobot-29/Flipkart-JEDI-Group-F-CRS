package com.flipkart.constant;

/**
 * 
 * @author JEDI-03
 * Enumeration class for Gender
 *
 */
public enum Gender {
	MALE(1),FEMALE(2),OTHER(3);
	private final int gender;
	
	/**
	 * Parameterized Constructor
	 * @param gender
	 */
	private Gender(int gender)
	{
		this.gender=gender;
	}
	
	/**
	 * Method to return gender type in String
	 * @return Gender name in String
	 */
	@Override
	public String toString()
	{
		final String name=name();
		return name; 
	}
	
	/**
	 * Method to get Gender object depending upon user input
	 * @param val
	 * @return Gender object
	 */
	public static Gender getName(int val)
	{
		Gender gender=Gender.OTHER;
		switch(val)
		{
		case 1:
			gender=Gender.MALE;
			break;
		case 2:
			gender=Gender.FEMALE;
			break;
			
		}
		return gender;
	}
	
	/**
	 * Method to convert String to Gender object
	 * @param val
	 * @return Gender object
	 */
	public static Gender stringToGender(String val)
	{
		Gender gender=Gender.OTHER;
		if(val.equalsIgnoreCase("m"))
			gender=Gender.MALE;
		else if(val.equalsIgnoreCase("f"))
			gender=Gender.FEMALE;
		else if(val.equalsIgnoreCase("o"))
			gender=Gender.OTHER;
		
		return gender;
	}
	
}
