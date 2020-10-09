package context.c202;

import java.util.Arrays;

public class L5497 {
    public static void main(String[] args) {
        L5497 m = new L5497();
        int [] arr = {1};
        m.findLatestStep(arr, 1);
    }

    public int findLatestStep(int[] arr, int m) {
        int n = arr.length;
        if(n <= 1){
            return arr[0] == m ? 1 : -1;
        }
        int ans = -1;
        int [] arrHelper = new int [n];
        for(int i = 0; i < n; i++){
            changeArrHelper(arrHelper, arr[i] - 1);
            System.out.println(Arrays.toString(arrHelper));
            if(containsM(arrHelper, m)){
                ans = i + 1;
            }
        }
        return ans;
    }

    private void changeArrHelper(int[] arrHelper, int i) {
        int newValue = 0;
        if(i > 0 && i < arrHelper.length - 1) {
            newValue = arrHelper[i - 1] + arrHelper[i + 1] + 1;
        } else if (i == 0){
            newValue = arrHelper[i + 1] + 1;
        } else {
            newValue = arrHelper[i - 1] + 1;
        }

        arrHelper[i] = newValue;

        int l = i - 1;
        while(l >= 0){
            if(arrHelper[l] == 0){
                break;
            }
            arrHelper[l] = newValue;
            l--;
        }
        int r = i + 1;
        while(r < arrHelper.length){
            if(arrHelper[r] == 0){
                break;
            }
            arrHelper[r] = newValue;
            r++;
        }
    }

    private boolean containsM(int[] arrHelper, int m) {
        int i = 0;
        while(i < arrHelper.length){
            if(arrHelper[i] == m){
                return true;
            }
            if(arrHelper[i] == 0){
                i++;
            } else {
                i += arrHelper[i];
            }
        }
        return false;
    }
}
