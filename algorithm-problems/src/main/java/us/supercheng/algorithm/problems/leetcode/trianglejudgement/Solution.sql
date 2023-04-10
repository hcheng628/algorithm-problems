SELECT x, y, z,
       IF(  (x + y > z AND ABS(x - y) < z) OR
            (x + z > y AND ABS(x - z) < y) OR
            (y + z > x AND ABS(y - z) < x), 'Yes', 'No') AS triangle
FROM Triangle;
