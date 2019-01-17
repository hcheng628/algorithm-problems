package us.supercheng.algorithm.problems.coursescheduleii;

import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int [] ret = new int [numCourses];
        int [] degree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap();

        for (int i=0;i<prerequisites.length;i++) {
            degree[prerequisites[i][0]]++;
            if (!map.containsKey(prerequisites[i][1])) {
                List<Integer> list = new ArrayList();
                list.add(prerequisites[i][0]);
                map.put(prerequisites[i][1], list);
            } else
                map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        Queue<Integer> queue = new LinkedList();
        for (int i=0;i<degree.length;i++)
            if(degree[i] == 0)
                queue.add(i);

        for (int index=0;!queue.isEmpty();) {
            int course = queue.poll();
            List<Integer> list = map.get(course);
            ret[index++] = course;
            for (int i=0;list!=null && i<list.size();i++) {
                degree[list.get(i)]--;
                if (degree[list.get(i)]==0)
                    queue.add(list.get(i));
            }
        }

        for (int each : degree)
            if(each > 0)
                return new int [0];

        return ret;
    }
}