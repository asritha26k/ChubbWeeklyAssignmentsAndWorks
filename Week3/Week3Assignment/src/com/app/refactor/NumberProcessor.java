package com.app.refactor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberProcessor {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenSquares = new ArrayList<>();

        // Imperative: filter even numbers and square them
        for (Integer n : numbers) {
            if (n % 2 == 0) {
                evenSquares.add(n * n);
            }
        }

        // Print results
        for (Integer n : evenSquares) {
            System.out.println(n);
        }
        
        List<Integer> evenSq = numbers.stream()
                .filter(n -> n % 2 == 0)  // keep even numbers
                .map(n -> n * n)          // square them
                .collect(Collectors.toList()); // collect to list

evenSq.forEach(System.out::println);

    }
}
