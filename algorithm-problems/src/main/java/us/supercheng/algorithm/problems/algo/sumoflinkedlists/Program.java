package us.supercheng.algorithm.problems.algo.sumoflinkedlists;

public class Program {

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList sumOfLinkedLists_Solution1(LinkedList linkedListOne, LinkedList linkedListTwo) {
        LinkedList dummy = new LinkedList(-1);
        this.helper(dummy, linkedListOne, linkedListTwo, 0);
        return dummy.next;
    }

    private LinkedList helper(LinkedList ret, LinkedList one, LinkedList two, int carry) {
        if (one == null && two == null) {
            if (carry != 0) {
                LinkedList node = new LinkedList(carry);
                ret.next = node;
                return node;
            }
            return ret;
        }

        int res = carry + (one != null ? one.value : 0) + (two != null ? two.value : 0);
        int num = res > 9 ? res - 10 : res;
        int newCarry = res > 9 ? 1 : 0;
        LinkedList node = new LinkedList(num);
        ret.next = node;

        if (one == null)
            return helper(node, one, two.next, newCarry);
        else if (two == null)
            return helper(node, one.next, two, newCarry);
        else
            return helper(node, one.next, two.next, newCarry);
    }

    public LinkedList sumOfLinkedLists_Solution2(LinkedList linkedListOne, LinkedList linkedListTwo) {
        LinkedList ret = new LinkedList(-1);
        LinkedList list = ret;
        int carry = 0;

        for (LinkedList one = linkedListOne, two = linkedListTwo; one != null || two != null || carry != 0; ) {
            int val = (one != null ? one.value : 0) + (two != null ? two.value : 0) + carry;
            int num = val > 9 ? val - 10 : val;
            carry = val > 9 ? 1 : 0;

            LinkedList curr = new LinkedList(num);
            list.next = curr;

            list = list.next;
            if (one != null)
                one = one.next;
            if (two != null)
                two = two.next;
        }

        return ret.next;
    }

}
