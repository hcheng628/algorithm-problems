-- 1:
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

-- 2:
SELECT DISTINCT t1.id, IF(t1.p_id IS NULL, 'Root',
                          IF (t2.p_id IS NULL, 'Leaf', 'Inner')) AS type
FROM Tree AS t1
LEFT JOIN Tree AS t2 ON t1.id = t2.p_id;
