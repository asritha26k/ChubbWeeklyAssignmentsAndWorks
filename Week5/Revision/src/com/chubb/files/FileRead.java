package com.chubb.files;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileRead {
public static void main(String[] args) {
	try {
	BufferedReader br = new BufferedReader(new FileReader("sample.txt"));
	String line;
	int count=0;
	while((line = br.readLine()) != null) {
		String [] words = line.split(" ");
		for(String word: words) {
			if(word.equalsIgnoreCase("India"))
			count++;
		}
	}
	System.out.println("The word 'India' occurred " + count + " times in the file.");
	br.close();
	} catch (Exception e) {
		e.printStackTrace();
	
}
	
}
}
