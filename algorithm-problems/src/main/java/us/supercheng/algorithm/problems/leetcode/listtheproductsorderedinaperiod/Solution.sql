-- 1
SELECT product_name, SUM(unit) AS unit
FROM Products AS p, Orders AS o
WHERE MONTH(order_date) = 2 AND YEAR(order_date) = 2020 AND p.product_id = o.product_id
GROUP BY p.product_name
HAVING unit > 99

-- 2
SELECT product_name, SUM(unit) AS unit
FROM Products AS p JOIN Orders AS o
ON MONTH(order_date) = 2 AND YEAR(order_date) = 2020 AND p.product_id = o.product_id
GROUP BY p.product_name HAVING unit > 99
