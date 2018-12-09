package us.supercheng.algorithm.problems.wordladder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet(wordList),
                visited = new HashSet();
        visited.add(beginWord);
        int ret = 1;

        while(!visited.contains(endWord)) {
            Set<String> temp = new HashSet();
            for(String eachV : visited) {
                List<String> del = new ArrayList();
                for(String each : set)
                    if(this.isOneCharDiff(each, eachV)) {
                        temp.add(each);
                        del.add(each);
                    }
                for(String t : del)
                    set.remove(t);
            }

            if(temp.isEmpty())
                return 0;

            visited = temp;
            ret++;
            if(visited.contains(endWord))
                return ret;
        }
        return 0;
    }

    private boolean isOneCharDiff(String a, String b) {
        for(int i=0,count=0;i<a.length();i++)
            if(a.charAt(i) != b.charAt(i))
                if(++count > 1)
                    return false;
        return true;
    }
}