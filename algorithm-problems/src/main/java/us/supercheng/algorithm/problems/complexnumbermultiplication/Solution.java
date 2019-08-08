package us.supercheng.algorithm.problems.complexnumbermultiplication;

class Solution {
    public String complexNumberMultiply(String a, String b) {
        int plusIdxA = a.indexOf("+"),
                iIdxA = a.indexOf("i"),
                plusIdxB = b.indexOf("+"),
                iIdxB = b.indexOf("i"),
                numA = Integer.parseInt(a.substring(0, plusIdxA)),
                imgA = Integer.parseInt(a.substring(plusIdxA+1, iIdxA)),
                numB = Integer.parseInt(b.substring(0, plusIdxB)),
                imgB = Integer.parseInt(b.substring(plusIdxB+1, iIdxB));
        return (-1 * imgA * imgB + numA * numB) + "+" + (numA * imgB + imgA * numB) +"i";
    }
}