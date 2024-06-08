import java.util.Scanner;

public class Member extends User {
    
    public Member (String name) {
        super(name);
		this.operation = new IOOperation[] {
    			new ViewBooks(),
        		new Search(),
        		new PlaceOrder(),
        		new BorrowBook(),
        		new CalculateFine(),
        		new ReturnBook(),
        		new Exit()
    	};
    }

    public Member (String name, String email, String phonenumber) {
        super(name, email, phonenumber);
		 this.operation = new IOOperation[] {
	    			new ViewBooks(),
	        		new Search(),
	        		new PlaceOrder(),
	        		new BorrowBook(),
	        		new CalculateFine(),
	        		new ReturnBook(),
	        		new Exit()
	    	};
    }

    @Override
	public void menu(Database database, User user) {
    	System.out.println("1. View Books");
    	System.out.println("2. Search");
    	System.out.println("3. Place Order");
    	System.out.println("4. Borrow Book");
    	System.out.println("5. Calulate fine");
    	System.out.println("6. Return Book");
    	System.out.println("7. Exit");
    	
    	Scanner s = new Scanner(System.in);
    	int n = s.nextInt();
    	this.operation[n-1].oper(database,user);
    	s.close();
    }
    
    public String toString() {
        String text = name + "<N/>" + email + "<N/>" + phonenumber + "<N/>" + "Member"; 
        return text;
    }
}