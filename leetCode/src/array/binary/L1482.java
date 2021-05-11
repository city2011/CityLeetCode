package array.binary;

public class L1482 {
    public static void main(String[] args) {
        L1482 m = new L1482();
    }

    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length / k < m) {
            return -1;
        }
        int low = Integer.MAX_VALUE, high = 0;
        int n = bloomDay.length;
        for (int i = 0; i < n; i++) {
            low = Math.min(bloomDay[i], low);
            high = Math.max(bloomDay[i], high);
        }

        while (low < high) {
            int day = low + (high - low) / 2;
            if(check(bloomDay, m, k, day)){
                high = day;
            } else {
                low = day + 1;
            }
        }

        return low;
    }

    private boolean check(int[] bloomDay, int m, int k, int day){
        int bouquets = 0;
        int flowers = 0;
        int length = bloomDay.length;
        for (int i = 0; i < length && bouquets < m; i++) {
            if (bloomDay[i] <= day) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }
        return bouquets >= m;
    }
}
