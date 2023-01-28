package asn3;

import java.util.*;

abstract class Account{
	String accountId;
	String description;
	double minimumBalance;
	
	abstract void display();
		
}

class Current extends Account{
	
	Current(){
		super.minimumBalance = 0;
	}
	
	@Override
	void display() {
		System.out.println("Account Id: " + super.accountId);
		System.out.println("Description: " + super.description);
		System.out.println("Minimum Balance: " + super.minimumBalance);
	}
	
}

class Saving extends Account{
	
	Saving(){
		super.minimumBalance = 500;
	}
	
	@Override
	void display() {
		System.out.println("Account Id: " + super.accountId);
		System.out.println("Description: " + super.description);
		System.out.println("Minimum Balance: " + super.minimumBalance);
	}
}

public class AccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		Current c = new Current();
		Saving s = new Saving();
		
		System.out.println("Current account details: ");
		System.out.println("Enter account id: ");
		c.accountId = sc.nextLine();
		System.out.println("Enter description of current account:");
		c.description = sc.nextLine();
		
		System.out.println("Saving account details: ");
		System.out.println("Enter account id: ");
		s.accountId = sc.nextLine();
		System.out.println("Enter description of saving account:");
		s.description = sc.nextLine();
		
		System.out.println("CURRENT ACCOUNT DETAILS");
		c.display();
		System.out.println();
		System.out.println("SAVING ACCOUNT DETAILS");
		s.display();
		
	}

}
