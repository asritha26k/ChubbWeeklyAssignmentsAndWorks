package ForComparisions;

import java.util.*;

class Account implements Comparable<Account> {
    String accountHolderName;
    int accountNo;
    String transCode;
    String country;
    String ifscCode;
    double balance;

    public Account(String accountHolderName, int accountNo, String transCode,
                   String country, String ifscCode, double balance) {
        this.accountHolderName = accountHolderName;
        this.accountNo = accountNo;
        this.transCode = transCode;
        this.country = country;
        this.ifscCode = ifscCode;
        this.balance = balance;
    }

    // Comparable based on accountHolderName
    @Override
    public int compareTo(Account other) {
        return this.accountHolderName.compareTo(other.accountHolderName);
    }

    // Comparator for accountNo
    public static Comparator<Account> accountNoComparator = new Comparator<>() {
        @Override
        public int compare(Account a1, Account a2) {
            return Integer.compare(a1.accountNo, a2.accountNo);
        }
    };

    // Comparator for balance
    public static Comparator<Account> balanceComparator = new Comparator<>() {
        @Override
        public int compare(Account a1, Account a2) {
            return Double.compare(a1.balance, a2.balance);
        }
    };

    // equals and hashCode based on accountHolderName + accountNo
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account other = (Account) o;
        return this.accountNo == other.accountNo &&
               this.accountHolderName.equals(other.accountHolderName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountHolderName, accountNo);
    }

    @Override
    public String toString() {
        return accountHolderName + " | " + accountNo + " | " + balance;
    }
}
