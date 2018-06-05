package us.supercheng.algorithm.data.structure.queue;

import us.supercheng.algorithm.common.helper.PrintHelper;
import us.supercheng.algorithm.common.helper.ThreadHelper;

public class LinkedListQueueMain {

    public static void main(String[] args){

        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        int napTime = 3;

        PrintHelper.echoLn("Is LinkedListQueue Empty: " + queue.isEmpty() + "\n");
        ThreadHelper.sleep(napTime);

        PrintHelper.echoLn("Enqueue 1 - 10 to LinkedListQueue and Dequeue at %3 == 0");
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

        PrintHelper.echoLn("\nGet 1st Element from LinkedListQueue: " + queue.getFront() + "\n");
        ThreadHelper.sleep(napTime);

        PrintHelper.echoLn("Get LinkedListQueue Size: " + queue.getSize() + "\n");
        ThreadHelper.sleep(napTime);


        PrintHelper.echoLn("Dequeue more Element than LinkedListQueue Contains and IllegalArgumentException Occur");
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

        PrintHelper.echoLn("\nEnqueue (13) to LinkedListQueue");
        queue.enqueue(13);
        PrintHelper.echoLn(queue);
        ThreadHelper.sleep(napTime);

        PrintHelper.echoLn("\nIs LinkedListQueue Empty: " + queue.isEmpty() + "\n");
        PrintHelper.echoLn(queue);
        ThreadHelper.sleep(napTime);

        PrintHelper.echoLn("\nEnqueue (15) to LinkedListQueue");
        queue.enqueue(15);
        PrintHelper.echoLn(queue);
        ThreadHelper.sleep(napTime);

        PrintHelper.echoLn("Get LinkedListQueue Size: " + queue.getSize() + "\n");
        ThreadHelper.sleep(napTime);

        PrintHelper.echoLn("Get 1st Element from LinkedListQueue: " + queue.getFront() + "\n");
        ThreadHelper.sleep(napTime);
    }
}