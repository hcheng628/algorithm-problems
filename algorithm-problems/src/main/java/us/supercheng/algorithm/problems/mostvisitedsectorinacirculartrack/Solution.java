package us.supercheng.algorithm.problems.mostvisitedsectorinacirculartrack;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> mostVisited(int n, int[] rounds) {
        int len = rounds.length,
                max = 0;
        int[] visited = new int[n+1];
        List<Integer> ret = new ArrayList<>();

        for (int i=0; i<len-1; i++)
            this.travel(visited, rounds[i], rounds[i+1], n);
        visited[rounds[len-1]]++;

        for (int i=1; i<=n; i++)
            if (visited[i] > max)
                max = visited[i];
        for (int i=1; i<=n; i++)
            if (visited[i] == max)
                ret.add(i);

        return ret;
    }

    private void travel(int[] visited, int from, int to, int N) {
        if (from <= to)
            while (from < to)
                visited[from++]++;
        else {
            while (from<=N)
                visited[from++]++;
            for (from=1; from<to; from++)
                visited[from]++;
        }
    }
}