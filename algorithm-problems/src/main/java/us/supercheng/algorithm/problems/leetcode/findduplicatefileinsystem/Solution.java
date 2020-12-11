package us.supercheng.algorithm.problems.leetcode.findduplicatefileinsystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> ret = new ArrayList<>();

        for (String path : paths) {
            String[] dir = path.split(" ");
            for (int i=1;i<dir.length;i++) {
                int lastIdxP = dir[i].lastIndexOf("(");
                String file = dir[i].substring(lastIdxP+1, dir[i].length());

                if (map.containsKey(file))
                    map.get(file).add(dir[0] + "/" + dir[i].substring(0, dir[i].lastIndexOf("(")));
                else {
                    List<String> list = new ArrayList<>();
                    list.add(dir[0] + "/" + dir[i].substring(0, dir[i].lastIndexOf("(")));
                    map.put(file, list);
                }
            }
        }

        for (String content : map.keySet()) {
            List<String> eachList = map.get(content);
            if (eachList.size()>1)
                ret.add(eachList);
        }

        return ret;
    }
}