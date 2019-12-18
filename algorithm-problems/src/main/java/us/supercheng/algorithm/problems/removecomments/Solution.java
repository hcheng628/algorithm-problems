package us.supercheng.algorithm.problems.removecomments;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> removeComments(String[] source) {
        if (source == null || source.length < 1)
            return new ArrayList<>();

        List<String> ret = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean isBlocking = false;
        for (String s : source) {
            isBlocking = this.processRow(s.toCharArray(), isBlocking, sb);
            if (!isBlocking && sb.length() != 0) {
                ret.add(sb.toString());
                sb.setLength(0);
            }
        }
        return ret;
    }

    private boolean processRow(char[] chars, boolean isBlocking, StringBuilder sb) {
        for (int i=0, len=chars.length;i<len;i++) {
            if (isBlocking) {
                if (i+1 < len && chars[i] == '*' && chars[i+1] == '/') {
                    isBlocking = false;
                    i++;
                }
            } else {
                if (i+1 < len && chars[i] == '/' && chars[i+1] == '/')
                    return isBlocking;
                else if (i+1 < len && chars[i] == '/' && chars[i+1] == '*') {
                    isBlocking = true;
                    i++;
                } else
                    sb.append(chars[i]);
            }
        }
        return isBlocking;
    }
}