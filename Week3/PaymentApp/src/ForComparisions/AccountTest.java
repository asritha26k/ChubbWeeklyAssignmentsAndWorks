package ForComparisions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AccountTest {
    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("Aashish Choudhary", 102, "T01", "India", "IFSC001", 5000.0));
        accounts.add(new Account("Ramesh Kumar", 101, "T02", "India", "IFSC002", 7000.0));
        accounts.add(new Account("Suresh Patel", 103, "T03", "India", "IFSC003", 3000.0));

        System.out.println("Original List:");
        accounts.forEach(System.out::println);

        System.out.println("\nSorted by accountHolderName (Comparable):");
        Collections.sort(accounts);
        accounts.forEach(System.out::println);

        System.out.println("\nSorted by accountNo (Comparator):");
        accounts.sort(Account.accountNoComparator);
        accounts.forEach(System.out::println);

        System.out.println("\nSorted by balance (Comparator):");
        accounts.sort(Account.balanceComparator);
        accounts.forEach(System.out::println);

        System.out.println("\nUnique Accounts (using HashSet):");
        Set<Account> uniqueAccounts = new HashSet<>(accounts);
        uniqueAccounts.forEach(System.out::println);
    }
}
