/**
 * @param {number[]} arr
 * @return {number}
 */
var sumOddLengthSubarrays = function(arr) {
        var ret = 0,
            len = arr.length;

        for (size=1; size<=len; size+=2)
            ret += sum(arr, len, size);

        return ret;
},
    sum = function(arr, L, size) {
        var ret = 0,
            curr,
            prev = 0,
            i,
            idx;

        for (i=0; i+size<=L; i+=1) {
            curr = 0;
            if (i == 0)
                for (idx=0; idx<size; idx+=1)
                    curr += arr[i+idx];
            else
                curr = prev + arr[i+size-1] - arr[i-1];

            ret += curr;
            prev = curr;
        }

        return ret;
};