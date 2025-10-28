package LibraryMain;

import java.util.ArrayList;
import java.util.List;

import Books.Book;
import Members.Student;
import Members.Teacher;

public class Main {
	public static void main(String[] args) {
		List<Book> library = new ArrayList<>();
		library.add(new Book(1, "The Alchemist", "Fiction", "Paulo Coelho", 2));
		library.add(new Book(2, "Brief History of Time", "Science", "Stephen Hawking", 1));

		Student s1 = new Student("Asritha", "CSE");
		Teacher t1 = new Teacher("Dr. Rao", "Physics");

		try {
			s1.borrowBooks("The Alchemist", library);
			s1.borrowBooks("The Alchemist", library); // should still work (2 copies)
			s1.borrowBooks("The Alchemist", library); // should throw BookNotAvailableException
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		try {
			t1.borrowBooks("Unknown Book", library); // should throw BookNotFoundException
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		try {
			s1.returnBooks("The Alchemist", library);
			s1.returnBooks("The Alchemist", library);
			s1.returnBooks("The Alchemist", library); // should throw BookNotBorrowedException
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		System.out.println("\nFinal Library Status:");
		for (Book b : library) {
			System.out.println(b);
		}

	}
}
