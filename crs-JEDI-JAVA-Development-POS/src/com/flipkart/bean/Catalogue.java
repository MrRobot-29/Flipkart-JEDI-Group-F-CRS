package com.flipkart.bean;

import java.util.ArrayList;

public class Catalogue {
	private ArrayList<Course> catalogue;

	public Catalogue(ArrayList<Course> catalogue) {
		this.catalogue = catalogue;
	}

	public ArrayList<Course> getCatalogue() {
		return catalogue;
	}

	public void setCatalogue(ArrayList<Course> catalogue) {
		this.catalogue = catalogue;
	}

}
