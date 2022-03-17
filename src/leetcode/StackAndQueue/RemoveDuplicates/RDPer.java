package leetcode.StackAndQueue.RemoveDuplicates;

public class RDPer {
    public static String removeDuplicates(String S) {

        if(S.length() == 1) return S;
        StringBuilder s = new StringBuilder(S);
        while(hasDuplicates(s.toString())){
            int l = s.length();
            for (int i = 1; i < l; i++) {
                if(s.charAt(i) == (s.charAt(i - 1)))
                {
                    s.delete(i - 1, i + 1);
                    break;
                }
            }
        }
        return s.toString();

    }
    public static boolean hasDuplicates(String s)
    {
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == (s.charAt(i - 1))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
    }
}
