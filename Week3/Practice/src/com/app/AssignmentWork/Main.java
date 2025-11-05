package com.app.AssignmentWork;

public class Main {
    public static void main(String[] args) {
        Account account = new Account();

        UserThread t1 = new UserThread(account, "User1", 700);
        UserThread t2 = new UserThread(account, "User2", 700);

        t1.start();
        t2.start();
    }
}
