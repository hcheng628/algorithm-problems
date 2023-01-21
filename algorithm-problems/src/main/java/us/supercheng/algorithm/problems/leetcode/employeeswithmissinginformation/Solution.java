package us.supercheng.algorithm.problems.leetcode.employeeswithmissinginformation;

public class Solution {

    String SQL = "SELECT e.employee_id \n" +
            "FROM Salaries AS s\n" +
            "RIGHT JOIN Employees AS e ON e.employee_id = s.employee_id\n" +
            "WHERE salary IS NULL\n" +
            "\n" +
            "UNION \n" +
            "\n" +
            "SELECT s.employee_id \n" +
            "FROM Employees AS e\n" +
            "RIGHT JOIN Salaries AS s ON e.employee_id = s.employee_id\n" +
            "WHERE name IS NULL\n" +
            "\n" +
            "GROUP BY employee_id\n" +
            "ORDER BY employee_id";

}
