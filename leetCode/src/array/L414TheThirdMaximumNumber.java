package array;

import java.util.Arrays;

/**
 * @ProjectName: CityLeetCode
 * @Author: City
 * @Description:
 *
Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number.
The time complexity must be in O(n).

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/third-maximum-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

LeetCode官方的题目描述，不是很清晰。
1 给定的数据中，数字可以重复。
2 重复的数字只能算一次，比如{9,9,8,7} 第三大的数字是7，不是8,因为9虽然重复，但是只记一次。

 * @Date: Created in 3:15 PM 2020/5/23
 * @Modified By:city
 */
public class L414TheThirdMaximumNumber {
    public static void main(String[] args) {
        L414TheThirdMaximumNumber main = new L414TheThirdMaximumNumber();
        int input [] = {9,9,9,8,7,6};

        int ans = main.thirdMax(input);
        System.out.println(ans);
    }

    public int thirdMax(int[] nums) {
        Integer [] max3 = new Integer[3];

        for(int num : nums){
            addToMax3(num, max3);
        }

        System.out.println(Arrays.toString(max3));

        if(max3[2] == null){
            return max3[0];
        } else {
            return max3[2];
        }
    }

    private void addToMax3(int num, Integer [] max3){
        int i = 0;
        for(; i < 3; i++){
            if(max3[i] == null || num > max3[i]){
                break;
            }
            if(max3[i] == num){
                i = 3;
            }
        }
        int j = 2;
        if(i<3){
            while(j>i){
                max3[j] = max3[j-1];
                j--;
            }
            max3[i] = num;
        }
    }
}
