package WeekCompetition.Week_341;

import java.util.Deque;
import java.util.LinkedList;

public class P3 {

    public int addMinimum(String word) {

        Deque<Character> stack = new LinkedList<>();
        int res = 0;

        for (char c: word.toCharArray()) {
            if(c == 'a'){
                if(stack.isEmpty()){
                    stack.push(c);
                }else {
                    if(stack.peek() == 'a'){
                        stack.pop();
                        res += 3;
                        stack.push(c);
                    }else if(stack.peek() == 'b'){
                        res += 3;
                        stack.pop();
                        stack.pop();
                        stack.push(c);
                    }
                }
            }
            else if(c == 'b'){
                if(stack.isEmpty()){
                    stack.push('a');
                    stack.push(c);
                }
                else {
                    char up = stack.peek();
                    if(up == 'a')stack.push(c);
                    else if(up == 'b'){
                        stack.pop();
                        stack.pop();
                        stack.push('a');
                        stack.push(c);
                        res += 3;
                    }
                }
            }else{
                if(stack.isEmpty()){
                    res += 3;
                }
                else if(stack.peek() == 'a') {
                    res += 3;
                    stack.pop();
                }else if(stack.peek() == 'b'){
                    res += 3;
                    stack.pop();
                    stack.pop();
                }
            }
        }
        if(!stack.isEmpty()){
            res += 3;
        }

        return res - word.length();

    }

    public static void main(String[] args) {
        P3 p = new P3();
        System.out.println(p.addMinimum("aaaabb"));
        System.out.println(p.addMinimum("b"));
        System.out.println(p.addMinimum("abc"));
        System.out.println(p.addMinimum("cba"));

    }
}
