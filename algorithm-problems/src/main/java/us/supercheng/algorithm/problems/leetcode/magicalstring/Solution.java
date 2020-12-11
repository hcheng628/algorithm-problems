package us.supercheng.algorithm.problems.leetcode.magicalstring;

class Solution {

    public int magicalString(int n) {
        if (n < 1)
            return 0;
        else if (n < 4)
            return 1;

        int [] arr = new int[n];
        int retVal = 1, idx = 2, digitCount = 3;

        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 2;


        for (boolean isOne = true;digitCount < n;isOne = !isOne)
            if (arr[idx++] == 1)
                if (isOne) {
                    arr[digitCount++] = 1;
                    retVal++;
                } else
                    arr[digitCount++] = 2;
            else
                if (isOne) {
                    arr[digitCount++] = 1;
                    retVal++;
                    if (digitCount < n) {
                        arr[digitCount++] = 1;
                        retVal++;
                    }
                } else {
                    arr[digitCount++] = 2;
                    if (digitCount < n)
                        arr[digitCount++] = 2;
                }
        return retVal;
    }
}