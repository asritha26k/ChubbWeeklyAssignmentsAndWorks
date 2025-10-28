package com.app.payments;

import com.app.account.Account;
import com.app.benef.Beneficiary;
import com.app.exceptions.TransactionFailedException;

public abstract class Payment {
	int amount;
	Account account;
	Payment(int amount,Account account){
		this.amount=amount;
		this.account=account;
		
	}
	public abstract void processPayment(Beneficiary beneficiary) throws TransactionFailedException;
}
