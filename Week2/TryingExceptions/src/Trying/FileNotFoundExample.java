package Trying;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileNotFoundExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
            FileReader file = new FileReader("test.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
	}

}
