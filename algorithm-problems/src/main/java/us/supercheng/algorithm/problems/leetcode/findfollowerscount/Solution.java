package us.supercheng.algorithm.problems.leetcode.findfollowerscount;

public class Solution {

    String SQL = "SELECT user_id, COUNT(follower_id) AS followers_count\n" +
            "FROM Followers\n" +
            "GROUP BY user_id\n" +
            "ORDER BY user_id";

}
