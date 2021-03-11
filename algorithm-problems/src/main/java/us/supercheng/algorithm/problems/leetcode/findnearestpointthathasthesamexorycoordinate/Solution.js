/**
 * @param {number} x
 * @param {number} y
 * @param {number[][]} points
 * @return {number}
 */
var nearestValidPoint = function(x, y, points) {
        var i,
            len,
            ret = -1,
            dis = -1,
            curr;

        for (i=0, len=points.length; i<len; i+=1)
            if (x == points[i][0] || y == points[i][1]) {
                curr = calDis(x, y, points[i][0], points[i][1]);
                if (dis == -1 || curr < dis) {
                    dis = curr;
                    ret = i;
                }
            }

        return ret;
    },

    calDis = function(x1, y1, x2, y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
};