package us.supercheng.algorithm.problems.twosumiisortedinput;

public class App {
    public static void main(String[] args) {
        App app = new App();
        int [] arr = {2,1,3,4,3,1,2,4,5,6};
        int [] res = app.twoSum(arr,3);
        System.out.println("Final Result: " + res[0] + " " + res[1]);
    }

    public int[] twoSum(int[] numbers, int target) {
        int head = 0;
        int tail = numbers.length -1;
        int [] arr = new int[2];
        while(head < tail) {
            int res = numbers[head] + numbers[tail];
            if ( res == target) {
                arr[0] = head + 1;
                arr[1] = tail + 1;
                break;
            }
            if(numbers[tail] > target) {
                tail--;
            } else {
                if (res > target) {
                    tail--;
                } else {
                    head++;
                }
            }
        }
        return arr;
    }
}