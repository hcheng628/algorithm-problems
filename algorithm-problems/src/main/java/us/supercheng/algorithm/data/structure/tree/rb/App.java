package us.supercheng.algorithm.data.structure.tree.rb;

import us.supercheng.algorithm.common.helper.FileOperation;
import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.ArrayList;

public class App {
    public static void main(String[] args){
        PrintHelper.echoLn("Pride and Prejudice");
        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("src/main/resources/books/pride-and-prejudice.txt", words)) {
            PrintHelper.echoLn("Total words: " + words.size());
            RBTree<String, Integer> map = new RBTree<>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }
            PrintHelper.echoLn("Total different words: " + map.getSize());
            PrintHelper.echoLn("Frequency of PRIDE: " + map.get("pride"));
            PrintHelper.echoLn("Frequency of PREJUDICE: " + map.get("prejudice"));
        }
    }
}