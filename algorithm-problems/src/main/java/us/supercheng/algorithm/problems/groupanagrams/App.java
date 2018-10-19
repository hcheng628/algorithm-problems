package us.supercheng.algorithm.problems.groupanagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new ArrayList<>();
        Map<Integer,int []> map = new HashMap<>();
        for(String each : strs) {
            int [] db = new int[26];
            for(char c : each.toCharArray())
                db[c - 'a']++;
            int hasIt = this.contains(map, db);
            if(hasIt == -1) {
                List<String> list = new ArrayList();
                list.add(each);
                ret.add(list);
                map.put(ret.size()-1, db);
            } else
                ret.get(hasIt).add(each);
        }
        return ret;
    }

    public int contains(Map<Integer, int []> map, int[] db) {
        for(Integer key : map.keySet()) {
            int [] row = map.get(key);
            boolean found = true;
            for(int i=0;i<26;i++)
                if(row[i] != db[i]) {
                    found = false;
                    break;
                }
            if(found)
                return key;
        }
        return -1;
    }
}
