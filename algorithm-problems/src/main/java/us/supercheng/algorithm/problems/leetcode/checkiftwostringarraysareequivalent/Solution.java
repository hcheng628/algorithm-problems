package us.supercheng.algorithm.problems.leetcode.checkiftwostringarraysareequivalent;

class Solution {

    public boolean arrayStringsAreEqualOneLiner(String[] word1, String[] word2) {
        return String.join("", word1).equals(String.join("", word2));
    }

    int[] idx1;
    int[] idx2;

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        this.idx1 = new int[]{0, 0};
        this.idx2 = new int[]{0, 0};

        while (true) {
            Character c1 = this.getNext(word1, false),
                    c2 = this.getNext(word2, true);
            if (c1 != c2)
                return false;
            else if (c1 == null && c2 == null)
                break;
        }

        return true;
    }


    private Character getNext(String[] arr, boolean isWord2) {
        Character ret = null;
        int cellIdx = this.idx1[0],
                idx = this.idx1[1],
                len = arr.length;

        if (isWord2) {
            cellIdx = this.idx2[0];
            idx = this.idx2[1];
        }

        if (cellIdx >= len)
            return ret;

        if (idx >= arr[cellIdx].length()) {
            idx = 0;
            cellIdx++;
        }


        if (cellIdx < len)
            ret = arr[cellIdx].charAt(idx++);

        if (isWord2) {
            this.idx2[0] = cellIdx;
            this.idx2[1] = idx;
        } else {
            this.idx1[0] = cellIdx;
            this.idx1[1] = idx;
        }

        return ret;
    }
}