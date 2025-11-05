package com.app.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;



import java.util.*;

public class TryComparator {
    public static void main(String[] args) {
        Student s1 = new Student("John", "22");
        Student s2 = new Student("Alice", "20");
        Student s3 = new Student("Bob", "21");
        ArrayList<Student> students = new ArrayList<>(Arrays.asList(s1, s2, s3));

        // Anonymous class
        Comparator<Student> byName = new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getName().compareTo(s2.getName());
            }
        };

        // Lambda
        Comparator<Student> lambdaByName = (a, b) -> a.getName().compareTo(b.getName());

        // ✅ Method reference (cleanest)
        Comparator<Student> byNameMethodRef = Comparator.comparing(Student::getName);

        Collections.sort(students, byNameMethodRef);
        for (Student s : students) {
            System.out.println(s.getName() + " " + s.getAge());
        }
    }
}


  class Student { private String name; private String age;
  
  public Student(String name, String age) { this.name = name; this.age = age; }
  
  public String getName() { return name; }
  
  public String getAge() { return age; } 
  }
 