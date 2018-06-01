package us.supercheng.algorithm.problems.movezeros;

public class App {

    /**
     * You must do this in-place without making a copy of the array.
     * @param args
     */

    public static void main(String[] args) {
        App app = new App();
        int [] arr = {0,1,0,3,12,17,0,8,4,2,0,5,2,13};

        for(int i=0;i<arr.length;i++)
            System.out.print(i==arr.length-1 ? arr[i] : arr[i] + ",");
        System.out.println();

        app.moveZeroes(arr);

        for(int i=0;i<arr.length;i++)
            System.out.print(i==arr.length-1 ? arr[i] : arr[i] + ",");
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
}