package array.intersection;

import java.util.Arrays;
import java.util.HashMap;

public class L349IntersectionOfTwoArrays {
    public static void main(String[] args) {
        L349IntersectionOfTwoArrays m = new L349IntersectionOfTwoArrays();
        int [] ans = m.intersection(new int [] {4,9,5}, new int [] {9,4,9,8,4});
        System.out.println(Arrays.toString(ans));
    }

    // 2020/11/02
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> mem = new HashMap<>();
        for(int num : nums1) {
            mem.put(num, 1);
        }

        int [] ans = new int [Math.min(nums2.length, nums1.length)];
        int idx = 0;
        for(int num : nums2){
            if(mem.get(num) != null && mem.get(num) == 1){
                ans[idx++] = num;
                mem.put(num, -1);
            }
        }
        System.out.println(idx);
        return Arrays.copyOfRange(ans, 0, idx);
    }
}
