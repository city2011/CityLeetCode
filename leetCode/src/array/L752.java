package array;

public class L752 {
    public static void main(String[] args) {
        L752 m = new L752();
        m.openLock(new String [] {"0201","0101","0102","1212","2002"}, "0202");
    }

    public int openLock(String[] deadends, String target) {
        int sum = 0;
        int[][] statis = new int [4][10];
        for(String deadend : deadends) {
            for(int i = 0; i < 4; i++) {
                int idx = Integer.parseInt(deadend.charAt(i) + "");
                statis[i][idx]++;
            }
        }

        for(int i = 0; i < 4; i++) {
            int tNum = Integer.parseInt(target.charAt(i) + "");
            int minum = calDis(tNum, statis[i]);
            if(minum == -1)
                return -1;
            sum += minum;
        }
        return sum;
    }

    private int calDis(int tNum, int [] statis) {
        int minum = -1;
        for (int i = 0; i <= tNum; i++) {
            if(statis[i] > 0) {
                return -1;
            }
            minum = tNum;
        }

        for (int i = 9; i >= tNum; i--) {
            if(statis[i] > 0) {
                return -1;
            }
            minum = Math.min(minum, 10 - tNum);
        }
        return minum;
    }
}
