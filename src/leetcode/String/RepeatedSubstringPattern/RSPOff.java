package leetcode.String.RepeatedSubstringPattern;

public class RSPOff {

    public boolean repeatedSubstringPattern(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }
}
