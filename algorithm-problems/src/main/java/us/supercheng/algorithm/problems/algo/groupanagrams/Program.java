package us.supercheng.algorithm.problems.algo.groupanagrams;

import java.util.*;

public class Program {

    public static List<List<String>> groupAnagrams_Solution1(List<String> words) {
        List<List<String>> ret = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (int i=0, size = words.size(); i<size; i++) {
            String w = words.get(i);
            char[] chars = w.toCharArray();
            Arrays.sort(chars);
            String sortedW = new String(chars);

            if (map.containsKey(sortedW))
                ret.get(map.get(sortedW)).add(w);
            else {
                List<String> l = new ArrayList<>();
                l.add(w);
                ret.add(l);
                map.put(sortedW, ret.size() - 1);
            }
        }

        return ret;
    }

    public static List<List<String>> groupAnagrams_Solution2(List<String> words) {
        int size = words.size();

        if (size < 1)
            return new ArrayList<>();

        List<String> sortedWords = new ArrayList<>();
        List<Integer> indices = new ArrayList<>();
        List<List<String>> ret = new ArrayList<>();

        for (int i=0; i<size; i++) {
            char[] chars = words.get(i).toCharArray();
            Arrays.sort(chars);
            sortedWords.add(new String(chars));
            indices.add(i);
        }

        indices.sort(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return sortedWords.get(a).compareTo(sortedWords.get(b));
            }
        });

        List<String> currGroup = new ArrayList<>();
        String curr = sortedWords.get(indices.get(0));

        for (int idx : indices) {
            String w = words.get(idx);
            String sortedW = sortedWords.get(idx);

            if (curr.equals(sortedW))
                currGroup.add(w);
            else {
                ret.add(new ArrayList<>(currGroup));
                curr = sortedW;
                currGroup = new ArrayList<>();
                currGroup.add(w);
            }
        }

        if (!currGroup.isEmpty())
            ret.add(currGroup);

        return ret;
    }
}