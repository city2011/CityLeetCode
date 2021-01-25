package graph.union_find;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

public class L1725 {
    public static void main(String[] args) {
        L1725 l = new L1725();
        List<List<String>> accounts = Lists.newArrayList();
        accounts.add(Lists.newArrayList("john", "ddddddd@dddd"));
        accounts.add(Lists.newArrayList("joke", "john@ddd.com","ddddddd@dddd"));
        accounts.add(Lists.newArrayList("marial", "john@ddd.com"));
        List<List<String>> res = l.accountsMerge(accounts);
        System.out.println(res);
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        Map<String, Integer> p = new HashMap<>();
        Set<String> set = new HashSet<>();
        Uf uf = new Uf(n);
        List<String> head = new ArrayList<>();

        int count = 0;
        for(List<String> lists : accounts){
            head.add(lists.get(0));
            lists.remove(0);
            for(String x : lists){
                if(set.contains(x)){
                    int xf = p.get(x);
                    uf.union(count, xf);
                }
                p.put(x, count);
                set.add(x);
            }
            count++;
        }

        Map<Integer, List<Integer>> mem = new HashMap<>();
        int[] parent = uf.getParent();
        for (int i = 0; i < parent.length; i++) {
            if(mem.get(parent[i]) == null){
                List<Integer> tmp = new ArrayList<>();
                tmp.add(i);
                mem.put(parent[i], tmp);
            } else {
                mem.get(parent[i]).add(i);
            }
        }

       for (Map.Entry<Integer, List<Integer>> entry : mem.entrySet()){
           List<Integer> eachUf = entry.getValue();
           PriorityQueue<String> queue = new PriorityQueue<>();
           for(int i : eachUf){
               queue.addAll(accounts.get(i));
           }

           List<String> tmp = new ArrayList<>();
           tmp.add(head.get(entry.getKey()));
           tmp.addAll(queue.stream().distinct().sorted().collect(Collectors.toList()));
           ans.add(tmp);
       }

        return ans;
    }

    static class Uf{
        int[] parent;

        Uf(int n){
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x){
           if(parent[x] != x){
               parent[x] = find(parent[x]);
           }
           return parent[x];
        }

        void union(int a, int b){
            int fa = find(a);
            int fb = find(b);
            parent[fb] = fa;
        }

        int [] getParent(){
            return parent;
        }
    }
}
