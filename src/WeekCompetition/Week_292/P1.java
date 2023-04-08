package WeekCompetition.Week_292;

public class P1 {

    public String largestGoodInteger(String num) {
        int n = num.length();
        String max = "000";
        boolean found = false;
        for (int i = 0; i <= n - 3; i++) {
            String sub = num.substring(i, i + 3);
            if(sub.charAt(0) == sub.charAt(1) && sub.charAt(2) == sub.charAt(1)){
                found = true;
                if(Integer.parseInt(sub) > Integer.parseInt(max)){
                    max = sub;
                }
            }
        }
        if(!found)return "";
        return max;
    }

    public static void main(String[] args) {

    }
}
