

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Database {
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<String> usernames = new ArrayList<>();
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<String> booknames = new ArrayList<>();
    
    private File usersFile = new File("C:\\chaljabhai\\Data\\Users");
    private File booksFile = new File("C:\\chaljabhai\\Data\\Books");
    private File folder = new File("C:\\chaljabhai\\Data");
    
    public Database() {
    	if(!folder.exists()) {
    		folder.mkdir();
    	}
    	if(!usersFile.exists()) {
    		try {
    			usersFile.createNewFile();
    		}
    		catch(Exception e){
    		}
    		
    	}
    	if(!booksFile.exists()) {
    		try {
    			booksFile.createNewFile();
    		}
    		catch(Exception e){
    		}
    	}
        getUsers();
        getBooks();
    }
    
    public void AddUser(User s ) {
        users.add(s);
        usernames.add(s.getName());
        saveUsers();
    }

    public int login(String phonenumber, String email) {
        int n = -1;
        for (User s : users) {
            if (s.getPhoneNumber().matches(phonenumber) && s.getEmail().matches(email)) {
                n = users.indexOf(s);
                break;
            }
        }
        return n;
    }

    public User getUser(int n) {
        return users.get(n);
    }
    
    public void AddBook(Book book) {
    	books.add(book);
    	booknames.add(book.getName());
    	saveBooks();
    }

    private void getUsers() {
        String text1 = "";
        try {
            BufferedReader br1 = new BufferedReader(new FileReader(usersFile));
            String s1;
            while ((s1 = br1.readLine()) != null) {
                text1 += s1;
            }
            br1.close();
        }
        catch (Exception e) {
            System.err.println(e.toString());
        }
        
        if (!text1.matches("") || !text1.isEmpty()) {
            String[] a1 = text1.split("<NewUser/>");
            for (String s : a1) {
                String[] a2 = s.split("<N/>");
                if (a2[3].matches("Admin")) {
                    User user = new Admin(a2[0], a2[1], a2[2]);
                    users.add(user);
                    usernames.add(user.getName());
                }
                else {
                    User user = new NormalUser(a2[0], a2[1], a2[2]);
                    users.add(user);
                    usernames.add(user.getName());
                    
                }
            }
        }
    }


    private void saveUsers() {
        String text1 = "";
        for (User user : users) {
            text1 = text1 + users.toString() + "<NewUser/>\n";
        }
        try {
            PrintWriter pw = new PrintWriter(usersFile);
            pw.print(text1);
            pw.close();
           // System.err.println("Data Saved!");
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
    private void saveBooks() {
        String text1 = "";
        for (Book book : books) {
            text1 = text1 + book.toString2() + "<NewBook/>\n";
        }
        try {
            PrintWriter pw = new PrintWriter(booksFile);
            pw.print(text1);
            pw.close();
           // System.err.println("Data Saved!");
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }


private void getBooks() {
    String text1 = "";
    try {
        BufferedReader br1 = new BufferedReader(new FileReader(booksFile));
        String s1;
        while ((s1 = br1.readLine()) != null) {
            text1 += s1;
        }
        br1.close();
    }
    catch (Exception e) {
        System.err.println(e.toString());
    }
    
    if (!text1.matches("") || !text1.isEmpty()) {
        String[] a1 = text1.split("<NewBook/>");
        for (String s : a1) {
        	Book book = parseBook(s);
        	books.add(book);
        	booknames.add(book.getName());
        }
    }
}
	public Book parseBook(String s) {
		String[] a = s.split("<N/>");
		Book book = new Book();
		book.setName(a[0]);
		book.setAuthor(a[1]);
		book.setPublisher(a[2]);
		book.setAddress(a[3]);
		book.setQty(Integer.parseInt(a[4]));
		book.setPrice(Double.parseDouble(a[5]));
		book.setBrwcopies(Integer.parseInt(a[0]));
		return book;
	}
	public ArrayList<Book> getAllBooks(){
		return books;
	}
}