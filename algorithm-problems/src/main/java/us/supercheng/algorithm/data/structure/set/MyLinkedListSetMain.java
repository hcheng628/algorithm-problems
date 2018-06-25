package us.supercheng.algorithm.data.structure.set;

import us.supercheng.algorithm.common.helper.FileOperation;
import us.supercheng.algorithm.data.structure.list.MyLinkedList;
import java.io.File;
import java.util.ArrayList;

public class MyLinkedListSetMain {

    public static void main(String[] args) {
        String book_Pride_and_Prejudice = "books/pride-and-prejudice.txt";
        String book_A_Tale_of_Two_Cities = "books/a-tale-of-two-cities.txt";
        String filePathPP = new File(MyBSTSetMain.class.getClassLoader().getResource(book_Pride_and_Prejudice).getFile()).getAbsolutePath();
        String filePathTTC = new File(MyBSTSetMain.class.getClassLoader().getResource(book_A_Tale_of_Two_Cities).getFile()).getAbsolutePath();
        System.out.println("Pride and Prejudice");
        ArrayList<String> words1 = new ArrayList<>();
        if (FileOperation.readFile((filePathPP), words1)) {
            System.out.println("Total words: " + words1.size());
            MyLinkedListSet<String> set1 = new MyLinkedListSet<>();
            for (String word : words1)
                set1.add(word);
            System.out.println("Total different words: " + set1.getSize());
        }
        System.out.println();
        System.out.println("A Tale of Two Cities");
        ArrayList<String> words2 = new ArrayList<>();
        if (FileOperation.readFile(filePathTTC, words2)) {
            System.out.println("Total words: " + words2.size());
            MyLinkedListSet<String> set2 = new MyLinkedListSet<>();
            for (String word : words2)
                set2.add(word);
            System.out.println("Total different words: " + set2.getSize());
        }
    }
}