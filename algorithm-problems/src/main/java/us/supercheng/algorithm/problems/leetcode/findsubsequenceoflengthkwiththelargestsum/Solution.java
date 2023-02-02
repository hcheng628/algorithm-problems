package us.supercheng.algorithm.problems.leetcode.findsubsequenceoflengthkwiththelargestsum;

import java.util.*;

class Solution {

    public int[] maxSubsequenceBF(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        Integer[] arr = new Integer[1001];

        for (int i = 0, len = nums.length; i < len; i++)
            if (heap.size() < k) {
                heap.offer(nums[i]);
                updateMap(map, nums[i], i);
            } else
            if (heap.peek() < nums[i]) {
                int del = heap.poll();
                List<Integer> idxes = map.get(del);
                if (idxes.size() == 1)
                    map.remove(del);
                else
                    idxes.remove(0);
                heap.offer(nums[i]);
                updateMap(map, nums[i], i);
            }

        while (!heap.isEmpty()) {
            int key = heap.poll();
            arr[map.get(key).remove(0)] = key;
        }

        return Arrays.stream(arr).filter(Objects::nonNull).mapToInt(Integer::intValue).toArray();
    }

    private void updateMap(Map<Integer, List<Integer>> map, int key, int idx) {
        List<Integer> idxes = map.computeIfAbsent(key, k -> new ArrayList<>());
        idxes.add(idx);
    }

    public int[] maxSubsequence(int[] nums, int k) {
        if (nums.length == k)
            return nums;

        int len = nums.length;
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < len; i++)
            if (heap.size() < k) {
                heap.offer(new int[]{nums[i], i});
                set.add(i);
            } else if (heap.peek()[0] < nums[i]) {
                set.remove(heap.poll()[1]);
                heap.offer(new int[]{nums[i], i});
                set.add(i);
            }

        for (int i = 0; i < len; i++)
            if (set.contains(i))
                list.add(nums[i]);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

}