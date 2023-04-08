package WeekCompetition.Week_291;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class RemoveDigit {

    public String removeDigit(String number, char digit) {
        List<Integer> list = new ArrayList<>();
        int first = number.indexOf(digit);
        int last = number.lastIndexOf(digit);
        StringBuilder sb = new StringBuilder(number);
        if(first == last){
            return sb.deleteCharAt(first).toString();
        }
        for (int i = 0; i < number.length(); i++) {
            if(number.charAt(i) == digit){
                list.add(i);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            int index = list.get(i);
            if(index == last){

            }
            int num = Character.getNumericValue(sb.charAt(index + 1));
            int fir = Character.getNumericValue(sb.charAt(index));
            if(num > fir){
                return sb.deleteCharAt(index).toString();
            }
        }
        return "";
    }
}
