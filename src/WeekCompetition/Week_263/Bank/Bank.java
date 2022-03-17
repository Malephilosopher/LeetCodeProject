package WeekCompetition.Week_263.Bank;

/**
 * @Author Ivan Vladimir Xu
 * @Date 2021/10/17 10:42
 */
public class Bank {

    long[] balance;

    public Bank(long[] balance) {
        this.balance = balance;
    }

    public boolean transfer(int account1, int account2, long money) {
        int n = balance.length;
        if(account1 < 1 || account1 > n || account2 < 1 || account2 > n){
            return false;
        }
        long bal1 = balance[account1 - 1];
        long bal2 = balance[account2 - 1];
        if(bal1 - money < 0){
            return false;
        }
        balance[account1 - 1] -= money;
        balance[account2 - 1] += money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if(account < 1 || account > balance.length){
            return false;
        }
        balance[account - 1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if(account < 1 || account > balance.length){
            return false;
        }
        if(balance[account - 1] - money < 0){
            return false;
        }
        balance[account - 1] -= money;
        return true;
    }
}
