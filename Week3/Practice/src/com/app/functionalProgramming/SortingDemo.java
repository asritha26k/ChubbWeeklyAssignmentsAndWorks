package com.app.functionalProgramming;
import java.util.Arrays;
import java.util.List;

public class SortingDemo {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Asritha", "arjun", "Bala", "charlie");

        // 1. Using Lambda:
        // The lambda takes two strings and calls the compareToIgnoreCase method on the first one.
        // names.sort((s1, s2) -> s1.compareToIgnoreCase(s2));

        // 2. Using Method Reference:
        // String::compareToIgnoreCase refers to an instance method of an arbitrary String object.
        // The JVM understands that List.sort(Comparator) needs two arguments, which are supplied.
        names.sort(String::compareToIgnoreCase); 

        System.out.println("Case-Insensitive Sorted List: " + names);

	}

}
