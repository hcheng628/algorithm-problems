package us.supercheng.algorithm.data.structure.stack;

import us.supercheng.algorithm.common.helper.PrintHelper;
import us.supercheng.algorithm.common.helper.ThreadHelper;

import java.util.Random;

public class MyLinkedListStackMain {

    public static void main(String[] args) {
        int napTime = 1;
        MyLinkedListStack<Integer> stack = new MyLinkedListStack<>();

        PrintHelper.echoLn("Push 1-5 to MyLinkedListStack");
        for (int i = 1; i < 6; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        ThreadHelper.sleep(napTime);

        PrintHelper.echoLn("\nPop 15 Times from MyLinkedListStack Exception Occur at 5th Time");
        try {
            for (int i = 1; i < 16; i++) {
                stack.pop();
                System.out.println(stack);
            }
        } catch (Exception ex) {
            PrintHelper.echoLn(ex.getMessage());
        }
        ThreadHelper.sleep(napTime);

        PrintHelper.echoLn("\nIs MyLinkedListStack Empty ? " + stack.isEmpty() + "\n");
        ThreadHelper.sleep(napTime);

        PrintHelper.echoLn("Push 20-25 to MyLinkedListStack");
        for (int i = 20; i < 26; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        ThreadHelper.sleep(napTime);

        PrintHelper.echoLn("\nMyLinkedListStack Size: " + stack.getSize() + "\n");
        ThreadHelper.sleep(napTime);

        System.out.println(stack);

        PrintHelper.echoLn("\nTesting ArrayStack vs LinkedListStack on Push and Pop Operations");
        int opCount = 10000000;
        MyArrayStack<Integer> arrStack =  new MyArrayStack<>();
        MyLinkedListStack<Integer> linkedListStack = new MyLinkedListStack<>();
        PrintHelper.echoLn("ArrayStack: " + testStack(arrStack, opCount));
        PrintHelper.echoLn("LinkedListStack: " + testStack(linkedListStack, opCount));
    }

    private static double testStack(Stack<Integer> stack, int opCount) {
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++)
            stack.push(random.nextInt(Integer.MAX_VALUE));
        for (int i = 0; i < opCount; i++)
            stack.pop();
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }
}