package JianzhiOffer;

import java.util.Arrays;

public class E51 {

    public static void main(String[] args) {
        E51 m = new E51();
        int [] input = {7, 5, 6, 4};
        int [] temps = new int[input.length];

        int res = m.reversePairs(input);

        m.countReverseByMergeSort(input, 0, input.length-1, temps);


        System.out.println("res is "+ res);
        System.out.println(Arrays.toString(input));
        System.out.println(Arrays.toString(temps));
    }

    private int reversePairs(int[] nums) {
        int len = nums.length;

        if (len < 2) {
            return 0;
        }

        int[] copy = new int[len];
        System.arraycopy(nums, 0, copy, 0, len);

        int[] temp = new int[len];
        return countReverseByMergeSort(copy, 0, len - 1, temp);
    }

    private int countReverseByMergeSort(int[] nums, int l, int r, int[] temps){
        if(l >= r){
            return 0;
        }
        int mid = l + (r - l) / 2;
        int leftNum = countReverseByMergeSort(nums, l, mid, temps);
        int rightNum = countReverseByMergeSort(nums, mid + 1, r, temps);
        int curNum = mergeAndCount(nums, l, mid, r, temps);
        return leftNum + rightNum + curNum;
    }

    private int mergeAndCount(int[] nums, int l, int mid, int r, int[] temps){
        int count = 0;

        System.arraycopy(nums, l, temps, l, mid - l + 1);
        int lef = l;
        int rig = mid + 1;
        for(int i = l; i <= r; i++){
            if(lef == mid + 1){
                break;
            } else if (rig == r + 1){
                nums[i] = temps[lef];
                lef++;
            } else if(temps[lef] <= nums[rig]){
                nums[i] = temps[lef];
                lef++;
            } else {
                nums[i] = nums[rig];
                rig++;
                count += (mid - lef + 1);
            }
        }
        return count;
    }
}
