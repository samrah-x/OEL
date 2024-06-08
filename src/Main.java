
import java.util.Scanner;

public class Main {
	static Scanner scanner;
    static Database database;
    public static void main(String[] args) {

        database = new Database();
    System.out.println("Welcome to Library Managemenet System!");
        int option;
        do {
            System.out.println("""
                               0. Exit
                               1. Login
                               2. New User""");
            scanner = new Scanner(System.in);
            option = scanner.nextInt();

            switch (option) {
                case 1 : login();
                case 2 : newUser();
                default : System.out.println("Error! Enter valid option.");
            }
        }
        while (option !=0);

        
        
    }
    private static void login() {
        System.out.println("Enter phone number: ");
        String phonenumber = scanner.next();
        System.out.println("Enter email: ");
        String email = scanner.next();
        int n = database.login(phonenumber, email);
        if (n != -1) {
            User user = database.getUser(n);
            //System.out.println("Welcome!" + user.getName());
            user.menu(database, user);
        }
        else {
        	System.out.println("User doesnt exist");
        }
    }

    private static void newUser() {
        System.out.println("Enter name: ");
        String name = scanner.next();
        System.out.println("Enter phone number: ");
        String phonenumber = scanner.next();
        System.out.println("Enter email: ");
        String email = scanner.next();
        System.out.println("1. Admin\n2. Member");
        int option = scanner.nextInt();
        User user;
        if(option == 1) {
            user = new Admin(name, email, phonenumber);
            //database.AddUser(admin);
        }
        else {
            user = new Member(name, email, phonenumber);
            //database.AddUser(user);
        }
        database.AddUser(user);
        user.menu(database, user);
        // System.out.println("User created succesfully!");
    }

}
