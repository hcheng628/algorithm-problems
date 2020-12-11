package us.supercheng.algorithm.problems.leetcode.courseschedule;

import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int [] degree = new int [numCourses];
        Map<Integer, List<Integer>> map = new HashMap();

        for(int i=0;i<prerequisites.length;i++) {
            degree[prerequisites[i][0]]++;
            if(map.containsKey(prerequisites[i][1]))
                map.get(prerequisites[i][1]).add(prerequisites[i][0]);
            else {
                List<Integer> list = new ArrayList();
                list.add(prerequisites[i][0]);
                map.put(prerequisites[i][1], list);
            }
        }

        Queue<Integer> queue = new LinkedList();
        for(int i=0;i<numCourses;i++)
            if(degree[i] == 0)
                queue.add(i);

        while (!queue.isEmpty()) {
            int each = queue.poll();
            if(map.containsKey(each))
                for(Integer nextCourse : map.get(each))
                    if(--degree[nextCourse] == 0)
                        queue.add(nextCourse);
        }

        for(int i=0;i<numCourses;i++)
            if(degree[i] > 0)
                return false;
        return true;
    }
}