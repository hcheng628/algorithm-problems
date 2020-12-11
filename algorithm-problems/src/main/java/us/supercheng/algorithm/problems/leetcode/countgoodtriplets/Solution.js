/**
 * @param {number[]} arr
 * @param {number} a
 * @param {number} b
 * @param {number} c
 * @return {number}
 */
var countGoodTriplets = function(arr, a, b, c) {
    var ret = 0,
        i,
        j,
        k,
        len = arr.length;

    for (i=0; i<len; i+=1)
        for (j=i+1; j<len; j+=1)
            if (Math.abs(arr[i] - arr[j]) <= a) {
                for (k=j+1; k<len; k+=1)
                    if (Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c)
                        ret +=1;
            }

    return ret;
};