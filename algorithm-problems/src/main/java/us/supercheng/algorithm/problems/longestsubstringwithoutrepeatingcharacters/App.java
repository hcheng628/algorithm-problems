package us.supercheng.algorithm.problems.longestsubstringwithoutrepeatingcharacters;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String [] args) {
        String s = "abcabcbb";
        PrintHelper.echoLn(new App().lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> db = new HashMap<>();
        char [] chars = s.toCharArray();
        int ret=0;
        for(int i=0;i<chars.length;i++) {
            char temp = chars[i];
            if(db.containsKey(temp) && db.get(temp) != null) {
                int prevIndex = db.get(temp);
                for(Character each : db.keySet())
                    if(db.get(each) != null && db.get(each) < prevIndex)
                        db.put(each, null);
            }
            db.put(temp, i);
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for(Character each : db.keySet()) {
                Integer val = db.get(each);
                if(val != null) {
                    if(val < min)
                        min = val;
                    if(val > max)
                        max = val;
                }
            }
            if(max - min + 1 > ret)
                ret = max - min + 1;
        }
        return ret;
    }
}