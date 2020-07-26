package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import dao.LoginDAO;
import dao.RegistrationDAO;
import model.Login;
import model.Registration;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Enter your choice\n1. Register\n2. Login");
		int x = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		x = Integer.parseInt(br.readLine());
		
		//objects
		Registration registration = new Registration();
		RegistrationDAO registrationDAO = new RegistrationDAO();
		
		switch(x) {
		case 1:
			System.out.println("Enter first name");
			String firstName = br.readLine();
			System.out.println("Enter last name");
			String lastName = br.readLine();
			System.out.println("Enter user name");
			String userName = br.readLine();
			System.out.println("Enter password");
			String password = br.readLine();
			System.out.println("Enter email");
			String email = br.readLine();
			
			registration.setFirstName(firstName);
			registration.setLastName(lastName);
			registration.setUserName(userName);
			registration.setPassword(password);
			registration.setEmail(email);
			
			registrationDAO.addUser(registration);
			break;
		case 2:
			loginWithDB();
			break;
		}
	}

	private static void loginWithDB() throws IOException, ClassNotFoundException, SQLException {
		Login login = new Login();
		LoginDAO loginDAO = new LoginDAO();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		System.out.println("Enter user name");
		String username = br.readLine();
		System.out.println("Enter password");
		String pass = br.readLine();
		
		login.setUserName(username);
		login.setPassword(pass);
		
		if(loginDAO.validate(login) == true) {
			System.out.println("You successfully login through Oracle Database");
		}
		else {
			System.out.println("Please enter valid options");
			loginWithDB();
		}				
	}
}
