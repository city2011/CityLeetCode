package context.c193;

import java.util.*;

public class L5437 {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : arr){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        List<Integer> lists = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry :map.entrySet()){
            lists.add(entry.getValue());
        }

        lists.sort(Comparator.comparingInt(o -> o));

        int size = lists.size();
        for(int x : lists){
            if(k >= x){
                k-=x;
                size--;
            }
        }
        return size;
    }
}
