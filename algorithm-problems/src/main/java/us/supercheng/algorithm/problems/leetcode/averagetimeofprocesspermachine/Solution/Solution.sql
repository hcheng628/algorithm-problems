-- 1
WITH start_info AS (
    SELECT * FROM Activity WHERE activity_type = 'start'
),

end_info AS (
    SELECT * FROM Activity WHERE activity_type = 'end'
)

SELECT s.machine_id, ROUND(AVG((e.timestamp - s.timestamp)), 3) AS processing_time
FROM start_info AS s INNER JOIN end_info AS e
ON s.process_id = e.process_id AND s.machine_id = e.machine_id
GROUP BY s.machine_id



-- 2
SELECT s.machine_id, ROUND(AVG((e.timestamp - s.timestamp)), 3) AS processing_time
FROM Activity AS s INNER JOIN Activity AS e
ON s.process_id = e.process_id AND s.machine_id = e.machine_id
WHERE s.activity_type = 'start' AND e.activity_type = 'end'
GROUP BY s.machine_id
