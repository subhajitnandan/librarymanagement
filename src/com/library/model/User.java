package com.library.model;

import java.util.Set;

public class User {
	
public User(Integer userId, String userName, String name, Integer bookLimit) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.name = name;
		this.bookLimit = bookLimit;
	}
private Integer userId;
private String userName;
private String name;
private Integer bookLimit;
private Set<Book> bookList;
public Integer getUserId() {
	return userId;
}
public void setUserId(Integer userId) {
	this.userId = userId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public Integer getBookLimit() {
	return bookLimit;
}
public void setBookLimit(Integer bookLimit) {
	this.bookLimit = bookLimit;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

public Set<Book> getBookList() {
	return bookList;
}
public void setBookList(Set<Book> bookList) {
	this.bookList = bookList;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + ((userName == null) ? 0 : userName.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	User other = (User) obj;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	if (userName == null) {
		if (other.userName != null)
			return false;
	} else if (!userName.equals(other.userName))
		return false;
	return true;
}
@Override
public String toString() {
	return "User [userId=" + userId + ", userName=" + userName + ", name=" + name + ", bookLimit=" + bookLimit
			+ ", bookList=" + bookList + "]";
}



}
