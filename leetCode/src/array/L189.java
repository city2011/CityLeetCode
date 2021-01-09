package array;

import java.util.Arrays;

public class L189 {
    public static void main(String[] args) {
        L189 m = new L189();
        m.rotate(new int [] {-1,-100,3,99}, 2);
    }
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if(k == 0) return;
        int [] tmp = new int [k];
        for(int i = 0; i < k; i++){
            tmp[i] = nums[i + n - k];
        }
        for(int i = n - 1; i >= k; i--){
            System.out.println(i +"  " +(i - n + k + 1));
            nums[i] = nums[i - k];
        }
        System.out.println(Arrays.toString(nums));
        for(int i = 0; i < k; i++){
            nums[i] = tmp[i];
        }
        System.out.println(Arrays.toString(nums));
    }
}
