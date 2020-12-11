package us.supercheng.algorithm.problems.leetcode.topkfrequentelements;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class App {

    public static void main(String[] args) {
        int [] nums = {1,1,1,2,2,3};
        int k = 2;
        for(int each : new App().topKFrequent(nums, k))
            PrintHelper.echo(each + " ");
    }

    public List<Integer> topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> ret = new ArrayList<>();

        for(int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        List<Integer> list = new ArrayList<>();
        for(int key : map.keySet())
            if(!list.contains(map.get(key)))
                list.add(map.get(key));

        Collections.sort(list, Collections.reverseOrder());

        for(int i=0;i<k && i<list.size() && ret.size()<k;i++)
            for(int key: map.keySet())
                if(map.get(key) == list.get(i) )
                    ret.add(key);

        return ret;
    }
}