/**
 * @param {number} n
 * @return {number}
 */
var getMaximumGenerated =
    function(n) {
        var list,
            res,
            ret = 1,
            i,
            idx_a,
            idx_b;

        if (n < 1)
            return 0;
        else if (n < 3)
            return ret;

        list = [0,1];
        for (i=2, idx_a=1, idx_b=1; i<=n; i+=1) {
            if (i % 2 == 0) {
                res = list[idx_a];
                idx_a +=1;
            } else {
                res = list[idx_b] + list[idx_b + 1];
                idx_b +=1;
            }

            list.push(res);
            if (res > ret)
                ret = res;
        }

        return ret;
    };