package us.supercheng.algorithm.problems.leetcode.oddstringdifference;

class Solution {

    public String oddString(String[] words) {
        for (int c = 0, cLen = words[0].length() - 1, rLen = words.length; c < cLen; c++) {
            int[] info1 = new int[]{100, -1, 0};
            int[] info2 = new int[]{100, -1, 0};
            for (int r = 0; r < rLen; r++) {
                int diff = words[r].charAt(c + 1) - words[r].charAt(c);

                if (info1[0] == 100)
                    info1 = new int[]{diff, r, 1};
                else
                    if (diff == info1[0]) {
                        info1[2]++;
                        if (info1[2] > 1 && info2[1] != -1)
                            return words[info2[1]];
                    } else {
                        if (info2[0] == 100) {
                            if (info1[2] > 1)
                                return words[r];
                            info2 = new int[]{diff, r, 1};
                        } else {
                            if (diff == info2[0])
                                info2[2]++;
                            if (info2[2] > 1)
                                return words[info1[1]];
                        }
                    }
            }
        }

        return "something is wrong";
    }

}
