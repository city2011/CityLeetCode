package context;

public class C6055 {
    public int convertTime(String current, String correct) {
        int h1 = Integer.parseInt(current.substring(0,2));
        int h2 = Integer.parseInt(correct.substring(0,2));
        int m1 = Integer.parseInt(current.substring(3,5));
        int m2 = Integer.parseInt(correct.substring(3,5));
        if (m2 < m1) {
            m2 += 60;
            h2 -= 1;
        }
        int diff = m2 - m1;
        int sum = 0;
        sum += h2 - h1;
        int[] op = new int [] {1,5,15};
        for(int i = op.length - 1; i >= 0; i--) {
            int p = diff / op[i];
            diff = diff % op[i];
            sum += p;
        }
        return sum;
    }
}
