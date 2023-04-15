-- 1
SELECT eu.unique_id, e.name
FROM Employees AS e LEFT JOIN EmployeeUNI AS eu ON eu.id = e.id

-- 2
SELECT eu.unique_id, e.name
FROM EmployeeUNI AS eu RIGHT JOIN Employees AS e ON eu.id = e.id