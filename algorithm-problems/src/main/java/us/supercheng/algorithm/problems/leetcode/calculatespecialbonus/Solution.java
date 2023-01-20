package us.supercheng.algorithm.problems.leetcode.calculatespecialbonus;

public class Solution {

    String SQL = "SELECT employee_id,\n" +
            "       CASE\n" +
            "            WHEN employee_id % 2 = 0 OR name LIKE 'M%' THEN 0\n" +
            "            ELSE salary\n" +
            "       END AS bonus\n" +
            "FROM Employees\n" +
            "ORDER BY employee_id";

}
