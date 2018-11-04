package us.supercheng.algorithm.problems.sortcolors;

public class App {
    public void sortColors(int[] nums) {
        for(int redEnd=0, blueBegin = nums.length-1, index = 0;index<=blueBegin;) {
            if(nums[index]==0) {
                this.swap(nums, index, redEnd++);
                if(redEnd > index)
                    index = redEnd;
            } else if (nums[index] == 2)
                this.swap(nums, index, blueBegin--);
            else
                index++;
        }
    }

    private void swap(int[] nums, int a, int b) {
        if(a != b) {
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }
    }
}
