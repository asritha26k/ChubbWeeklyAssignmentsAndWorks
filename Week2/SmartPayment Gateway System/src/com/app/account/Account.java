package com.app.account;

import com.app.exceptions.InsufficientBalanceException;
import com.app.exceptions.InvalidAmountException;

public class Account {
	double balance;
	public Account(double balance){
		this.balance=balance;
	}
	//credit,debit,balance
	public double getBalance() {
		return balance;
	}
	//credit
	public void credit(double amount) {
		balance+=amount;
		System.out.println("amount credited,available balance is"+balance);
	}
	public void debit(double amount) throws InvalidAmountException, InsufficientBalanceException {
		if(amount<=0) {
			throw new InvalidAmountException("not sufficient amount");
		}else if(balance<=0 || balance<amount) {
			throw new InsufficientBalanceException("insufficient bal");
		}
	}
}
