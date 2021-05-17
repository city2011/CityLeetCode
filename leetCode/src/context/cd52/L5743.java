package context.cd52;

public class L5743 {
    public static void main(String[] args) {
        L5743 m = new L5743();

    }

    public int[] memLeak(int memory1, int memory2) {
        int [] ans = new int [3];
        int i = 1;
        while(i <= memory1 || i <= memory2){
            if(memory1 >= memory2) {
                memory1 -= i;
            } else {
                memory2 -= i;
            }
            i++;
        }
        ans[0] = i;
        ans[1] = memory1;
        ans[2] = memory2;
        return ans;
    }
}
