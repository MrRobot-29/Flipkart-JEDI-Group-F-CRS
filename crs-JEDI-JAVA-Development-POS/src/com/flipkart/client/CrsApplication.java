package com.flipkart.client;

import java.util.Scanner;
import com.flipkart.client.*;
import com.flipkart.service.StudentService;
import com.flipkart.service.StudentServiceOperation;

public class CrsApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to the CRS Applicatoin Choose the Option given below ->");
		System.out.println("1. Login ");
		System.out.println("2. Registration of Student");
		System.out.println("3. Update Password ");
		System.out.println("4. Exit ");
		
		Scanner sc = new Scanner(System.in);
		
		int selectedOption = sc.nextInt();
		
		boolean isExit = false;
		while(!isExit)
		{
			switch(selectedOption)
			{
			case 1:
				System.out.println("Enter user name : ");
				
				System.out.println("Enter Password : ");
				System.out.println("Enter Role : ");
				String role = sc.next();
				if(role == "professor") {
					ProfessorCRSMenu professorMenu = new ProfessorCRSMenu();
					professorMenu.createMenu();
				}
				
				break;
			case 2:
				System.out.println("Enter user name : ");
				System.out.println("Enter Password : ");
				System.out.println("Enter Role : ");
				break;
			case 3:
				System.out.println("Enter user name : ");
				System.out.println("Enter Password : ");
				System.out.println("Enter Role : ");
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
