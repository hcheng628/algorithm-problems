package us.supercheng.algorithm.problems.houserobber;

public class App {

    public static void main(String[] args) {
        App app = new App();
        int [] arr = {2,7,9,3,1};
        System.out.println(app.rob(arr));
        System.out.println("----------");
        System.out.println(app.rob2(arr));
        System.out.println("----------");
        System.out.println(app.rob3(arr));
    }

    public int rob(int[] nums) {
        if(nums ==null || nums.length < 1) {
            return 0;
        }
        if(nums.length < 2) {
            return nums[0];
        }
        if(nums.length < 3) {
            return Math.max(nums[0],nums[1]);
        }
        int [] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], dp[0]);
        for(int i=2; i <nums.length;i++) {
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }
        return dp[nums.length-1];
    }

    public int rob2(int[] nums) {
        if(nums ==null || nums.length < 1) {
            return 0;
        }
        if(nums.length < 2) {
            return nums[0];
        }
        if(nums.length < 3) {
            return Math.max(nums[0],nums[1]);
        }
        int prev1 = nums[0];
        int prev2 = Math.max(nums[1], prev1);
        int curr = 0;
        for(int i=2; i <nums.length;i++) {
            curr = Math.max(nums[i] + prev1, prev2);
            prev1 = prev2;
            prev2 = curr;
        }
        return curr;
    }

    public int rob3(int[] nums) {
        int [] arr = new int[nums.length];
        return rob3Helper(nums, 0, 0, arr);
    }

    public int rob3Helper(int[] nums, int total, int index, int [] ints) {
        System.out.println("Total: " + total + " Index: " + index);
        if(index<0 || index > nums.length) {
            return 0;
        }
        if(ints[index] > 0) {
            return nums[index];
        }
        ints[index] = Math.max(nums[index] + rob3Helper(nums,total,index -2, ints), rob3Helper(nums, total, index, ints));
        return ints[index];
    }

    Integer [] memo;

    public int rob4(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        this.memo = new Integer [nums.length];
        return this.helper(nums, nums.length-1);
    }

    private int helper(int[] nums, int idx) {
        if (idx < 0)
            return 0;
        else if (idx == 0)
            return nums[0];
        else if (idx == 1)
            return Math.max(nums[0], nums[1]);
        else if (this.memo[idx] != null)
            return this.memo[idx];
        this.memo[idx] = Math.max(this.helper(nums, idx-2) + nums[idx], this.helper(nums,idx-1));
        return this.memo[idx];
    }
}