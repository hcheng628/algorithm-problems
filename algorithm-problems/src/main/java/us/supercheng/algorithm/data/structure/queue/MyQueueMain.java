package us.supercheng.algorithm.data.structure.queue;

import java.util.Random;

public class MyQueueMain {

    public static final double TIME_UNIT = 1000000000.0;
    public static final int SLEEP_TIME = 1000;

    public static void main(String [] args) {

        MyArrayQueue<Integer> arrayQueue = new MyArrayQueue();
        MyLoopQueue<Integer> loopQueue = new MyLoopQueue<>();

        int loopCount = 26;

        for(int i=1;i<loopCount;i++) {
            arrayQueue.enqueue(i);
            System.out.println(arrayQueue);
        }
        for(int i=1;i<loopCount;i++) {
            arrayQueue.dequeue();
            System.out.println(arrayQueue);
        }
        arrayQueue.dequeue();
        System.out.println();

        try {
            Thread.sleep(SLEEP_TIME);
        } catch (Exception ex){}

        for(int i=1;i<loopCount;i++) {
            loopQueue.enqueue(i);
            System.out.println(loopQueue);
        }

        for(int i=1;i<loopCount;i++) {
            loopQueue.dequeue();
            System.out.println(loopQueue);
        }

        // Performance Test ;-)
        int size = 100000;
        double arrayQueueTime = compareArrayVsLoopQueue(new MyArrayQueue<Integer>(), size);
        double loopQueueTime = compareArrayVsLoopQueue(new MyLoopQueue<Integer>(), size);
        System.out.println("ArrayQueue, time: " + arrayQueueTime + " s");
        System.out.println("LoopQueue, time: " + loopQueueTime + " s");
    }

    public static double compareArrayVsLoopQueue(Queue<Integer> queue, int size) {
        Random random = new Random();
        long start = System.nanoTime();
        for(int i=0;i<size;i++)
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        for(int i=0;i<size;i++)
            queue.dequeue();
        long end = System.nanoTime();
        return (end - start) / TIME_UNIT;
    }
}