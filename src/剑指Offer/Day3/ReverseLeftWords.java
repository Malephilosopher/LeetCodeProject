package 剑指Offer.Day3;

public class ReverseLeftWords {

    public String reverseLeftWords(String s, int n) {
        int len = s.length();
        char[] array = new char[len * 2];
        for (int i = 0; i < len; i++) {
            array[i] = s.charAt(i);
        }
        for (int i = 0; i < n; i++) {
            array[len++] = array[i];
        }
        return new String(array, n, len - n);
    }
}
