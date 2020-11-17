/**
 * @param {number[]} arr
 * @param {number[][]} pieces
 * @return {boolean}
 */
var canFormArray = function(arr, pieces) {
    var m = {},
        i = 0,
        len = arr.length,
        j,
        len_j,
        list;

    pieces.forEach(function(p) {
        m[p[0]] = p;
    });

    while (i < len) {
        if (!m[arr[i]])
            return false;

        list = m[arr[i]];
        for (j=0, len_j=list.length; j<len_j; j+=1) {
            if (list[j] == arr[i])
                i++;
            else
                return false;
        }
    }

    return true;
};