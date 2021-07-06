package array;

public class L168 {
    public static void main(String[] args) {

    }

    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        int num = columnNumber;
        while(num > 0) {
            int remainder = num % 26;
            num = num / 26;
            if(remainder == 0) {
                num--;
                remainder = 26;
            }
            sb.append(from(remainder));
        }
        sb.reverse();
        return sb.toString();
    }

    private Character from(int i) {
        return (char)('A' + (i - 1));
    }
}
