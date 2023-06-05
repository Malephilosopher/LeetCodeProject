package WeekCompetition.Week_347;

public class P1 {

    public String removeTrailingZeros(String num) {
        int n = num.length();
        if(num.charAt(n - 1) != '0')return num;
        while (num.charAt(num.length() - 1) == '0'){
            num = num.substring(0, num.length() - 1);
        }

        if(num.length() == 0) num = "0";
        return num;
    }
}
