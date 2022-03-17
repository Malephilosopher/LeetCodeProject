package 携程笔试;

import java.util.Scanner;

public class p1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String code = sc.nextLine();
        int n = code.length();
        code.trim();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = code.charAt(i);
            if(c == '<' || c == '>' || c == '='){
                sb.append(code.substring(0, i).trim() + " ");
                sb.append(c);
                sb.append(" " + code.substring(i + 1, n).trim());
                break;
            }
        }
        System.out.println(sb);
    }
}
