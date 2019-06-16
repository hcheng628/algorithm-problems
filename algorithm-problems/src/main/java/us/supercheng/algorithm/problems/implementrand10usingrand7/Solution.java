package us.supercheng.algorithm.problems.implementrand10usingrand7;

import java.util.Random;

class Solution {
    public int rand10() {
        int ret = 0;
        do {
            ret = 7 * (this.rand7() - 1) + this.rand7();
        } while (ret > 40);
        ret %= 10;
        return ret == 0 ? 10 : ret;
    }

    private int rand7() {
        return new Random().nextInt(7) + 1;
    }
}