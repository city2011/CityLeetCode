package array.binary;

import java.util.Arrays;

public class L1300 {
    public static void main(String[] args) {
        L1300 main = new L1300();

        int [] arr = {4,9,3};
        int target = 10;
        System.out.println(main.findBestValue(arr, target));
    }

    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int len = arr.length;
        int curSum = 0;
        for (int i = 0; i < len; i++) {
            int curAve = (target - curSum) / (len - i);
            if (curAve <= arr[i]) {
                double curAveDou = (target * 1.0 - curSum) / (len - i);
                if (curAveDou - curAve <= 0.5) {
                    return curAve;
                } else {
                    return curAve + 1;
                }
            }
            curSum += arr[i];
        }
        return arr[len - 1];
    }
}
