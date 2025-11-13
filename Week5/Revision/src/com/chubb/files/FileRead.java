package com.chubb.files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.*;

public class FileRead {
public static void main(String[] args) {
	try {
	BufferedReader bufferedReader = new BufferedReader(new FileReader("sample.txt"));
	String line;
	int count=0;
//	while((line = br.readLine()) != null) {
//		String [] words = line.split(" ");
//		for(String word: words) {
//			if(word.equalsIgnoreCase("India"))
//			count++;
//		}
//	}

//	while((line = br.readLine()) != null) {
//		String [] words = line.split(" ");
//		count +=(int) Arrays.stream(words)
//				.filter(word -> word.equalsIgnoreCase("India"))
//				.count();
//	}
	long c = bufferedReader.lines().flatMap(l-> Arrays.stream(l.split(" "))).filter(word->word.equalsIgnoreCase("India")).count();
	
	
	//System.out.println("The word 'India' occurred " + count + " times in the file.");
	System.out.println("The word 'India' occurred " + c + " times in the file.");

	bufferedReader.close();
	} catch (Exception e) {
		e.printStackTrace();
	
}
	
}
}
