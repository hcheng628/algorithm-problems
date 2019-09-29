SELECT
	ret.id AS 'id',
	SUM(ret.Jan) AS 'Jan_Revenue',
	SUM(ret.Feb) AS 'Feb_Revenue',
	SUM(ret.Mar) AS 'Mar_Revenue',
	SUM(ret.Apr) AS 'Apr_Revenue',
	SUM(ret.May) AS 'May_Revenue',
	SUM(ret.Jun) AS 'Jun_Revenue',
	SUM(ret.Jul) AS 'Jul_Revenue',
	SUM(ret.Aug) AS 'Aug_Revenue',
	SUM(ret.Sep) AS 'Sep_Revenue',
	SUM(ret.Oct) AS 'Oct_Revenue',
	SUM(ret.Nov) AS 'Nov_Revenue',
	SUM(ret.Dec) AS 'Dec_Revenue'
FROM (
	SELECT
		dept.id AS 'id',
		IF (dept.month = 'Jan', dept.revenue, NULL) AS 'Jan',
		IF (dept.month = 'Feb', dept.revenue, NULL) AS 'Feb',
		IF (dept.month = 'Mar', dept.revenue, NULL) AS 'Mar',
		IF (dept.month = 'Apr', dept.revenue, NULL) AS 'Apr',
		IF (dept.month = 'May', dept.revenue, NULL) AS 'May',
		IF (dept.month = 'Jun', dept.revenue, NULL) AS 'Jun',
		IF (dept.month = 'Jul', dept.revenue, NULL) AS 'Jul',
		IF (dept.month = 'Aug', dept.revenue, NULL) AS 'Aug',
		IF (dept.month = 'Sep', dept.revenue, NULL) AS 'Sep',
		IF (dept.month = 'Oct', dept.revenue, NULL) AS 'Oct',
		IF (dept.month = 'Nov', dept.revenue, NULL) AS 'Nov',
		IF (dept.month = 'Dec', dept.revenue, NULL) AS 'Dec'
	FROM Department AS dept
) AS ret
GROUP BY ret.id
ORDER BY ret.id;