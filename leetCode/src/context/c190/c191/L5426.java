package context.c190.c191;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L5426 {
    public static void main(String[] args) {
        L5426 main = new L5426();
        int[][] connections = {{1, 0}, {1, 2}, {3, 2}};
        int res = main.minReorder(4, connections);
        System.out.println(res);
    }
    public int minReorder(int n, int[][] connections) {
        Path[] paths = new Path[n];
        for(int[] con : connections){
            if(paths[con[0]] == null){
                if(paths[con[1]] == null){
                    Path path2 = new Path(con[1]);
                    paths[con[1]] = path2;
                    paths[con[0]] = new Path(con[0], path2);
                    path2.addPre(paths[con[0]]);
                } else {
                    paths[con[0]] = new Path(con[0], paths[con[1]]);
                    paths[con[1]].addPre(paths[con[0]]);
                }
            } else {
                if(paths[con[1]] == null){
                    Path path2 = new Path(con[1]);
                    paths[con[1]] = path2;
                    paths[con[0]].addNext(path2);
                    paths[con[1]].addPre(paths[con[0]]);
                } else {
                    paths[con[0]].addNext(paths[con[1]]);
                    paths[con[1]].addPre(paths[con[0]]);
                }
            }
        }

        Set<Path> used = new HashSet();
        return dfs(paths[0], used);
    }


    private int dfs(Path path, Set<Path> used){
        if(used.contains(path)){
            return 0;
        }
        List<Path> paths = path.next;
        List<Path> paths2 = path.pre;
        if(paths.isEmpty() && paths2.isEmpty()){
            return 0;
        }

        int ans = 0;
        for(Path p : paths){
            if(!used.contains(p)){
                ans += (1 + dfs(p, used));
            }
        }

        used.add(path);
        for(Path p : paths2){
            if(!used.contains(p)){
                ans += dfs(p, used);
            }
        }

        return ans;
    }

    class Path{
        int val;
        List<Path> next = new ArrayList();
        List<Path> pre = new ArrayList();

        public Path(int val){
            this.val = val;
        }

        public Path(int val, Path nextNode){
            this.val = val;
            next.add(nextNode);
        }

        public void addNext(Path nextNode){
            next.add(nextNode);
        }

        public void removeNext(Path nextNode){
            next.remove(nextNode);
        }

        public void addPre(Path preNode){
            pre.add(preNode);
        }

        public void removePre(Path preNode){
            pre.remove(preNode);
        }
    }
}
