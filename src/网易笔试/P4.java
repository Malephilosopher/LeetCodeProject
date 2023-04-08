package 网易笔试;

import java.util.HashMap;
import java.util.Scanner;

public class P4 {

    static HashMap<Long, Integer> map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] nums = new long[n];
        sc.nextLine();
        String[] line = sc.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            nums[i] = Long.parseLong(line[i]);
        }
         map = new HashMap<>();

        long[] prefix = new long[n];
        long m = 1;
        for (int i = 0; i < n; i++) {
            prefix[i] = m * nums[i];
            m = prefix[i];
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                long mul = 0;
                if(i == 0){
                    mul = prefix[j];
                }else {
                    if(prefix[Math.max(0, i - 1)] == 0){
                        mul = 0;
                    }else {
                        mul = prefix[j] / prefix[Math.max(0, i - 1)];
                    }
                }
                int p = 0;
                if(map.containsKey(mul)){
                    p = map.get(mul);
                }else {
                    p = Long.numberOfTrailingZeros(mul);
                    map.put(mul, p);
                }
                ans += p;
            }
        }
        System.out.println(ans);
    }
}
