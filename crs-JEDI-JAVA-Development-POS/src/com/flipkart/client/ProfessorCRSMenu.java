package com.flipkart.client;

import java.util.Scanner;

public class ProfessorCRSMenu {
	
	
	
	public void createMenu(String user) {
		boolean isLogin = true;
		while(isLogin) {
			System.out.println("Login as : " + user + "\n");
			
			System.out.println("Enter your choise : ");
			System.out.println("1. viewCourse");
			System.out.println("2. View Enrolled Student");
			System.out.println("3. Add Grade");
			System.out.println("4. log out");
			
			Scanner sc = new Scanner(System.in);
			
			int selectedOption = sc.nextInt();
			
			boolean isExit = false;
			while(!isExit)
			{
				switch(selectedOption)
				{
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					isExit = true;
					break;
				default:
					break;
						
				}
			}
		}
		
	}

}
