package us.supercheng.algorithm.problems.firstbadversion;

public class App {

    /**
     * You are given an API bool isBadVersion(version) which will return whether version is bad.
     * Implement a function to find the first bad version.
     * You should minimize the number of calls to the API.
     * @param version
     * @return
     */
    boolean isBadVersion(int version) {
        // Cannot Test Here ;-(
        return true;
    }

    public int firstBadVersion(int n) {
        if(n == 1) {
            return n;
        }
        int left = 1;
        int right = n;
        while(left <= right) {
            int curr = left + ((right - left) / 2);
            if(isBadVersion(curr)) {
                if(curr -1 < left) {
                    return left;
                }
                if (!isBadVersion(curr +1) ) {
                    return curr + 1;
                }
                right = curr;
            } else {
                if(curr + 1 > right) {
                    return right;
                }
                if(isBadVersion(curr+1)) {
                    return curr + 1;
                }
                left = curr;
            }
        }
        return -1;
    }
}