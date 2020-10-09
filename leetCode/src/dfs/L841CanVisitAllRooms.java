package dfs;

import java.util.*;

public class L841CanVisitAllRooms {
    private boolean canVisitAllRoomsBFS(List<List<Integer>> rooms) {
        int n = rooms.size(), num = 0;
        boolean [] visited = new boolean[rooms.size()];

        Queue<Integer> deque = new ArrayDeque<>();
        visited[0] = true;
        deque.offer(0);
        while (!deque.isEmpty()){
            num++;
            for(Integer in : rooms.get(deque.poll())){
                if(!visited[in]){
                    deque.offer(in);
                    visited[in] = true;
                }
            }
        }

        return num == n;
    }

    private boolean canVisitAllRoomsDFS(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean visited [] = new boolean [n];
        visited[0] = true;
        return dfs(rooms, visited, 0) == n;
    }

    private int dfs(List<List<Integer>> rooms, boolean visited [], int idx){
        int num = 1;
        for(Integer i : rooms.get(idx)){
            if(!visited[i]){
                visited[i] = true;
                num += dfs(rooms, visited, i);
            }
        }
        return num;
    }
}
