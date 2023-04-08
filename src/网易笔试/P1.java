package 网易笔试;

import java.util.Scanner;

public class P1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0, j = n; i < n && j > 0; i++, j--) {
            for (int k = j; k > 0; k--) {
                System.out.print(".");
            }
            for (int k = 0; k < 4 * n - 2 * j; k++) {
                System.out.print("*");
            }
            for (int k = j; k > 0; k--) {
                System.out.print(".");
            }
            System.out.println();
        }
        for (int i = 0; i < 2 * n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < 2 * n; j++) {
                System.out.print(".");
            }
            for (int j = 0; j < n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 0, j = 1; i < n && j <= n; i++, j++) {
            for (int k = 0; k < j; k++) {
                System.out.print(".");
            }
            for (int k = 0; k < 4 * n - 2 * j; k++) {
                System.out.print("*");
            }
            for (int k = 0; k < j; k++) {
                System.out.print(".");
            }
            System.out.println();
        }
    }
}
