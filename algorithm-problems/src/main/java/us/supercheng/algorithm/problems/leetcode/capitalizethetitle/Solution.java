package us.supercheng.algorithm.problems.leetcode.capitalizethetitle;

class Solution {

    public String capitalizeTitle(String title) {
        char[] chars = title.toCharArray();

        for (int i = 0, len = chars.length; i < len; i++)
            if (chars[i] != ' ') {
                int right = i;
                for (; right < len && chars[right] != ' '; right++)
                    chars[right] = Character.toLowerCase(chars[right]);

                if (right - i > 2)
                    chars[i] = Character.toUpperCase(chars[i]);
                i = right;
            }

        return new String(chars);
    }

}
