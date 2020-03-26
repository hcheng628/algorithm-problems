package us.supercheng.algorithm.problems.keysandrooms;

import java.util.List;

public class Solution {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];

        this.dfs(rooms, 0, visited);

        for (boolean v : visited)
            if (!v)
                return false;

        return true;
    }

    private void dfs(List<List<Integer>> rooms, int roomIdx, boolean[] visited) {
        if (visited[roomIdx])
            return;

        visited[roomIdx] = true;

        for (int next : rooms.get(roomIdx))
            this.dfs(rooms, next, visited);
    }
}