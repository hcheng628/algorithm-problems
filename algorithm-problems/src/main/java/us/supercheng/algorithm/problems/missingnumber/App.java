package us.supercheng.algorithm.problems.missingnumber;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        App app = new App();
        int [] arr = {9,6,4,2,3,5,7,0,1};
        System.out.println(app.missingNumber(arr));
    }

    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i=0; i<nums.length;i++) {
            if(nums[i] != i) {
                return i;
            }
        }
        if(nums[0] != 0) {
            return 0;
        } else {
            return nums.length;
        }
    }
}
