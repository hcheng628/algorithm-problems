package us.supercheng.algorithm.problems.leetcode.customsortstring;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String customSortString(String S, String T) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (char c : T.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        for (char c : S.toCharArray()) {
            Integer count = map.get(c);
            if (count != null) {
                for (int i=0;i<count;i++)
                    sb.append(c);
                map.put(c, 0);
            }
        }

        for (Character c : map.keySet())
            for (int i=0, count=map.get(c);i<count;i++)
                sb.append(c);

        return sb.toString();
    }

    public String customSortStringOPTMap(String S, String T) {
        int[] map = new int[26];
        StringBuilder sb = new StringBuilder();

        for (char c : T.toCharArray())
            map[c-'a']++;

        for (char c : S.toCharArray()) {
            int cNum = c-'a';
            for (int i=0,len=map[cNum];i<len;i++)
                sb.append(c);
            map[cNum] = 0;
        }

        for (int i=0;i<26;i++)
            for (int j=0,count=map[i],cNum=i+'a';j<count;j++)
                sb.append((char)cNum);

        return sb.toString();
    }

    public String customSortStringSORT(String S, String T) {
        char[] chars = new StringBuilder().append(T).toString().toCharArray();
        Character[] ret = new Character[chars.length];

        for (int i=0, len=chars.length;i<len;i++)
            ret[i] = chars[i];

        Arrays.sort(ret, new Comparator<Character>(){
            @Override
            public int compare(Character o1, Character o2) {
                return S.indexOf(o1) - S.indexOf(o2);
            }
        });

        for (int i=0,len=chars.length;i<len;i++)
            chars[i] = ret[i];

        return String.valueOf(chars);
    }
}