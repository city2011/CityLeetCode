package dp;

import java.util.Arrays;

public class L354RussianDollEnvelopes {
    public static void main(String[] args) {
        L354RussianDollEnvelopes m = new L354RussianDollEnvelopes();
        int [][] envelopes = new int [][] {{5,4},{6,4},{6,7},{2,3}};
        m.maxEnvelopes(envelopes);
    }

    // todo
    public void maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (o1, o2) -> {
            if(o1[0] == o2[0]){
                return o2[1] - o1[0];
            } else {
                return o1[0] - o2[0];
            }
        });
        for (int[] envelope : envelopes) {
            System.out.println(Arrays.toString(envelope));
        }
    }
}
