package us.supercheng.algorithm.data.structure.stack;

public class MyArrayStackMain {

    public static void main(String [] args) {

        MyArrayStack<Integer> stack = new MyArrayStack<>();

        for(int i = 0 ; i < 20 ; i ++){
            stack.push(i);
            System.out.println(stack);
        }

        for(int i = 0 ; i < 25 ; i ++){
            try{
                Thread.sleep(300);
            } catch (Exception ex) {}
            stack.pop();
            System.out.println(stack);
        }

        for(int i = 0 ; i < 20 ; i ++){
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}