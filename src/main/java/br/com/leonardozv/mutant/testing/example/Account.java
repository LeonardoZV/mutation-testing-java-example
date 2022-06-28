package br.com.leonardozv.mutant.testing.example;

public class Account {

    private double balance;

    public Account(double amount) {
        this.balance = amount;
    }

    public double getBalance() {
        return balance;
    }

    public void credit(double amount) {
        balance = balance + amount;
    }

    public void debit(double amount) throws BalanceCannotBecomeNegativeException {

        double newBalance = balance - amount;

        if (newBalance < 0)
            throw new BalanceCannotBecomeNegativeException();

        balance = newBalance;

    }

}