package us.supercheng.algorithm.problems.leetcode.salesperson;

public class Solution {

    String SQL = "SELECT name\n" +
                "FROM SalesPerson\n" +
                "WHERE sales_id NOT IN (\n" +
                "    SELECT sp.sales_id\n" +
                "    FROM Orders as o, \n" +
                "        Company as c, \n" +
                "        SalesPerson as sp\n" +
                "    WHERE c.name = 'RED'\n" +
                "        AND c.com_id = o.com_id\n" +
                "        AND o.sales_id = sp.sales_id\n" +
                ")";

    String SQL2 = "SELECT e_name AS name FROM (\n" +
            "    SELECT c.name, sp.name as e_name\n" +
            "    FROM SalesPerson AS sp\n" +
            "    LEFT JOIN Orders AS o ON sp.sales_id = o.sales_id\n" +
            "    LEFT JOIN Company AS c ON o.com_id = c.com_id\n" +
            "    GROUP BY sp.sales_id\n" +
            "    HAVING c.name != 'RED' OR c.name IS NULL\n" +
            ") AS t";

}
