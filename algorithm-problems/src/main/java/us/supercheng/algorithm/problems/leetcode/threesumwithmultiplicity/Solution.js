/**
 * @param {number[]} A
 * @param {number} target
 * @return {number}
 */
var threeSumMulti = function(A, target) {
    var len,
        i,
        j,
        k,
        map = {},
        ret = 0;

    for (i=0, len=A.length; i<len; i+=1)
        map[A[i]] = map[A[i]] ? map[A[i]] + 1 : 1;

    for (i in map)
        for (j in map) {
            k = target - i - j;
            if (k > -1 && map[k]) {
                if (i==j && j==k)
                    ret += parseInt(map[i] * (map[i]-1) * (map[i]-2) / 6);
                else if (i == j && j != k)
                    ret += parseInt(map[i] * (map[i]-1) / 2 * map[k]);
                else if (j - i > 0  && k - j > 0)
                    ret += parseInt(map[i] * map[j] * map[k]);
            }
        }

    return ret % 1000000007;
};