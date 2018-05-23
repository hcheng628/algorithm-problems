package us.supercheng.algorithm.problems.addTwoNumbers;

import us.supercheng.algorithm.common.entity.ListNode;

public class App {

    public static void main(String[]  args) {
        App app = new App();
        System.out.println(app.addTwoNumbers(null, null));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String a = "";
        String b = "";
        while(l1 != null) {
            a = l1.val + a;
            l1 = l1.next;
        }
        while(l2 != null) {
            b = l2.val + b;
            l2 = l2.next;
        }

        int numOfZeros = a.length() - b.length();
        if(numOfZeros <0) {
            numOfZeros = -numOfZeros;
            for(int i=0;i<numOfZeros;i++) {
                a = "0" + a;
            }
        } else if(numOfZeros >0) {
            for(int i=0;i<numOfZeros;i++) {
                b = "0" + b;
            }
        }
        String returnStr = "";
        int overflow = 0;
        for(int i=b.length()-1;i>=0;i--) {
            int numA = Integer.parseInt(a.charAt(i) + "");
            int numB = Integer.parseInt(b.charAt(i) + "");
            int result = numA + numB + overflow;
            if(result > 9) {
                String temp = result + "";
                returnStr += temp.charAt(1) + "";
                overflow = 1;
            } else {
                returnStr += result + "";
                overflow = 0;
            }
        }
        if(overflow == 1) {
            returnStr += 1;
        }
        ListNode node = new ListNode(13);
        ListNode backup = node;
        for(int i=0; i< returnStr.length();i++) {
            ListNode newNode = new ListNode(Integer.parseInt(returnStr.charAt(i) + ""));
            node.next = newNode;
            node = node.next;
        }
        return backup.next;
    }
}