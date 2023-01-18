package us.supercheng.algorithm.problems.leetcode.findtotaltimespentbyeachemployee;

public class Solution {

    String SQL = "SELECT event_day AS day, emp_id, SUM(out_time - in_time) AS total_time\n" +
            "FROM Employees\n" +
            "GROUP BY event_day, emp_id";

}
