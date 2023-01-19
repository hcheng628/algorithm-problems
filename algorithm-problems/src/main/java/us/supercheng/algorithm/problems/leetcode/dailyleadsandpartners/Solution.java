package us.supercheng.algorithm.problems.leetcode.dailyleadsandpartners;

public class Solution {

    String SQL = "SELECT date_id, make_name, COUNT(DISTINCT lead_id) AS unique_leads, COUNT(DISTINCT partner_id) AS unique_partners\n" +
            "FROM DailySales\n" +
            "GROUP BY date_id, make_name";

}
