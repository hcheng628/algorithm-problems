package us.supercheng.algorithm.data.structure.tree.avl;

import us.supercheng.algorithm.common.helper.FileOperation;
import us.supercheng.algorithm.common.helper.PrintHelper;
import us.supercheng.algorithm.data.structure.tree.BST;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        PrintHelper.echoLn("Pride and Prejudice");
        ArrayList<String> words = new ArrayList();
        if(FileOperation.readFile("src/main/resources/books/pride-and-prejudice.txt", words)) {
            PrintHelper.echoLn("Total words: " + words.size());
            // Test BST
            long startTime = System.nanoTime();
            BST<String, Integer> bst = new BST<>();
            for (String word : words) {
                if (bst.contains(word))
                    bst.set(word, bst.get(word) + 1);
                else
                    bst.add(word, 1);
            }
            for(String word: words)
                bst.contains(word);
            long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000000.0;
            PrintHelper.echoLn("BST: " + time + " s");

            startTime = System.nanoTime();

            AVLTree<String, Integer> avl = new AVLTree<>();
            for (String word : words) {
                if (avl.contains(word))
                    avl.set(word, avl.get(word) + 1);
                else
                    avl.add(word, 1);
            }

            for(String word: words)
                avl.contains(word);

            endTime = System.nanoTime();

            time = (endTime - startTime) / 1000000000.0;
            PrintHelper.echoLn("AVL: " + time + " s");
            PrintHelper.echoLn(avl.isBalanced());
            PrintHelper.echoLn("Occ prejudice: " + avl.get("prejudice"));
            PrintHelper.echoLn("Occ pride: " + avl.get("pride"));
        }
        PrintHelper.echoLn("");
    }
}