package us.supercheng.algorithm.problems.leetcode.bankaccountsummaryii;

public class Solution {

    String SQL = "SELECT u.name AS 'NAME', SUM(t.amount) AS 'BALANCE'\n" +
            "FROM Transactions AS t\n" +
            "JOIN Users AS u ON u.account = t.account\n" +
            "GROUP BY t.account\n" +
            "HAVING BALANCE > 10000";

}
