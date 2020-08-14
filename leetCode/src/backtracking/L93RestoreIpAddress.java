package backtracking;

import java.util.*;

public class L93RestoreIpAddress {
    public static void main(String[] args) {
        L93RestoreIpAddress m = new L93RestoreIpAddress();
        String s = "010010";
        List<String> ans1 = m.restoreIpAddresses2(s);
        System.out.println(ans1);
    }

    private int[] ipSegments = new int[4];

    public List<String> restoreIpAddresses2(String s) {
        List<String> ans = new ArrayList<>();
        dealIpAddress(s, 0, s.length() - 1, 1, ans);
        return ans;
    }

    private void dealIpAddress(String s, int start, int end, int pos, List<String> ans) {
        if (start > end) {
            return;
        }

        // 最后一个段的计算和判断
        if (pos == 4) {
            // 前导0的判断
            if(s.charAt(start) == '0' && start < end)
                return;
            Integer num = Integer.valueOf(s.substring(start, end + 1));
            if (num <= 255 && num >= 0) {
                ipSegments[3] = num;
                StringBuilder ipAddr = new StringBuilder();
                for (int i = 0; i < 4; ++i) {
                    ipAddr.append(ipSegments[i]);
                    if (i != SEG_COUNT - 1) {
                        ipAddr.append('.');
                    }
                }
                ans.add(ipAddr.toString());
            }
        }

        // 由于不能有前导零，如果当前数字为 0，那么这一段 IP 地址只能为 0
        if (s.charAt(start) == '0') {
            ipSegments[pos - 1] = 0;
            dealIpAddress(s, start + 1, end, pos + 1, ans);
            return;
        }


        // 在后面的段合法长度的情况下，计算出每个段的最小和最大合法位置
        int min = Math.max(start, end - (3 * (4 - pos)));
        if(min > start + 2){
            return;
        }
        int max = Math.min(start + 2, end - (4 - pos));

        for (int i = min; i <= max; i++) {
            Integer num = Integer.valueOf(s.substring(start, i + 1));
            if (num <= 255 && num >= 0) {
                ipSegments[pos - 1] = num;
                dealIpAddress(s, i + 1, end, pos + 1, ans);
            }
        }
    }



    ///    作者：LeetCode-Solution
    //    链接：https://leetcode-cn.com/problems/restore-ip-addresses/solution/fu-yuan-ipdi-zhi-by-leetcode-solution/
    //    来源：力扣（LeetCode）
    //    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    static final int SEG_COUNT = 4;
    List<String> ans = new ArrayList<>();
    int[] segments = new int[SEG_COUNT];

    public List<String> restoreIpAddresses(String s) {
        segments = new int[SEG_COUNT];
        dfs(s, 0, 0);
        return ans;
    }

    public void dfs(String s, int segId, int segStart) {
        // 如果找到了 4 段 IP 地址并且遍历完了字符串，那么就是一种答案
        if (segId == SEG_COUNT) {
            if (segStart == s.length()) {
                StringBuffer ipAddr = new StringBuffer();
                for (int i = 0; i < SEG_COUNT; ++i) {
                    ipAddr.append(segments[i]);
                    if (i != SEG_COUNT - 1) {
                        ipAddr.append('.');
                    }
                }
                ans.add(ipAddr.toString());
            }
            return;
        }

        // 如果还没有找到 4 段 IP 地址就已经遍历完了字符串，那么提前回溯
        if (segStart == s.length()) {
            return;
        }

        // 由于不能有前导零，如果当前数字为 0，那么这一段 IP 地址只能为 0
        if (s.charAt(segStart) == '0') {
            segments[segId] = 0;
            dfs(s, segId + 1, segStart + 1);
        }

        // 一般情况，枚举每一种可能性并递归
        int addr = 0;
        for (int segEnd = segStart; segEnd < s.length(); ++segEnd) {
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if (addr > 0 && addr <= 0xFF) {
                segments[segId] = addr;
                dfs(s, segId + 1, segEnd + 1);
            } else {
                break;
            }
        }
    }
}
