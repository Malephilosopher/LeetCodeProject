package 携程笔试;

import java.util.*;

public class p3 {

    final static int MOD = 1000000007;
    static List<Integer> nums;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String line = sc.nextLine();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(line.split(" ")[i]);
            list.add(a);
        }
        int value = 0;
        nums = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int count = count(list.get(i)) % MOD;
            map.put(list.get(i), count);
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {

            }
        }
        System.out.println(value % MOD);
    }

    public static int count(int num){
        int ans = 0;
        for (int i = 2; i < num / 2; i++) {
            if(!valid(i))continue;
            if(nums.contains(i))continue;
            if(num % i == 0){
                nums.add(i);
                ans++;
            }
        }
        if(valid(num))ans++;nums.add(num);
        return ans;
    }

    public static boolean valid(int num){
        for (int i = 2; i < 10; i++) {
            if(num % i == 0 && num != i){
                return false;
            }
        }
        return true;
    }
}
