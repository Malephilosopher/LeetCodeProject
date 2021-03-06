package leetcode.AddDigits;

public class APer{

    public int addDigits(int num) {
        if(num == 0) return 0;
        if (num % 9 == 0) return 9;
        return num % 9;
    }

    public int addDigits1(int num) {
        while (num >= 10) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }

}
