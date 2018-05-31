package us.supercheng.algorithm.problems.missingnumber;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        App app = new App();
        int [] arr = {3,4,2,1,0};

        //System.out.println(app.missingNumber(arr));
        //System.out.println(app.missingNumber2(arr));
        System.out.println(app.missingNumber3(arr));
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

    public int missingNumber2(int[] nums) {
        int sum = (nums.length) * (nums.length + 1) / 2 ;
        for(int i=0;i<nums.length;i++) {
            sum -= nums[i];
        }
        return sum;
    }

    public int missingNumber3(int[] nums) {
        for(int i=1;i<=nums.length;i++){
            System.out.print(nums[i-1]);
        }
        System.out.println();


        int x =0;


        for(int i=1;i<=nums.length;i++){
            System.out.println(x + " ^ " + i + " ^ " + nums[i-1]);
            x = x ^ i ^ nums[i-1];
            System.out.println("x: " + x);
        }
        return x;
    }
}
