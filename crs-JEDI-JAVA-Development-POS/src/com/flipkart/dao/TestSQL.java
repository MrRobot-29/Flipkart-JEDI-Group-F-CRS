/**
 * 
 */
package com.flipkart.dao;
import com.flipkart.utils.*;
/**
 * @author ashwin.kumar2
 *
 */
public class TestSQL {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		
		StudentDaoImpl std = new StudentDaoImpl();
		
		var result = std.getStudentId("divya@gmail.com");
		
		System.out.println(result);
		
		var res2 = std.isApproved(2);
		
		System.out.println(res2);
		
//		DBUtils dbs = new DBUtils();
//		
//		dbs.getConnection();
		
	}

}
