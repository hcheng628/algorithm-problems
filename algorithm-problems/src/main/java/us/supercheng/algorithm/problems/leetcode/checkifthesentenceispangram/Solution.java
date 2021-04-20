package us.supercheng.algorithm.problems.leetcode.checkifthesentenceispangram;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public boolean checkIfPangram(String sentence) {
        Set<Integer> set = new HashSet<>();

        for (int i=0; i<26; i++)
            set.add(i);

        for (char c : sentence.toCharArray())
            set.remove(c - 'a');

        return set.isEmpty();
    }

}
