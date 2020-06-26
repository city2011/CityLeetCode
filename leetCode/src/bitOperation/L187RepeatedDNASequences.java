package bitOperation;

import java.util.*;

/**
@author city
@date 2:00 PM 2020/6/26
 
############################################# 题目描述 #############################################

187. 重复的DNA序列
所有 DNA 都由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。

编写一个函数来查找目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。


示例：

输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
输出：["AAAAACCCCC", "CCCCCAAAAA"]

############################################# 题目描述 #############################################
 */
public class L187RepeatedDNASequences {
    public static void main(String[] args) {
        L187RepeatedDNASequences m = new L187RepeatedDNASequences();
        List<String> res = m.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
//        res.forEach(System.out::println);

        System.out.print("A: ");
        System.out.println(Integer.toBinaryString('A'));
        System.out.print("C: ");
        System.out.println(Integer.toBinaryString('C'));
        System.out.print("G: ");
        System.out.println(Integer.toBinaryString('G'));
        System.out.print("T: ");
        System.out.println(Integer.toBinaryString('T'));

        System.out.println();

        int sum = 0;
        for(int i = 0 ; i < 10; i++){
            sum += Math.pow(4, i);
        }
        System.out.println(sum);

        System.out.println(Integer.MAX_VALUE);
    }

    /**
     *@author city
     *@solution notes

     因为只有4个不同的表示。 ACGT。
     字符串可以映射为二进制从而映射为一个整型。比较一个整型，时间复杂度则为 O(1)

     *@date
     */
    public List<String> findRepeatedDnaSequences(String s) {
        if(s.length() < 10){
            return new ArrayList<>();
        }

        char[] cs = s.toCharArray();
        HashSet<Integer> existSet = new HashSet<>();
        HashSet<String> ans = new HashSet<>();
        int L30 = 0x3fffffff;
        int L7 = 0x00000007;

        int dnaMask = 0;
        for (int i = 0; i < 10; i++){
            dnaMask <<= 3;
            dnaMask |= (cs[i] & L7);
        }
        existSet.add(dnaMask);

        for(int i = 11; i <= s.length(); i++){
            dnaMask <<= 3;
            dnaMask &= L30;
            dnaMask |= (cs[i - 1] & L7);

            if(existSet.contains(dnaMask)){
                ans.add(s.substring(i-10, i));
            } else {
                existSet.add(dnaMask);
            }
        }

        return new ArrayList<>(ans);
    }

    /**
     *@author city
     *@solution notes

     Rabin-Karp

     核心 rolling hash。10位 4进制数 的计算。

     *@date
     */
        public List<String> findRepeatedDnaSequences2(String s) {
            int L = 10, n = s.length();
            if (n <= L) return new ArrayList<>();

            // rolling hash parameters: base a
            int a = 4, aL = (int)Math.pow(a, L);

            // convert string to array of integers
            Map<Character, Integer> toInt = new
                    HashMap<Character, Integer>() {{put('A', 0); put('C', 1); put('G', 2); put('T', 3); }};
            int[] nums = new int[n];
            for(int i = 0; i < n; ++i)
                nums[i] = toInt.get(s.charAt(i));

            int h = 0;
            Set<Integer> seen = new HashSet<>();
            Set<String> output = new HashSet<>();
            // iterate over all sequences of length L
            for (int start = 0; start < n - L + 1; ++start) {
                // compute hash of the current sequence in O(1) time
                if (start != 0)
                    h = h * a - nums[start - 1] * aL + nums[start + L - 1];
                    // compute hash of the first sequence in O(L) time
                else
                    for(int i = 0; i < L; ++i) h = h * a + nums[i];

                // update output and hashset of seen sequences
                if (seen.contains(h)) output.add(s.substring(start, start + L));
                seen.add(h);
            }
            return new ArrayList<>(output);
        }

}
