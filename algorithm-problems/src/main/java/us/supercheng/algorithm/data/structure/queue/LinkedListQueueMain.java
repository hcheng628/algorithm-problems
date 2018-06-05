package us.supercheng.algorithm.data.structure.queue;

import us.supercheng.algorithm.common.helper.PrintHelper;
import us.supercheng.algorithm.common.helper.ThreadHelper;
import java.util.Random;

public class LinkedListQueueMain {

    public static void main(String[] args){

        MyLinkedListQueue<Integer> queue = new MyLinkedListQueue<>();
        int napTime = 3;

        PrintHelper.echoLn("Is MyLinkedListQueue Empty: " + queue.isEmpty() + "\n");
        ThreadHelper.sleep(napTime);

        PrintHelper.echoLn("Enqueue 1 - 10 to MyLinkedListQueue and Dequeue at %3 == 0");
        for(int i = 1 ; i < 11 ; i ++){
            queue.enqueue(i);
            PrintHelper.echoLn(queue);

            if(i % 3 == 0){
                ThreadHelper.sleep(napTime);
                queue.dequeue();
                PrintHelper.echoLn(queue);
            }
        }
        ThreadHelper.sleep(napTime);

        PrintHelper.echoLn("\nGet 1st Element from MyLinkedListQueue: " + queue.getFront() + "\n");
        ThreadHelper.sleep(napTime);

        PrintHelper.echoLn("Get MyLinkedListQueue Size: " + queue.getSize() + "\n");
        ThreadHelper.sleep(napTime);


        PrintHelper.echoLn("Dequeue more Element than MyLinkedListQueue Contains and IllegalArgumentException Occur");
        try {
            for(int i=0;i<8;i++) {
                ThreadHelper.sleep(napTime);
                PrintHelper.echoLn(queue);
                queue.dequeue();
            }
        } catch (Exception ex) {
            PrintHelper.echoLn(ex.getMessage());
        }
        ThreadHelper.sleep(napTime);

        PrintHelper.echoLn("\nEnqueue (13) to MyLinkedListQueue");
        queue.enqueue(13);
        PrintHelper.echoLn(queue);
        ThreadHelper.sleep(napTime);

        PrintHelper.echoLn("\nIs MyLinkedListQueue Empty: " + queue.isEmpty() + "\n");
        PrintHelper.echoLn(queue);
        ThreadHelper.sleep(napTime);

        PrintHelper.echoLn("\nEnqueue (15) to MyLinkedListQueue");
        queue.enqueue(15);
        PrintHelper.echoLn(queue);
        ThreadHelper.sleep(napTime);

        PrintHelper.echoLn("Get MyLinkedListQueue Size: " + queue.getSize() + "\n");
        ThreadHelper.sleep(napTime);

        PrintHelper.echoLn("Get 1st Element from MyLinkedListQueue: " + queue.getFront() + "\n");
        ThreadHelper.sleep(napTime);

        int opCount = 100000;

        MyArrayQueue<Integer> arrayQueue = new MyArrayQueue<>();
        double time1 = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue, time: " + time1 + " s");

        MyLoopQueue<Integer> loopQueue = new MyLoopQueue<>();
        double time2 = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue, time: " + time2 + " s");

        MyLinkedListQueue<Integer> linkedListQueue = new MyLinkedListQueue<>();
        double time3 = testQueue(linkedListQueue, opCount);
        System.out.println("MyLinkedListQueue, time: " + time3 + " s");
    }

    private static double testQueue(Queue<Integer> q, int opCount){
        long startTime = System.nanoTime();
        Random random = new Random();
        for(int i = 0 ; i < opCount ; i ++)
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        for(int i = 0 ; i < opCount ; i ++)
            q.dequeue();
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }
}