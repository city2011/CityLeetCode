package array;

import java.util.*;

public class L1418_displaytable {
    public static void main(String[] args) {

    }

    public List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> ans = new ArrayList<>();

        Map<String, int[]> mem = new HashMap<>();
        Map<String, Integer> item2idx = new HashMap<>();
        Set<String> items = new HashSet<>();
        Set<String> tables = new HashSet<>();
        for (List<String> str : orders) {
            items.add(str.get(2));
            tables.add(str.get(1));
        }
        int n = items.size();
        List<String> litems = new ArrayList<>(items);

        Collections.sort(litems);
        for (String str : tables) {
            mem.put(str, new int[n]);
        }
        for (int i = 0; i < items.size(); i++) {
            item2idx.put(litems.get(i), i);
        }
        for (List<String> str : orders) {
            int[] table = mem.get(str.get(1));
            table[item2idx.get(str.get(2))]++;
        }
        List<String> head = new ArrayList<>();
        head.add("Table");
        head.addAll(litems);
        ans.add(head);

        mem.entrySet().stream().sorted(Comparator.comparingInt(x -> Integer.parseInt(x.getKey()))).forEach(x -> {
            List<String> tableOrder = new ArrayList<>();
            tableOrder.add(x.getKey());
            int[] table = x.getValue();
            for (int i : table) {
                tableOrder.add(i+"");
            }
            ans.add(tableOrder);
        });

        return ans;
    }
}
