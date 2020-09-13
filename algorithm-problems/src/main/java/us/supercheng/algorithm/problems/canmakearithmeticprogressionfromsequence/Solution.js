/**
 * @param {number[]} arr
 * @return {boolean}
 */
var canMakeArithmeticProgression = function(arr) {
    var len = arr.length,
        diff,
        i;

    if (len < 3)
        return true;

    arr.sort(function(a,b){
        return a - b;
    });

    for (diff = arr[1] - arr[0], i=2; i<len;i+=1)
        if (arr[i] - arr[i-1] != diff)
            return false;

    return true;
};