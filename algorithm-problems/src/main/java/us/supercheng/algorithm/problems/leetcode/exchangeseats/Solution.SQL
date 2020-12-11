-- Version 1
SELECT * FROM (
	SELECT
		IF(MOD(c.total,2),
				IF (id != c.total,
				    IF(MOD(id, 2),
				        id+1,
				        id-1),
				    id),
				IF (MOD(id, 2),
				    id+1,
				    id-1)
		) AS id, student FROM seat,
        (SELECT COUNT(1) as total FROM seat) AS c
) AS t
ORDER BY t.id;

-- Version 2
SELECT
	IF(MOD(ss.id,2),
		IF (s.id != ss.id,
		    IF(MOD(s.id, 2),
		        s.id+1,
		        s.id-1),
		    s.id),
		IF (MOD(s.id, 2),
		    s.id+1,
		    s.id-1)
	) AS id,
		student
	FROM
		seat AS s,
		(SELECT max(id) as id FROM seat) as ss
ORDER BY id;

-- Case + WEHN...