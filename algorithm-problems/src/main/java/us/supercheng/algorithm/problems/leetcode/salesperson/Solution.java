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

}
