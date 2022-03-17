package WeekCompetition.Week_278;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @Author Ivan Vladimir Xu
 * @Date 2022/1/30 11:00
 */
public class SubStrHash {

    private long[] powers;

    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        int n = s.length();
        powers = new long[n];
        powers[0] = 1;

        for (int i = 1; i < k; i++) {
            powers[i] = powers[i - 1] * power % modulo;
        }
        for (int i = 0; i <= n - k; i++) {
            String sub = s.substring(i, i + k);
            if(hash(sub, modulo) == hashValue){
                return sub;
            }
        }
        return s;
    }

    public int hash(String sub, int m){
        int n = sub.length();
        long hash = 0;
        for (int i = 0; i < n; i++) {
            hash += (sub.charAt(i) - 'a' + 1) * powers[i];
        }
        hash %= m;
        return (int)hash;
    }

    public static void main(String[] args) {
        String s = "xqgfatvtlwnnkxipmipcpqwbxihxblaplpfckvxtihonijhtezdnkjmmk";
        SubStrHash subStrHash = new SubStrHash();
        System.out.println(subStrHash.subStrHash(s, 22, 51, 41, 9));
        System.out.println(subStrHash.hash("xqgfatvtlwnnkxipmipcpqwbxihxblaplpfckvxti", 51));
    }
}
