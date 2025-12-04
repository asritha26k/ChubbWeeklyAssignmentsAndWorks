package com.app.main;

import java.util.*;

import com.app.dto.AccountBalaneException;
import com.app.dto.Customer;
import com.app.dto.NEFTProcessFund;
import com.app.process.ProcessPayment;
import java.io.*;
public class FundTransfer {

	public int count;//heap
	public static void main(String[] args) throws FileNotFoundException,IOException {
		
      System.out.println("This is test");
      
     
     
    	  System.out.println("Inside a catch");
   
     
      FundTransfer fdobj = new FundTransfer();
     
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