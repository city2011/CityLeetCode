package geometry;

public class L1232 {

    public static void main(String[] args) {
        L1232 m = new L1232();
        boolean ans = m.checkStraightLine(new int [][] {{-4,-3},{1,0},{3,-1},{0,-1},{-5,2}});
        System.out.println(ans);
    }

    public boolean checkStraightLine(int[][] coordinates) {
        int n = coordinates.length;
        if(n <= 2){
            return true;
        }
        if(coordinates[0][0] - coordinates[1][0] == 0){
            for(int i = 2; i < n; i++){
                if(coordinates[i][0] - coordinates[i - 1][0] != 0){
                    return false;
                }
            }
        } else {
            double k = ((coordinates[1][1] - coordinates[0][1]) + 0.0) / (coordinates[1][0] - coordinates[0][0]);
            System.out.println(k);
            for(int i = 2; i < n; i++){
                if((coordinates[i][0] - coordinates[i - 1][0] == 0) ||
                        (k != ((coordinates[i][1] - coordinates[i - 1][1])  + 0.0) / (coordinates[i][0] - coordinates[i - 1][0]))){
                    return false;
                }
            }
        }
        return true;
    }
}
