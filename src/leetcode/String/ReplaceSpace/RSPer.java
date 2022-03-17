package leetcode.String.ReplaceSpace;

public class RSPer {
    public String replaceSpace(String s) {
        int n = s.length();
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = s.substring(i, i + 1);
        }
        for (int i = 0; i < n; i++) {
            if(strings[i].equals(" "))
            {
                strings[i] = "%20";
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            stringBuilder.append(strings[i]);
        }
        return stringBuilder.toString();
    }
}
