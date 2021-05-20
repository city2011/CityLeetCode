package array;

import java.util.*;

public class L692 {
    public static void main(String[] args) {
        L692 m = new L692();
        System.out.println(new Word("abc", 0).hashCode());
        System.out.println(new Word("abc", 1).hashCode());
        String [] input = new String [] {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        List<String> ans = m.topKFrequent(input, 4);
        System.out.println(ans);

        List<String> ansErr = m.topKFrequentErr(input, 4);
        System.out.println(ansErr);
    }

    /**
     * 错误的一个解决方案。主要是因为在初始化TreeMap的时候，写入了自己的comparator
     *
     * 这里保留这个错误的方法，记录为什么不对
     *
     * 本意是重写了Word的hashCode和equals后，treeMap可以在get Word这个对象时，只看Word中key这个变量的值。进行覆盖。
     * 但是tree.get() tree.put()的源码显示，如果传入了comparator，则在索引treeMap的key的时候，会使用这个comparator进行值的比较。而不会用到重写的hashCode。
     */
    public List<String> topKFrequentErr(String[] words, int k) {
        TreeMap<Word, Integer> tree = new TreeMap<>((x, y) -> {if (x.count.equals(y.count)) {
            return y.key.compareTo(x.key);
        } else {
            return y.count - x.count;
        }});

        for (String word : words) {
            Word w = new Word(word, 0);
            if(tree.get(w) == null){
                tree.put(new Word(word, 1),1 );
            } else {
                int count = tree.get(w) + 1;
                tree.put(new Word(word, count), count);
            }
        }

        List<String> ans = new ArrayList<>();

        for (int i = 0; i < k && !tree.isEmpty(); i++) {
            ans.add(tree.pollFirstEntry().getKey().key);
        }

        return ans;
    }

    static class Word{
        String key;
        Integer count;

        Word (String key, Integer count){
            this.key = key;
            this.count = count;
        }

        @Override
        public int hashCode(){
            return key.hashCode();
        }

        @Override
        public boolean equals(Object x){
            if(!(x instanceof Word)){
                return false;
            }
            Word tx = (Word) x;
            return this.hashCode() == tx.hashCode();
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> cnt = new HashMap<String, Integer>();
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<Map.Entry<String, Integer>>(new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                return entry1.getValue() == entry2.getValue() ? entry2.getKey().compareTo(entry1.getKey()) : entry1.getValue() - entry2.getValue();
            }
        });
        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<String> ret = new ArrayList<String>();
        while (!pq.isEmpty()) {
            ret.add(pq.poll().getKey());
        }
        Collections.reverse(ret);
        return ret;
    }
}
