package us.supercheng.algorithm.problems.plusone;

public class App {

    public static void main(String[]  args) {
        App app = new App();
        int [] arr = {5,2,3,4,3,2,2,1};
        int [] returnArr = app.plusOne(arr);

        for (int i=0;i<returnArr.length;i++) {
            System.out.print(returnArr[i]);
        }
    }

    public int[] plusOne(int[] digits) {
        int overflow = 0;
        for (int i=digits.length-1;i>=0;i--) {
            int sum = 0;
            if (i == digits.length - 1) {
                sum = digits[i] + 1;
            } else {
                sum = digits[i] + overflow;
            }
            digits[i] = sum % 10;
            overflow = sum / 10;
        }
        if(overflow == 1) {
            int [] arr = new int [digits.length + 1];
            arr[0] = overflow;
            for(int i=1; i<digits.length;i++) {
                arr[i] = digits[i-1];
            }
            return arr;
        } else {
            return digits;
        }
    }
}