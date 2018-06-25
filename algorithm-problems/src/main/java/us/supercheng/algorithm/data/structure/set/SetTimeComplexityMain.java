package us.supercheng.algorithm.data.structure.set;

import us.supercheng.algorithm.common.helper.FileOperation;
import us.supercheng.algorithm.common.helper.PrintHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SetTimeComplexityMain {

    public static void main(String[] args) {
        String book_Pride_and_Prejudice = "books/pride-and-prejudice.txt";
        String book_A_Tale_of_Two_Cities = "books/a-tale-of-two-cities.txt";
        String filePathPP = new File(MyBSTSetMain.class.getClassLoader().getResource(book_Pride_and_Prejudice).getFile()).getAbsolutePath();
        String filePathTTC = new File(MyBSTSetMain.class.getClassLoader().getResource(book_A_Tale_of_Two_Cities).getFile()).getAbsolutePath();
        System.out.println("Load 2 Books into List..... ");
        ArrayList<String> words1 = new ArrayList<>();
        ArrayList<String> words2 = new ArrayList<>();
        if (FileOperation.readFile((filePathPP), words1) && FileOperation.readFile((filePathTTC), words2)) {
            double bstTime = SetTimeComplexityMain.execute(new MyBSTSet<Integer>(), words1, words2);
            double linkedListTime = SetTimeComplexityMain.execute(new MyLinkedListSet<Integer>(), words1, words2);
            PrintHelper.echoLn("BST Time: " + bstTime);
            PrintHelper.echoLn("LinkedList Time: " + linkedListTime);
        }
    }

    public static double execute(Set<Integer> set, List<String> words1, List<String> words2) {
        long start = System.nanoTime();
        MyBSTSet<String> set1 = new MyBSTSet<>();
        for (String word : words1)
            set1.add(word);
        //System.out.println("Total different words: " + set1.getSize());
        MyBSTSet<String> set2 = new MyBSTSet<>();
        for (String word : words2)
            set2.add(word);
        //System.out.println("Total different words: " + set2.getSize());
        long end = System.nanoTime();
        return (end - start) / 1000000000.0;
    }
}