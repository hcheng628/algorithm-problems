/**
 * @param {number[]} nums
 * @return {number}
 */
var specialArray = function(nums) {
        var bucket = {},
            i,
            len = nums.length;

        for (i=0; i<len; i+=1)
            bucket[nums[i]] = bucket[nums[i]] ? bucket[nums[i]] + 1 : 1;

        for (i=1; i<1001; i+=1)
            if (doCount(nums, len, bucket, i) == i)
                return i;

        return -1;
    },
    doCount = function(nums, len, bucket, val) {
        var ret = 0,
            idx = val;

        for (; idx < 1001; idx +=1) {
            if (bucket[idx])
                ret += bucket[idx];

            if (ret > val || ret > len)
                return -1;
        }

        return ret;
    };