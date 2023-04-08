package WeekCompetition.Week_287;

public class ConvertTime {

    public static int convertTime(String current, String correct) {
        String[] strings = current.split(":");
        String[] string1 = correct.split(":");
        int h1 = Integer.parseInt(strings[0]);
        int m1 = Integer.parseInt(strings[1]);
        int h2 = Integer.parseInt(string1[0]);
        int m2 = Integer.parseInt(string1[1]);

        int hourDiff = h2 - h1;
        int minDiff = m2 - m1;
        int ans = 0;
        if(hourDiff == 0 && minDiff == 0) return 0;

        if(minDiff >= 0){
            ans += hourDiff;
        }else {
            ans += hourDiff - 1;
            minDiff = 60 - m1 + m2;
        }
        while (minDiff > 0){
            if(minDiff >= 15){
                int count = minDiff / 15;
                ans += count;
                minDiff -= count * 15;
            }else if(minDiff >= 5){
                int c = minDiff / 5;
                ans += c;
                minDiff -= c * 5;
            }else {
                ans += minDiff;
                break;
            }
        }


        return ans;
    }

    public static void main(String[] args) {
        System.out.println(convertTime("01:42", "02:42"));
    }
}
