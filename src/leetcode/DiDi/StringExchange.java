package leetcode.DiDi;

import java.util.Arrays;
import java.util.Scanner;

/*
给一个字符串s，你可以至多选择两个不同位置的字符进行交换（可以选择不交换，保留原串），问所有可能中字典序最小的串。

有关字典序：对于长度相同的串a和串b，串a的字典序小于串b当且仅当存在一个位置i使得串a和串b的前i-1个字符完全相同且串a的第i个字符小于串b的第i个字符。即a1=b1,a2=b2,...ai-1=bi-1且ai<bi。



输入描述
一行一个字符串s，保证串中都为小写字母('a'~'z')。字符串长度<=200000

输出描述
输出一个串t，表示所有可能中字典序最小的串。


样例输入
aaazbcdeadcd
样例输出
aaaabcdezdcd
 */
public class StringExchange {
    public static String exchangeString(String s)
    {
        int n = s.length();
        String ans = s;
        char[] temp = s.toCharArray();
        Arrays.sort(temp);
        int smallest = 0;
        int largest = 0;
        int left = 0;
        int right = n - 1;
        while(left < n)
        {
            if(s.charAt(left) == s.charAt(largest))
            {
                left++;
                continue;
            }
            if(s.charAt(left) > s.charAt(largest))
            {
                largest = left;
                break;
            }

        }
        while(right >= 0)
        {
            if(s.charAt(right) == temp[0])
            {
                smallest = right;
                break;
            }
            right--;
        }
        ans = exchange(s, largest, smallest);
        return ans;
    }

    public static String exchange(String s, int num1, int num2)
    {
        int n = s.length();
        char[] tmp = s.toCharArray();
        char temp = tmp[num2];
        tmp[num2] = tmp[num1];
        tmp[num1] = temp;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder.append(tmp[i]);
        }
        return stringBuilder.toString();
    }

    public static boolean dicOrder(String s1, String s2)
    {
        int i = 0;
        int n = s1.length();
        while(i < n)
        {
            if(s1.charAt(i) == s2.charAt(i))
            {
                i++;
                continue;
            }
            if(s1.charAt(i) < s2.charAt(i))
            {
                return true;
            }
            if(s1.charAt(i) > s2.charAt(i))
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
        String s = "aceadzaca";
        System.out.println(exchangeString(s));
    }
}
//小郁做法
class Solution {
    public static void main(String[] args) {
        String str = "aceadzaca";
        System.out.println(solution(str));
    }
    public static String solution(String input) {
        int[] map = new int[26];
        char[] chars = input.toCharArray();
        for (char c : chars) {
            map[c - 'a']++;
        }
        boolean isSwapped = false;
        for (int i = 0; i < chars.length; i++) {
            map[chars[i] - 'a']--;
            for (int j = 0; j < chars[i] - 'a'; j++) {
                if (map[j] > 0) {
                    char swap = chars[i];
                    chars[i] = (char) (j + 'a');
                    isSwapped = true;
                    for (int h = chars.length - 1; h >= 0; h--) {
                        if (chars[h] - 'a' == j) {
                            chars[h] = swap;
                            break;
                        }
                    }
                    break;
                }
            }
            if (isSwapped) {
                break;
            }
        }
        return String.valueOf(chars);
    }
}

