package us.supercheng.algorithm.problems.leetcode.numberofstudentsunabletoeatlunch;

public class Solution {

    public int countStudents(int[] students, int[] sandwiches) {
        int[] bucket = new int[2];

        for (int stu : students)
            bucket[stu]++;

        for (int sand : sandwiches) {
            if (bucket[sand] < 1)
                return bucket[1-sand];
            bucket[sand]--;
        }

        return 0;
    }

}