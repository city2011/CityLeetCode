package crackingTCI.mid16.base2;

public class Lcp22 {
    public static void main(String[] args) {
        Lcp22 m = new Lcp22();
        m.paintingPlan(2, 4);
        int res = m.cn(4, 6);
        System.out.println(res);
    }

    public int paintingPlan(int n, int k) {
        int sum = 0;
        for(int row = 0; row <= n; row++){
            if(row * n > k){
                break;
            }

            for(int col = 0; col <= n; col++){
                int gridNums = row * n + col * n - (row * col);
                if(gridNums == k){
                    sum += methodNum(row, col, n);
                }
                if(gridNums > k){
                    break;
                }
            }
        }
        return sum;
    }

    private int methodNum(int row, int col, int n){
        return cn(row, n) * cn(col, n);
    }

    private int cn(int top, int root){
        if(top > root / 2){
            top = root - top;
        }
        if(top == 0){
            return 1;
        }
        int time = top;
        int topsum = top;
        int rootsum = root;
        for(int i = 0; i < time - 1; i++){
            top = top - 1;
            root = root - 1;
            topsum *= top;
            rootsum *= root;
        }
        System.out.println(topsum);
        System.out.println(rootsum);
        return rootsum / topsum;
    }
}
