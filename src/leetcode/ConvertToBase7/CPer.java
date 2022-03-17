package leetcode.ConvertToBase7;

public class CPer {

    public String convertToBase7(int num) {
        StringBuilder sb = new StringBuilder();
        boolean neg = false;
        if(num < 0) {
            num = -num;
            neg = true;
        }
        while (num > 0){
            sb.append(num % 7);
            num /= 7;
        }

        sb.reverse();
        return (neg ? "-" : "") + sb;
    }
}
