package us.supercheng.algorithm.problems.kthlargestelementinanarray;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.Arrays;
import java.util.PriorityQueue;

public class App {

    public static void main(String [] args) {
        int [] nums = {3,2,1,5,6,4};
        int k = 2;
        PrintHelper.echoLn(new App().findKthLargest(nums, k));
        PrintHelper.echoLn("");
        PrintHelper.echoLn(new App().findKthLargest(nums, k));

    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int num : nums)
            this.add(heap, k, num);
        return heap.peek();
    }

    private void add(PriorityQueue<Integer> heap, int k, int val) {
        heap.add(val);
        if(heap.size() > k)
            heap.poll();
    }

    public int findKthLargest2(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}