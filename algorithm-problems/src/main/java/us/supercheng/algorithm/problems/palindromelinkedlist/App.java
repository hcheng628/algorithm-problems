package us.supercheng.algorithm.problems.palindromelinkedlist;

import us.supercheng.algorithm.common.entity.ListNode;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        App app = new App();
        System.out.println(app.isPalindrome(null));
    }

    public boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        List<Integer> intList = new ArrayList<>();
        while(temp!= null) {
            intList.add(temp.val);
            temp = temp.next;
        }
        int left = 0;
        int right = intList.size() -1;
        while(left < right) {
            if(!intList.get(left++).equals(intList.get(right--))) {
                return false;
            }
        }
        return true;
    }
}