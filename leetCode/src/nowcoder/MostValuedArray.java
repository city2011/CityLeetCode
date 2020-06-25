package nowcoder;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class MostValuedArray {
    public static void main(String[] args) {
        int size = 8;
        int input [] = {-998244352, -998244352, 2147483646, 998244352, 998244352, -214748364, 998244350, 99824438};
        quickSort(input, 0, size - 1);

        MostValuedArray main = new MostValuedArray();
        main.d2(size, input);

        main.d1(size, input);
    }

    private void d1(int size, int input[]){
        int mid = size / 2; long ans = 0; int m = 998244353;
        for (int i = 0; i < mid; i++) {
            ans = ((long) input[i] + ans) % m;
        }

        for (int i = mid; i < size; i++) {
            ans = ((long) input[i] * ans) % m;
        }
        System.out.print("d1 answer : ");
        System.out.println((ans + m ) % m);
    }

    private void d2(int n, int b[]){
        BigInteger gg = new BigInteger("998244353");
        int a = 0;
        for (int i = n / 2 - 1; i >= 0; i--)
            a = Integer.parseInt(BigInteger.valueOf(a).add(BigInteger.valueOf(b[i])).mod(gg).toString());
        for (int i = n / 2; i < n; i++)
            a = Integer.parseInt(BigInteger.valueOf(a).multiply(BigInteger.valueOf(b[i])).mod(gg).toString());
        System.out.print("d2 answer : ");
        System.out.println(a);
    }

    private static void quickSort(int[] input, int left, int right) {
        int pivot = partition(input, left, right);
        if (left < pivot - 1) {
            quickSort(input, left, pivot - 1);
        }
        if (pivot < right) {
            quickSort(input, pivot, right);
        }
    }

    private static int partition(int[] input, int left, int right) {
        int mid = left + (right - left) / 2;
        int tmp = input[mid];
        while (left <= right) {
            while (input[left] < tmp) {
                left++;
            }

            while (input[right] > tmp) {
                right--;
            }
            swap(input, left, right);
            if (left <= right) {
                left++;
                right--;
            }
        }
        return left;
    }

    private static void swap(int[] input, int a, int b) {
        int tmp = input[a];
        input[a] = input[b];
        input[b] = tmp;
    }
}
