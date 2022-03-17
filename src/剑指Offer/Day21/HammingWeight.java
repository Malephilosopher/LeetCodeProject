package 剑指Offer.Day21;

public class HammingWeight {

    public int hammingWeight(int n) {
        int ans = 0;
        while (n != 0){
            ans += n & 1;
            n >>>= 1; //>>>：无符号右移
        }
        return ans;
    }
}
