package us.supercheng.algorithm.problems.leetcode.decodethemessage;

class Solution {

    public String decodeMessage(String key, String message) {
        StringBuilder sb = new StringBuilder();
        Character[] map = new Character[26];
        int idx = 0;

        for (char c : key.toCharArray())
            if (c != ' ' && map[c - 'a'] == null)
                map[c - 'a'] = (char) ('a' + idx++);

        for (char c : message.toCharArray())
            sb.append(c == ' ' ? ' ' : map[c - 'a']);

        return sb.toString();
    }

}
