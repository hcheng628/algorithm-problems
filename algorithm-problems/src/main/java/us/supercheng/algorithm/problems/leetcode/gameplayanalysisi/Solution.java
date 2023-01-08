package us.supercheng.algorithm.problems.leetcode.gameplayanalysisi;

public class Solution {
    String SQL = "SELECT player_id, MIN(event_date) as first_login \n" +
            "FROM Activity\n" +
            "GROUP BY player_id\n" +
            "ORDER BY player_id";

}
