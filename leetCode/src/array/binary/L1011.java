package src.array.binary;

import java.util.Arrays;

public class L1011 {
    public static void main(String[] args) {
        L1011 m = new L1011();
        int minMumLoadCapacity = m.shipWithinDays(new int [] {2,3,4,5,6,7,8,9,10}, 5);
        System.out.println(minMumLoadCapacity);
    }

    public int shipWithinDays(int[] weights, int D) {
        // 最小不能小于最重的商品。 最重不能超过商品重量总和。然后二分逼近。
        int left = Arrays.stream(weights).max().getAsInt(), right = Arrays.stream(weights).sum();
        while (left < right) {
            int mid = left + right >> 1;
            int need = 1, count = 0;
            for(int i = 0; i < weights.length; i++){
                if(count + weights[i] > mid){
                    count = 0;
                    need++;
                }
                count += weights[i];
            }
            if(need <= D){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
