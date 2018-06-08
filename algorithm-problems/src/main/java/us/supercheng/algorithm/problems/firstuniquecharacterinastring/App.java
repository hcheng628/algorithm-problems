package us.supercheng.algorithm.problems.firstuniquecharacterinastring;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        App app = new App();
        String name = "SteveNash";

        PrintHelper.echoLn(app.firstUniqChar(name));
        PrintHelper.echoLn(app.firstUniqChar2(name));
        PrintHelper.echoLn(app.firstUniqChar3(name));
    }

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(map.get(c) == null) {
                map.put(c, i);
            } else {
                map.put(c, -1);
            }
        }
        int max = Integer.MAX_VALUE;
        for(Character key : map.keySet()) {
            int pos = map.get(key);
            if(pos != -1) {
                if(pos < max) {
                    max = pos;
                }
            }
        }
        return max == Integer.MAX_VALUE ? -1 : max;
    }

    public int firstUniqChar2(String s) {
        char c = 'a';
        int index = Integer.MAX_VALUE;
        for(int i=0;i<26;i++) {
            char currChar = (char)((int)c + i);
            int tempIndex = s.indexOf(currChar + "");
            if(tempIndex != -1) {
                String temp = s.substring(0, tempIndex) + s.substring(tempIndex+1, s.length());
                if(temp.indexOf(currChar) ==-1 && tempIndex < index) {
                    index = tempIndex;
                }
            }
        }
        return index == Integer.MAX_VALUE ? -1 : index;
    }

    public int firstUniqChar3(String s) {
        int index = Integer.MAX_VALUE;
        for(int i='a';i<='z';i++) {
            int first = s.indexOf(i);
            if(first != -1 && first == s.lastIndexOf(i)) {
                index = Math.min(index, first);
            }
        }
        return index == Integer.MAX_VALUE ? -1 : index;
    }
}
