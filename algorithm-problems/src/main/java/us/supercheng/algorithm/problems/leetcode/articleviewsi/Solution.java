package us.supercheng.algorithm.problems.leetcode.articleviewsi;

public class Solution {

    String SQL = "SELECT DISTINCT v.author_id AS id\n" +
            "FROM Views AS v\n" +
            "WHERE \n" +
            "    v.author_id = v.viewer_id\n" +
            "ORDER BY id;";
}
