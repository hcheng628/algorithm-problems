package us.supercheng.algorithm.problems.leetcode.fixnamesinatable;

public class Solution {

    String SQL = "SELECT user_id, CONCAT(UPPER(SUBSTRING(name, 1, 1)), LOWER(SUBSTRING(name, 2))) AS name\n" +
            "FROM Users\n" +
            "ORDER BY user_id";

}
