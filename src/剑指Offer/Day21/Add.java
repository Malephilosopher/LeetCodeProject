package 剑指Offer.Day21;

public class Add {

    public int add(int a, int b) {
        while (b != 0){
            //先算进位和
            int c = (a & b) >> 1;
            a ^= b; //非进位和
            b = c;//进位和就是新的b
        }
        return a;
    }
}
