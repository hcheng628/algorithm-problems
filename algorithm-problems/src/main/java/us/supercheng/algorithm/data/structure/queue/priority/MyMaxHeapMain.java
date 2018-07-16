package us.supercheng.algorithm.data.structure.queue.priority;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.Random;

public class MyMaxHeapMain {

    public static void main(String[] args) {
        int n = 10000;
        Random random = new Random();
        Integer[] testNums = new Integer[n];
        for(int i=0;i<n;i++)
            testNums[i] = random.nextInt(Integer.MAX_VALUE);

        PrintHelper.echoLn("Without Heapify: " + executeTest(testNums, false) + " s");
        PrintHelper.echoLn("With Heapify: " + executeTest(testNums, true) + " s");
    }

    private static double executeTest(Integer [] nums, boolean isHeapify) {
        long start = System.nanoTime();
        MyMaxHeap<Integer> heap;

        if(isHeapify)
            heap = new MyMaxHeap<>(nums);
        else {
            heap = new MyMaxHeap<>();
            for(int each : nums)
                heap.add(each);
        }
        heap.replace(13);

        int [] arr = new int [nums.length];
        for(int i=0;i<nums.length;i++)
            arr[i] = heap.extractTop();

            for(int i=1; i<arr.length; i++)
                if(arr[i-1] < arr[i])
                    throw new IllegalArgumentException("Error");
        return (System.nanoTime() - start) / 100000000.0;
    }
}