package com.library;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.library.model.Book;
import com.library.model.User;
import com.library.service.LibraryManagementService;

public class Library {
	private static Integer userIdGenerator=1000;
	private static Integer bookIdGenerator=5000;
	public static void main(String[] args) {
		LibraryManagementService service=new LibraryManagementService();

		while(true){
			try{
			System.out.println("please provide input for following action: \n 1 for add user \n 2 for add book \n 3 for lend book \n 4 for return book \n 5 for get user details by user name \n 2 for get book details by title \n 3 for get book details by author \n 0 exit");
			Scanner in=new Scanner(System.in);
			int input=in.nextInt();
			switch (input) {
			case 1:
				System.out.println("Kindly Add user details \n enter Name:");
				String a=in.next();
				System.out.println("Kindly Add book limit \n enter limit:");
				int b=in.nextInt();
				User user=new User(userIdGenerator,a+userIdGenerator, a, b);
				boolean flag=service.addUser(user);
				if(!flag)System.out.println("User exist");
				else 
				{
					System.out.println(user.getUserName());
					userIdGenerator++;
				};
				break;
			case 2:
				System.out.println("Kindly Add book details \n enter Name:");
				String x=in.next();
				System.out.println("\n author Name:");
				String y=in.next();
				Book book=new Book(bookIdGenerator,x, y, true);
				flag=service.addBook(book);
				if(!flag)System.out.println("book exist");
				else 
				{
					System.out.println(book.getBookId());
					bookIdGenerator++;
				};
				break;
			case 3:
				System.out.println("Kindly provide user details \n enter Name:");
				String username=in.next();
				User user2=service.getUserByUserName(username);
				if(user2!=null){
					System.out.println("\n enter book Name:");
					String bookname=in.next();
					Book book1=service.getBookByTitle(bookname);
					if(book1!=null)
						service.lendBook(user2, book1);
					else System.out.println("book doesnot exist");
				}
				else{
					System.out.println("user doest not exist");
				}
				break;
			case 4:
				System.out.println("Kindly provide user details \n enter Name:");
				username=in.next();
				user2=service.getUserByUserName(username);
				if(user2!=null){
					System.out.println("\n enter book Name:");
					String bookname=in.next();
					Book book1=service.getBookByTitle(bookname);
					if(book1!=null)
						service.returnBook(user2, book1);
					else System.out.println("book doesnot exist");
				}
				else{
					System.out.println("user doest not exist");
				}
				break;
			case 5:
				System.out.println("Kindly provide user details \n enter Name:");
				username=in.next();
				User user3=service.getUserByUserName(username);
				System.out.println(user3!=null?user3:"user does not exist");
				break;
			case 6:
				System.out.println("Kindly provide book details \n enter title:");
				String title=in.next();
				Book book2=service.getBookByTitle(title);
				System.out.println(book2!=null?book2:"book does not exist");
				
				break;
			case 7:
				System.out.println("Kindly provide book details \n enter author Name:");
				String author=in.next();
				List<Book> book3=service.getBooksByAuthor(author);
				System.out.println(book3!=null?book3:"book does not exist");
				break;
			default:
				in.close();
				System.exit(0);
				break;
			}
			}
			catch(InputMismatchException e){
				System.out.println("Wrong input try again");
			}
		}
	}
}
