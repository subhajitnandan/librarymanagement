package com.library.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.library.Storage.LibraryStorage;
import com.library.model.Book;
import com.library.model.User;

public class LibraryManagementService {
public boolean addBook(Book book) {
	return LibraryStorage.getBookStore().add(book);
}
public boolean addUser(User user) {
	return LibraryStorage.getUserList().add(user);
}
public String lendBook(User user,Book book) {
	Set<Book> books= user.getBookList();
	if(books==null)
	{user.setBookList(new HashSet<>());
	books=user.getBookList();
	}
	if(books.size()>=user.getBookLimit()){
		return "user exhausted the maximum number of book borrowing limit";
	}
	if(book.isAvailable()){
		books.add(book);
		book.setAvailable(false);
		book.setUser(user.getUserId());
		return "Book is added Successfully";
	}
	else{
		return "Book is not available";
	}
}
public String returnBook(User user,Book book) {
	Set<Book> books= user.getBookList();
	books.remove(book);
	book.setAvailable(true);
	book.setUser(null);
	return "Book is returned Successfully";
	
}
public Book getBookByTitle(String title) {
	return LibraryStorage.getBookStore().stream().filter((l)->l.getTitle().equals(title)).findAny().orElse(null);
}
public List<Book> getBooksByAuthor(String author) {
return LibraryStorage.getBookStore().stream().filter((b)->b.getAuthor().equals(author)).collect(Collectors.toList());	
}
public User getUserByUserName(String title) {
	return LibraryStorage.getUserList().stream().filter((u)->u.getUserName().equals(title)).findFirst().orElse(null);
}
}
