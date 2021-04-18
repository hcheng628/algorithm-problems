/**
 * @param {number[]} nums
 * @return {number}
 */
var minOperations = function(nums) {
    var i = 0,
        len = nums.length,
        increase,
        ret = 0;

    for (i=1; i<len; i+=1)
        if (nums[i - 1] >= nums[i]) {
            increase = nums[i - 1] - nums[i] + 1;
            nums[i] += increase;
            ret += increase;
        }

    return ret;
};