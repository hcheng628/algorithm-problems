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

    public int[] maxSubsequenceOPT(int[] nums, int k) {
        if (nums.length == k)
            return nums;

        int[][] info = new int[2][k];
        List<Integer> list = new ArrayList<>();
        for (int i = 0, len = nums.length; i < len; i++)
            list.add(i);

        Collections.sort(list, Comparator.comparingInt(l -> -nums[l]));
        for (int i = 0; i < k; i++)
            info[0][i] = list.get(i);

        Arrays.sort(info[0]);
        for (int i = 0; i < k; i++)
            info[1][i] = nums[info[0][i]];

        return info[1];
    }

    public int[] maxSubsequenceOPT1(int[] nums, int k) {
        if (nums.length == k)
            return nums;

        int[][] info = new int[2][k];
        List<Integer> list = new ArrayList<>();
        for (int i = 0, len = nums.length; i < len; i++)
            list.add(i);

        Collections.sort(list, Comparator.comparingInt(l -> -nums[l]));
        for (int i = 0; i < k; i++)
            info[0][i] = list.get(i);

        Arrays.sort(info[0]);
        for (int i = 0; i < k; i++)
            info[1][i] = nums[info[0][i]];

        return info[1];
    }

    public static void main(String[] args) {
        Solution so = new Solution();
//        System.out.println(Arrays.toString(so.maxSubsequenceOPT2(new int[]{2,1,3,3}, 2)));
//        System.out.println(Arrays.toString(so.maxSubsequenceOPT2(new int[]{-1,-2,3,4}, 3)));
        System.out.println(Arrays.toString(so.maxSubsequenceOPT2(new int[]{3,4,3,3}, 2)));
//        System.out.println(Arrays.toString(so.maxSubsequenceOPT2(new int[]{50,-75}, 2)));
    }

    public int[] maxSubsequenceOPT2(int[] nums, int k)  {
        if (nums.length == k)
            return nums;

        int[] ret = new int[k];
        PriorityQueue<int[]> valueHeap = new PriorityQueue<>(Comparator.comparingInt(n -> n[0]));
        PriorityQueue<int[]> idxHeap = new PriorityQueue<>(Comparator.comparingInt(n -> n[1]));

        for (int i = 0, len = nums.length; i < len; i++) {
            valueHeap.add(new int[]{nums[i], i});
            if (valueHeap.size() > k)
                valueHeap.poll();
        }

        while (!valueHeap.isEmpty())
            idxHeap.offer(valueHeap.poll());

        for (int i = 0; i < k; i++)
            ret[i] = idxHeap.poll()[0];

        return ret;
    }

}