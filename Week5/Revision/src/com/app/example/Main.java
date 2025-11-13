package com.app.example;
import com.app.example.Author;
import com.app.example.Book;
import org.apache.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Calendar;

public class Main {

	public static void main(String[] args) {
		// String id,String title, List<Author> authors, String genre,Edition edition,float price,Date publishedDate
		List<Author> listOfAuthors = new ArrayList<>(Arrays.asList(new Author("Asritha"),new Author("Sabiha")));
		Calendar cal = Calendar.getInstance();
		cal.set(2005,Calendar.JANUARY, 26);
		Date publishedTime=cal.getTime();
		
		Book book = new Book(1,"Geetanjali",listOfAuthors,Genre.FICTION,Edition.BASIC,200.00f,publishedTime);
		System.out.println(book);
		
		final Logger logger = LogManager.getLogger(Main.class);//we use LogManager to get the logger instance
		//we give Main.class to associate the logger with this class
		//getLogger is a static method that returns a logger instance
		
		logger.info("Application started");
		logger.debug("Book created: " + book);
		logger.info("Application ended");
		

	}

}
