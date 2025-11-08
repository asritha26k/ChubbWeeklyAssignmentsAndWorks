package LL;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

public class FileStream {

	public static void main(String[] args) throws IOException {
		try(BufferedReader reader = new BufferedReader(new FileReader("Sales.csv"))){
			String line;
			while((line=reader.readLine())!=null) {
				//String [] data = line.split(",");
				//OrderID	Product	Category	Quantity	Price	Region	Date
				//System.out.println("OrderID: "+data[0]+" Product: "+data[1]+" Category: "+data[2]+" Quantity: "+data[3]+" Price: "+data[4]+" Region: "+data[5]+" Date: "+data[6]);
				Stream<String> dataStream = Stream.of(line.split(","));
				dataStream.forEach((String l)-> System.out.print(  " | "+l ));
				System.out.println();
			}
			
		}catch(Exception e) {
			System.out.println("Error reading file: "+e.getMessage());
		}

	}

}
