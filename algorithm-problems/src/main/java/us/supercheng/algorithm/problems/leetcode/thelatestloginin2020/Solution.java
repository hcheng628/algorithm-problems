package us.supercheng.algorithm.problems.leetcode.thelatestloginin2020;

public class Solution {

    String SQL = "SELECT user_id, MAX(time_stamp) AS last_stamp\n" +
            "FROM Logins\n" +
            "WHERE YEAR(time_stamp)=2020\n" +
            "GROUP BY user_id";

}
