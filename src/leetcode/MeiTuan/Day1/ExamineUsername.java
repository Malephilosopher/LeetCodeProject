package leetcode.MeiTuan.Day1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

/**
 * @Author Ivan Vladimir Xu
 * @Date 2022/1/30 17:09
 */
public class ExamineUsername {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();
        List<String> strings = new ArrayList<>();
        while (T > 0){
            String username = scanner.nextLine();
            strings.add(username);
            T--;
        }
        for (int i = 0; i < strings.size(); i++) {
            examine(strings.get(i));
        }

    }

    public static void examine(String username){
        int n = username.length();
        if(n < 3) {
            System.out.println("Wrong");
            return;
        }
        if(!Character.isAlphabetic(username.charAt(0))){
            System.out.println("Wrong");
            return;
        }
        boolean hasNum = false;
        for (int i = 1; i < n; i++) {
            if(!Character.isAlphabetic(username.charAt(i)) && !Character.isDigit(username.charAt(i))){
                System.out.println("Wrong");
                return;
            }
            if(Character.isDigit(username.charAt(i))){
                hasNum = true;
            }
        }
        if(!hasNum){
            System.out.println("Wrong");
            return;
        }
        System.out.println("Accept");

    }


}
