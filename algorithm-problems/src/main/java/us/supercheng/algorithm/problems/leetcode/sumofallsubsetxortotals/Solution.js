/**
 * @param {number[]} nums
 * @return {number}
 */
var subsetXORSum = function(nums) {
    return helper(nums, 0, nums.length - 1, 0);
};

var helper = function(nums, idx, last, val) {
    return idx > last ? val :
        helper(nums, idx + 1, last, val ^ nums[idx]) +
            helper(nums, idx + 1, last, val);
};
