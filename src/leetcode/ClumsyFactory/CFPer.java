package leetcode.ClumsyFactory;

import java.util.Deque;
import java.util.LinkedList;

public class CFPer {
    public static int clumsy(int N) {
        if(N == 1) return 1;
        int ans = 0;
        Deque<Integer> stack = new LinkedList<>();
        int[] nums = new int[N];
        for (int i = N; i > 0; i--) {
            nums[N - i] = i;
        }
        for (int i = 0; i < N; i++) {
            if(i % 4 == 0)
            {
                stack.push(nums[i]);
            }
            if(i % 4 == 1)
            {
                stack.push(stack.pop() * nums[i]);
            }
            if(i % 4 == 2)
            {
                stack.push(stack.pop() / nums[i]);
                ans += stack.pop();
            }
            if(i % 4 == 3)
            {
                ans += nums[i];
            }
        }
        if(!stack.isEmpty())
        {
            ans = Math.abs(ans - stack.pop());
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(clumsy(n));
    }
}
