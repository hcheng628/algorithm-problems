package us.supercheng.algorithm.problems.increasingdecreasingstring;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public String sortString(String s) {

        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int len = s.length();

        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        for (boolean goUp = true; sb.length() != len; goUp =!goUp) {
            int inc = 1,
                from = 97;

            if (!goUp) {
                inc = -1;
                from = 122;
            }

            for (int i=0; i<26; i++, from += inc) {
                char cc = (char) (from);
                Integer count = map.get(cc);
                if (count != null) {
                    sb.append(cc);

                    if (count == 1)
                        map.remove(cc);
                    else
                        map.put(cc, count-1);
                }
            }
        }

        return sb.toString();
    }
}