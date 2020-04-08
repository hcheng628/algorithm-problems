package us.supercheng.algorithm.problems.convertintegertothesumoftwonozerointegers;

public class Solution {

    public int[] getNoZeroIntegers(int n) {
        for (int i=1;i<n;i++) {
            int b = n - i,
                    copyI = i,
                    copyB = b;
            boolean found = true;

            for (; found && copyI > 9; copyI /=10)
                if (copyI % 10 == 0)
                    found = false;

            for (; found && copyB > 9; copyB /= 10)
                if (copyB % 10 == 0)
                    found = false;

            if (found)
                return new int[] {i, b};
        }

        return new int[2]; // should not ret here
    }
}