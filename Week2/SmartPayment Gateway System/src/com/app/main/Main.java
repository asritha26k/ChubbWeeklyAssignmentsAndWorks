package com.app.main;

import com.app.account.Account;
import com.app.benef.Beneficiary;
import com.app.exceptions.BeneficiaryNotFoundException;
import com.app.exceptions.TransactionFailedException;
import com.app.payments.CreditCardPayment;
import com.app.payments.Payment;
import com.app.payments.UPIPayment;

public class Main {

	public static void main(String[] args) throws BeneficiaryNotFoundException {
		// TODO Auto-generated method stub
		Beneficiary [] arr = { new Beneficiary("Thanuja"),new Beneficiary("Kalyan")};
		Payment [] payment = {new UPIPayment(-100,new Account(1000)),
				new CreditCardPayment(20,new Account(50))};
		for(Payment p:payment) {
			
				try {
					p.processPayment(arr[0]);
				} catch (TransactionFailedException e) {
					
					e.printStackTrace();
				}
			
			
		}
		boolean found=false;
		String search ="Asritha";
		for(Beneficiary b:arr) {
			if(!b.name.equals(search)) {
				found=true;
			}
		
		
		}
		if(!found) {
			throw new BeneficiaryNotFoundException("Benfeciary not found");
		}
		

	}

}
