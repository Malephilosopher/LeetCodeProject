package leetcode.LongestCommonPrefix;

//横向扫描
public class LCPPer {
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        StringBuilder stringBuilder = new StringBuilder();
        char tmp = ' ';
        int pointer = 0;
        int count = 1;
        int minLength = strs[0].length();
        for (String s: strs) {
            minLength = Math.min(s.length(), minLength);
        }
        stringBuilder.append("");
        while(pointer <= minLength - 1)
        {
            tmp = strs[0].charAt(pointer);
            for (int i = 0; i < strs.length; i++) {
                if(strs[i].charAt(pointer) != tmp)
                {
                    return stringBuilder.toString();
                }
            }
            stringBuilder.append(tmp);
            pointer++;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
