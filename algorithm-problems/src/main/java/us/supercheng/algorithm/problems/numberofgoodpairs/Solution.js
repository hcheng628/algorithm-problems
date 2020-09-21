/**
 * @param {number[]} nums
 * @return {number}
 */
var numIdenticalPairs = function(nums) {
    var len = nums.length,
        i = 1,
        j,
        ret = 0;

    for (; i<len; i+=1)
        for (j=0; j<i; j+=1)
            if (nums[i] == nums[j])
                ret += 1;

    return ret;
};