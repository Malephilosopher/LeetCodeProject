package WeekCompetition.Week_263.AreNumbersAscending;

/**
 * @Author Ivan Vladimir Xu
 * @Date 2021/10/17 10:31
 */
public class APer {

    public boolean areNumbersAscending(String s) {
        int pre = -1;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if(Character.isDigit(s.charAt(i))){
                int num = 0;
                if(i != n - 1 && Character.isDigit(s.charAt(i + 1))){
                    num = Integer.parseInt(s.substring(i, i + 2));
                    i++;
                }else {
                    num = Integer.parseInt(s.substring(i, i + 1));
                }
                if(num <= pre){
                    return false;
                }else {
                    pre = num;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "hello world 5 x 5";
        APer a = new APer();
        System.out.println(a.areNumbersAscending(s));
    }
}
