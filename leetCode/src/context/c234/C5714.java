package context.c234;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C5714 {
    public static void main(String[] args) {
        C5714 m = new C5714();
        List<List<String>> knowledge = new ArrayList<>();
        List<String> k1 = Lists.newArrayList("name","bob");
        List<String> k2 = Lists.newArrayList("age","two");
        knowledge.add(k1);
        knowledge.add(k2);

        m.evaluate("(name)is(age)yearsold", knowledge);
    }
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> kV = new HashMap<>();
        for (List<String> each : knowledge){
            kV.put(each.get(0), each.get(1));
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int n = s.length();
        while(i < n){
            if(s.charAt(i) == '('){
                i++;
                StringBuilder tmp = new StringBuilder();
                while(s.charAt(i) != ')'){
                    tmp.append(s.charAt(i));
                    i++;
                }
                String value = kV.getOrDefault(tmp.toString(), "?");
                sb.append(value);
            } else {
                sb.append(s.charAt(i));
            }
            i++;
        }
        return sb.toString();
    }
}
