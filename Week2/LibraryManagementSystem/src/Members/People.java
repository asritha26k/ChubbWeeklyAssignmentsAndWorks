package Members;

import java.util.ArrayList;
import java.util.List;

import Books.Book;
import Exceptions.BookNotAvailableException;
import Exceptions.BookNotBorrowedException;
import Exceptions.BookNotFoundException;

public abstract class People {
	public String name;
	public String department;
	public List<Book> borrowedBooks = new ArrayList<>();

	public People(String name, String department) {
		this.name = name;
		this.department = department;

	}

	public abstract void borrowBooks(String name, List<Book> library)
			throws BookNotAvailableException, BookNotFoundException;

	public abstract void returnBooks(String name, List<Book> library) throws BookNotBorrowedException;

}
