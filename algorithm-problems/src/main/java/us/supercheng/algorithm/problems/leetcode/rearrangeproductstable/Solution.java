package us.supercheng.algorithm.problems.leetcode.rearrangeproductstable;

public class Solution {

    String SQL = "SELECT product_id, 'store1' AS store, store1 AS price\n" +
            "FROM Products\n" +
            "WHERE store1 IS NOT NULL\n" +
            "\n" +
            "UNION\n" +
            "\n" +
            "SELECT product_id, 'store2' AS store, store2 AS price\n" +
            "FROM Products\n" +
            "WHERE store2 IS NOT NULL\n" +
            "\n" +
            "UNION\n" +
            "\n" +
            "SELECT product_id, 'store3' AS store, store3 AS price\n" +
            "FROM Products\n" +
            "WHERE store3 IS NOT NULL";

}
