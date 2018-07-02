package us.supercheng.algorithm.data.structure.map;

import us.supercheng.algorithm.common.helper.FileOperation;
import us.supercheng.algorithm.common.helper.PrintHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MyBSTMapMain {

    public static void main(String [] args) {
        MyBSTMap<Integer, String> myBSTMap = new MyBSTMap<>();

        myBSTMap.add(20, "20");
        myBSTMap.add(18, "18");
        myBSTMap.add(22, "22");
        myBSTMap.add(16, "16");
        myBSTMap.add(19, "19");
        myBSTMap.add(21, "21");
        myBSTMap.add(23, "23");

        int key = 18;
        PrintHelper.echoLn("Contains " + key + " ? " + myBSTMap.contains(key));
        PrintHelper.echoLn("Del " + key + ": " + myBSTMap.remove(key));
        myBSTMap.add(key, "Nash");
        PrintHelper.echoLn("Contains " + key + " ? " + myBSTMap.contains(key));
        PrintHelper.echoLn("Get " + key + " Before Del: " + myBSTMap.get(key));
        PrintHelper.echoLn("Del " + key + ": " + myBSTMap.remove(key));
        PrintHelper.echoLn("Get " + key + " After Del: " + myBSTMap.get(key));
        PrintHelper.echoLn("Contains " + key + " ? " + myBSTMap.contains(key));

        /* */
        myBSTMap.add(13, "Nash");
        myBSTMap.add(28, "Cheng");

        PrintHelper.echoLn("Map Size: " + myBSTMap.getSize());
        PrintHelper.echoLn("Map Contains 13? " + myBSTMap.contains(13));
        PrintHelper.echoLn("Map Contains 28? " + myBSTMap.contains(28));
        PrintHelper.echoLn("Get 15 [This is not in the Map]: " + myBSTMap.get(15));
        PrintHelper.echoLn("Get 16 [16]: " + myBSTMap.get(16));

        PrintHelper.echoLn("Add 15 [Carter] ");
        myBSTMap.add(15, "Carter");
        PrintHelper.echoLn("Get 15 [Carter]: " + myBSTMap.get(15));
        PrintHelper.echoLn("Change 15[Carter] to 15[Messi]");
        myBSTMap.set(15, "Messi");
        PrintHelper.echoLn("Get 15 [Messi]: " + myBSTMap.get(15));

        PrintHelper.echoLn("Del 15: " + myBSTMap.remove(15));
        PrintHelper.echoLn("Get 15 [null]: " + myBSTMap.get(15));

        PrintHelper.echoLn("Get Max: " + myBSTMap.getMax());
        PrintHelper.echoLn("Get Min: " + myBSTMap.getMin());

        PrintHelper.echoLn("Add some more data .....");
        myBSTMap.add(6, "Moka");
        myBSTMap.add(3, "Sambuca");
        PrintHelper.echoLn("Del 13: " + myBSTMap.remove(13));
        PrintHelper.echoLn("Get 13 [null]: " + myBSTMap.get(13));
        PrintHelper.echoLn("Del 3: " + myBSTMap.remove(3));
        PrintHelper.echoLn("Get 3 [null]: " + myBSTMap.get(3));
        PrintHelper.echoLn("Get 100 [null]: " + myBSTMap.get(100));
        PrintHelper.echoLn("Map Size: " + myBSTMap.getSize());

        String book_Pride_and_Prejudice = "books/pride-and-prejudice.txt";
        String book_A_Tale_of_Two_Cities = "books/a-tale-of-two-cities.txt";
        String filePathPP = new File(MyBSTMapMain.class.getClassLoader().getResource(book_Pride_and_Prejudice).getFile()).getAbsolutePath();
        String filePathTTC = new File(MyBSTMapMain.class.getClassLoader().getResource(book_A_Tale_of_Two_Cities).getFile()).getAbsolutePath();
        ArrayList<String> words1 = new ArrayList<>();
        ArrayList<String> words2 = new ArrayList<>();
        if (FileOperation.readFile((filePathPP), words1) && FileOperation.readFile((filePathTTC), words2)) {
            double bstMapTime = MyLinkedListMapMain.execute(new MyBSTMap<String, Integer>(), words1, words2);
            PrintHelper.echoLn("MSTMap Time: " + bstMapTime);
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