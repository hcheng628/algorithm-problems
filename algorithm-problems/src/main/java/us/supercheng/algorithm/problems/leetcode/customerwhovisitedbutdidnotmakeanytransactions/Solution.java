package us.supercheng.algorithm.problems.leetcode.customerwhovisitedbutdidnotmakeanytransactions;

public class Solution {

    String SQL = "SELECT v.customer_id, COUNT(1) AS count_no_trans\n" +
            "FROM Visits AS v\n" +
            "LEFT JOIN Transactions AS t ON v.visit_id = t.visit_id\n" +
            "WHERE t.transaction_id IS NULL\n" +
            "GROUP BY customer_id";

}
