package com.app.payments;

import com.app.account.Account;
import com.app.benef.Beneficiary;
import com.app.exceptions.InsufficientBalanceException;
import com.app.exceptions.TransactionFailedException;

public class UPIPayment extends Payment implements Refundable,Retryable{

	public UPIPayment(int amount, Account account) {
		super(amount, account);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void retry() {
		System.out.println("UPIPayment.retry()");
		
		
	}

	@Override
	public void refund() {
		// TODO Auto-generated method stub
		System.out.println("UPIPayment.refund()");
		
		
	}

	@Override
	public void processPayment(Beneficiary beneficiary) throws TransactionFailedException {
		// TODO AutEo-generated method stub
		try {
		account.debit(amount);
		System.out.println("for UPI payment->amount"+"debited to"+beneficiary.name);
		}catch(Exception e) {
			throw new TransactionFailedException("UPIPayment failed",e);
		}
		
	}

}
