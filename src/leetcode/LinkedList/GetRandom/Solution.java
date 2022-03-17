package leetcode.LinkedList.GetRandom;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @Author Ivan Vladimir Xu
 * @Date 2022/1/16 10:27
 */
public class Solution {

    ListNode head;
    Random random;

    public Solution(ListNode head) {
        this.head = head;
        random = new Random();
    }

    public int getRandom() {
        int i = 1, ans = 0;
        for (ListNode node = head; node != null; node = node.next) {
            if (random.nextInt(i) == 0) { // 1/i 的概率选中（替换为答案）
                ans = node.val;
            }
            ++i;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int ans = 0;
        while(scan.hasNext()){
            String line = scan.nextLine();
            String[] l = line.split("       ");
            System.out.println(Arrays.toString(l));
            String price = l[1];
            String discount = l[2];
            double p = Double.parseDouble(price);
            double d = 0;
            if(discount.charAt(0) == '半') {
                d = 0.5;
            }else {
                discount = discount.substring(0, discount.length() - 1);
                d = Double.parseDouble(discount);
                if(d > 10){
                    d /= 100;
                }else {
                    d /= 10;
                }
            }
            ans += p * d;
        }
        System.out.println(ans);
            scan.close();
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}