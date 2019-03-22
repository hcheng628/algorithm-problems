package us.supercheng.algorithm.problems.countnumberswithuniquedigits;

class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int ret = 1, multipler = 9;
        for (int i=1;i<=n;i++,multipler--) {
            int res = 9;
            for (int j=9;j>multipler;j--)
                res *=j;
            ret += res;
        }
        return ret;
    }
}