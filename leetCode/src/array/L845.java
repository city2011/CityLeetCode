package array;

public class L845 {

    public int longestMountain(int[] A) {
        int maxLength = 0;
        int i = 1;

        while (i < A.length) {
            int increasing = 0, decreasing = 0;

            while(i < A.length && A[i - 1] < A[i]) {
                i++;
                increasing++;
            }
            while(i < A.length && A[i - 1] > A[i])
            {
                i++;
                decreasing++;
            }

            if (increasing > 0 && decreasing > 0)
                maxLength = Math.max(maxLength, increasing + decreasing + 1);

            while(i < A.length && A[i - 1] == A[i]) i++;
        }
        return maxLength;
    }
}
