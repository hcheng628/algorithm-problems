WITH max_unique AS (
    SELECT num, COUNT(num) AS c
    FROM MyNumbers
    GROUP BY num
    HAVING c = 1
    ORDER BY num DESC LIMIT 1
    )

SELECT IFNULL( (SELECT num FROM max_unique), null) AS num;
-- SELECT from empty set returns null
-- or this -> SELECT (SELECT num FROM max_unique) AS num;
