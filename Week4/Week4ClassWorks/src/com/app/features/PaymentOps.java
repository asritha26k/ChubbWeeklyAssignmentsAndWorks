/*
 * package com.app.features;
 * 
 * import com.app.dto.Account;
 * 
 * public class PaymentOps {
 * 
 * public static void main(String[] args) { Account acc1 = new Account("1",
 * 500); Account acc2 = new Account("2", 1000);
 * 
 * fundTransfer(acc1, acc2, 250); }
 * 
 * public static boolean fundTransfer(Account acc1, Account acc2, double
 * transferAmount) {
 * 
 * if (acc1.balance() < transferAmount) {
 * System.out.println("no enough amount"); return false; } if (transferAmount <
 * 0) { System.out.println("wrong amount"); return false; }
 * 
 * Account updatedAcc1 = new Account(acc1.accountId(), acc1.balance() -
 * transferAmount); Account updatedAcc2 = new Account(acc2.accountId(),
 * acc2.balance() + transferAmount);
 * 
 * System.out.println("Transfer successful!");
 * System.out.println("Updated Account 1: " + updatedAcc1);
 * System.out.println("Updated Account 2: " + updatedAcc2);
 * 
 * return true; } }
 */
package com.app.features;

import com.app.dto.Account;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;
class AccountIdComparator implements Comparator<Account> {
    @Override
    public int compare(Account a1, Account a2) {
        return Double.compare(a1.balance(), a2.balance());
    }
}
public class PaymentOps {

    public static void main(String[] args) {
    	List<Account> accounts = List.of(
                new Account("3", 700),
                new Account("1", 500),
                new Account("2", 1000),
                new Account("5", 1200),
                new Account("4", 300)
            );
    	//sorted with comparator
    	Collections.sort(accounts, new AccountIdComparator());
    	
            
            List<Account> sortedAccounts = accounts.stream()
                    .sorted(Comparator.comparing(Account::accountId))
                    .collect(Collectors.toList());

            System.out.println("Accounts sorted by account number:");
            sortedAccounts.forEach(System.out::println);

            
            fundTransfer(sortedAccounts.get(0), sortedAccounts.get(1), 200);
    }

    public static boolean fundTransfer(Account acc1, Account acc2, double transferAmount) {

        Predicate<Double> isAmountNegative = amount -> amount < 0;
        Predicate<Double> isInsufficientBalance = amount -> acc1.balance() < amount;

        Consumer<String> alert = msg -> System.out.println( msg);

        if (isAmountNegative.test(transferAmount)) {
            alert.accept("Wrong amount entered!");
            return false;
        }

        if (isInsufficientBalance.test(transferAmount)) {
            alert.accept("Not enough balance in source account!");
            return false;
        }

       
        Supplier<Account> updatedAcc1 = () -> new Account(acc1.accountId(), acc1.balance() - transferAmount);
        Supplier<Account> updatedAcc2 = () -> new Account(acc2.accountId(), acc2.balance() + transferAmount);

        
        Consumer<Account> printAcc = acc -> System.out.println("Updated: " + acc);

        
        alert.accept("Transfer successful!");
        printAcc.accept(updatedAcc1.get());
        printAcc.accept(updatedAcc2.get());

        return true;
    }
}
