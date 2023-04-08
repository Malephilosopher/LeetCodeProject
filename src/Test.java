import java.math.BigInteger;
import java.util.*;

public class Test {

    public static void main(String[] args) {

        System.out.println(Math.pow(10, 26) % 391);

    }

    // Stein算法——循环实现
    public static long gcd(long m, long n) {
        long k = 0;
        while (m != n) {
            if (m == 0)
                return n;
            if (n == 0)
                return m;
            if ((m & 1) == 0 && (n & 1) == 0) {
                m >>= 1;
                n >>= 1;
                k += 1;
            } else if ((m & 1) == 0){
                m >>= 1;
            } else if ((n & 1) == 0){
                n >>= 1;
            } else {
                long tmp = Math.abs(m - n);
                n = Math.min(m, n);
                m = tmp;
            }
        }
        return m << k;
    }

    public static long lcm(long m, long n) {
        return m * n / gcd(m, n);
    }


}
