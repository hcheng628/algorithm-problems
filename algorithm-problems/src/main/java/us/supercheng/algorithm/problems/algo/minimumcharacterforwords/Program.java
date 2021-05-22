package us.supercheng.algorithm.problems.algo.minimumcharacterforwords;

import java.util.*;

public class Program {

    // Time: O(w*n) Space: O(1) [fixed amount of different characters]
    public String[] minimumCharactersForWords(String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        for (String w : words) {
            Map<Character, Integer> m = new HashMap<>();
            for (char c : w.toCharArray()) {
                m.put(c, m.getOrDefault(c, 0) + 1);
                if (!map.containsKey(c) || map.get(c) < m.get(c))
                    map.put(c, m.get(c));
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char c = entry.getKey();
            for (int i=0, len=entry.getValue(); i<len; i++)
                list.add(Character.toString(c));
        }

        String[] ret = new String[list.size()];
        for (int i=0, len=list.size(); i<len; i++)
            ret[i] = list.get(i);

        return ret;
    }
}
