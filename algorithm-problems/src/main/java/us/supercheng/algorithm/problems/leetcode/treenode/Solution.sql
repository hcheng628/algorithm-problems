WITH
    root AS (SELECT id, 'Root' AS type FROM Tree WHERE p_id IS NULL),
    leaf AS (SELECT id, 'Leaf' AS type FROM Tree
             WHERE p_id IS NOT NULL AND id NOT IN (SELECT DISTINCT p_id FROM Tree WHERE p_id IS NOT NULL))
SELECT id, type FROM root
UNION
SELECT id, type FROM leaf
UNION
SELECT id, 'Inner' AS type FROM Tree
WHERE
        id NOT IN (SELECT id FROM root) AND id NOT IN (SELECT id FROM leaf);