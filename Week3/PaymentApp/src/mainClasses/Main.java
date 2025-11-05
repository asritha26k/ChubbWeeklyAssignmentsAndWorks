package mainClasses;

import java.io.FileNotFoundException;
import java.io.IOException;
import com.app.dto.Customer;
import com.app.dto.NEFTProcessFund;



public class Main {

	public int count;
	public static void main(String[] args) throws FileNotFoundException,IOException {
		
      System.out.println("This is test");
      
     
     
    	  System.out.println("Inside a catch");
   
     
      Main fdobj = new Main();
     
      Customer c1 = new Customer("James","james@gmail.com","43432432442",4343);
      
      Customer c2 = new Customer("Robin","robin@gmail.com","43432432441",50000);
      
   
      
      NEFTProcessFund neftobj = new NEFTProcessFund();
      
      
      System.out.println("customer balance intiator" + c1.getAmountbalance());
      System.out.println("customer balance bene" + c2.getAmountbalance());
      boolean isValidCustomer = neftobj.validateCustomer(c2);
      if(isValidCustomer) {
     try {
		neftobj.processFund(c1, c2, 3000);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      }else {
    	  System.out.println("is not valid customer");
      }
      
      	
	}

}
