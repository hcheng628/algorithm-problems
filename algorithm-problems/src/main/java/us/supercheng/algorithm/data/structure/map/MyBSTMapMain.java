package us.supercheng.algorithm.data.structure.map;

import us.supercheng.algorithm.common.helper.PrintHelper;

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

    }
}