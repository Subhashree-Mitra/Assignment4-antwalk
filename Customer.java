package asn3;

import java.util.*;

public class Customer implements Validation {
	
	//attributes mentioned in the question
	//Can be accessed only by instance methods
	
	private String name;
	private String username;
	private String password;
	private int age;
	private String ssn;
	private String address;
	private String email;
	private long phone;
	private double balance;
	
	//user defined variables
	private Scanner sc = new Scanner(System.in);
	public boolean login = false;
	private double deposit;
	private double withdraw;
	
	@Override
	public void validateSSN(String ssn) {
		if(ssn.length() != 9) {
			System.out.println("INVALID SSN. It should contain 9 digits");
		}
		else {
			try {
				long ssnNumber = Long.parseLong(ssn);
				System.out.println("VALID SSN");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
				System.out.println("INVALID SSN. It should contain numeric values only");
			}
			
		}
	}
	
	@Override
	public void validateAge(int age) {
		if(age <= 18) {
			System.out.println("INVALID AGE");
			System.out.println("Age must be greater than 18 years");
		}
		else
			System.out.println("VALID AGE");
	}
	
	public void login() {
		System.out.println("---------------------------LOGIN PAGE--------------------------");
		System.out.println("********************Welcome to XYZ Bank Ltd. ******************");
		
		System.out.println("Do you want to login?");
		System.out.println("Type yes/no");
		String ch = sc.nextLine();
		
		if(ch.equals("yes")) {
			System.out.println("Enter username: ");
			username = sc.nextLine();
			System.out.println("Enter password: ");
			password = sc.nextLine();
			login = true;
			System.out.println("User logged in successfully\n");
		}
		else {
			System.out.println("Close the login window");
			System.exit(0);
		}
	}
	
	public void deposit() {
		if(login) {
			System.out.println("Enter the amount you want to deposit: ");
			deposit = sc.nextDouble();
			sc.nextLine();
			balance += deposit;
		}
	}
	
	public void withdrawal() {
		if(login) {
			System.out.println("Enter the amount you want to withdraw: ");
			withdraw = sc.nextDouble();
			sc.nextLine();
			balance -= withdraw;
		}
	}
	
	public void checkBalance() {
		if(login)
			System.out.print("The current balance in your account is: " + balance);
		System.out.println();
	}
	
	public void editProfile() {
		if(login) {
			System.out.println("PROFILE DETAILS");
			System.out.println("Name: " + name);
			System.out.println("Age: " + age);
			System.out.println("Address: " + address);
			System.out.println("Email: " + email);
			System.out.println("Phone: " + phone);
			System.out.println("SSN: " + ssn);
			
			System.out.println("\nWant to edit profile?");
			System.out.println("Type yes/no");
			String ch = sc.nextLine();
			
			if(ch.equals("no"))
				return;
			else {
				while(true) {
					System.out.println("Select an option to edit: ");
					System.out.println("1. Name\n2. Age\n3. Address\n4. Email\n5. Phone\n6. SSN");
					int c = sc.nextInt();
					sc.nextLine();
					
					switch(c) {
					case 1:
						System.out.println("Enter name: ");
						name = sc.nextLine();
						break;
						
					case 2:
						System.out.println("Enter age: ");
						age = sc.nextInt();
						sc.nextLine();
						validateAge(age);
						break;
						
					case 3:
						System.out.println("Enter address: ");
						address = sc.nextLine();
						break;
						
					case 4:
						System.out.println("Enter email: ");
						email = sc.nextLine();
						break;
						
					case 5:
						System.out.println("Enter phone: ");
						phone = sc.nextLong();
						sc.nextLine();
						break;
						
					case 6:
						System.out.println("Enter SSN: ");
						ssn = sc.nextLine();
						validateSSN(ssn);
						break;
						
					default:
						System.out.println("WRONG CHOICE!!!");
						break;
					}
					
					System.out.println("Want to continue editing?");
					System.out.println("Press 1 to continue\nPress 0 to exit");
					int choice = sc.nextInt();
					sc.nextLine();
					if(choice == 1)
						continue;
					else {
						System.out.println("EXIT from Edit Profile");
						break;
					}
				}
			}
		}
	
	}
	
	public void changePassword() {
		if(login) {
			System.out.println("Enter current password: ");
			String current = sc.nextLine();
			
			if(password.equals(current)) {
				System.out.println("Enter new password: ");
				String newPass = sc.nextLine();
				System.out.println("Confirm new password: ");
				String confirm = sc.nextLine();
				if(newPass.equals(confirm)) {
					password = confirm;
					System.out.println("PASSWORD CHANGED");
				}
				else {
					System.out.println("Password doesn't match");
					System.out.println("Call the function again");
				}	
			}
			else {
				System.out.println("WRONG PASSWORD\nUnauthorised user");
				System.out.println("Call the function again");
			}
		}
		
	}
	
	

}
