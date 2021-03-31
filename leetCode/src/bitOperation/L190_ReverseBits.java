package bitOperation;

public class L190_ReverseBits {
    public static void main(String[] args) {
        L190_ReverseBits m = new L190_ReverseBits();
        m.reverseBits(1);
    }

    public int reverseBits(int n) {
        int mask = 1;
        int sym = (n & mask);
        int time = 30;
        int rest = 0;
        if(sym == 0){
            while(time >= 0){
                mask = mask << 1;
                if((n & mask) != 0){
                    rest += Math.pow(2, time);
                    System.out.println(rest);
                }
                time--;
            }
        } else {
            while(time >= 0){
                mask = mask << 1;
                if((n & mask) == 0){
                    rest += Math.pow(2, time);
                }
                time--;
            }
            rest = -rest - 1;
        }
        return rest;
    }
}
