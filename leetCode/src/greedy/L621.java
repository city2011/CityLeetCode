package greedy;

public class L621 {
    public static void main(String[] args) {
        L621 m = new L621();
        int ans = m.leastInterval(new char [] {'A','A','A','B','B','B'}, 0);
        System.out.println(ans);
    }

    public int leastInterval(char[] tasks, int n) {
        int count [] = new int [26];
        int max = Integer.MIN_VALUE;
        int remains = 0;
        for(char c : tasks){
            count[c - 'A']++;
        }

        for(int x : count){
            if(x == max){
                remains++;
            } else if (x > max){
                max = x;
                remains = 1;
            }
        }

        System.out.println(String.format("%d %d", max, remains));

        int nom = (max - 1) * (n + 1) + remains;
        return nom > tasks.length ? nom : tasks.length;
    }
}
