package leetcode.HasAlternatingBits;

public class HasAlternatingBits {

    public boolean hasAlternatingBits(int n) {
        int pre = n & 1;

        while (n > 0){
            n >>>= 1;
            int bit = n & 1;
            if(pre + bit != 1) return false;
            pre = bit;
        }

        return true;
    }
}
