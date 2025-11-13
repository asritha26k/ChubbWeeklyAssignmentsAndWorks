package com.app.example;

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

	}

}
