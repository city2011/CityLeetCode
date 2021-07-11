package sort;

import java.util.Arrays;

public class L274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int count = 0;
        for(int i = citations.length - 1; i >= 0; i--) {
            count++;
            if(count > citations[i]) {
                break;
            }
        }
        return count;
    }
}
