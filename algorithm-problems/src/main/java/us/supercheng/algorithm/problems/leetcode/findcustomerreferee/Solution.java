package us.supercheng.algorithm.problems.leetcode.findcustomerreferee;

public class Solution {

    String SQL = "SELECT name\n" +
            "FROM Customer\n" +
            "WHERE referee_id <> 2 OR referee_id IS NULL;";

    String SQL2 = "SELECT name\n" +
            "FROM Customer\n" +
            "WHERE coalesce(referee_id, -1) <> 2;";

}
