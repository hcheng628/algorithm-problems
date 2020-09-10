package us.supercheng.algorithm.problems.pathcrossing;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public boolean isPathCrossing(String path) {
        int currX = 0,
            currY = 0;
        Set<Integer> visited = new HashSet<>();
        visited.add(0);

        for (char c : path.toCharArray()) {
            if (c == 'N')
                currY += 1;
            else if (c == 'S')
                currY -= 1;
            else if (c == 'W')
                currX -= 1;
            else if (c == 'E')
                currX += 1;
            else
                throw new RuntimeException("Invalid Path");

            int key = currX + currY * 100000;
            if (visited.contains(key))
                return true;
            visited.add(key);
        }

        return false;
    }

}
