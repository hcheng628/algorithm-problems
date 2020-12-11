package us.supercheng.algorithm.problems.leetcode.minimumindexsumoftwolists;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.ArrayList;
import java.util.HashMap;

public class App {

    public static void main(String[] args) {
        String[] arr1 = {"Shogun","Tapioca Express","Burger King","KFC"};
        String[] arr2 = {"KFC","Burger King","Tapioca Express","Shogun"};

        for(String each : new App().findRestaurant(arr1, arr2))
            PrintHelper.echo(each + " ");

    }

    public String[] findRestaurant(String[] list1, String[] list2) {
        ArrayList<String> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0;i<list1.length;i++)
            map.put(list1[i], i);
        int totalIndexVal = -1;
        for(int i=0;i<list2.length;i++) {
            //if(map.containsKey(list2[i])) {
                int tempIndex = map.get(list2[i]) + i;
                if(totalIndexVal == -1) {
                    totalIndexVal = tempIndex;
                    list.add(list2[i]);
                }else if(tempIndex == totalIndexVal)
                    list.add(list2[i]);
                else if(tempIndex < totalIndexVal) {
                    totalIndexVal = tempIndex;
                    list.removeAll(list);
                    list.add(list2[i]);
                }
            //}
        }
        return list.toArray(new String[0]);
    }
}