package us.supercheng.algorithm.problems.leetcode.movezeros;

import us.supercheng.algorithm.common.helper.ArrayHelper;
import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    /**
     * You must do this in-place without making a copy of the array.
     * @param args
     */

    public static void main(String[] args) {
        App app = new App();
        int [] arr = {0,1,0,3,12,17,0,8,4,2,0,5,2,13};
        int [] arr2 = {1,0,2,0,0,3};

        PrintHelper.echoLn("Shifting Approach");
        PrintHelper.echoLn(" - Before");
        app.moveZeroes(arr);
        PrintHelper.echoLn(" - After");

        PrintHelper.echoLn("Swapping Approach");
        PrintHelper.echoLn(" - Before");
        app.moveZeroes2(arr2);
        PrintHelper.echoLn(" - After");
    }

    public void moveZeroes(int[] nums) {
        int i =0;
        int l = nums.length;
        for(int count=0;count<l;count++) {
            if(nums[i] == 0) {
                for(int j=i;j<l-1;j++) {
                    nums[j] = nums[j+1];
                }
                nums[l-1] = 0;
            } else {
                i++;
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        int firstZeroIndex = 0;
        int swapTempVal;
        for(int i=0;i<nums.length;i++){
            //ArrayHelper.echo(nums);
            //PrintHelper.echo(" Before\n");
            if(nums[i]!= 0) {
                if(i!=firstZeroIndex) {
                    swapTempVal = nums[i];
                    nums[i] = nums[firstZeroIndex];
                    nums[firstZeroIndex] = swapTempVal;
                }
                firstZeroIndex++;
            }
            //ArrayHelper.echo(nums);
            //PrintHelper.echo(" After\n");
        }
    }

    public void moveZeroes3(int[] nums) {
        int zero=0,
                noneZero = 0;
        for (;noneZero < nums.length;noneZero++)
            if (nums[noneZero] != 0)
                nums[zero++] = nums[noneZero];

        for (;zero < nums.length;zero++)
            nums[zero] = 0;
    }

    public void moveZeroes4(int[] nums) {
        for (int zero=0,noneZero = 0;zero < nums.length;zero++)
            if (nums[zero] != 0) {
                if (zero != noneZero) {
                    int temp = nums[zero];
                    nums[zero] = nums[noneZero];
                    nums[noneZero] = temp;
                }
                noneZero++;
            }
    }
}