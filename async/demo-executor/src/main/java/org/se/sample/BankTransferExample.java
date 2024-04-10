package org.se.sample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * поставщик потребитель на примере перевода денег между банковскими аккаунтами
 * ExecutorService (Runnable)
 */
public class BankTransferExample {
    public static void main(String[] args) {
        BankAccount accountA = new BankAccount("Account A", 1000);
        BankAccount accountB = new BankAccount("Account B", 1000);

        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(() -> {
            accountA.deposit(accountB, 100);
        });

        executor.submit(() -> {
            accountB.deposit(accountA, 50);
        });

        executor.shutdown();

        // Wait for all tasks to complete
        try {
            executor.awaitTermination(Long.MAX_VALUE, java.util.concurrent.TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        // Print the final balances
        System.out.println(accountA.getName() + " balance: " + accountA.getBalance());
        System.out.println(accountB.getName() + " balance: " + accountB.getBalance());
    }

    static class BankAccount {
        private final String name;
        private int balance;

        public BankAccount(String name, int balance) {
            this.name = name;
            this.balance = balance;
        }

        public String getName() {
            return name;
        }

        public int getBalance() {
            return balance;
        }

        public synchronized void deposit(BankAccount otherAccount, int amount) {
            if (balance >= amount) {
                balance -= amount;
                otherAccount.balance += amount;
                System.out.println(name + " transferred " + amount + " to " + otherAccount.getName());
            } else {
                System.out.println(name + " does not have sufficient balance to transfer to " + otherAccount.getName());
            }
        }
    }
}
