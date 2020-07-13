package sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        MergeSort m = new MergeSort();
        int [] input = {4,3,5,6,8,7,9,8,2};
        int [] temps = new int[input.length];

        m.mergeSort(input, 0, input.length-1, temps);

        System.out.println(Arrays.toString(input));
        System.out.println(Arrays.toString(temps));
    }

    public int reversePairs(int[] nums) {
        return -1;
    }

    void mergeSort(int [] nums, int l, int r, int [] temps){
        if(l >= r){
            return;
        }
        int mid = l + (r - l) / 2;
        mergeSort(nums, l, mid, temps);
        mergeSort(nums, mid + 1, r, temps);
        merge(nums, l, mid, r, temps);
    }

    void merge(int [] nums, int l, int mid, int r, int [] temps){
        int [] temp = new int [mid - l + 1];
        System.arraycopy(nums, l, temp, 0, mid - l + 1);

        System.arraycopy(nums, l, temps, l, mid - l + 1);
        int lef = l;
        int rig = mid + 1;
        for(int i = l; i <= r; i++){

            if(lef == mid + 1){
                break;
            } else if (rig == r + 1){
                nums[i] = temps[lef];
            } else if(temps[lef] <= nums[rig]){
                nums[i] = temps[lef];
                lef++;
            } else {
                nums[i] = nums[rig];
                rig++;
            }
        }
    }
}
