package experience;

import java.util.ArrayList;
import java.util.List;

public class L119PascalTriangle2 {
    public static void main(String[] args) {
        L119PascalTriangle2 m = new L119PascalTriangle2();
        for (int i = 0; i < 5; i++) {
            List<Integer> tmpAns = m.getRow(i);
            System.out.println(tmpAns);
        }
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre = new ArrayList<>();
        pre.add(1);

        if (rowIndex == 0){
            return pre;
        }

        if(rowIndex == 1){
            pre.add(1);
            return pre;
        }

        pre.add(1);
        for(int i = 1; i < rowIndex; i++){
            List<Integer> assist = new ArrayList<>();
            assist.add(1);

            int size = pre.size();
            for(int j = 0; j < size - 1; j++){
                assist.add(pre.get(j) + pre.get(j + 1));
            }

            assist.add(1);
            pre = assist;
        }

        return pre;
    }
}
