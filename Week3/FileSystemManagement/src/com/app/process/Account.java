package com.app.process;

import java.io.*;
import java.util.*;

class Account {
    String accountHolderName;
    String country;
    String ifscCode;
    long accountNo;
    double balance;

    public Account(String accountHolderName, String country, long accountNo, String ifscCode, double balance) {
        this.accountHolderName = accountHolderName;
        this.country = country;
        this.accountNo = accountNo;
        this.ifscCode = ifscCode;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return accountHolderName + " (" + ifscCode + ") - " + balance;
    }
}
