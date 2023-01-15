package us.supercheng.algorithm.problems.leetcode.groupsoldproductsbythedate;

public class Solution {

    String SQL = "SELECT sell_date,\n" +
            "    COUNT(DISTINCT product) AS num_sold,\n" +
            "    GROUP_CONCAT(DISTINCT product SEPARATOR ',') AS products\n" +
            "FROM Activities\n" +
            "GROUP BY sell_date";

}
