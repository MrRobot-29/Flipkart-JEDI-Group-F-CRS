package com.flipkart.exception;

public class DemoException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10, b = 0, c;
		try {
			c = a/b;
			System.out.println("Exception raised in program " + c);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Some exception");
//			e.printStackTrace();
		} finally {
			System.out.println("End of prgm");
		}

	}

}
