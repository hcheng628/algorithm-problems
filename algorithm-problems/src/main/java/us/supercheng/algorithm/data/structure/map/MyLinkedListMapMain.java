package us.supercheng.algorithm.data.structure.map;

import us.supercheng.algorithm.common.helper.FileOperation;
import us.supercheng.algorithm.common.helper.PrintHelper;
import us.supercheng.algorithm.data.structure.set.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MyLinkedListMapMain {

    public static void main(String[] args) {
        MyLinkedListMap<Integer, String> myLinkedListMap = new MyLinkedListMap<>();
        PrintHelper.echoLn("Del 13: " + myLinkedListMap.remove(13));
        myLinkedListMap.add(13, "Nash");
        PrintHelper.echoLn("Del 13: " + myLinkedListMap.remove(13));
        myLinkedListMap.add(13, "Nash");
        myLinkedListMap.add(28, "Cheng");

        PrintHelper.echoLn("Map Size: " + myLinkedListMap.getSize());
        PrintHelper.echoLn("Map Contains 13? " + myLinkedListMap.contains(13));
        PrintHelper.echoLn("Map Contains 28? " + myLinkedListMap.contains(28));
        PrintHelper.echoLn("Get 15 [This is not in the Map]: " + myLinkedListMap.get(15));
        PrintHelper.echoLn("Get 13 [Nash]: " + myLinkedListMap.get(13));

        PrintHelper.echoLn("Add 15[Carter] ");
        myLinkedListMap.add(15, "Carter");
        PrintHelper.echoLn("Get 15 [Carter]: " + myLinkedListMap.get(15));
        PrintHelper.echoLn("Change 15[Carter] to 15[Messi]");
        myLinkedListMap.set(15, "Messi");
        PrintHelper.echoLn("Get 15 [Messi]: " + myLinkedListMap.get(15));

        PrintHelper.echoLn("Del 15: " + myLinkedListMap.remove(15));
        PrintHelper.echoLn("Get 15 [null]: " + myLinkedListMap.get(15));

        PrintHelper.echoLn("Add some more data .....");
        myLinkedListMap.add(6, "Moka");
        myLinkedListMap.add(3, "Sambuca");
        PrintHelper.echoLn("Del 13: " + myLinkedListMap.remove(13));
        PrintHelper.echoLn("Get 13 [null]: " + myLinkedListMap.get(13));
        PrintHelper.echoLn("Del 3: " + myLinkedListMap.remove(3));
        PrintHelper.echoLn("Get 3 [null]: " + myLinkedListMap.get(3));
        PrintHelper.echoLn("Get 100 [null]: " + myLinkedListMap.get(100));
        PrintHelper.echoLn("Map Size: " + myLinkedListMap.getSize());


        String book_Pride_and_Prejudice = "books/pride-and-prejudice.txt";
        String book_A_Tale_of_Two_Cities = "books/a-tale-of-two-cities.txt";
        String filePathPP = new File(MyBSTSetMain.class.getClassLoader().getResource(book_Pride_and_Prejudice).getFile()).getAbsolutePath();
        String filePathTTC = new File(MyBSTSetMain.class.getClassLoader().getResource(book_A_Tale_of_Two_Cities).getFile()).getAbsolutePath();
        ArrayList<String> words1 = new ArrayList<>();
        ArrayList<String> words2 = new ArrayList<>();
        if (FileOperation.readFile((filePathPP), words1) && FileOperation.readFile((filePathTTC), words2)) {
            double linkedListTime = MyLinkedListMapMain.execute(new MyLinkedListMap<String, Integer>(), words1, words2);
            PrintHelper.echoLn("LinkedListMap Time: " + linkedListTime);
        }
    }

    public static double execute(Map<String, Integer> map, List<String> words1, List<String> words2) {
        long start = System.nanoTime();
        for (String word : words1) {
            if (map.contains(word))
                map.set(word, map.get(word) + 1);
            else
                map.add(word, 1);
        }
        for (String word : words2) {
            if (map.contains(word))
                map.set(word, map.get(word) + 1);
            else
                map.add(word, 1);
        }
        PrintHelper.echoLn("Total different words: " + map.getSize() +
                "\nFrequency of PRIDE: " + map.get("pride") +
                "\nFrequency of PREJUDICE: " + map.get("prejudice"));
        long end = System.nanoTime();
        return (end - start) / 1000000000.0;
    }
}