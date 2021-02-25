package us.supercheng.algorithm.problems.algo.topologicalsort;

import java.util.*;

public class Program {

    // Time: O(m * n) Space: Time: O(max(m,n))
    public static List<Integer> topologicalSort(List<Integer> jobs, List<Integer[]> deps) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, List<Integer>> reverseMap = new HashMap<>();

        List<Integer> ret = new ArrayList<>();

        for (int j : jobs) {
            map.put(j, new HashSet<>());
            reverseMap.put(j, new ArrayList<>());
        }
        for (Integer[] dep : deps) {
            map.get(dep[1]).add(dep[0]);
            reverseMap.get(dep[0]).add(dep[1]);
        }

        while (true) {
            Integer nextJob = doNextJob(map, reverseMap);
            if (nextJob == null)
                break;
            ret.add(nextJob);
        }

        return ret.size() == jobs.size() ? ret : new ArrayList<>();
    }

    private static Integer doNextJob(Map<Integer, Set<Integer>> map, Map<Integer, List<Integer>> reverseMap) {
        Integer ret = null;

        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            int jobId = entry.getKey();
            Set<Integer> deps = entry.getValue();
            if (deps.isEmpty()) {
                ret = jobId;
                break;
            }
        }

        if (ret != null) {
            map.remove(ret);
            for (int dep : reverseMap.get(ret))
                map.get(dep).remove(ret);
        }

        return ret;
    }


    public static List<Integer> topologicalSort_Solution2(List<Integer> jobs, List<Integer[]> deps) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        List<Integer> ret = new ArrayList<>();

        for (int j : jobs)
            map.put(j, new ArrayList<>());
        for (Integer[] dep : deps)
            map.get(dep[1]).add(dep[0]);

        for (int j : jobs)
            if (!visited.contains(j)) {
                Set<Integer> inProgress = new HashSet<>();
                inProgress.add(j);
                if (travel(j, map, visited, inProgress, ret) == -1)
                    return new ArrayList<>();
            }

        return ret;
    }

    private static int travel(int jobId, Map<Integer, List<Integer>> map, Set<Integer> visited, Set<Integer> inProgress, List<Integer> ret) {
        if (visited.contains(jobId))
            return 0;

        List<Integer> deps = map.get(jobId);
        if (deps == null) {
            visited.add(jobId);
            ret.add(jobId);
            return jobId;
        }

        for (Integer dep : deps) {
            if (inProgress.contains(dep))
                return -1;

            inProgress.add(jobId);
            if (travel(dep, map, visited, inProgress, ret) == -1)
                return -1;
            inProgress.remove(jobId);
        }

        visited.add(jobId);
        ret.add(jobId);

        return jobId;
    }
}
