package com.flipkart.data;

import java.util.ArrayList;

import com.flipkart.bean.Course;

public class TempData {

	private ArrayList<Course> courseList = new ArrayList<Course>();
	
	
	
	
	public TempData() {
		super();
		for(int i = 0; i < 100; i++) {
			Course c = new Course("Course" + (i+1),"crs-id-"+(i+1),"ins-"+(i+1), true, 100.1);
			courseList.add(c);
		}
	}




	public ArrayList<Course> getCourseList() {
		return courseList;
	}




	public void setCourseList(ArrayList<Course> courseList) {
		this.courseList = courseList;
	}
}
