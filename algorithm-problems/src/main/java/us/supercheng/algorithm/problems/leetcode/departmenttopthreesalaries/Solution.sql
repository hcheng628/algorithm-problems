SELECT d.name AS Department, e.name AS Employee, e.salary AS Salary
FROM Employee AS e LEFT JOIN Department AS d ON d.id = e.departmentId
WHERE e.salary >= (
    SELECT DISTINCT salary
    FROM Employee
    WHERE departmentId = d.id
    ORDER BY salary DESC LIMIT 1 OFFSET 2)
OR
    (
    SELECT count(1)
    FROM Employee
    WHERE departmentId = d.id
    ORDER BY salary LIMIT 3) < 4


-- DENSE_RANK Approach

WITH ranked AS (
    SELECT d.name AS Department, e.name AS Employee, e.salary AS Salary,
        DENSE_RANK() OVER(PARTITION BY departmentId
                            ORDER BY e.salary DESC) AS sales_rank
    FROM Employee AS e LEFT JOIN Department AS d ON d.id = e.departmentId
)
SELECT r.Department, r.Employee, r.Salary
FROM ranked AS r
WHERE r.sales_rank < 4
