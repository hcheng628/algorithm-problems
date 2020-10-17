
/**
 * @param {number[]} arr
 * @param {number} m
 * @param {number} k
 * @return {boolean}
 */
var containsPattern = function(arr, m, k) {
    var len,
        i,
        j,
        idx,
        patt,
        match_p,
        count;

    for (i=0, len=arr.length; i<len; i+=1) {
        patt = [];
        for (j=0; j<m; j+=1)
            patt.push(arr[i+j]);

        match_p = true;
        count = 1;

        for (idx=m+i; idx<len; ) {
            for (j=0; match_p && j<m; j+=1, idx+=1)
                if (patt[j] != arr[idx])
                    match_p = false;

            if (match_p) {
                count +=1;
                if (++count == k)
                    return true;
            } else
                break;
        }
    }

    return false;
};