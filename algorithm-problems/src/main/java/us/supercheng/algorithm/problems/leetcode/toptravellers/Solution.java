package us.supercheng.algorithm.problems.leetcode.toptravellers;

public class Solution {

    String SQL = "SELECT u.name, COALESCE(SUM(r.distance), 0) AS travelled_distance\n" +
            "FROM Users AS u\n" +
            "LEFT JOIN Rides AS r ON u.id = r.user_id\n" +
            "GROUP BY u.id\n" +
            "ORDER BY travelled_distance DESC, u.name;";

    String SQL2 = "WITH cte1 AS (\n" +
            "    SELECT u.name, SUM(r.distance) AS travelled_distance\n" +
            "    FROM Users AS u, Rides AS r\n" +
            "    WHERE u.id = r.user_id\n" +
            "    GROUP BY u.id\n" +
            "),\n" +
            "    cte2 AS (\n" +
            "    SELECT u.name, 0 AS travelled_distance\n" +
            "    FROM Users AS u\n" +
            "    WHERE u.id NOT IN (SELECT user_id FROM Rides)\n" +
            ")\n" +
            "SELECT t.name, t.travelled_distance FROM (\n" +
            "    SELECT * FROM cte1\n" +
            "        UNION\n" +
            "    SELECT * FROM cte2\n" +
            ") AS t\n" +
            "ORDER BY t.travelled_distance DESC, t.name;";

}
