package com.app.functionalProgramming;

import java.util.Arrays;
import java.util.List;

class Student {
    String name;
    int marks;
    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class FPExample {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Alice", 90),
            new Student("Bob", 75),
            new Student("John", 82)
        );

        students.stream()
                .filter(s -> s.marks > 80)
                .map(s -> s.name.toUpperCase())
                .forEach(System.out::println);
    }
}
