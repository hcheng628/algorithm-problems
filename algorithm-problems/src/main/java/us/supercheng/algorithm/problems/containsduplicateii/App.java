package us.supercheng.algorithm.problems.containsduplicateii;

import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        App app = new App();
        app.containsNearbyDuplicate(null, 3);
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length < 2) {
            return false;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            if(map.get(nums[i]) == null) {
                map.put(nums[i], i);
            } else {
                if(i - map.get(nums[i]) <= k) {
                    return true;
                } else {
                    map.put(nums[i], i);
                }
            }
        }
        return false;
    }
}
