package us.supercheng.algorithm.problems.leetcode.useractivityforthepast30daysi;

public class Solution {

    String SQL = "SELECT a.activity_date as day, COUNT(DISTINCT a.user_id) AS active_users\n" +
            "FROM Activity AS a\n" +
            "WHERE a.activity_date BETWEEN DATE_ADD('2019-07-27', INTERVAL -29 DAY) AND '2019-07-27'\n" +
            "GROUP BY a.activity_date";

}
