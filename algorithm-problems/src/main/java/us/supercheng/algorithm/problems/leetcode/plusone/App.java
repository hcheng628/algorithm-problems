package us.supercheng.algorithm.problems.leetcode.plusone;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[]  args) {
        App app = new App();
        List<List<Integer>> list =  app.generate(13);
        for(List<Integer> eachList : list ) {
            for(Integer each : eachList) {
                System.out.print(each + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> returnList = new ArrayList<>();
        for(int i=1; i <= numRows; i++) {
            List<Integer> newIntList = new ArrayList<>();
            for(int j=1; j<=i;j++) {
                if(j == 1 || j == i) {
                    newIntList.add(1);
                } else {
                    if(i>=3) {
                        int a = returnList.get(i-2).get(j-2);
                        int b = returnList.get(i-2).get(j-1);
                        int res = a + b;
                        newIntList.add(res);
                    }
                }
            }
            returnList.add(newIntList);
        }
        return returnList;
    }
}