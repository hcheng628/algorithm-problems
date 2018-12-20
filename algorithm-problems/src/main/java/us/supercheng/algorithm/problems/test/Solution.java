package us.supercheng.algorithm.problems.test;

import us.supercheng.algorithm.common.helper.PrintHelper;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        int [][] nums = {{1,1,0},{1,1,0},{0,0,1}};
        int [][] num2 = {{1,1,0},{1,1,0},{0,0,1}};

        Solution solution = new Solution();
        int res = solution.findCircleNum(nums);
        PrintHelper.echoLn("res: " + res);

        Map<String, String> map = new HashMap<>();

        //map.put("a", "A");

        PrintHelper.echoLn(map.put("b", "B"));
        map.put("a", "A");
        PrintHelper.echoLn(map.get("a"));
        map.put("a", "B");
        PrintHelper.echoLn(map.get("a"));

    }

    private int [] data;

    public int findCircleNum(int[][] M) {
        this.data = new int [M.length ];
        for(int i=0;i<this.data.length;i++)
            this.data[i] = i;

        int index = 0;
        for(int i=0;i<M.length;i++) {
            for(int j=i+1;j<M[0].length;j++,index++) {
                if(M[i][j] == 1) {
                    this.makeFriend(i, j);
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        for(int each : this.data)
            set.add(each);
        return set.size();
    }

    private void makeFriend(int a, int b) {
        if(this.data[a] == this.data[b])
            return;

        int groupId = this.data[b];
        for(int i=0;i<this.data.length;i++)
            if(this.data[i] == groupId)
                this.data[i] = this.data[a];
    }

}