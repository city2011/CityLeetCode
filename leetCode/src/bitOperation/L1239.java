package bitOperation;

import java.util.ArrayList;
import java.util.List;

public class L1239 {
    public int maxLength(List<String> arr) {
        List<Integer> masks = new ArrayList<>();
        masks.add(0);
        int maxL = -1;
        for (String s : arr) {
            char [] cs = s.toCharArray();
            int mask = 0;
            for (char c : cs) {
                int offset = c - 'a';
                if((1 << offset & mask) == 0) {
                    mask |= 1 << offset;
                } else {
                    mask = 0;
                    break;
                }
            }
            if(mask == 0) {
                continue;
            }

            int size = masks.size();
            for (int i = 0; i < size; i++) {
                if((mask & masks.get(i)) == 0) {
                    int newMask = masks.get(i) | mask;
                    masks.add(newMask);
                    maxL = Math.max(maxL, Integer.bitCount(newMask));
                }
            }
        }
        return maxL;
    }
}
