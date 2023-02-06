package com.flipkart.client;

import java.sql.Connection;
import java.util.Scanner;

import com.flipkart.helper.DaoHelper;
import com.flipkart.service.UserServiceOperation;

/**
 * This class is used as the main entry point of the application
 */
public class CrsApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner sc = new Scanner(System.in);
		 
		UserServiceOperation uso = new UserServiceOperation();
		boolean isExit = false;
		while(!isExit)
		{
			Connection conn = null;
			conn = DaoHelper.getConnection();
			System.out.println("Welcome to the CRS Applicatoin Choose the Option given below ->");
			System.out.println("1. Login ");
			System.out.println("2. Registration of Student");
			System.out.println("3. Update Password ");
			System.out.println("4. Exit ");
			int selectedOption = sc.nextInt();
			switch(selectedOption)
			{
			case 1:
				// login
				uso.loginAccount();
				break;
			case 2:
				// student registration
				uso.registerAccount();
				break;
			case 3:
				
				break;
			case 4:
				isExit = true;
//				System.exit(0);
				break;
			default:
				break;
					
			}
		}
		
		

	}

}
