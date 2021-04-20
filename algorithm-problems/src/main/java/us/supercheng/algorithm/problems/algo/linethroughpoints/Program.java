package us.supercheng.algorithm.problems.algo.linethroughpoints;

import java.util.HashMap;
import java.util.Objects;

public class Program {

    // Time: O(n^2) Space: O(n)
    public int lineThroughPoints(int[][] points) {
        if (points == null)
            return 0;
        if (points.length < 3)
            return points.length;

        int ret = 2;
        for (int i=0, len = points.length; i<len; i++) {
            HashMap<KeyInfo, Integer> map = new HashMap<>();
            for (int j=0; j<len; j++)
                if (i != j) {
                    int top = points[j][1] - points[i][1];
                    int bot = points[j][0] - points[i][0];
                    int gcd = this.gcd(top, bot);

                    KeyInfo key = new KeyInfo(top / gcd, bot / gcd);
                    if (!map.containsKey(key))
                        map.put(key, 1);
                    map.put(key, map.get(key) + 1);
                    ret = Math.max(map.get(key), ret);
                }
        }

        return ret;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : this.gcd(b, a % b);
    }

    class KeyInfo {
        int top;
        int bot;

        public KeyInfo(int top, int bot) {
            this.top = top;
            this.bot = bot;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            KeyInfo other = (KeyInfo) o;
            return top == other.top && bot == other.bot;
        }

        @Override
        public int hashCode() {
            return Objects.hash(top, bot);
        }
    }

}
