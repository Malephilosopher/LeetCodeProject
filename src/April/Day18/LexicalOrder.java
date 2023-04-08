package April.Day18;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LexicalOrder {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            ans.add(i);
        }

        ans.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return String.valueOf(o1).compareTo(String.valueOf(o2));
            }
        });

        return ans;

    }

    public List<Integer> lexicalOrder1(int n) {
        List<Integer> ans = new ArrayList<>();
        int number = 1;
        for (int i = 1; i <= n; i++) {
            ans.add(number);
            if(number * 10 <= n){
                number *= 10;
            }else {
                while (number % 10 == 9 || number + 1 > n){
                    number /= 10;
                }
                number++;
            }
        }

        return ans;

    }

}
