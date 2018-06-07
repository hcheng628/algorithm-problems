package us.supercheng.algorithm.problems.firstuniquecharacterinastring;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        App app = new App();
        PrintHelper.echoLn(app.firstUniqChar("SteveNash"));
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
}
