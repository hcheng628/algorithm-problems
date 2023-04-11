SELECT product_name, year, price
FROM Sales AS s, Product AS p
WHERE s.product_id = p.product_id;
