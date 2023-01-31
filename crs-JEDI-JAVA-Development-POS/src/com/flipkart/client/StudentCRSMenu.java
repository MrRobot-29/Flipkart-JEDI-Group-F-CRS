package com.flipkart.client;

import java.util.Scanner;

public class StudentCRSMenu {
	static boolean isLoggedIn = true;
	public void createMenu()
	{
		Scanner sc = new Scanner(System.in);
		while(isLoggedIn == true)
		{
			System.out.println("Welcome to Student Menu !!");
			System.out.println("1. Generate Course List");
			System.out.println("2. Register Course");
			System.out.println("3. Add Course");
			System.out.println("4. Drop Course");
			System.out.println("5. Approved Course");
			System.out.println("6. Pay Fee");
			System.out.println("7. View Grades");
			System.out.println("8. Log Out");
			System.out.println("Enter Your Choice: ");
			
			int selectedOption = sc.nextInt();
			
			switch(selectedOption)
			{
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				isLoggedIn = false;
				break;
			case 9:
				System.out.println("Invalid Choice!! Try Again");
			}
			
		}
		
	}

}
