package us.supercheng.algorithm.problems.wordpattern;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class App {

    public static void main(String [] args) {
        App app = new App();
        System.out.println(app.wordPattern("aaa", "cheng cheng cheng"));
    }

    public boolean wordPattern(String pattern, String str) {
        String[] arr = str.split(" ");
        if(arr.length != pattern.length())
            return false;
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        for(int i=0;i<pattern.length();i++) {
            char c = pattern.charAt(i);
            if(map.get(c) == null) {
                map.put(c, arr[i]);
                if(!set.add(arr[i])) {
                    return false;
                }
            } else {
                if(!map.get(c).equals(arr[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}
