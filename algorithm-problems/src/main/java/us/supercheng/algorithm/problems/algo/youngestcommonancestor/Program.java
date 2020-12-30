package us.supercheng.algorithm.problems.algo.youngestcommonancestor;

import java.util.*;

public class Program {

    public static AncestralTree getYoungestCommonAncestor_Solution1(AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {
        Set<AncestralTree> setOne = new HashSet<>(),
                           setTwo = new HashSet<>();

        while (descendantOne != null && descendantTwo != null) {
            setOne.add(descendantOne);
            setTwo.add(descendantTwo);

            if (setOne.contains(descendantTwo))
                return descendantTwo;

            if (setTwo.contains(descendantOne))
                return descendantOne;

            descendantOne = descendantOne.ancestor;
            descendantTwo = descendantTwo.ancestor;
        }

        for (; descendantOne != null; descendantOne = descendantOne.ancestor) {
            setOne.add(descendantOne);
            if (setTwo.contains(descendantOne))
                return descendantOne;
        }

        for (; descendantTwo != null; descendantTwo = descendantTwo.ancestor) {
            setTwo.add(descendantTwo);
            if (setOne.contains(descendantTwo))
                return descendantTwo;
        }

        return topAncestor;
    }

    public static AncestralTree getYoungestCommonAncestor_Solution2(AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {
        int oneDepth = getDepth(descendantOne, 0);
        int twoDepth = getDepth(descendantTwo, 0);

        AncestralTree lower = oneDepth > twoDepth ? descendantOne : descendantTwo;
        AncestralTree upper = lower == descendantTwo ? descendantOne : descendantTwo;

        for (int i=0, len=Math.abs(oneDepth - twoDepth); i<len; i++)
            lower = lower.ancestor;

        while (lower != null && upper != null && lower != upper) {
            lower = lower.ancestor;
            upper = upper.ancestor;
        }

        return lower;
    }

    private static int getDepth(AncestralTree tree, int curr) {
        return tree == null || tree.ancestor == null ? curr : getDepth(tree.ancestor, curr + 1);
    }

    static class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name) {
            this.name = name;
            this.ancestor = null;
        }

        // This method is for testing only.
        void addAsAncestor(AncestralTree[] descendants) {
            for (AncestralTree descendant : descendants) {
                descendant.ancestor = this;
            }
        }
    }
}

