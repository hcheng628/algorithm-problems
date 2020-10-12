/**
 * @param {number[]} arr
 * @return {boolean}
 */
var threeConsecutiveOdds = function(arr) {
    var i,
        end;

    if (arr || arr.length > 2)
        for (i=0, end=arr.length-2; i<end; i+=1)
            if (arr[i] % 2 != 0 && arr[i+1] % 2 != 0 && arr[i+2] % 2 != 0)
                return true;

    return false;
};