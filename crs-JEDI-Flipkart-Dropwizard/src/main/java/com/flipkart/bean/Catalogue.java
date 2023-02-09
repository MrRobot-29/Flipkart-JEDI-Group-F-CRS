package com.flipkart.bean;

import java.util.ArrayList;

public class Catalogue {

	private ArrayList<Course> catalogue;

	/**
	 * Constructor
	 * @param catalogue: list of courses in catalogue
	 */
	public Catalogue(ArrayList<Course> catalogue) {
		this.catalogue = catalogue;
	}

	/**
	 *
	 * @return returns the list of courses in catalogue
	 */
	public ArrayList<Course> getCatalogue() {
		return catalogue;
	}

	/**
	 *
	 * @param catalogue: list of courses in catalogue
	 */
	public void setCatalogue(ArrayList<Course> catalogue) {
		this.catalogue = catalogue;
	}

}
