package us.supercheng.algorithm.problems.leetcode.actorsanddirectorswhocooperatedatleastthreetimes;

public class Solution {

    String SQL = "SELECT actor_id, director_id\n" +
            "FROM ActorDirector\n" +
            "GROUP BY actor_id, director_id\n" +
            "HAVING COUNT(1) > 2;";
    String SQL2 = "WITH tmp AS (\n" +
            "    SELECT actor_id, director_id, COUNT(timestamp) AS count \n" +
            "    FROM ActorDirector\n" +
            "    GROUP BY actor_id, director_id\n" +
            ")\n" +
            "SELECT tmp.actor_id, tmp.director_id \n" +
            "FROM tmp\n" +
            "WHERE tmp.count > 2;";

}
