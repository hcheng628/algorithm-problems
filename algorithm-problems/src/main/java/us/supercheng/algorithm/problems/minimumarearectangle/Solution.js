/**
 * @param {number[][]} points
 * @return {number}
 */
var minAreaRect = function(points) {
    var map = {},
        i,
        j,
        len,
        a,
        b,
        res,
        ret;

    points.forEach(function(p) {
        if (!map[p[0]])
            map[p[0]] = {};
        map[p[0]][p[1]] = true;
    });

    for (i=0, len=points.length; i<len; i+=1)
        for (j=i+1; j<len; j+=1) {
            a = points[i];
            b = points[j];
            res = Math.abs(a[0] - b[0]) * Math.abs(a[1] - b[1]);
            if (res != 0 && (!ret || res < ret) && map[a[0]] && map[a[0]][b[1]] && map[b[0]] && map[b[0]][a[1]])
                ret = res;
        }

    return ret ? ret : 0;
};