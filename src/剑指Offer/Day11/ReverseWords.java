package 剑指Offer.Day11;

public class ReverseWords {

    public String reverseWords(String s) {
        s = s.trim();
        int l = 0;

        char[] chars = s.toCharArray();
        int r = chars.length - 1;
        while (l < r){
            swap(chars, l , r);
            l++;
            r--;
        }

        int front = 0;
        int end = 0;
        while (front < chars.length){
            while (end < chars.length && chars[end] == ' ')end++;
            front = end;
            while (front < chars.length && chars[front] != ' ')front++;
            front--;
            int le = end;
            int ri = front;
            while (le < ri){
                swap(chars, le , ri);
                le++;
                ri--;
            }
            if(front == chars.length - 1) break;
            end = front + 1;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(chars));
        for (int i = 0; i < sb.length() - 1; i++) {
            if(sb.charAt(i) == ' '){
                i++;
                while (sb.charAt(i) == ' '){
                    sb.deleteCharAt(i);
                }
            }
        }
        return sb.toString();
    }

    public void swap(char[] chars, int l, int r){
        char temp = chars[l];
        chars[l] = chars[r];
        chars[r] = temp;
    }

    public static void main(String[] args) {
        ReverseWords r = new ReverseWords();
        System.out.println(r.reverseWords("   a   b  c d   e  "));
    }
}
