package leetcode.String.strStr;

public class SSPer {
    public static int strStr(String haystack, String needle) {
        if ("".equals(needle)) return 0;
        int n1 = haystack.length();
        int n2 = needle.length();
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = 0; i < n2; i++) {
//            stringBuilder.append(needle.charAt(i));
//        }
        for (int i = 0; i < n1 - n2 + 1; i++) {
            if(haystack.substring(i, i + n2).equals(needle))
            {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "issip";
        System.out.println(strStr(haystack, needle));
    }
}
