package com.app.files;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class FileReading {
public static void main(String[] args) throws IOException {
	System.out.println("File Reading Example");
	try {
	BufferedReader reader = new BufferedReader(new FileReader("Students.txt"));
	String text;
	while((text=reader.readLine())!=null) {
		System.out.println(text);
	}
	}catch(IOException e) {
		System.out.println("File not found");
	}
	
	try(FileWriter fileWriter = new FileWriter("Students.txt",true)){
		fileWriter.write("\npragna\n");
		System.out.println("File written successfully");
	}catch(IOException e) {
		System.out.println("Error writing to file");
	}
	
}
}