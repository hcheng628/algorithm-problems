/**
 * @param {number[]} nums
 * @return {number}
 */
var arraySign = function(nums) {
    var is_negative = false,
        i,
        len = nums.length;

    for (i=0; i<len; i+=1)
        if (nums[i] == 0)
            return 0;
        else if (nums[i] < 0)
            is_negative ^= true;

    return is_negative ? -1 : 1;
};