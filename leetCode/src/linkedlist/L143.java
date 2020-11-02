package linkedlist;

import java.util.List;

public class L143 {
    public static void main(String[] args) {
        L143 m = new L143();
        System.out.println(m.test((Object)"ddd"));
    }

    public int test(String a) throws ClassNotFoundException, NoSuchMethodException {
        Class x = Class.forName("L143");
        x.getAnnotations();
        x.getConstructor();
        return 1;
    }

    public String test(Object a){
        return "";
    }
}