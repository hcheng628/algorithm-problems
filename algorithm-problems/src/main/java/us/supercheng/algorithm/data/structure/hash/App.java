package us.supercheng.algorithm.data.structure.hash;

import us.supercheng.algorithm.common.helper.FileOperation;
import us.supercheng.algorithm.common.helper.PrintHelper;
import us.supercheng.algorithm.data.structure.tree.avl.AVLTree;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) {

        HashTable<String, Integer> table = new HashTable<>();
        table.add("Illy", 1);
        table.add("Apple", 1);

        PrintHelper.echoLn(table.contains("Illy"));
        PrintHelper.echoLn(table.get("Apple"));

        table.add("KIMBO", 1);

        PrintHelper.echoLn(table.remove("KIMBO"));
        PrintHelper.echoLn("Size: " + table.size());
        table.set("Apple", 13);
        PrintHelper.echoLn(table.get("Illy"));
        table.remove("KIMBO");

        /* */
        PrintHelper.echoLn("Pride and Prejudice");
        ArrayList<String> words = new ArrayList();
        if(FileOperation.readFile("src/main/resources/books/pride-and-prejudice.txt", words)) {
            PrintHelper.echoLn("Total words: " + words.size());
            // Test HashTable
            long startTime = System.nanoTime();
            HashTable<String, Integer> hashTable = new HashTable<>();
            for (String word : words) {
                if (hashTable.contains(word))
                    hashTable.set(word, hashTable.get(word) + 1);
                else
                    hashTable.add(word, 1);
            }
            for(String word: words)
                hashTable.contains(word);
            long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000000.0;
            PrintHelper.echoLn("HashTable " + time + " s");

            // Test AVLTree
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

            PrintHelper.echoLn("Occ prejudice: " + hashTable.get("prejudice"));
            PrintHelper.echoLn("Occ pride: " + hashTable.get("pride"));

            for(String word : words) {
                hashTable.remove(word);
                if(hashTable.contains(word))
                    throw new RuntimeException("Delete Exception Word: " + word);
            }
        }
        PrintHelper.echoLn("");
    }
}