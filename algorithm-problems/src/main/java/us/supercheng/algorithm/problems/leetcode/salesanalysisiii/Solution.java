package us.supercheng.algorithm.problems.leetcode.salesanalysisiii;

public class Solution {

    String SQL = "WITH \n" +
            "p2019 AS (SELECT product_id FROM Sales WHERE sale_date >= '2019-01-01' AND sale_date <= '2019-03-31'),\n" +
            "not_p2019 AS (SELECT product_id FROM Sales WHERE sale_date < '2019-01-01' OR sale_date > '2019-03-31')\n" +
            "SELECT product_id, product_name FROM Product\n" +
            "WHERE product_id IN (SELECT product_id FROM p2019) AND product_id NOT IN (SELECT product_id FROM not_p2019);";

    String SQL2 = "SELECT p.product_id, p.product_name\n" +
            "FROM Product AS p\n" +
            "LEFT JOIN Sales AS s ON p.product_id = s.product_id\n" +
            "GROUP BY s.product_id\n" +
            "HAVING MIN(s.sale_date) >= '2019-01-01' AND MAX(s.sale_date) <= '2019-03-31'";

}
