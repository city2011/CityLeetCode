package context.c194;

import java.util.*;

public class L5441 {

    public static void main(String[] args) {
        L5441 main = new L5441();
        String[] input = {"kingston(0)","kingston","kingston"};

        String[] res = main.getFolderNames(input);
        main.getBynames("ores(2019)");
    }

    public String[] getFolderNames(String[] names) {
        Map<String, Integer> maps = new HashMap<>();
        String [] res = new String[names.length];

        for(int i = 0; i < names.length; i++){
            FileName fn = getBynames(names[i]);
            System.out.print(fn.a + " " + fn.b);
            if(fn.b == null){
                if(maps.get(fn.a) == null){
                    maps.put(fn.a, 0);
                    res[i] = fn.a;
                } else {
                    int b = maps.get(fn.a);
                    String nname = fn.a + "(" + (b+1) + ")";
                    res[i] = fn.a + "(" + (b+1) + ")";
                    maps.put(fn.a, b+1);
                    maps.put(nname, 0);
                }
            } else {
                if(maps.get(names[i]) != null){
                    int b = maps.get(names[i]);
                    String nname = names[i] + "(" + (b+1) + ")";
                    res[i] = nname;
                    maps.put(names[i], b+1);
                    maps.put(nname, 0);
                } else {
                    if(maps.get(fn.a) == null){
                        maps.put(fn.a, fn.b);
                        res[i] = names[i];
                    } else {
                        int b = maps.get(fn.a);
                        if(b > fn.b){
                            String nname = fn.a + "(" + b + ")";
                            maps.put(nname, 0);
                        } else if (b == fn.b) {
                            String nname = fn.a + "(" + (b+1) + ")";
                            res[i] = fn.a + "(" + (b+1) + ")";
                            maps.put(fn.a, b+1);
                            maps.put(nname, 0);
                        } else {
                            String nname = fn.a + "(" + fn.b + ")";
                            res[i] = fn.a + "(" + fn.b + ")";
                            maps.put(fn.a, fn.b);
                            maps.put(nname, 0);
                        }
                    }
                }
            }
        }

        return res;

    }

    private FileName getBynames(String name){
        if(name.charAt(name.length()-1)==')'){
            int idx = name.length() - 2;
            int n = 0;
            int ans = 0;
            int b = 1;
            while(idx >= 0 && Character.isDigit(name.charAt(idx))){
                ans = (name.charAt(idx) - '0') * b + ans;
                idx--;
                n++;
                b*=10;
            }
            if(idx < name.length() - 2 && idx > 0){
                return new FileName(name.substring(0, idx), ans);
            } else {
                return new FileName(name, null);
            }
        }
        return new FileName(name, null);
    }

    class FileName{
        String a;
        Integer b;

        FileName(String a, Integer b){
            this.a = a;
            this.b = b;
        }
    }
}
