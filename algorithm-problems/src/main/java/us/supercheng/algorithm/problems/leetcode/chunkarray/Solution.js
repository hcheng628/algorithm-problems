/**
 * @param {Array} arr
 * @param {number} size
 * @return {Array[]}
 */
var chunk = function(arr, size) {
    if (!arr || arr.length < 1 || !size || size < 1)
        return [];

    var len = arr.length,
        batch = Math.floor(len / size),
        idx = 0,
        i,
        j,
        each,
        ret = [];

    for (i = 0; i < batch; i += 1) {
        for (each = [], j = 0; j < size; j += 1, idx += 1)
            each.push(arr[idx]);
        ret.push(each);
    }

    if (idx != len) {
        for (each = []; idx < len; idx += 1)
            each.push(arr[idx])
        ret.push(each);
    }

    return ret;
};
