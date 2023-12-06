package us.supercheng.algorithm.problems.leetcode.minimumstringlengthafterremovingsubstrings;

import java.util.Stack;

class Solution {
	public int minLength(String s) {
		if (s == null || s.isEmpty())
			return 0;

		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray())
			if (!stack.isEmpty() && ((c == 'B' && stack.peek() == 'A') || (c == 'D' && stack.peek() == 'C')))
				stack.pop();
			else
				stack.push(c);

		return stack.size();
	}
}
