package us.supercheng.algorithm.data.structure.queue;

public class MyQueueMain {

    public static void main(String [] args) {

        MyArrayQueue<Integer> arrayQueue = new MyArrayQueue();

        System.out.println(arrayQueue);
        for(int i=1;i<26;i++) {
            arrayQueue.enqueue(i);
            System.out.println(arrayQueue);
        }

        for(int i=1;i<26;i++) {
            arrayQueue.dequeue();
            System.out.println(arrayQueue);
        }


        for(int i=1;i<26;i++) {
            arrayQueue.dequeue();
            System.out.println(arrayQueue);
        }

    }
}