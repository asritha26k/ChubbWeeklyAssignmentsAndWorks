package com.app.AssignmentWork;

class Account {
    private int balance = 1000;

    public synchronized void withdraw(String user, int amount) {
        if (balance >= amount) {
            System.out.println(user + " is going to withdraw " + amount);
            try { Thread.sleep(100); } catch (InterruptedException e) {}
            balance -= amount;
            System.out.println(user + " completed withdrawal. Remaining balance: " + balance);
        } else {
            System.out.println(user + " tried to withdraw " + amount + " but insufficient balance!");
        }
    }
}