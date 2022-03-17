package 携程笔试;

import java.util.Scanner;

public class p4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int a = Integer.parseInt(line.split(" ")[0]);
        int b = Integer.parseInt(line.split(" ")[1]);
        String line1 = sc.nextLine();
        int c = Integer.parseInt(line1.split(" ")[0]);
        int d = Integer.parseInt(line1.split(" ")[1]);
        int e = Integer.parseInt(line1.split(" ")[2]);
        StringBuilder sb = new StringBuilder();
        sb.append(c);
        sb.append(d);
        sb.append(e);
        String cur = c + " " + d + " " + e;
        while (!isPalindrome(sb.toString())){
            if(d > a){
                c++;
                d = 1;
                continue;
            }
            if(e > b){
                d++;
                e = 0;
                continue;
            }
            e++;
            sb = new StringBuilder();
            sb.append(c);
            sb.append(d);
            sb.append(e);
            cur = c + " " + d + " " + e;
        }
        System.out.println(cur);
    }

    public static boolean isPalindrome(String s){
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if(s.charAt(i) != s.charAt(n - i - 1)){
                return false;
            }
        }
        return true;
    }
}
