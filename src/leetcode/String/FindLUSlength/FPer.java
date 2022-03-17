package leetcode.String.FindLUSlength;

public class FPer {

    public int findLUSlength(String a, String b) {
        return !a.equals(b) ? Math.max(a.length(), b.length()) : -1;
    }
}
