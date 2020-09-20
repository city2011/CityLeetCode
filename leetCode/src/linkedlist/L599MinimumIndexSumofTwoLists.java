package linkedlist;

import java.util.*;

/**
* author:city
* date:2020/8/15 2:21
* description:
*  https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists/
 *
 * 599. 两个列表的最小索引总和
 * 假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
 *
 * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。
 *
 * 示例 1:
 *
 * 输入:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * 输出: ["Shogun"]
 * 解释: 他们唯一共同喜爱的餐厅是“Shogun”。
 * 示例 2:
 *
 * 输入:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["KFC", "Shogun", "Burger King"]
 * 输出: ["Shogun"]
 * 解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
 * 提示:
 *
 * 两个列表的长度范围都在 [1, 1000]内。
 * 两个列表中的字符串的长度将在[1，30]的范围内。
 * 下标从0开始，到列表的长度减1。
 * 两个列表都没有重复的元素。
 *
*/
public class L599MinimumIndexSumofTwoLists {
    public static void main(String[] args) {
        L599MinimumIndexSumofTwoLists m = new L599MinimumIndexSumofTwoLists();
        String[] list1 = {"Shogun","Tapioca Express","Burger King","KFC"};
        String[] list2 = {"KFC","Burger King","Tapioca Express","Shogun"};

        String [] ans = m.findRestaurant(list1, list2);
        System.out.println(Arrays.toString(ans));
    }

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> mem = new HashMap<>();
        for(int i = 0; i < list1.length; i++){
            mem.put(list1[i], i);
        }
        int sum, minSum = Integer.MAX_VALUE;
        List<String> ans = new ArrayList<>();
        for(int i = 0; i <= minSum && i < list2.length; i++) {
            if(mem.containsKey(list2[i])){
                sum = i + mem.get(list2[i]);
                if(sum < minSum){
                    ans.clear();
                    ans.add(list2[i]);
                    minSum = sum;
                } else if(sum == minSum){
                    ans.add(list2[i]);
                }

            }
        }

        String [] res = new String[ans.size()];
        return ans.toArray(res);
    }
}
