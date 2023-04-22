WITH low_sal_emp AS (
    SELECT employee_id, manager_id
    FROM Employees
    WHERE salary < 30000 AND manager_id IS NOT NULL
)

SELECT l.employee_id
FROM low_sal_emp AS l
         LEFT JOIN Employees AS e on l.manager_id = e.employee_id
WHERE e.employee_id IS NULL
ORDER BY l.employee_id
