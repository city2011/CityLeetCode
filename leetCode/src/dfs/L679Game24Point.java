package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author city
 * @date 11:37 PM 2020/8/22
 * <p>
 * ############################################# 题目描述 #############################################
 * <p>
 * 679. 24 点游戏
 * 你有 4 张写有 1 到 9 数字的牌。你需要判断是否能通过 *，/，+，-，(，) 的运算得到 24。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [4, 1, 8, 7]
 * 输出: True
 * 解释: (8-4) * (7-1) = 24
 * 示例 2:
 * <p>
 * 输入: [1, 2, 1, 2]
 * 输出: False
 * 注意:
 * <p>
 * 除法运算符 / 表示实数除法，而不是整数除法。例如 4 / (1 - 2/3) = 12 。
 * 每个运算符对两个数进行运算。特别是我们不能用 - 作为一元运算符。例如，[1, 1, 1, 1] 作为输入时，表达式 -1 - 1 - 1 - 1 是不允许的。
 * 你不能将数字连接在一起。例如，输入为 [1, 2, 1, 2] 时，不能写成 12 + 12 。
 * <p>
 * ############################################# 题目描述 #############################################
 */
public class L679Game24Point {
    private static final int AIM = 24;
    private static final double epsilon = Math.pow(10, -6);
    private static final int ADD = 0, MULTIPLY = 1, SUBSTRACT = 2, DEVIDE = 3;

    public static void main(String[] args) {
        L679Game24Point m = new L679Game24Point();
        int [] nums = {1,2,3};
        boolean res = m.judgePoint24(nums);
        System.out.println(res);
    }

    public boolean judgePoint24(int[] nums) {
        System.out.println(epsilon);
        System.out.println(1e-6);
        List<Double> list = new ArrayList<>();
        for (int num : nums) {
            list.add((double) num);
        }
        return solve(list);

    }

    private boolean solve(List<Double> list) {
        int n = list.size();
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return Math.abs(list.get(0) - AIM) < epsilon;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    List<Double> list2 = new ArrayList<>();

                    for (int k = 0; k < n; k++) {
                        if (k != i && k != j) {
                            list2.add(list.get(k));
                        }
                    }

                    for (int k = 0; k < 4; k++) {
                        if (i > j && k < 2) {
                            continue;
                        }
                        if (k == ADD) {
                            list2.add(list.get(i) + list.get(j));
                        } else if (k == MULTIPLY) {
                            list2.add(list.get(i) * list.get(j));
                        } else if (k == SUBSTRACT) {
                            list2.add(list.get(i) - list.get(j));
                        } else {
                            if (Math.abs(list.get(j)) < epsilon) {
                                continue;
                            }
                            list2.add(list.get(i) / list.get(j));
                        }

                        if (solve(list2)) {
                            return true;
                        }
                        list2.remove(list2.size() - 1);
                    }
                }
            }
        }
        return false;
    }
}
