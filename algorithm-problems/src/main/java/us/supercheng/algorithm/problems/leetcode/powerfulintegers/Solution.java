package us.supercheng.algorithm.problems.leetcode.powerfulintegers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> ret = new HashSet<>();
        List<Integer> listX = new ArrayList(),
                listY = new ArrayList();

        this.populateList(listX, x, bound);
        this.populateList(listY, y, bound);
        for(int eachX : listX)
            for(int eachY : listY) {
                int res = eachX + eachY;
                if(res<= bound)
                    ret.add(res);
            }
        return new ArrayList<>(ret);
    }

    private void populateList(List<Integer> list, int val, int bound) {
        int prev = -1;
        for(int i=0;;i++,list.add(prev)) {
            int res = (int) Math.pow(val, i);
            if(prev == res || res > bound)
                break;
            prev = res;
        }
    }
}