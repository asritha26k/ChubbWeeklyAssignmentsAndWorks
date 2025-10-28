package Books;

public class Book {
	public int id;
	public String name;
	public String genre;
	public String author;
	public int count;

	public Book(int id, String name, String genre, String author, int count) {
		super();
		this.id = id;
		this.name = name;
		this.genre = genre;
		this.count = count;
		this.author = author;
	}

	@Override
	public String toString() {
		return name + " by " + author + " (" + genre + "), Available: " + count;
	}
}
