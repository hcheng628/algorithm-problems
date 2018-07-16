package us.supercheng.algorithm.data.structure.queue.priority;

import us.supercheng.algorithm.common.helper.PrintHelper;

import java.util.Random;

public class MyMaxHeapMain {

    public static void main(String[] args) {
        int n = 10;
        Random random = new Random();
        Integer[] testNums = new Integer[n];
        for(int i=0;i<n;i++)
            testNums[i] = random.nextInt(666);

        double time1 = executeTest(testNums, false);
        System.out.println("Without heapify: " + time1 + " s");

        double time2 = executeTest(testNums, true);
        System.out.println("With heapify: " + time2 + " s");
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

        heap.print();

        int [] arr = new int [nums.length];

        for(int i=0;i<nums.length;i++) {
            arr[i] = heap.extractNext();
            PrintHelper.echo("Extract Next: " + arr[i] + " ");
        }

            for(int i=1; i<nums.length; i++)
            if(arr[i-1] < arr[i])
                throw new IllegalArgumentException("Error");
        return (System.nanoTime() - start) / 100000000.0;
    }
}