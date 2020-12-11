package us.supercheng.algorithm.problems.leetcode.hindexii;

class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0)
            return 0;
        int left=0, right=citations.length-1, len = citations.length;
        while (left <= right) {
            int mid = (right - left) / 2 + left, count = len - mid;
            if (citations[mid] == count)
                return count;
            else if (citations[mid] >= count)
                right = mid-1;
            else
                left = mid+1;
        }
        return len - left;
    }
}