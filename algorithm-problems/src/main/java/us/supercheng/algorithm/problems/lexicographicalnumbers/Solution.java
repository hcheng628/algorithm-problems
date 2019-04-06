package us.supercheng.algorithm.problems.lexicographicalnumbers;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ret = new ArrayList<>();
        int curr = 1;
        for (int i=1;i<=n;i++) {
            ret.add(curr);
            if (curr * 10 <= n)
                curr *= 10;
            else if (curr % 10 != 9 && curr + 1 <= n)
                curr++;
            else {
                if (curr == n) {
                    while ((curr / 10) % 10 == 9)
                        curr /= 10;
                    curr = curr / 10 + 1;
                } else {
                    while (curr % 10 == 9)
                        curr /= 10;
                    curr++;
                }
            }
        }
        return ret;
    }
}