/**
 * @param {number[]} nums
 * @return {boolean}
 */
var check = function(nums) {
    var count = 0,
        i,
        len;

    for (i=1, len=nums.length; i<=len; i+=1)
        if (nums[i - 1] > nums[i % len]) {
            count += 1;
            if (count > 1)
                return false;
        }

    return true;
};