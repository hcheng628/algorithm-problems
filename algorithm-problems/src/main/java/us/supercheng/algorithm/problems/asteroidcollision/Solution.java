package us.supercheng.algorithm.problems.asteroidcollision;

import java.util.Stack;

public class Solution {

    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null || asteroids.length < 1)
            return new int[0];

        Stack<Integer> stack = new Stack<>();

        for (int a : asteroids) {
            breakPoint: {
                while (a<0 && !stack.isEmpty() && stack.peek()>0) {
                    int val = stack.peek(),
                            absA = Math.abs(a);
                    if (absA > val) {
                        stack.pop();
                        continue;
                    } else if (absA == val)
                        stack.pop();
                    break breakPoint;
                }
                stack.add(a);
            }
        }

        return stack.stream().mapToInt(n->n).toArray();
    }
}