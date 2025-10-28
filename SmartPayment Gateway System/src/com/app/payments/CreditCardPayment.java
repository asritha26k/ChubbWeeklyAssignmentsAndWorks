package com.app.payments;

import com.app.account.Account;
import com.app.benef.Beneficiary;
import com.app.exceptions.InsufficientBalanceException;
import com.app.exceptions.TransactionFailedException;

public class CreditCardPayment extends Payment implements Refundable,Retryable{

	public CreditCardPayment(int amount, Account account) {
		super(amount, account);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void retry() {
		// TODO Auto-generated method stub
		System.out.println("CreditCardPayment.retry()");
		
		
	}

	@Override
	public void refund() {
		// TODO Auto-generated method stub
		System.out.println("CreditCardPayment.refund()");
		
	}

	@Override
	public void processPayment(Beneficiary beneficiary) throws TransactionFailedException {
		try {
		account.debit(amount);
		System.out.println("for credit cardpayment->amount"+"debited to "+beneficiary.name);
		System.out.println("CreditCardPayment.processPayment()");
		}catch(Exception e) {
			throw new TransactionFailedException("CreditcardPayment failed",e);
		}
		
	}

}
