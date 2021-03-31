package stack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class L150EvalRPN {
    public static void main(String[] args) {
        L150EvalRPN m = new L150EvalRPN();
        m.evalRPN(new String [] {"4","13","5","/","+"});
    }

    public int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<>();
        Map<String, Integer> sym = new HashMap<>();
        sym.put("+", 1);
        sym.put("-", 2);
        sym.put("*", 3);
        sym.put("/", 4);

        for(int i = 0; i < tokens.length; i++){
            String each = tokens[i];
            Integer operator = sym.get(each);
            if(operator != null){
                Integer aft = stack.pop();
                Integer pre = stack.pop();
                Integer then;
                switch(operator){

                    case 1 :
                        then = pre + aft;
                        break;
                    case 2 :
                        then = pre - aft;
                        break;
                    case 3 :
                        then = pre * aft;
                        break;
                    case 4 :
                        then = pre / aft;
                        break;
                    default:
                        throw new IllegalArgumentException("please check your input");
                }
                stack.push(then);
            } else {
                stack.push(Integer.parseInt(each));
            }
        }
        return stack.pop();
    }
}
