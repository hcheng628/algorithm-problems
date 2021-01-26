/**
 * @param {number[][]} rectangles
 * @return {number}
 */
var countGoodRectangles = function(rectangles) {
    var i,
        len,
        curr,
        ret = 1,
        max_len = Math.min(rectangles[0][0], rectangles[0][1]);

    for (i=1, len=rectangles.length; i<len; i+=1) {
        curr = Math.min(rectangles[i][0], rectangles[i][1]);
        if (curr == max_len)
            ret += 1;
        else if (curr > max_len) {
            max_len = curr;
            ret = 1;
        }
    }

    return ret;
};