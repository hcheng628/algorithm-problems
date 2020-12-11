package us.supercheng.algorithm.problems.leetcode.numberofboomerangs;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        int [][] arr = {{0,0},{1,0},{2,0}};
        PrintHelper.echoLn(new App().numberOfBoomerangs(arr));
    }

    public int numberOfBoomerangs(int[][] ps) {
        int ret = 0;
        for (int i=0; i<ps.length;i++) {
            Map<Long, Integer> map = new HashMap();
            for(int j=0;j<ps.length;j++) {
                if(i != j) {
                    long dis = (ps[i][0] - ps[j][0]) * (ps[i][0] - ps[j][0]) + (ps[i][1] - ps[j][1]) * (ps[i][1] - ps[j][1]);
                    if(map.containsKey(dis))
                        map.put(dis, map.get(dis) + 1);
                    else
                        map.put(dis,1);
                }
            }
            for(long key : map.keySet()) {
                int val = map.get(key);
                if(val> 1)
                    ret += val * (val -1);
            }
        }
        return ret;
    }
}
