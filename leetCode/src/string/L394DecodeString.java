package string;

import java.util.LinkedList;
import java.util.List;

public class L394DecodeString {
    public String decodeString(String s) {
        int multi = 0;

        LinkedList<String> strs = new LinkedList<>();
        LinkedList<Integer> multis = new LinkedList<>();

        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c == '['){
                multis.addLast(multi);
                strs.addLast(sb.toString());
                multi = 0;
                sb = new StringBuilder();
            } else if(c == ']'){
                String cur = strs.removeLast();
                int count = multis.removeLast();
                StringBuilder tmp = new StringBuilder();
                for(int i = 0; i < count; i++) tmp.append(sb);
                sb.append(cur).append(tmp.toString());
            } else if(c >= '0' && c <='9'){
                multi = multi * 10 + Integer.parseInt(c+"");
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
