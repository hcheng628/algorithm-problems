package us.supercheng.algorithm.problems.decodeways;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        int res = new App().numDecodings("226");
    }

    public int numDecodings(String s) {
        if(s == null || s.length() == 0)
            return 0;
        if(s.length() == 1)
            return 1;

        char[] chars = s.toCharArray();
        //Set<String> set = new HashSet<>();
        List<String> superList = new ArrayList<>();

        this.helper(superList, "", chars, 0);

        for(String row : superList) {
            System.out.println(row);
        }
        return 0;
    }

    private void helper(List<String> superList, String list, char[] chars, int index) {
        System.out.println("index: " + index);

//        if(addIt && index < chars.length) {
//            list.add(Character.toString(chars[index]));
//        }

        if (index > chars.length) {
            return;
        } else if (list.length() == chars.length) {
            superList.add(list);
            return;
        }


        for(int i=index;i<chars.length;i++) {
            //list.add(Character.toString(chars[i]));
            list += Character.toString(chars[i]);
            this.helper(superList, list, chars, i+1);
            //System.out.println("i: " + i);
            if(i+1 <= chars.length -1 && Integer.parseInt((chars[i]) + "" + (chars[i+1])) < 26 ) {
                //list.add(chars[i] + "" + chars[i+1]);
                list += chars[i] + "" + chars[i+1];
                this.helper(superList, list, chars, i+2);
                list.substring(0, list.length()-1);
            }

            list.substring(0, list.length()-1);
            //list.remove(list.size()-1);
        }
    }
}