
import java.util.Scanner;

public class AddBook implements IOOperation{
	@Override
	public void oper(Database database, User user) {
		
				Scanner s = new Scanner(System.in);
		Book book = new Book();
		System.out.println("Enter book name: ");
		book.setName(s.next());
		System.out.println("Enter book author: ");
		book.setAuthor(s.next());
		System.out.println("Enter book publisher: ");
		book.setPublisher(s.next());
		System.out.println("Enter Book collection address: ");
		book.setAddress(s.next());
		System.out.println("Enter book Qty: ");
		book.setQty(s.nextInt());
		System.out.println("Enter book Price: ");
		book.setPrice(s.nextDouble());
		System.out.println("Enter book Borrowing Copies: ");
		book.setBrwcopies(s.nextInt());
		
		database.AddBook(book);
		System.out.println("Book added successfully!\n");
		
		s.close();
		
		user.menu(database, user);
	}
}
