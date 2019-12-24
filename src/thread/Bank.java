package thread;

import java.util.Arrays;

/**
 * Bank
 */
public class Bank {

    private final double[] accounts;

    public Bank(int n, double initBalance) {
        accounts = new double[n];
        Arrays.fill(accounts, initBalance);
    }

    public void transfer(int from, int to, double amount) {
        if(accounts[from] < amount) {
            return;
        }
        System.out.print(Thread.currentThread());
        accounts[from] -= amount;
        System.out.printf(" %10.2f from %d to %d", amount, from, to);
        accounts[to] += amount;
        System.out.printf(" Total balance: %10.2f%n", getTotal());
    }

    public double getTotal() {
        double total = 0;

        for (double balance : accounts) {
            total += balance;
        }
        
        return total;
    }

    public int size() {
        return accounts.length;
    }
}