package leetcode.greedy.LemonadeChange;

public class LCPer {

    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int i = 0; i < bills.length; i++) {
            switch (bills[i]) {
                case 5:{
                    five += 1;
                }
                case 10 :{
                    ten += 1;
                    if (five < 1) return false;
                    five--;
                }
                case 20:{
                    if (five < 1) {
                        return false;
                    } else {
                        if (ten < 1 && five < 3) {
                            return false;
                        } else if (ten > 0) {
                            ten--;
                            five--;
                        } else {
                            five -= 3;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] bills = {5,5,5,10,5,5,10,20,20,20};
        LCPer lcPer = new LCPer();
        System.out.println(lcPer.lemonadeChange(bills));
    }
}
