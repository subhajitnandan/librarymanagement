package com.library.Storage;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.library.model.Book;
import com.library.model.User;

public class LibraryStorage {
private static Set<Book> bookStore=new HashSet<>();
private static Set<User> userList=new HashSet<>();
//private static Map<Integer,Set<Integer>> userBookList=new HashMap<>();
public static Set<Book> getBookStore() {
	return bookStore;
}
public static void setBookStore(Set<Book> bookStore) {
	LibraryStorage.bookStore = bookStore;
}
public static Set<User> getUserList() {
	return userList;
}
public static void setUserList(Set<User> userList) {
	LibraryStorage.userList = userList;
}
/*public static Map<Integer, Set<Integer>> getUserBookList() {
	return userBookList;
}
public static void setUserBookList(Map<Integer, Set<Integer>> userBookList) {
	LibraryStorage.userBookList = userBookList;
}*/

}
