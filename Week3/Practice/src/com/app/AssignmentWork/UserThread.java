package com.app.AssignmentWork;

class UserThread extends Thread {
    private Account account;
    private String user;
    private int amount;

    public UserThread(Account account, String user, int amount) {
        this.account = account;
        this.user = user;
        this.amount = amount;
    }

    public void run() {
        account.withdraw(user, amount);
    }
}
