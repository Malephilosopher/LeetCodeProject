package leetcode.Bank;

public class Bank {

    long[] storage;
    int n;

    public Bank(long[] balance) {
        storage = balance;
        n = storage.length;
    }

    public boolean transfer(int account1, int account2, long money) {
        if(account1 < 1 || account1 > n || account2 < 1 || account2 > n)return false;
        long origin1 = storage[account1 - 1];
        long origin2 = storage[account2 - 1];
        if(account1 == account2) return origin1 >= money;
        if(origin1 < money) return false;
        origin1 -= money;
        origin2 += money;
        storage[account1 - 1] = origin1;
        storage[account2 - 1] = origin2;
        return true;
    }

    public boolean deposit(int account, long money) {
        if(account < 1 || account > n) return false;
        storage[account - 1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if(account < 1 || account > n) return false;
        long origin = storage[account - 1];
        if(origin < money) return false;
        origin -= money;
        storage[account - 1] = origin;
        return true;
    }
}
