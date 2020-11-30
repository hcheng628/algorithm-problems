package us.supercheng.algorithm.problems.maximumrepeatingsubstring;

public class Solution {

    public int maxRepeating(String sequence, String word) {
        int ret = 0;

        for (int i=0, len = sequence.length(), wid = word.length(); i<len; i++) {
            if ((len - i) / wid <= ret)
                break;

            int idx = 0;
            while (idx + i <len && sequence.charAt(idx + i) == word.charAt(idx % wid))
                idx++;

            ret = Math.max(idx / wid, ret);
        }

        return ret;
    }

}