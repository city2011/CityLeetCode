package graph.union_find;

public class L839SimilarStringGroup {
    public static void main(String[] args) {
        L839SimilarStringGroup m = new L839SimilarStringGroup();

    }

    public int numSimilarGroups(String[] strs) {
        int n = strs.length;

        UnionFindService uf = new UnionFindService(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (uf.findRootUsingPS(i) == uf.findRootUsingPS(j))
                    continue;
                if(check(strs[i], strs[j])){
                    uf.union(i, j);
                }
            }
        }

        return uf.soloCount();
    }

    private boolean check(String str, String str1) {
        int n = str.length();
        int num = 0;
        for (int i = 0; i < n; i++) {
            if(str.charAt(i) != str1.charAt(i)){
                num++;
            }
        }
        return num == 0 || num == 2;
    }
}
