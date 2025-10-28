package Members;

import java.util.List;

import Books.Book;
import Exceptions.BookNotAvailableException;
import Exceptions.BookNotBorrowedException;
import Exceptions.BookNotFoundException;

public class Student extends People {
	public Student(String name, String department) {
		super(name, department);
	}

	@Override
	public void borrowBooks(String Bookname, List<Book> library)
			throws BookNotAvailableException, BookNotFoundException {

		boolean found = false;
		for (Book book : library) {
			if (book.name.equalsIgnoreCase(Bookname)) {
				if (book.count > 0) {
					System.out.println(Bookname + " is borrowed by " + name);
					found = true;
					book.count--;
					break;
				} else {
					found = true;
					throw new BookNotAvailableException(
							"All books of name " + name + " are borrowed, nothing left out");
				}
			}
		}
		if (!found) {
			throw new BookNotFoundException("there is no book named " + Bookname);
		}
	}

	@Override
	public void returnBooks(String Bookname, List<Book> library) throws BookNotBorrowedException {
		boolean found = false;
		for (Book b : borrowedBooks) {
			if (b.name.equals(Bookname)) {
				borrowedBooks.remove(Bookname);
				found = true;
				b.count++;
			}
		}
		if (!found) {
			throw new BookNotBorrowedException("You did not borrow this book " + Bookname);
		}
	}
}
