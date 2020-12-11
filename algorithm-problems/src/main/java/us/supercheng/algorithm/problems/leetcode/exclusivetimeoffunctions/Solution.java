package us.supercheng.algorithm.problems.leetcode.exclusivetimeoffunctions;

import java.util.List;
import java.util.Stack;

class Solution {

    class Job {
        int id;
        int time;

        Job(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        if (n < 1 || logs == null || logs.size() < 2)
            throw new IllegalArgumentException("Invalid params");

        Stack<Job> stack = new Stack<>();
        int[] ret = new int [n];

        for (String log : logs) {
            String[] arr = log.split(":");
            int jobId = Integer.parseInt(arr[0]),
                    time = Integer.parseInt(arr[2]);

            if (arr[1].charAt(0) == 's') {
                if (!stack.isEmpty()) {
                    Job job = stack.peek();
                    ret[job.id] += time - job.time;
                }
                stack.push(new Job(jobId, time));
            } else {
                Job job = stack.pop();
                ret[job.id] += time - job.time + 1;
                if (!stack.isEmpty()) {
                    job = stack.peek();
                    job.time = time+1;
                }
            }
        }

        return ret;
    }
}