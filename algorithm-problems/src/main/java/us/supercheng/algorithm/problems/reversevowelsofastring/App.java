package us.supercheng.algorithm.problems.reversevowelsofastring;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.HashSet;
import java.util.Set;

public class App {

    public static void main(String[] args) {
        App app = new App();
        String s = "Steve Nash";
        PrintHelper.echoLn("Original String: \n" + s);
        String revS = app.reverseVowels(s);
        PrintHelper.echoLn("Reverse Vowel(s): \n" + revS);
        PrintHelper.echoLn("Reverse Vowel(s) Again: \n" + app.reverseVowels2(revS));
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

    public String reverseVowels2(String s) {
        boolean [] vowels = new boolean[128];
        vowels['a'] = true;
        vowels['e'] = true;
        vowels['i'] = true;
        vowels['o'] = true;
        vowels['u'] = true;
        vowels['A'] = true;
        vowels['E'] = true;
        vowels['I'] = true;
        vowels['O'] = true;
        vowels['U'] = true;
        char[] arr = s.toCharArray();
        int left = 0;
        int right = arr.length-1;
        while(left < right) {
            while(left<right && !vowels[arr[left]])
                left++;
            while(left<right && !vowels[arr[right]])
                right--;
            if(left < right) {
                char temp = arr[left];
                arr[left++] = arr[right];
                arr[right--] = temp;
            }
        }
        return String.valueOf(arr);
    }
}