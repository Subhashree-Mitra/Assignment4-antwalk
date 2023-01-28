package asn3;

import java.util.*;

public class Bank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		Customer c = new Customer();
		c.login();
		
		/*this label is used as when user exits he/she is directed to the login page,
		 * so after they log in, they must be directed to the menu so that they can
		 * operate their account
		 */
		
		repeat:
		while(true) {
			System.out.println("Select any one option: ");
			System.out.println("1. Deposit\n2. Withdrawal\n3. Check Balance\n4. Edit Profile\n5. Change Password\n6. EXIT");
			int ch = sc.nextInt();
			sc.nextLine();
			
			switch(ch) {
			
			case 1:
				c.deposit();
				break;
				
			case 2:
				c.withdrawal();
				break;
				
			case 3:
				c.checkBalance();
				break;
				
			case 4:
				c.editProfile();
				break;
				
			case 5:
				c.changePassword();
				break;
				
			case 6:
				break;
					
			default:
				System.out.println("WRONG CHOICE!!!");
				break;
			}
			
			System.out.println("Do you want to continue accessing the Bank application?");
			System.out.println("Type yes/no");
			String s = sc.nextLine();
			
			if(s.equals("yes"))
				continue;
			else {
				c.login = false;
				System.out.println("********************EXIT******************");
				System.out.println("Press Enter to redirect to the login page");
				sc.nextLine();
				c.login();
				continue repeat;
			}
			
		}
	}

}
