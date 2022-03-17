package WeekCompetition.Week_258.ReversePrefix;

public class RPPer {

    public String reversePrefix(String word, char ch) {
        String c = Character.toString(ch);
        if(!word.contains(c)){
            return word;
        }

        int i = word.indexOf(ch);
        char[] chars = word.toCharArray();
        for (int j = 0; j <= i >> 1; j++) {
            char tmp = chars[j];
            chars[j] = chars[i - j];
            chars[i - j] = tmp;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char char1: chars) {
            stringBuilder.append(char1);
        }

        return stringBuilder.toString();

    }
}
