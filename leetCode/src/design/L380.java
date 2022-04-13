package design;

import java.util.*;

public class L380 {
    public static void main(String[] args) {
        L380.RandomizedSet rs = new L380.RandomizedSet();
        rs.insert(1);
        rs.insert(2);
        System.out.println(rs.getRandom());
        rs.insert(3);
        System.out.println(rs.getRandom());
        rs.remove(2);
        rs.remove(5);
        System.out.println(rs.getRandom());
        rs.remove(3);
        System.out.println(rs.getRandom());
    }

    static class RandomizedSet {
        Map<Integer, Integer> mem = new HashMap<>();
        public RandomizedSet() {
            Map<Integer, Integer> mem = new HashMap<>();
        }

        public boolean insert(int val) {
            if (mem.get(val) != null) {
                return false;
            } else {
                mem.put(val, 1);
                return true;
            }
        }

        public boolean remove(int val) {
            if(mem.get(val) != null) {
                mem.remove(val);
                return true;
            } else {
                return false;
            }
        }

        public int getRandom() {
            Set<Integer> ss = mem.keySet();
            Integer[] ss2 = new Integer[ss.size()];
            ss2 = ss.toArray(ss2);
            System.out.println(Arrays.toString(ss2));
            int idx = ss.size();
            while(idx == ss.size()) {
                idx = (int) (Math.random() * ss.size());
                System.out.println(idx);
            }
            return ss2[idx];
        }
    }
}
