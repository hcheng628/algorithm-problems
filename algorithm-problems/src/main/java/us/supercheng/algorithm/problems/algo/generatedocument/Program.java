package us.supercheng.algorithm.problems.algo.generatedocument;

import java.util.HashMap;
import java.util.Map;

public class Program {

    // Time: (c + d) Space: (n)
    public boolean generateDocument(String characters, String document) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : characters.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        for (char c : document.toCharArray()) {
            Integer count = map.get(c);
            if (count == null || count == 0)
                return false;

            map.put(c, count - 1);
        }

        return true;
    }
}
