package us.supercheng.algorithm.data.structure.list;

import us.supercheng.algorithm.common.helper.PrintHelper;
import us.supercheng.algorithm.common.helper.ThreadHelper;

public class MyLinkedListMain {

    public static void main(String[] args) {
        testMyLinkedList(new MyLinkedList<Integer>());
    }

    public static void testMyLinkedList(MyLinkedList<Integer> linkedList) {
        PrintHelper.echoLn("Is MyLinkedList Empty? " + linkedList.isEmpty() + "\n");
        ThreadHelper.sleep(5);

        PrintHelper.echoLn("Create a MyLinkedList 1 to 5");
        for(int i=1;i<6;i++)
            linkedList.addLast(i);
        PrintHelper.echoLn(linkedList + "\n");
        ThreadHelper.sleep(5);


        PrintHelper.echoLn("Is MyLinkedList Empty? " + linkedList.isEmpty()+ "\n");
        ThreadHelper.sleep(5);

        PrintHelper.echoLn("Remove the 2nd from MyLinkedList");
        linkedList.remove(2);
        PrintHelper.echoLn(linkedList + "\n");
        ThreadHelper.sleep(5);

        PrintHelper.echoLn("Remove the 1st from MyLinkedList");
        linkedList.removeFirst();
        PrintHelper.echoLn(linkedList + "\n");
        ThreadHelper.sleep(5);

        PrintHelper.echoLn("Remove the last from MyLinkedList");
        linkedList.removeLast();
        PrintHelper.echoLn(linkedList + "\n");
        ThreadHelper.sleep(5);

        PrintHelper.echoLn("Add (13) as the First Element in MyLinkedList");
        linkedList.addFirst(13);
        PrintHelper.echoLn(linkedList + "\n");
        ThreadHelper.sleep(5);

        PrintHelper.echoLn("Insert (6) at Index 2 in MyLinkedList");
        linkedList.addFirst(6);
        PrintHelper.echoLn(linkedList + "\n");
        ThreadHelper.sleep(5);

        PrintHelper.echoLn("Does MyLinkedList Contains 6? " + linkedList.contains(6) + "\n");
        ThreadHelper.sleep(5);

        PrintHelper.echoLn("Does MyLinkedList Contains 7? " + linkedList.contains(7) + "\n");
        ThreadHelper.sleep(5);

        PrintHelper.echoLn("Delete Element 13 from MyLinkedList");
        linkedList.removeElement(13);
        PrintHelper.echoLn(linkedList + "\n");
        ThreadHelper.sleep(5);


        PrintHelper.echoLn("Set MyLinkedList the 1st Element to 13");
        linkedList.set(0, 13);
        PrintHelper.echoLn(linkedList + "\n");
        ThreadHelper.sleep(5);

        PrintHelper.echoLn("Get the 1st Element from MyLinkedList >>> " + linkedList.getFirst()+ "\n");
        ThreadHelper.sleep(5);

        PrintHelper.echoLn("Get the last Element from MyLinkedList >>> " + linkedList.getLast()+ "\n");
        ThreadHelper.sleep(5);

        PrintHelper.echoLn("Get MyLinkedList Size>>> " + linkedList.getSize()+ "\n");
    }
}