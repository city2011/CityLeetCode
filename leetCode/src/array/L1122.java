package array;

import java.util.*;

public class L1122 {
    public static void main(String[] args) {
        L1122 m = new L1122();
        int [] ans = m.relativeSortArray(new int [] {2,3,1,3,2,4,6,7,9,2,19}, new int [] {2,1,4,3,9,6});
        System.out.println(Arrays.toString(ans));
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int[] ans = new int[n];
        List<Integer> pre = new ArrayList<>();
        List<Integer> last = new ArrayList<>();
        Map<Integer, List<Integer>> pos = new HashMap<>();
        for(int i = 0; i < m; i++){
            pos.put(i, new ArrayList<>());
        }
        Map<Integer, Integer> map2 = new HashMap<>();
        for(int i = 0; i < m; i++){
            map2.put(arr2[i], i);
        }
        for(int a : arr1){
            if(map2.get(a) != null){
                pos.get(map2.get(a)).add(a);
            } else {
                last.add(a);
            }
        }

        pos.forEach((key, value) -> pre.addAll(value));
        last.sort(Comparator.comparingInt(a -> a));
        pre.addAll(last);

        for (int i = 0; i < n; i++) {
            ans[i] = pre.get(i);
        }

        return ans;
    }


}
