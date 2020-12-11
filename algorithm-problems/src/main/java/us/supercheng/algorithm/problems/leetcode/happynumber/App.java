package us.supercheng.algorithm.problems.leetcode.happynumber;

import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        App app = new App();
        System.out.println(app.isHappy(19));
    }

    public boolean isHappy(int n) {
        String nStr = n + "";
        Map<Integer, Integer> prev = new HashMap<>();
        boolean goFlag = true;
        Integer eachResult = null;
        while(goFlag) {
            eachResult = 0;
            for(int i=0;i<nStr.length();i++) {
                eachResult += (int)Math.pow(Integer.parseInt(nStr.charAt(i) + ""), 2);
            }
            if(prev.get(eachResult)!= null) {
                goFlag = false;
            }
            if(eachResult == 1) {
                return true;
            }
            prev.put(eachResult, eachResult);
            nStr = eachResult + "";
        }
        return false;
    }
}