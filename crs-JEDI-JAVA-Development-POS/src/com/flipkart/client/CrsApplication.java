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
		
		
		
		boolean isExit = false;
		while(!isExit)
		{
			int selectedOption = sc.nextInt();
			switch(selectedOption)
			{
			case 1:
				System.out.println("Enter user name : ");
				String userName = sc.next();
				System.out.println("Enter Password : ");
				String password = sc.next();
				System.out.println("Enter Role : ");
				String role = sc.next();
				if(role.equals("professor")) {
					ProfessorCRSMenu professorMenu = new ProfessorCRSMenu();
					professorMenu.createMenu(userName);
				}
				else if(role.equals("student")) {
					StudentCRSMenu studentMenu = new StudentCRSMenu();
					studentMenu.createMenu(userName);
				}
				else if(role.equals("admin")) {
					AdminCRSMenu adminMenu = new AdminCRSMenu();
					adminMenu.createMenu(userName);
				}
				else
				{
					System.out.println("Invalid Role!!");
				}
				break;
			case 2:
				
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
