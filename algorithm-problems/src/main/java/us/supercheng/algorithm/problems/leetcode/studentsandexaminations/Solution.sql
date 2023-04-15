WITH info AS (
    SELECT student_id, student_name, subject_name
    FROM Students, Subjects
)
SELECT
    info.student_id,
    info.student_name,
    info.subject_name,
    COUNT(e.student_id) AS attended_exams
FROM info LEFT JOIN Examinations AS e
                    ON info.student_id = e.student_id AND info.subject_name = e.subject_name
GROUP BY info.student_id, info.subject_name
ORDER BY info.student_id, info.subject_name
