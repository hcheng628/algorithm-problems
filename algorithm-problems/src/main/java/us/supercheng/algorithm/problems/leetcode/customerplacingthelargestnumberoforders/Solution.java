package us.supercheng.algorithm.problems.leetcode.customerplacingthelargestnumberoforders;

public class Solution {

    String SQL = "SELECT\n" +
                "    customer_number\n" +
                "FROM\n" +
                "    Orders\n" +
                "GROUP BY customer_number\n" +
                "ORDER BY COUNT(1) DESC LIMIT 1;";

}
