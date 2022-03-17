package 剑指Offer.Day19;

public class SumNums {

    public int sumNums(int n) {
        return n * (n + 1) >> 1;
    }

    int[] test=new int[]{0};
    public int sumNums1(int n) {
        try{
            return test[n];
        }catch(Exception e){
            return n+sumNums1(n-1);
        }
    }

    public static int quickMul(int a, int b){
        int ans = 0;
        while (b > 0){
            if((b & 1) == 1){
                ans += a;
            }
            a <<= 1;
            b >>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(quickMul(6, 6));
    }
}
