package 携程笔试;

import java.util.Scanner;

public class p2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < t; i++) {
            String line = sc.nextLine();
            int a = Integer.parseInt(line.split(" ")[0]);
            int b = Integer.parseInt(line.split(" ")[1]);
            int sum = 0;
            while (b > 0){
                int bit = b % 10;
                if(bit == 0) {
                    b /= 10;
                    continue;
                }
                sum += bit;
                b /= 10;
            }
            System.out.println(sum * a);
        }
    }
}
