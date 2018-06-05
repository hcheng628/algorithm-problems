package us.supercheng.algorithm.problems.reversevowelsofastring;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.HashSet;
import java.util.Set;

public class App {

    public static void main(String[] args) {
        App app = new App();
        String s = "Steve Nash";
        PrintHelper.echoLn(app.reverseVowels(s));
    }

    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        char[] arr = s.toCharArray();
        int left = 0;
        int right = arr.length-1;
        int swapA = -1;
        int swapB = -1;
        while(left < right) {
            if(vowels.contains(arr[left]))
                swapA = left;
            else
                left++;
            if(vowels.contains(arr[right]))
                swapB = right;
            else
                right--;
            if(swapA != -1 && swapB !=-1) {
                char temp = arr[left];
                arr[left++] = arr[right];
                arr[right--] = temp;
                swapA = -1;
                swapB = -1;
            }
        }
        return String.valueOf(arr);
    }
}