package 网易笔试;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class P2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        int n = Integer.parseInt(line[0]);
        long k = Integer.parseInt(line[1]);
        long x = Integer.parseInt(line[2]);
        List<Long> list = new ArrayList<>();
        for (long i = 1; i <= k; i++) {
            if(x >= i){
                x -= i;
                list.add(i);
            }
        }
        int len = list.size();
        if(x > 0){
            list.set((int) (len - x), list.get((int) (len - x)) + x);
        }

        if(len < n) {
            System.out.println(-1);
            return;
        }else if(len == n){
            for (int i = 0; i < len; i++) {
                System.out.println(list.get(i));
            }
            return;
        }

        int diff = len - n;
        int size = len;
        list.sort(Comparator.comparingLong(a->a));
        for (int i = 0; i < diff; i++) {
            for (int j = 0; j < size - 1; j++) {
                long sum = list.get(j) + list.get(size - 1 - j);
                if(sum <= k && !list.contains(sum)){
                      list.remove(list.get(j));
                      list.remove(list.get(size - 2 - j));
                      list.add(sum);
                      size--;
                      break;
                }
            }
        }
        if(size > n){
            System.out.println(-1);
            return;
        }else {
            for (int i = 0; i < size; i++) {
                System.out.println(list.get(i));
            }
        }




    }
}
