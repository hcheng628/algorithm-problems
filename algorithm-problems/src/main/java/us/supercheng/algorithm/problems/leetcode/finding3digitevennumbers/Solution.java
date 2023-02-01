package us.supercheng.algorithm.problems.leetcode.finding3digitevennumbers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public int[] findEvenNumbersBF(int[] digits) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0, len = digits.length; i < len; i++)
            for (int j = 0; digits[i] != 0 && j < len; j++)
                for (int k = 0; i != j && k < len; k++)
                    if (i != k && j != k && digits[k] % 2 == 0)
                        set.add(digits[i] * 100 + digits[j] * 10 + digits[k]);

        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    public int[] findEvenNumbers(int[] digits) {
        int[] counts = new int[10];
        List<Integer> ret = new ArrayList<>();

        for (int d : digits)
            counts[d]++;

        next_number:
        for (int num = 100, curr = num; num < 1000; num += 2) {
            int[] tmpCounts = new int[10];
            curr = num;

            for (int i = 0; i < 3; i++, curr /= 10)
                tmpCounts[curr % 10]++;

            for (int i = 0; i < 10; i++)
                if (counts[i] < tmpCounts[i])
                    continue next_number;

            ret.add(num);
        }

        return ret.stream().mapToInt(Integer::intValue).toArray();
    }

}
